package com.example.springtutorial.controller;

import com.example.springtutorial.models.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/people")
    public String showFriends(Model model) {

        List<Person> friends = new ArrayList<Person>();
        friends.add(new Person(0,"Allan", 23, 142f));
        friends.add(new Person(1,"Bella", 29, 122f));
        friends.add(new Person(2,"Charles", 35, 150f));
        friends.add(new Person(3,"Doris", 40, 115f));
        System.out.println(friends);

        model.addAttribute("people", friends);
        // return the helloPage.html in templates
        return "printFriends";
    }
}
