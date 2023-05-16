package com.example.week3hw13q2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Bank {
    private static String id = UUID.randomUUID().toString();
    private String userName;
    private double balance;
}
