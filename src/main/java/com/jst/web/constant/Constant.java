package com.jst.web.constant;

/**
 * Created by Administrator on 2017/4/11.
 */
public class Constant {

    // cookie中name的值
    public static final String JSTSESSIONID = "JSTSESSIONID";

    // 所有权限 1*2*3*5*7*11*13*17=510510
    public static final int ALL_RIGHT = 510510;

    // 员工列表权限
    public static final int EMP_LIST_RIGHT = 17;

    // 会员列表
    public static final int MEMBER_LIST_RIGHT = 13;

    // 产品列表
    public static final int PRODUCT_LIST_RIGHT = 11;

    // 订单列表
    public static final int ORDER_LIST_RIGHT = 7;

    // 快速结账
    public static final int ADD_ORDER_RIGHT = 1;

    // 新建会员
    public static final int ADD_MEMBER_RIGHT = 2;

    // 添加商品
    public static final int ADD_PRODUCT_RIGHT = 3;

    // 添加员工
    public static final int ADD_EMP_RIGHT = 5;

    // 订单状态正常
    public static final int NORMAL = 0;

}
