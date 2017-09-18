package com.jst.web.dao;

import com.jst.web.model.database.JstOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/10.
 */
public interface JstOrderDAO {

    long saveOrder(JstOrder order);
    JstOrder getOrderById(long id);
    JstOrder getOrderByName(String name);
    List<Long> getOrderIds(Map<String, Object> map);
    List<Long> getOrderIdsInMonth(Map<String, Object> map);
    int getOrderCount();
    int getTotalByMemberId(@Param("memId") long memId);
    List<Long> getOrderIdsByMem(long memId);
    int revokeOrder(@Param("orderId")long orderId);
}
