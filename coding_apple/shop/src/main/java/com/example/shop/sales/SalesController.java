package com.example.shop.sales;

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

    @PostMapping("/order")
    String postSearch(@RequestParam String title, @RequestParam Integer price, @RequestParam Integer count, Authentication auth) {
        Sales sales = new Sales();
        Member member = new Member();
        CustomUser user = (CustomUser) auth.getPrincipal();

        member.setId(user.id);
        sales.setMember(member);

        sales.setItemName(title);
        sales.setPrice(price);
        sales.setCount(count);
        salesRepository.save(sales);
        return "redirect:/list";
    }

    @GetMapping("/order/all")
    @ResponseBody
    String getOrderAll() {
        List<Sales> result = salesRepository.customFindAll();
        System.out.println(result);
        return result.toString();
    }
}