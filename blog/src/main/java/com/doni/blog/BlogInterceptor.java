package com.doni.blog;

import com.doni.blog.service.UserSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Slf4j
public class BlogInterceptor implements HandlerInterceptor {
    UserSession userSession = new UserSession();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle 진입 : " + request.getRequestURI());
        boolean getSession = userSession.getSession(request);
        if(getSession){
            log.info("세션 검증완료 페이지 진입 : " + request.getRequestURI() + "/" + getSession);
            return true;
        }
        log.info("세션 없음 /login페이지로 Redirect");
        response.sendRedirect(request.getContextPath() + "/login");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
