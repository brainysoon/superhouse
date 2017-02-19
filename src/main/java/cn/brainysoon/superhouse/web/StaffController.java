package cn.brainysoon.superhouse.web;

import cn.brainysoon.superhouse.service.StaffService;
import cn.brainysoon.superhouse.utils.CodePaser;
import cn.brainysoon.superhouse.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by brainy on 17-2-18.
 */
@Controller
@SessionAttributes("staff")
public class StaffController {

    private StaffService staffService;

    @Autowired
    public void setStaffService(StaffService staffService) {
        this.staffService = staffService;
    }

    /**
     * @return 对登录页面请求的响应
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {

        return "login";
    }

    /**
     * @return 跳回到首页
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String doLogin(Model model,
                          @RequestParam(value = "_id") String _id,
                          @RequestParam(value = "password") String password,
                          @RequestParam(value = "issave", defaultValue = "checked") String issave,
                          HttpServletResponse response) {

        int loginCode = staffService.handleLogin(_id, password);

        //判断是否登录成功
        if (CodePaser.getCodePaser().paserLoginCode(loginCode)) {

            //添加Staff实体
            model.addAttribute("staff", staffService.getStaffById(_id));

            //是否需要添加Cookie
            if (issave != null && issave.equals("on")) {

                //默认保存一个月
                int maxAge = 60 * 60 * 24 * 31;

                CookieUtils.getInstance().addCookie(response, "_id", _id, maxAge);
                CookieUtils.getInstance().addCookie(response, "password", password, maxAge);
            } else {

                int maxAge = 0;
                CookieUtils.getInstance().addCookie(response, "_id", "", maxAge);
                CookieUtils.getInstance().addCookie(response, "password", "", maxAge);
            }

            //重定向到首页
            return "redirect:/";
        } else {

            model.addAttribute("code", loginCode);
            model.addAttribute("codestring", CodePaser.getCodePaser().paserLoginCodeToString(loginCode));

            return "login";
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(SessionStatus sessionStatus) {

        sessionStatus.setComplete();

        return "redirect:/";
    }
}