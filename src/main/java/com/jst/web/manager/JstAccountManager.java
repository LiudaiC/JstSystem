package com.jst.web.manager;

import com.jst.web.model.database.JstAccount;
import com.jst.web.service.JstAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/3/18.
 */
@Component
public class JstAccountManager {

    @Autowired
    private JstAccountService accountService;

    public JstAccount login(String name, String password) {
        JstAccount account = accountService.getAccountByName(name);
        if (account != null && account.getPassword() != null && account.getPassword().equals(password)) {
            return account;
        }
        return null;
    }

    public int modifyPassword(long accountId, String password) {
        return accountService.updatePassword(accountId, password);
    }

}
