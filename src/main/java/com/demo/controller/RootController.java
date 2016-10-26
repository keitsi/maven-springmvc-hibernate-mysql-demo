package com.demo.controller;

import com.demo.entity.UserInfoEntity;
import com.demo.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by keitsi on 16-10-22.
 */
@Controller
@RequestMapping("")
public class RootController {
    @Resource
    private UserInfoService userService;

    @RequestMapping("")
    public String root() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index() {
        return "redirect:/user/list.jsp";
    }

    @RequestMapping("/login")
    public String login() {
        return "/login.jsp";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response, String userName, String password) throws Exception {
        UserInfoEntity user = userService.getByName(userName);
        if (user.getPassword().equals(password)) {
            request.getSession().setAttribute("LoginUser", user);
            response.sendRedirect(request.getContextPath() + "/user/list");
        } else {
            response.sendRedirect(request.getContextPath() + "/login?errorMessage=User name or password is not correct.");
        }
    }
}
