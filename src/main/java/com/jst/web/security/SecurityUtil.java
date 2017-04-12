package com.jst.web.security;

import com.jst.web.constant.Constant;
import com.jst.web.model.database.JstAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/4/11.
 */
public class SecurityUtil {
    private static Logger log = LoggerFactory.getLogger(SecurityUtil.class);
    private static ThreadLocal<JstAccount> threadAccount = new ThreadLocal();

    public static JstAccount getAccount() {
        return (JstAccount) threadAccount.get();
    }

    public static void setAccount(JstAccount account) {
        threadAccount.set(account);
    }

    public static JstAccount authenticate(HttpServletRequest req, HttpServletResponse res) {
        HttpSession session = req.getSession();
        JstAccount account = new JstAccount();
        Cookie[] cookies = req.getCookies();
        String cookieName = null;
        if (cookies == null) {
            return account;
        }
        for (Cookie cookie : cookies) {
            cookieName = cookie.getName();
            if (Constant.JSTSESSIONID.equals(cookieName)) {
                account = (JstAccount) session.getAttribute(cookie.getValue());
                if (account != null) {
                    threadAccount.set(account);
                }
                break;
            }
        }
        if (account != null && account.getId() <= 0) {
            log.error("Account is illegal {}", System.currentTimeMillis());
        }
        return account;
    }
}
