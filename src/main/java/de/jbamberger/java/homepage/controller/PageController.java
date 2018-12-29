package de.jbamberger.java.homepage.controller;

import de.jbamberger.java.homepage.Owner;
import de.jbamberger.java.homepage.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
public class PageController {

    @ModelAttribute
    public void addCommonAttributes(Model model) {
        model.addAttribute("owner", new Owner());
        model.addAttribute("pages", Arrays.asList(
                new Page("Main", ""),
                new Page("Privacy Policy", "privacy_policy")
                )
        );
    }

    @GetMapping("/")
    public String landingPage() {
        return "landing_page";
    }

    @GetMapping("/privacy_policy")
    public String privacyPolicy() {
        return "privacy_policy";
    }

    @RequestMapping(path = "/throw")
    public String throwException() {
        throw new RuntimeException("This is an internal server error!");
    }

    @GetMapping("favicon.ico")
    @ResponseBody
    void returnNoFavicon() {
    }
}
