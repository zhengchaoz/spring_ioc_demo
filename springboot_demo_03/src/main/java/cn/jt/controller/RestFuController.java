package cn.jt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author 郑超
 * @create 2021/5/6
 */
@Controller
public class RestFuController {

    @GetMapping("/restFuTo/{method}")
    public String get(@PathVariable("method") String method, Model model) {
        System.out.println(method);
        model.addAttribute("method", method);
        return "restFuTo";
    }

    @PostMapping("/restFuTo/{method}")
    public String post(@PathVariable String method, Model model) {
        System.out.println(method);
        model.addAttribute("method", method);
        return "restFuTo";
    }

    @PutMapping("/restFuTo/{method}")
    public String put(@PathVariable String method, Model model) {
        System.out.println(method);
        model.addAttribute("method", method);
        return "restFuTo";
    }

    @DeleteMapping("/restFuTo/{method}")
    public String delete(@PathVariable String method, Model model) {
        System.out.println(method);
        model.addAttribute("method", method);
        return "restFuTo";
    }

}
