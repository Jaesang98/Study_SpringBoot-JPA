package com.example.shop.sales;

import com.example.shop.item.ItemRepository;
import com.example.shop.member.CustomUser;
import com.example.shop.member.Member;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalesService {
    private final SalesRepository salesRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public void addSales(String title, Integer price, Integer count, Long id, Authentication auth) {
        var result = itemRepository.findById(id);
        if(result.isPresent()) {
            var item = result.get();
            item.setCount(item.getCount() - 1);
            itemRepository.save(item);
        }


        Sales sales = new Sales();
        Member member = new Member();
        CustomUser user = (CustomUser) auth.getPrincipal();

        member.setId(user.id);
        sales.setMember(member);

        sales.setItemName(title);
        sales.setPrice(price);
        sales.setCount(count);
        salesRepository.save(sales);
    }
}
