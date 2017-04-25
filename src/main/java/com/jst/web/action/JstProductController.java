package com.jst.web.action;

import com.jst.web.interceptor.JstInterceptor;
import com.jst.web.manager.JstProductManager;
import com.jst.web.model.database.JstAccount;
import com.jst.web.model.database.JstProduct;
import com.jst.web.model.request.RequestProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
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
    public long saveProduct(@RequestBody RequestProduct requestProduct, HttpServletRequest req, HttpServletResponse res) {
        JstAccount account = JstInterceptor.authenticate(req, res);
        double proportion = requestProduct.getProportion().doubleValue();
        if (proportion > 10 || proportion < 0) {
            return -3;
        }
        long genId = productManager.saveProduct(account.getEmpId(), requestProduct);
        return genId;
    }

    @RequestMapping("/products/{id}")
    public JstProduct getProduct(@PathVariable("id") long id) {
        return productManager.getProduct(id);
    }

    @RequestMapping("/products/query/{name}")
    public List<JstProduct> getProduct(@PathVariable("name") String name){
        return productManager.getProductByName(name);
    }

    @RequestMapping("/products/all")
    public Map<String, Object> getProducts() {
        Map<String, Object> map = new HashMap<String, Object>();
        map = productManager.getProducts(0, 0);
        return map;
    }

    @RequestMapping(value = "/products/{page}/{num}", method = RequestMethod.GET)
    public Map<String, Object> getProducts(@PathVariable("page") int page, @PathVariable("num") int num) {
        Map<String, Object> map = new HashMap<String, Object>();
        map = productManager.getProducts(page, num);
        return map;
    }
}
