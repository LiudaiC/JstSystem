package com.jst.web.dao;

import com.jst.web.model.database.JstOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/10.
 */
public interface JstOrderDAO {

    public long saveOrder(JstOrder order);
    public JstOrder getOrderById(long id);
    public JstOrder getOrderByName(String name);
    public List<Long> getOrderIds(Map<String, Object> map);
    public List<Long> getOrderIdsInMonth(Map<String, Object> map);
    public int getOrderCount();
    public int getTotalByMemberId(@Param("memId") long memId);
    public List<Long> getOrderIdsByMem(long memId);
    public int revokeOrder(@Param("orderId")long orderId);
}
