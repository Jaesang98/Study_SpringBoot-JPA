package com.example.shop.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepository itemRepository;
    private final ItemService itemService;


    @GetMapping("/list")
    String list(Model model) {
        List<Item> result = itemRepository.findAll();
        model.addAttribute("items", result);
        return "list.html";
    }

    @GetMapping("/write")
    String write() {
        return "write.html";
    }

    @PostMapping("/add")
    String addPost(String title, Integer price) {
        itemService.saveItem(title,price);
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long id, Model model) {
        Optional<Item> result =  itemRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("item",result.get());
            return "detail.html";
        }
        else {
            return "redirect:/list";
        }
    }


    @GetMapping("/edit/{id}")
    String edit(@PathVariable Long id, Model model) {
        Optional<Item> result =  itemRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("item",result.get());
            return "edit.html";
        }
        else {
            return "redirect:/list";
        }
    }

    @PostMapping("/edit")
    String editPost(Long id ,String title, Integer price) {
        itemService.editItem(id,title,price);
        return "redirect:/list";
    }

    @DeleteMapping("/delete")
    String deletePost(@RequestParam Long id) {
        itemService.deleteItem(id);
        return "redirect:/list";
    }
}
