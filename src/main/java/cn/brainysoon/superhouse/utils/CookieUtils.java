package cn.brainysoon.superhouse.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by brainy on 16-11-29.
 */
public class CookieUtils {

    private static final CookieUtils mInstance = new CookieUtils();

    private CookieUtils() {
        super();
    }

    public static CookieUtils getInstance() {

        return mInstance;
    }

    /**
     * @param response //请求响应
     * @param name     //Cookie的名字
     * @param value    //Cookie的值
     * @param maxAge   //Cookie 的生命周期
     */
    public void addCookie(HttpServletResponse response, String name, String value, int maxAge) {

        Cookie cookie = new Cookie(name, value);

        cookie.setPath("/");

        if (maxAge > 0) {

            cookie.setMaxAge(maxAge);
        }

        response.addCookie(cookie);
    }

    /**
     * @param request //请求
     * @param name    //Cookie的名字
     * @return //对应的Cookie
     */
    public Cookie findCookieByCookieName(HttpServletRequest request, String name) {

        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {

            if (cookie.getName().equals(name)) {

                return cookie;
            }
        }

        return null;
    }
}
