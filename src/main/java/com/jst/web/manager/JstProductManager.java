package com.jst.web.manager;

import com.jst.web.model.database.JstProduct;
import com.jst.web.model.request.RequestProduct;
import com.jst.web.service.JstMemberService;
import com.jst.web.service.JstProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/3/9.
 */
@Component
public class JstProductManager {
    @Autowired
    private JstProductService productService;

    public long saveProduct(RequestProduct pro) {
        JstProduct product = new JstProduct();
        product.setProductName(pro.getProductName());
        product.setDiscountPrice(pro.getDiscountPrice());
        product.setOriginalPrice(pro.getOriginalPrice());
        product.setVipPrice(pro.getVipPrice());
        long currTime = System.currentTimeMillis();
        Timestamp stamp = new Timestamp(currTime);
        productService.saveProduct(product);
        return product.getId();
    }

    public JstProduct getProduct(long id) {
        return productService.getProductById(id);
    }
}
