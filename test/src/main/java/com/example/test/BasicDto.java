package com.example.test;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BasicDto {
    private Long id;
    private String title;
    private String userid;
    private String username;
    private Integer price;

    BasicDto(BasicEntity data) {
        this.id = data.getId();
        this.title = data.getTitle();
        this.userid = data.getUserid();
        this.username = data.getUsername();
        this.price = data.getPrice();
    }
}
