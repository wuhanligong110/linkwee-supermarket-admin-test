package com.linkwee.web.controller;

import com.linkwee.web.service.MenuSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Index Controller(Application Controller)
 *
 * @author 小马哥 QQ 1191971402
 * @copyright 咕泡学院出品
 * @since 2018/1/10
 */
@Controller
public class IndexController {

    @Autowired
    private MenuSerivce menuSerivce;

    @RequestMapping("/test")
    public String index(@RequestParam(required = false) String message,
                        Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping("/menu/test")
    @ResponseBody
    public String menuTest(){
        return menuSerivce.menuTest();
    }

}
