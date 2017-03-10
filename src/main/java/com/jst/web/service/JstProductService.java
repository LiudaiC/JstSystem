package com.jst.web.service;

import com.jst.web.dao.JstProductDAO;
import com.jst.web.model.database.JstProduct;
import com.jst.web.model.request.RequestProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public JstProduct getProductById(long id) {
        return productDao.getProductById(id);
    }


}
