package com.controllers;

import com.interfaces.IEntityRepository;
import com.model.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Component
@org.springframework.stereotype.Controller
public class TestControllers {
    @Autowired
    private IEntityRepository testRepository;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        Auto auto = testRepository.findByModel("Ferrari");
        model.addAttribute("message", auto);
        return "hello";
    }

    @RequestMapping(value = {"/", "/helloworld**"}, method = {RequestMethod.GET})
    public ModelAndView welcomePage() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Hello World Page");
        model.addObject("message", "Welcome Page !");
        model.setViewName("helloworld");
        return model;
    }

    @RequestMapping(value = "/protected**", method = RequestMethod.GET)
    public ModelAndView protectedPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Protected Page");
        model.addObject("message", "This is protected page - Only for Admin Users!");
        model.setViewName("protected");
        return model;

    }

    @RequestMapping(value = "/confidential**", method = RequestMethod.GET)
    public ModelAndView adminPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Confidential Page");
        model.addObject("message", "This is confidential page - Need Clint Eastwood Role!");
        model.setViewName("protected");
        return model;
    }

    @RequestMapping(value = "/dbSecurity**", method = RequestMethod.GET)
    public ModelAndView dbPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security DBSecurity Page ");
        model.addObject("message", "Role check from DB!");
        model.setViewName("protected");
        return model;
    }

}
