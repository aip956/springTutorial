package com.example.springtutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class tutorialController {
    // return a string from a test
    @GetMapping("/test1")
    @ResponseBody
    public String printHello() {
        // return this text
        return "Hello there!";
    }

    @GetMapping("/test2")
    public String showHelloPage(Model model) {
        model.addAttribute("message", "Have a great day");
        model.addAttribute("rating", 99);
        model.addAttribute("report", "Another great report");
        // return the helloPage.html in templates
        return "helloPage";
    }

    @GetMapping("/test3")
    public ModelAndView printHelloAgain() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Having a great day");
        mv.addObject("rating", 90);
        mv.setViewName("helloPage");
        return mv;
        // combines model and view
    }

    @GetMapping("/test4")
    public String showHelloPage4(@RequestParam("message") String message, Model model) {
        // will inject input from url
        // http://localhost:8080/test4?message=HeyPepper
        model.addAttribute("message", message);
        return "helloPage";
    }
}
