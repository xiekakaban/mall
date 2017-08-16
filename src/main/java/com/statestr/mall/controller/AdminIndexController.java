package com.statestr.mall.controller;

import com.statestr.mall.annotation.AdminAuthorCheckAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by e604845 on 8/12/2017.
 */
@Controller
@RequestMapping("admin")
public class AdminIndexController extends AbstractController {

    @GetMapping("/")
    @AdminAuthorCheckAnnotation(true)
    public ModelAndView index(){
        return new ModelAndView("/admin/index");
    }

    @GetMapping("/category")
    @AdminAuthorCheckAnnotation(true)
    public ModelAndView category(){
        return new ModelAndView("/admin/category");
    }

}
