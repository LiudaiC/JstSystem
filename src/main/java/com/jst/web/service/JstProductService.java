package com.jst.web.service;

import com.jst.web.dao.JstProductDAO;
import com.jst.web.model.database.JstProduct;
import com.jst.web.model.request.RequestProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/10.
 */
@Service
public class JstProductService {

    @Autowired
    private JstProductDAO productDao;

    public void saveProduct(JstProduct pro) {
        productDao.saveProduct(pro);
    }

    public void updateProduct(JstProduct pro) {
        productDao.updateProduct(pro);
    }

    public JstProduct getProductById(long id) {
        return productDao.getProductById(id);
    }

    public List<Long> queryProductIds(String name) {
        return productDao.queryProductIds(name);
    }

    public List<Long> getProductIds(int start, int num) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", start);
        map.put("num", num);
        return productDao.getProductIds(map);
    }

    public int getProductCount() {
        return productDao.getProductCount();
    }

}
