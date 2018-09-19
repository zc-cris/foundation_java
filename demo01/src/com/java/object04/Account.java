package com.java.object04;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName Account
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Account {
    private Integer id;
    private String name;
    private Double balance;

    public void saveBalance(Double money){
        Double balance = getBalance();
        setBalance(balance+money);
    }

    public static void main(String[] args) {
        
    }
}
