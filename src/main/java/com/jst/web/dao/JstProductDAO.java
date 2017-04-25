package com.jst.web.dao;

import com.jst.web.model.database.JstProduct;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/10.
 */
public interface JstProductDAO {

    public long saveProduct(JstProduct emp);
    public long updateProduct(JstProduct emp);
    public JstProduct getProductById(long id);
    public List<Long> queryProductIds(String name);
    public List<Long> getProductIds(Map map);
    public int getProductCount();
}
