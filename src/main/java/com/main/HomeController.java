package com.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by khanguyen on 3/14/17.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }
    @RequestMapping(value = "/employee")
    public String employee() {
        return "index";
    }
    @RequestMapping(value = "/tasks")
    public String tasks() {
        return "index";
    }
}
