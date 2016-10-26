package com.demo.controller;

/**
 * Created by keitsi on 16-10-21.
 */

import com.demo.entity.UserInfoEntity;
import com.demo.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserInfoService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listUsers(HttpServletRequest request, Model model) {
        UserInfoEntity loginUser = (UserInfoEntity)request.getSession().getAttribute("LoginUser");
        model.addAttribute("LoginUser", loginUser);
        model.addAttribute("user", new UserInfoEntity());
        model.addAttribute("allUsers", this.userService.getAll());
        return "/user_list.jsp";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public void logout(HttpServletRequest request, HttpServletResponse response, String userName, String password) throws Exception {
        request.getSession().setAttribute("LoginUser", null);
        response.sendRedirect(request.getContextPath() + "/index");
    }

    //For add and update person both
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("user") UserInfoEntity user) {

        if (user.getId() == 0) {
            //new person, add it
            this.userService.add(user);
        } else {
            //existing person, call update
            this.userService.update(user);
        }
        return "redirect:/user/list";
    }

    @RequestMapping("/edit/{id}")
    public String editPerson(HttpServletRequest request, @PathVariable("id") int id, Model model) {
        UserInfoEntity loginUser = (UserInfoEntity)request.getSession().getAttribute("LoginUser");
        model.addAttribute("LoginUser", loginUser);
        model.addAttribute("user", this.userService.getById(id));
        model.addAttribute("allUsers", this.userService.getAll());
        return "/user_list.jsp";
    }

    @RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id) {
        this.userService.remove(id);
        return "redirect:/user/list";
    }

}