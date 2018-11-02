package tuantienti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import tuantienti.model.Users;
import tuantienti.model.product;
import tuantienti.service.ProductService;

@Controller
public class AdminControler {
    @Autowired
    ProductService productService;

    @GetMapping("create-product")
    public ModelAndView showcreate(Model model) {
        model.addAttribute("createProduct", new product());
        ModelAndView modelAndView = new ModelAndView("admin/create-product");
        return modelAndView;
    }

    @PostMapping("create-product")
    public ModelAndView create(@ModelAttribute("createProduct") product createproduct) {
        productService.add(createproduct);
        ModelAndView modelAndView = new ModelAndView("admin/create-product");
        modelAndView.addObject("createProduct", new Users());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }
}
