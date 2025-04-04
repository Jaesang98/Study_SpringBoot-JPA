package com.example.shop;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Test {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String title;
    public Date date;
}
