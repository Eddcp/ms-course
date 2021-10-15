package com.devsuperior.hrpayroll.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Payment implements Serializable {

    private String name;
    private Double dailyIncome;
    private Integer days;

    public Payment() {
    }

    public double getTotal() {
        return days * dailyIncome;
    }
}
