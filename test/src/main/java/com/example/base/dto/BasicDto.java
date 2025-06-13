package com.example.base.dto;

import com.example.base.entity.BasicEntity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BasicDto {
    private Long id;
    private String userid;
    private String username;
    private String password;
    private String address;
    private String number;
    private String image;

    public BasicDto(BasicEntity data) {
        this.id = data.getId();
        this.userid = data.getUserid();
        this.username = data.getUsername();
        this.password = data.getPassword();
        this.address = data.getAddress();
        this.number = data.getNumber();
        this.image = data.getImage();
    }
}