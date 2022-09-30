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

public class SavingsAcco extends Acco
{
    
    private double rateOfInterest=0.05;
    
    public void setInterest(double r)
    {
        this.rateOfInterest=r;
    }
    
    public double getInterest()
    {
        return rateOfInterest;
    }
    
    public void creditInterest(){
        //....Debit Interest........
        this.depositMoney(bal*rateOfInterest);
    }
    
    SavingsAcco(User u,String d)
    {
            super(u,d);
            // using abstract class , abstract functions
            setMinBalance(500);
            setWithdrawalLimit(100,20000);
            setBalance(500);
    }

    
    SavingsAcco(String an, String pin, double balance, User u,String d)
    {
            this(u,d);
            // using the parent functions
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
            return Acco.SAVINGS_ACCOUNT;
    }
        
}