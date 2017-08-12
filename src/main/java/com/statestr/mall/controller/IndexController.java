package com.statestr.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by e604845 on 8/2/2017.
 */
@Controller
public class IndexController extends AbstractController {

    @GetMapping("/")
    public ModelAndView index(){
        return new ModelAndView("index");
    }
}
