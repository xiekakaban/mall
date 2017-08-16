package com.statestr.mall.handler;

import com.statestr.mall.exception.NoAdminPermissionException;
import com.statestr.mall.exception.NoPermissionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by e604845 on 8/16/2017.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value= Exception.class)
    public ModelAndView handler(Exception e,RedirectAttributes redirectAttributes){
        if(e instanceof NoAdminPermissionException){
            return noAdminPermissionExceptionHandler(e,redirectAttributes);
        }else{
            return commonExceptionHandler(e);
        }
    }

    private ModelAndView  noAdminPermissionExceptionHandler(Exception e,RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/login");
        redirectAttributes.addFlashAttribute("loginCheck", "You need Login First.");
        return modelAndView;
    }
    private void noPermissionExceptionHandler(Exception e){

    }

    private ModelAndView commonExceptionHandler(Exception e){
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/login");
        return modelAndView;
    }


}
