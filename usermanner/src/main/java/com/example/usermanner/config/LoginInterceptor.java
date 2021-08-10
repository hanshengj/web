

/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2021-08-08
 * Time: 17:12
 */
package com.example.usermanner.config;

import com.example.usermanner.tools.AppFinal;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        if (session != null &&
                session.getAttribute(AppFinal.USERINFO_SESSION_KEY) != null) {
            // 登录状态
            return true;
        }
        return false;
    }
}