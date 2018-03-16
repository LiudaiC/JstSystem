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

import static com.jst.web.constant.Constant.PAGE_NUM;

/**
 * Created by Administrator on 2017/3/9.
 */
@RestController
@RequestMapping("/jst")
public class JstProductController {

    @Autowired
    private JstProductManager productManager;

    @PostMapping(value = "/products")
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

    @GetMapping("/products/query/{name}")
    public List<JstProduct> getProduct(@PathVariable("name") String name){
        return productManager.getProductByName(name);
    }

    @GetMapping("/products/all")
    public Map<String, Object> getAllProducts() {
        return productManager.getProducts(1, Integer.MAX_VALUE);
    }

    @GetMapping("/products")
    public Map<String, Object> getProducts(HttpServletRequest req) {
        Map<String, Object> map = new HashMap<String, Object>();
        int page = Integer.valueOf(req.getParameter("page"));
        map = productManager.getProducts(page > 0 ? page : 1, PAGE_NUM);
        return map;
    }

    @GetMapping(value = "/products/{page}/{num}")
    public Map<String, Object> getProducts(@PathVariable("page") int page, @PathVariable("num") int num) {
        Map<String, Object> map = new HashMap<String, Object>();
        map = productManager.getProducts(page, num);
        return map;
    }
}
