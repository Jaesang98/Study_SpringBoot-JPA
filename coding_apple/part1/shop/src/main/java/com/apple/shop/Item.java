package com.apple.shop;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

//    @Column(nullable = false, unique = true)
//    @Column(columnDefinition = "Text")
    @Column(length = 1000)
    private String title;
    private Integer price;
}
