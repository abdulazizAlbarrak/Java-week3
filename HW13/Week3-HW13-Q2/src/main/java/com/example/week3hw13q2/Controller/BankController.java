package com.example.week3hw13q2.Controller;

import com.example.week3hw13q2.ApiResponse.ApiResponse;
import com.example.week3hw13q2.Model.Bank;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/bank")
public class BankController {
    ArrayList<Bank> banks = new ArrayList<>();

    //read
    @GetMapping("/get")
    public ArrayList<Bank> getCustomers(){
        return banks;
    }
    //create
    @PostMapping("/add")
    public ApiResponse addCustomers(@RequestBody Bank bank){
        banks.add(bank);
        return new ApiResponse("customer added");
    }
    //update
    @PutMapping("/update/{index}")
    public ApiResponse updateCustomers(@PathVariable int index,@RequestBody Bank bank){
        banks.set(index,bank);
        return new ApiResponse("customer updated");
    }
    //delete
    @DeleteMapping("delete/{index}")
    public ApiResponse deleteCustomers(@PathVariable int index){
        banks.remove(index);
        return new ApiResponse("customer deleted");
    }
    //deposit
    @PutMapping("/deposit/{index}/{amount}")
    public ApiResponse depositMoney(@PathVariable int index,@PathVariable double amount){
        banks.get(index).setBalance(banks.get(index).getBalance() + amount);
        return new ApiResponse("money deposited");
    }
    //withdraw
    @PutMapping("/withdraw/{index}/{amount}")
    public ApiResponse withdrawMoney(@PathVariable int index,@PathVariable double amount){
        if(banks.get(index).getBalance() - amount >= 0) {
            banks.get(index).setBalance(banks.get(index).getBalance() - amount);
            return new ApiResponse("money withdrawn");
        }else{
            return new ApiResponse("not enough money to proceed");
        }
    }
}
