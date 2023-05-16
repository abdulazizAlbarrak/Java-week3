package com.example.week3hw13q1.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Tracker {
    private static String id = UUID.randomUUID().toString();;
    private String title;
    private String description;
    private String status;
}
