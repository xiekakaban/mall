package com.statestr.mall.controller;

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
    public ModelAndView index(){
        return new ModelAndView("admin/index");
    }
}
