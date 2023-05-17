package com.example.week3day4hw14.Controller;

import com.example.week3day4hw14.Model.Employees;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeesController {
    ArrayList<Employees> employees = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList getEmployees(){
        return employees;
    }

    @PostMapping("/add")
    public ResponseEntity addEmployees(@Valid @RequestBody Employees Employees, Errors errors){
        if (errors.hasErrors()){
            String msg = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(msg);
        }
        employees.add(Employees);
        return ResponseEntity.status(200).body("employee added");
    }

    @PutMapping("/update/{index}")
    public ResponseEntity updateEmployees(@PathVariable int index, @Valid @RequestBody Employees Employees, Errors errors){
        if (errors.hasErrors()){
            String msg = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(msg);
        }
        employees.set(index,Employees);
        return ResponseEntity.status(200).body("employee updated");
    }

    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteEmployee(@PathVariable int index){
        employees.remove(index);
        return ResponseEntity.status(200).body("employee deleted");
    }

    @PutMapping("/leave/{index}")
    public ResponseEntity annualLeave(@PathVariable int index){
        if (employees.get(index).isOnLeave() || employees.get(index).getAnnualLeave()<=0)
            return ResponseEntity.status(400).body("annual leave is not possible");
        employees.get(index).setAnnualLeave(employees.get(index).getAnnualLeave() - 1);
        employees.get(index).setOnLeave(true);
        return ResponseEntity.status(200).body("leave is of effect, remaining leaves are: "+employees.get(index).getAnnualLeave());
    }
}
