package tuantienti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import tuantienti.model.Users;
import tuantienti.model.product;
import tuantienti.service.ProductService;
import tuantienti.service.UserService;

@Controller
public class UserControler {
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public ModelAndView index() {
        Iterable<product> products = productService.findAll();
        ModelAndView modelAndView = new ModelAndView("user/index");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("login")
    public ModelAndView showlogin(Model model) {
        model.addAttribute("user", new Users());
        ModelAndView modelAndView = new ModelAndView("user/login");
        return modelAndView;
    }

    @PostMapping("login")
    public ModelAndView login(Model model) {
        model.addAttribute("user", new Users());
        ModelAndView modelAndView = new ModelAndView("user/login");
        return modelAndView;
    }

    @PostMapping("log")
    public String checkValidation(@Validated @ModelAttribute("user") Users user, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "user/login";
        } else if (userService.check(user)) {
            return "user/user";
        } else if (user.getAcc().equals("batman123123") && user.getPass().equals("anhtuan")) {
            return "admin/admin";
        }
        return "user/login";
    }

    @GetMapping("do-create")
    public ModelAndView showcreate(Model model) {
        model.addAttribute("newUser", new Users());
        ModelAndView modelAndView = new ModelAndView("user/create");
        return modelAndView;
    }

    @PostMapping("do-create")
    public ModelAndView create(@ModelAttribute("newUser") Users newuser) {
        userService.save(newuser);
        ModelAndView modelAndView = new ModelAndView("user/create");
        modelAndView.addObject("newUser", new Users());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }
}
