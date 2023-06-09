package com.example.week3project.Service;

import com.example.week3project.Model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@Service
public class CategoryService {
    ArrayList<Category> categories = new ArrayList<>();

    public ArrayList<Category> getCategories(){
        return categories;
    }

    public void addCategory(Category category){
        categories.add(category);
    }

    public boolean updateCategory(int id, Category category){
        for (int i=0;i<categories.size();i++){
            if (categories.get(i).getId() == id){
                categories.set(i,category);
                return true;
            }
        }
        return false;
    }

    public boolean deleteCategory(int id){
        for (int i=0;i<categories.size();i++){
            if (categories.get(i).getId() == i){
                categories.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean checkCategory(int id){
        for (int i=0; i<categories.size();i++){
            if (categories.get(i).getId() == id)
                return true;
        }
        return false;
    }

}
