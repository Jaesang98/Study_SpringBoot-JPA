package com.apple.shop;

import jakarta.persistence.*;
import lombok.ToString;

@Entity
@ToString
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

//    @Column(nullable = false, unique = true)
//    @Column(columnDefinition = "Text")
    @Column(length = 1000)
    public String title;
    public Integer price;
}
