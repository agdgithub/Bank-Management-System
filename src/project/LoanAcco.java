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
public class LoanAcco extends Acco{
    
    private double principalAmount;

    public double getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(double principalAmount) {
        this.principalAmount = principalAmount;
    }
    
    private double interest=0.05;

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }
    
    private int loanDuration;

    public int getLoanDuration() {
        return loanDuration;
    }

    public void debitInterest(){
        //....Debit Interest........
        if(bal>bal*interest)
        this.depositMoney(bal*interest);
        else bal=0;
    }
    public void setLoanDuration(int loanDuration) {
        this.loanDuration = loanDuration;
    }
    
    LoanAcco(User u,String d)
    {
            super(u,d);
            setMinBalance(500);
            setWithdrawalLimit(100,20000);
            setBalance(500);
    }

    
    LoanAcco(String an, String pin, double balance, User u,String d)
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
            return Acco.LOAN_ACCOUNT;
    }
    
}
