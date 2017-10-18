package com.jst.web.manager;

import com.jst.web.model.database.*;
import com.jst.web.service.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Stefan on 2017/9/18.
 */
@Component
public class JstExportManager {

    @Autowired
    private JstEmployeeService employeeService;

    @Autowired
    private JstOrderService orderService;

    @Autowired
    private JstProductService productService;

    @Autowired
    private JstMemberService memberService;

    @Autowired
    private JstChargeService chargeService;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public void export(HttpServletRequest req, HttpServletResponse res) throws Exception{
        // 创建一个Workbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 设置标题样式
        HSSFCellStyle titleStyle = wb.createCellStyle();
        // 设置单元格边框样式
        titleStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框 细边线
        titleStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);// 下边框 细边线
        titleStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框 细边线
        titleStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框 细边线
        // 设置单元格对齐方式
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中
        titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 垂直居中
        // 设置字体样式
        Font titleFont = wb.createFont();
        titleFont.setFontHeightInPoints((short) 15); // 字体高度
        titleFont.setFontName("黑体"); // 字体样式
        titleStyle.setFont(titleFont);


        String type = req.getParameter("type");
        String start = req.getParameter("start");
        String end = req.getParameter("end");
        String title;
        String[] titleArray;
        List<List<String>> data;
        if ("order".equals(type)) {
            title = "账单信息";
            List<Long> ids = employeeService.getAllEmployeeIds(0, 1000);
            titleArray = new String[]{"姓名", "完成项目数", "实收总金额"};
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("startTime", start + " 00:00:00");
            map.put("endTime", end + " 23:59:59");
            map.put("start", 0);
            map.put("num", 10000);
            data = getMemberSum(ids, start, end, map);
            setContent(wb, "员工汇总表", titleStyle, titleArray, data);
            titleArray = new String[]{"员工姓名", "服务名称", "服务时间", "实收价格", "备注"};
            for (long id: ids) {
                JstEmployee e = employeeService.getEmployeeById(id);
                map.put("empId", id);
                Map<String, Object> result = orderService.getOrderCountAndAmount(map);
                if ((Long)result.get("acount") > 0) {
                    data = getOrders(e.getName(), start, end, map);
                    // 在Workbook中添加一个sheet,对应Excel文件中的sheet
                    setContent(wb, e.getName(), titleStyle, titleArray, data);
                }
            }

        } else {
            title = "会员信息";
            titleArray = new String[]{"会员号", "会员姓名", "联系电话", "余额", "消费记录(时间，项目，金额)",
                    "充值记录(时间，金额，备注)"};
            data = getMembers();
            // 在Workbook中添加一个sheet,对应Excel文件中的sheet
            setContent(wb, title, titleStyle, titleArray, data);
        }
        // 设置请求
        res.setContentType("application/application/vnd.ms-excel");
        res.setHeader("Content-disposition",
                "attachment;filename=" + URLEncoder.encode(title + ".xls", "UTF-8"));
        OutputStream outputStream = res.getOutputStream();// 打开流
        wb.write(outputStream);// HSSFWorkbook写入流
        outputStream.flush();// 刷新流
        outputStream.close();// 关闭流
    }

    private void setContent(HSSFWorkbook wb, String sheetName, HSSFCellStyle titleStyle, String[] titleArray,
                            List<List<String>> data) {
        if (wb.getSheet(sheetName) != null) {
            sheetName += "-1";
        }
        // 在Workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);
        // 在sheet中添加标题行
        HSSFRow row = sheet.createRow((int) 0);// 行数从0开始
        HSSFCell sequenceCell = row.createCell(0);// cell列 从0开始 第一列添加序号
        sequenceCell.setCellValue("序号");
        sequenceCell.setCellStyle(titleStyle);
        sheet.autoSizeColumn(0);// 自动设置宽度
        // 为标题行赋值
        for (int i = 0; i < titleArray.length; i++) {
            HSSFCell titleCell = row.createCell(i + 1);// 0号位被序号占用，所以需+1
            titleCell.setCellValue(titleArray[i]);
            titleCell.setCellStyle(titleStyle);
            sheet.autoSizeColumn(i + 1);// 0号位被序号占用，所以需+1
        }
        // 数据样式 因为标题和数据样式不同 需要分开设置 不然会覆盖
        HSSFCellStyle dataStyle = wb.createCellStyle();
        // 设置数据边框
        dataStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        dataStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        dataStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        dataStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        // 设置居中样式
        dataStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT); // 水平居中
        dataStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 垂直居中
        // 设置数据字体
        Font dataFont = wb.createFont();
        dataFont.setFontHeightInPoints((short) 12); // 字体高度
        dataFont.setFontName("宋体"); // 字体
        dataStyle.setFont(dataFont);
        dataStyle.setWrapText(true);
        // 遍历集合数据，产生数据行
        Iterator<List<String>> it = data.iterator();
        int index = 0;
        while (it.hasNext()) {
            index++;// 0号位被占用 所以+1
            row = sheet.createRow(index);
            // 为序号赋值
            HSSFCell sequenceCellValue = row.createCell(0);// 序号值永远是第0列
            sequenceCellValue.setCellValue(index);
            sequenceCellValue.setCellStyle(dataStyle);
            sheet.autoSizeColumn(0);
            List<String> t = it.next();
            // 利用反射，根据传过来的字段名数组，动态调用对应的getXxx()方法得到属性值
            for (int i = 0; i < titleArray.length; i++) {
                HSSFCell dataCell = row.createCell(i + 1);
                dataCell.setCellStyle(dataStyle);
                sheet.autoSizeColumn(i + 1);
                dataCell.setCellValue(new HSSFRichTextString(t.get(i)));// 为当前列赋值
            }
        }
    }

    private List<List<String>> getMemberSum(List<Long> ids, String start, String end, Map<String, Object> map) {
        List<List<String>> data = new ArrayList<List<String>>();
        for (long empId : ids) {
            JstEmployee e = employeeService.getEmployeeById(empId);
            map.put("empId", empId);
            Map<String, Object> result = orderService.getOrderCountAndAmount(map);
            if ((Long)result.get("acount") > 0) {
                List<String> info = Arrays.asList(e.getName(), result.get("acount").toString(),
                        result.get("amount").toString());
                data.add(info);
            }
        }

        return data;
    }


    private List<List<String>> getOrders(String empName, String start, String end, Map<String, Object> map) {
        List<List<String>> data = new ArrayList<List<String>>();
        List<Long> orderIds = orderService.getOrderIds(map);
        for (long oId : orderIds) {
            JstOrder o = orderService.getOrderById(oId);
            JstProduct p = productService.getProductById(o.getProductId());
            List<String> info = Arrays.asList(empName, p.getProductName(),
                    sdf.format(o.getAddTime()), o.getRealPrice().toString(), o.getRemark() == null ? "" : o.getRemark());
            data.add(info);
        }
        return data;
    }

    private List<List<String>> getMembers() {
        List<List<String>> data = new ArrayList<List<String>>();
        List<Long> ids = memberService.getMemberIds(0, 1000);
        for (long id : ids) {
            JstMember m = memberService.getMemberById(id);
            List<Long> orderIds = orderService.getOrderIdsByMem(id);
            List<JstCharge> charges = chargeService.getChargeListByMemberId(id);
            String cusmeInfo = "";
            for (int i = 0, l = orderIds.size(); i < l; i++) {
                JstOrder o = orderService.getOrderById(orderIds.get(i));
                JstProduct p = productService.getProductById(o.getProductId());
                cusmeInfo += sdf.format(o.getAddTime()) + ", " + p.getProductName()
                        + (StringUtils.isEmpty(o.getRemark()) ? "" : (", " + o.getRemark())) + (i == l - 1 ? "" : "\r\n");
            }
            String chargeInfo = "";
            for (int i = 0, l = charges.size(); i < l; i++) {
                JstCharge c = charges.get(i);
                chargeInfo += sdf.format(c.getChargeTime()) + ", " + c.getChargeAmount()
                        + (StringUtils.isEmpty(c.getRemark()) ? "" : (", " + c.getRemark())) + (i == l - 1 ? "" : "\r\n");
            }
            List<String> info = Arrays.asList(m.getCardNo(), m.getName(), m.getPhone(),
                    m.getBalanceAmount().toString(), cusmeInfo, chargeInfo);
            data.add(info);
        }

        return data;
    }


}
