package cn.jt.controller;

import cn.jt.pojo.Dog;
import cn.jt.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * @author 郑超
 * @create 2021/4/30
 */
@Controller
public class UserController {

//    @RequestMapping("/toUser")
//    public ModelAndView toUser() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("id", "1001");
//        modelAndView.addObject("name", "老君");
//        modelAndView.setViewName("user");
//        return modelAndView;
//    }

    @RequestMapping("/toUser")
    public String toUser(Model model) {
        model.addAttribute("id", "1024");
        model.addAttribute("name", "太昊");
        return "user";
    }

//    @RequestMapping(value = "/user/addUser", method = RequestMethod.POST)
//    public String addUser(Model model, HttpServletRequest req, HttpServletResponse resp) {
//        Integer id = Integer.valueOf(req.getParameter("id"));
//        String name = req.getParameter("name");
//
//        model.addAttribute("id", id);
//        model.addAttribute("name", name);
//        return "success";
//    }

//    @RequestMapping(value = "/user/addUser", method = RequestMethod.POST)
//    public String addUser(Integer id, String name) {
//        System.out.println(id);
//        System.out.println(name);
//        return "success";
//    }

//    @RequestMapping(value = "/user/addUser", method = RequestMethod.POST)
//    public String addUser(@RequestParam(value = "id", required = false, defaultValue = "1") Integer id1,
//                          @RequestParam("name") String name2) {
//        System.out.println(id1);
//        System.out.println(name2);
//        return "success";
//    }

//    @RequestMapping(value = "/user/addUser", method = RequestMethod.POST)
//    public String addUser(@RequestParam(value = "id", required = false, defaultValue = "1") Integer id1,
//                          @RequestParam("name") String name2, @RequestParam("hobby") String... hobby) {
//        System.out.println(id1);
//        System.out.println(name2);
//        System.out.println(Arrays.toString(hobby));
//        return "success";
//    }

//    @RequestMapping(value = "/user/addUser", method = RequestMethod.POST)
    @PostMapping("/user/addUser")
    public String addUser(User user) {
        System.out.println(user);
        return "success";
    }

    @GetMapping("/findUser")
    public String findUser() {
        // 重定向是多个请求
        return "redirect:/redirectUser";
    }

    @GetMapping("/redirectUser")
    public String redirectUser() {
        return "redirectUser";
    }

    @GetMapping("/findUser1")
    public String findUser1() {
        // 转发的是一个请求
        return "forward:/forwardUser";
    }

    @GetMapping("/forwardUser")
    public String forwardUser() {
        return "forwardUser";
    }

}
