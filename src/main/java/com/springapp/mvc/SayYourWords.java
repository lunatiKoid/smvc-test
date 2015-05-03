package com.springapp.mvc;

import com.app.biz.module.dataobject.UserDO;
import com.app.biz.module.service.UserServicesLocator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by liang.yaol on 3/30/15.
 */

@Controller
@RequestMapping("/say")
public class SayYourWords {

    @RequestMapping(value = "/{who}", method = RequestMethod.GET)
    public String sayWhat(@PathVariable String who, ModelMap model) {
        String toWho;
        if (StringUtils.isEmpty(who)) {
            toWho = "hi,Who are you? pls tell me your name!";
        } else {

            UserDO userDO = UserServicesLocator.getUserService().findUserByName(who);
            if (userDO != null) {
                toWho = "hi, meet you again, " + who;
                model.addAttribute("userDO", userDO);
            } else {
                int id = UserServicesLocator.getUserService().findMaxId() + 1;
                UserDO insertUserDO = new UserDO();
                insertUserDO.setName(who);
                insertUserDO.setAge(0);
                insertUserDO.setId(id);
                UserServicesLocator.getUserService().insertUser(insertUserDO);
                toWho = "hi, nice to meet you, " + who + ", we have register for you";
            }
        }
        model.addAttribute("who", toWho);
        return "sayWhat";
    }

}
