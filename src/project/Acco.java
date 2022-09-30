package project;


import java.util.Random;


public abstract class Acco
{       
        Database db=Database.getInstance();
        // to give a constant value to a variabel this is used , so that no other instances is allowed to change it
        // in case of only static instances of the same class can change the value;
	public static final int SAVINGS_ACCOUNT=1;
	public static final int CURRENT_ACCOUNT=2;
        public static final int LOAN_ACCOUNT=3;
	
	public static final int INSUFFICIENT_BALANCE=1;
	public static final int WITHDRAWAL_LIMIT_UNDER=2;
	public static final int WITHDRAWAL_LIMIT_OVER=3;
	
	private String acNo;
	private String passw;
        public String createdAt;
        protected double bal;
        protected User user;
        boolean isActiv;

        
        //Some other optional situations....
	protected double minBalance;
	protected double minWithdrawal;
	protected double maxWithdrawal;
        
        //Essential Properties of Acco...
        // Acc/No,PIN,User,balance,isActivated
        
	
	Acco(User c,String d)
	{
		acNo=generateUniqueAccountNumber(); //Generating an account Number...
		passw=generatePIN();// Generating PIN....
		user=c;//User...
                createdAt=d;
	}
	// to hides detial to the user or some how increasing the reuseability of code
	abstract void setMinBalance(double a);
	abstract void setWithdrawalLimit(double l, double h);
	abstract int getAccountType();
	
	double getBalance()
	{
		return bal;
	}
	void setBalance(double b)
	{
		bal=b;
	}
	
	String getAccuntNo()
	{
		return acNo;
	}
	void setAccountNo(String s)
	{
		acNo=s;
	}
	String getPIN()
	{
		return passw;
	}
	void setPIN(String s)
	{
		passw=s;
	}
	
	void activateAccount()
	{
		this.isActiv=true;
	}
	
	String generateUniqueAccountNumber()
	{
		Random r = new Random();
		String acNum=String.valueOf(r.nextInt(10000000)+89999999);
		if(db.isAccountNumberUnique(acNum))
		{
			return acNum;
		}
		return generateUniqueAccountNumber();
	}
        
	String generatePIN()
	{
		Random r = new Random();
		return String.valueOf(r.nextInt(1000)+8999);
	}
	
	boolean payBill(double amount)
	{
		if(bal-amount<minBalance)
			return false;
		
		bal-=amount;
		return true;	
	}
	
	void depositMoney(double amount)
	{
		this.bal+=amount;
                db.transactions.add(new Transaction(this.acNo,this.acNo,this.acNo, this.bal,amount,0));
	}
	
	boolean transferMoney(Acco ac, double amount)
	{
		if(bal-amount<minBalance)
			return false;
		
		this.bal-=amount;
		ac.bal+=amount;
                
                db.transactions.add(new Transaction(this.acNo, ac.getAccuntNo(),this.acNo, this.bal,0, amount));
                db.transactions.add(new Transaction(this.acNo, ac.getAccuntNo(),ac.getAccuntNo(),ac.bal,amount, 0));
		return true;	
	}
	
	int withdrawMoney(double amount)
	{
		if(amount<minWithdrawal)
			return WITHDRAWAL_LIMIT_UNDER;
		if(amount>maxWithdrawal)
			return WITHDRAWAL_LIMIT_OVER;
		if(bal-amount<minBalance)
			return INSUFFICIENT_BALANCE;
		
		bal-=amount;
                db.transactions.add(new Transaction(this.acNo,this.acNo,this.acNo, this.bal,0,amount));
		return 0;
	}
	
	public String toString()
	{
		return getAccountType()+"\n"+ acNo + "\n" + passw + "\n"+ bal + "\n" + user + "\n" + isActiv + "\n"+createdAt+"\n";
	}


        public User getUser() {
            return user;
        }
}
