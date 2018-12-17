package ru.itpark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itpark.service.HouseService;


@Controller
public class HouseController {
    private final HouseService service;

    public HouseController(HouseService service) {
        this.service = service;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("house", service.getAll());
        return "index";
    }

    @PostMapping
    public String index(Model model, @RequestParam int id, @RequestParam String district, @RequestParam int price) {
        service.add(id,district,price);
        model.addAttribute("house", service.getAll());
        return "index";
    }

}
