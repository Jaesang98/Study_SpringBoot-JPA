package com.example.shop.sales;

import com.example.shop.member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;
    private Integer price;
    private Integer count;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="member_id", foreignKey = @ForeignKey())
    private Member member;

    @ToString.Exclude
    @CreationTimestamp
    private LocalDateTime created;
}
