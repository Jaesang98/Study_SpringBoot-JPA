package com.example.shop.sales;

import com.example.shop.item.ItemRepository;
import com.example.shop.member.CustomUser;
import com.example.shop.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class SalesController {

    private final SalesRepository salesRepository;
    private final ItemRepository itemRepository;
    private final SalesService salesService;

    @PostMapping("/order")
    String postSearch(@RequestParam String title, @RequestParam Integer price, @RequestParam Integer count, @RequestParam Long id, Authentication auth) {
        salesService.addSales(title, price, count, id, auth);
        return "list.html";
    }

    @GetMapping("/order/all")
    @ResponseBody
    String getOrderAll() {
        List<Sales> result = salesRepository.customFindAll();
        System.out.println(result);
        return result.toString();
    }
}