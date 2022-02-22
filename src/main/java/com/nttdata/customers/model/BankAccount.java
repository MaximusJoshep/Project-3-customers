package com.nttdata.customers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
    private String type; // Ahorro, corriente o fijo
    private String numberAccount; //NúmeroDeCuenta
    private String balance; //Saldo
    private Boolean status;
}
