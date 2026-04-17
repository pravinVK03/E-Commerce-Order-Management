package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String dashboard(Model model) {
        // Manage Inventory: Show all products on the UI
        model.addAttribute("products", productRepository.findAll());
        return "index";
    }

    @PostMapping("/place")
    public String placeOrder(@RequestParam Long id, @RequestParam int qty, RedirectAttributes ra) {
        // Process Order & Payment Handling via Service
        String result = orderService.processOrder(id, qty);
        ra.addFlashAttribute("message", result);
        return "redirect:/";
    }
}
