package me.dio.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity (name = "tb_account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true)
    private String Number;
    private String Agency;

    @Column(scale = 13,precision = 2)
    private BigDecimal Balance;

    @Column(scale = 13,precision = 2,name = "additional_limit")
    private BigDecimal Limit;
}
