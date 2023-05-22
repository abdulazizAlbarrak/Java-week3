package com.example.week3project.Service;

import com.example.week3project.Model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@Service
public class UserService {
    ArrayList<User> Users = new ArrayList<>();

    public ArrayList<User> getUsers(){
        return Users;
    }

    public void addUser(User User){
        Users.add(User);
    }

    public boolean updateUser(int id, User User){
        for (int i=0;i<Users.size();i++){
            if (Users.get(i).getId() == id){
                Users.set(i,User);
                return true;
            }
        }
        return false;
    }

    public boolean deleteUser(int id){
        for (int i=0;i<Users.size();i++){
            if (Users.get(i).getId() == i){
                Users.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean reduceBalance(int id, double price){
        if ((Users.get(getUserIndex(id)).getBalance() - price) < 0)
            return false;
        Users.get(getUserIndex(id)).setBalance(Users.get(getUserIndex(id)).getBalance() - price);
        return true;
    }

    public boolean checkUserId(int id){
        for (int i=0;i<Users.size();i++){
            if (Users.get(i).getId() == id)
                return true;
        }
        return false;
    }

    public int getUserIndex(int id){
        for (int i=0;i<Users.size();i++){
            if (Users.get(i).getId() == id)
                return i;
        }
        return -1;
    }
}
