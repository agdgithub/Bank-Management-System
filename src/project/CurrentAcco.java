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
public class CurrentAcco extends Acco{
    
    private double creditLimit;

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    private double overdraftFee;
    
    public double getOverdraftFee() {
        return overdraftFee;
    }

    public void setOverdraftFee(double overdraftFee) {
        this.overdraftFee = overdraftFee;
    }

//    CurrentAcco(double creditLimit, double overdraftFee, User c) {
//        super(c);
//        this.creditLimit = creditLimit;
//        this.overdraftFee = overdraftFee;
//    }
    
    CurrentAcco(User u,String d)
    {
            super(u,d);
            setMinBalance(500);
            setWithdrawalLimit(100,20000);
            setBalance(500);
    }

    
    CurrentAcco(String an, String pin, double balance, User u,String d)
    {
            this(u,d);
            super.setAccountNo(an);
            super.setPIN(pin);
            super.setBalance(balance);
    }
    
    
    @Override
    void setMinBalance(double a)
    {
            minBalance=a;
    }

    @Override
    void setWithdrawalLimit(double l, double h)
    {
            minWithdrawal=l;
            maxWithdrawal=h;
    }

    @Override
    int getAccountType()
    {
            return Acco.CURRENT_ACCOUNT;
    }
    
}
