/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author jayes
 */
public class Transaction {
    
    String accountFrom;
    String accountTo;
    String associated;
    double balance;
    double creditAmount;
    double debitAmount;

    public Transaction(String accountFrom, String accountTo,String associated, double balance, double creditAmount, double debitAmount) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.associated=associated;
        this.balance = balance;
        this.creditAmount = creditAmount;
        this.debitAmount = debitAmount;
    }
    
    public String toString()
    {
            return this.accountFrom+"\n"+this.accountTo+"\n"+this.associated+"\n"+this.balance+"\n"+this.creditAmount+"\n"+this.debitAmount+"\n";
    }
}
