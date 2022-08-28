package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
@RequestMapping("/")
public class HelloController {

    private final UserService userService;

    @Autowired
    public HelloController(UserService userService){
        this.userService = userService;

    }


    @GetMapping()
    public String showAllUser(Model model) {
        model.addAttribute("allUser", userService.getAllUsers());
        return "all-user";
    }
    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        return "user-info";
    }
    @PostMapping()
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String updateUser(@RequestParam(value = "id", required = false) long id, ModelMap modelMap) {
        User user = userService.getUserById(id);
        modelMap.addAttribute("user", user);
        System.out.println(user.toString());
        return "user-info";
    }

    @GetMapping("/delite")
    public String delUser(@RequestParam(value = "id", required = false) long id) {
        System.out.println(id);
        userService.deleteUserById(id);
        return "redirect:/";
    }

}
