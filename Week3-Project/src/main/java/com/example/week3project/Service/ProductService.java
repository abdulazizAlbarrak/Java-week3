package com.example.week3project.Service;

import com.example.week3project.Model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@Service
public class ProductService {
    ArrayList<Product> Products = new ArrayList<>();

    public ArrayList<Product> getProducts(){
        return Products;
    }

    public void addProduct(Product Product){
        Products.add(Product);
    }

    public boolean updateProduct(int id, Product Product){
        for (int i=0;i<Products.size();i++){
            if (Products.get(i).getId() == id){
                Products.set(i,Product);
                return true;
            }
        }
        return false;
    }

    public boolean deleteProduct(int id){
        for (int i=0;i<Products.size();i++){
            if (Products.get(i).getId() == i){
                Products.remove(i);
                return true;
            }
        }
        return false;
    }

    public double getPrice(int id){
        for (int i=0;i<Products.size();i++){
            if (Products.get(i).getId() == id)
                return Products.get(i).getPrice();;
        }
        return -1;
    }



    public boolean checkProductId(int id){
        for (int i=0;i<Products.size();i++){
            if (Products.get(i).getId() == id)
                return true;
        }
        return false;
    }

}
