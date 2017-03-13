package com.jst.web.dao;

import com.jst.web.model.database.JstProduct;

import java.util.List;

/**
 * Created by Administrator on 2017/3/10.
 */
public interface JstProductDAO {

    public long saveProduct(JstProduct emp);
    public JstProduct getProductById(long id);
    public JstProduct getProductByName(String name);
    public List<Long> getProductIds(int start, int num);
    public int getProductCount();
}
