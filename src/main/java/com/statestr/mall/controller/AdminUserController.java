package com.statestr.mall.controller;

import com.statestr.mall.entity.AdministratorEntity;
import com.statestr.mall.service.AdministratorService;
import com.statestr.mall.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Created by e604845 on 8/10/2017.
 */
@Controller
@RequestMapping("/admin")
public class AdminUserController extends AbstractController{
    @Autowired
    private AdministratorService administratorService;

    @RequestMapping(value="/login", method={RequestMethod.GET,RequestMethod.POST})
    public ModelAndView adminLogin(String username, String pwd, HttpServletRequest request, HttpSession session) {
        // login
        if (session.getAttribute(Constants.ADMINSESS_USER) != null) {
            return new ModelAndView("redirect:/admin/");
        }
        if (request.getMethod().equalsIgnoreCase("POST")) {
            AdministratorEntity admin = administratorService.checkLogin(username, pwd);
            if (admin != null) {
                admin.setPwd("Eccrypt.");
                session.setAttribute(Constants.ADMINSESS_USER, admin);
                return new ModelAndView("redirect:/admin/");
            } else {
                ModelAndView modelAndView = new ModelAndView("admin/login");
                modelAndView.addObject("loginCheck", "Please check your username / password");
                return modelAndView;
            }
        } else {
            return new ModelAndView("/admin/login");
        }
    }
        @GetMapping("/logout")
        public ModelAndView adminLogout(HttpSession session){
            session.removeAttribute(Constants.ADMINSESS_USER);
            return new ModelAndView("redirect:/admin/login/");
        }
}
