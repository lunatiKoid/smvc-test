package com.springapp.mvc;

import com.app.biz.module.dataobject.UserDO;
import com.app.biz.module.service.UserServicesLocator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        UserDO userDO = UserServicesLocator.getUserService().findUserById(3);
        model.addAttribute("userDO", userDO);
        return "hello";
    }
}
