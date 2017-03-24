package com.jst.web.action;

import com.jst.web.manager.JstProductManager;
import com.jst.web.model.database.JstEmployee;
import com.jst.web.model.database.JstProduct;
import com.jst.web.model.request.RequestProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/9.
 */
@RestController
@RequestMapping("/jst")
public class JstProductController {

    @Autowired
    private JstProductManager productManager;

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public long saveProduct(@RequestBody RequestProduct requestProduct) {
        long genId = productManager.saveProduct(requestProduct);
        return genId;
    }

    @RequestMapping("/products/{id}")
    public JstProduct getProduct(@PathVariable("id") long id) {
        return productManager.getProduct(id);
    }

    @RequestMapping("/products/{name}")
    public JstProduct getProduct(@PathVariable("name") String name){
        return productManager.getProductByName(name);
    }

    @RequestMapping("/ptoducts")
    public Map<String, Object> getEmployees(int page, int num) {
        Map<String, Object> map = new HashMap<String, Object>();
        map = productManager.getProducts(page, num);
        return map;
    }
}
