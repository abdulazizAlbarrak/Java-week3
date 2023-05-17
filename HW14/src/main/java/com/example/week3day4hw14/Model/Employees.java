package com.example.week3day4hw14.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Employees {
    public static final String supervisor = "supervisor";
    public static final String coordinator = "coordinator";

    @NotEmpty(message = "id should not be empty")
    @Size(min = 3,message = "id length should be more than 2")
    private String id;

    @NotEmpty(message = "name should not be empty")
    @Size(min = 5, message = "name length should be more than 4")
    private String name;

    @NotNull(message = "age should not be empty")
    @Min(value = 26, message = "age should be higher than 25")
    private int age;

    @NotEmpty(message = "role should not be empty")
    @Pattern(regexp = "^(" + supervisor + "|" + coordinator + ")")
    private String role;

    private boolean onLeave = false;

    @NotNull(message = "employment year should not be empty")
    @PastOrPresent
    private Date employmentYear;

    @NotNull(message = "annual leave should not be empty")
    private int annualLeave;
}
