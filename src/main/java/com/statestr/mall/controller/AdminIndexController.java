package com.statestr.mall.controller;

import com.google.common.io.Files;
import com.statestr.mall.annotation.AdminAuthorCheckAnnotation;
import com.statestr.mall.dto.ResultBack;
import com.statestr.mall.entity.CategoryEntity;
import com.statestr.mall.service.CategoryService;
import com.statestr.mall.util.ResultBackUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Created by e604845 on 8/12/2017.
 */
@Controller
@RequestMapping("admin")
public class AdminIndexController extends AbstractController {

    @Autowired
    private CategoryService categoryService;


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

    @ResponseBody
    @GetMapping("/find_all_category")
    @AdminAuthorCheckAnnotation(true)
    public ResultBack<CategoryEntity> findAllCategory(){
        List<CategoryEntity> categoryEntityList = categoryService.findAll();
        return ResultBackUtil.success(categoryEntityList);
    }

    @PostMapping("addCategory")
    @AdminAuthorCheckAnnotation(true)
    public ModelAndView addCategory(@RequestParam("") MultipartFile file,Model model){
      return null;
    }


}
