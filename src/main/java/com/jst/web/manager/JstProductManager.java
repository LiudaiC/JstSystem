package com.jst.web.manager;

import com.jst.web.model.database.JstProduct;
import com.jst.web.model.request.RequestProduct;
import com.jst.web.service.JstProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/9.
 */
@Component
public class JstProductManager {
    @Autowired
    private JstProductService productService;

    public long saveProduct(long empId, RequestProduct pro) {
        JstProduct product = new JstProduct();
        product.setProductName(pro.getProductName());
        product.setDiscountPrice(pro.getDiscountPrice());
        product.setOriginalPrice(pro.getOriginalPrice());
        product.setVipPrice(pro.getVipPrice());
        long currTime = System.currentTimeMillis();
        Timestamp stamp = new Timestamp(currTime);
        product.setOpEmployee(empId);
        productService.saveProduct(product);
        return product.getId();
    }

    public JstProduct getProduct(long id) {
        return productService.getProductById(id);
    }

    public JstProduct getProductByName(String name) {
        return productService.getProductByName(name);
    }

    public Map<String, Object> getProducts(int page, int num) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", productService.getProductCount());
        int start = (page - 1)*num;
        List<Long> ids = productService.getProductIds(start, num);
        final List<JstProduct> products = new ArrayList<JstProduct>();
        for (long id : ids) {
            products.add(productService.getProductById(id));
        }
        map.put("list", products);
        map.put("page", start);
        return map;
    }
}
