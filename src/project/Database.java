package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


// ArrayList is similar to vector in c++
// here by declaring <Acco>in ArrayList we have created all the objects present in class Acco

public class Database
{
	private static Database instance;
	ArrayList<Acco> account = new ArrayList<>();
        ArrayList<Transaction> transactions = new ArrayList<>();
	
	// to create a new instance of database just like creating a new element of struct in c++
	public static Database getInstance()
	{
		if(instance==null)
		{
			instance=new Database();
		}
		return instance;
	}
	
        // my information time useage
	Acco getAccount(String n)
	{
		for(int i=0;i<account.size();i++)
		{
			if(account.get(i).getAccuntNo().equals(n))
			{
				return account.get(i);
			}
		}
		
		return null;
	}
        
	// login time useage
	Acco getAccount(String n, String p)
	{
		for(int i=0;i<account.size();i++)
		{
			if(account.get(i).getAccuntNo().equals(n) && account.get(i).getPIN().equals(p))
			{
				return account.get(i);
			}
		}
		
		return null;
	}
	
        // add is an inbuild function which is used to add element to our arrayList account.
	void addNewAccount(Acco ac)
	{
            // adding a new account to Arraylist acount of data type acco;
		this.account.add(ac);
	}
	
        // login time
	boolean isAccountNumberUnique(String n)
	{
		for(int i=0;i<account.size();i++)
		{
                    // get key word return the element from the particualr index from the account ArrayList
                    // equals is a inbuilt function of  string which will compare two string if it is equal to null 
                    // returns true else return false
			if(account.get(i).getAccuntNo().equals(n))
			{
				return false;
			}
		}
		
		return true;
	}
	
	void saveData()
	{
		System.out.println("Saving Data To the Data base...");
		try
		{       // from AccountList.txt we have taken our input and stored in a bufferwriter bw 
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("AccountList.txt")));
			for(int i=0;i<account.size();i++)
			{
				bw.write(String.valueOf(account.get(i)));
			}
			bw.close();
		} 
		catch (IOException e) // cathes if any input/output error has occur in try code
		{
			e.printStackTrace();
		}
                
                try
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("TransactionList.txt")));
			for(int i=0;i<transactions.size();i++)
			{
				bw.write(String.valueOf(transactions.get(i)));
			}
			bw.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
                
	}
	
        // for printing account
	void printAccounts()
	{
		for(int i=0;i<account.size();i++)
		{
			System.out.println(account.get(i).getAccuntNo() +" "+ account.get(i).getPIN());
		}
	}
	
        
	void loadData()
	{
		try
		{
                        // reading  from a file AccountList.txt by creating  a new BufferedReader br
			BufferedReader br = new BufferedReader(new FileReader(new File("AccountList.txt")));
			String type;
			DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss zzz yyyy");
			
			while((type=br.readLine()) != null)
			{
				Acco ac=null; // declaration of new object 
                                
				if(type.equals(String.valueOf(Acco.SAVINGS_ACCOUNT)))
				{
					ac=new SavingsAcco(br.readLine(),br.readLine(),Double.parseDouble(br.readLine()),new User(br.readLine(), df.parse(br.readLine()), br.readLine(), br.readLine(), br.readLine(),br.readLine() ),br.readLine());
					ac.isActiv=Boolean.getBoolean(br.readLine());
				}
                                else if (type.equals(String.valueOf(Acco.LOAN_ACCOUNT)))
				{
					ac=new LoanAcco(br.readLine(),br.readLine(),Double.parseDouble(br.readLine()),new User(br.readLine(), df.parse(br.readLine()), br.readLine(), br.readLine(), br.readLine(),br.readLine() ),br.readLine());
					ac.isActiv=Boolean.getBoolean(br.readLine());
				}
                                else if (type.equals(String.valueOf(Acco.CURRENT_ACCOUNT)))
				{
					ac=new CurrentAcco(br.readLine(),br.readLine(),Double.parseDouble(br.readLine()),new User(br.readLine(), df.parse(br.readLine()), br.readLine(), br.readLine(), br.readLine(),br.readLine() ),br.readLine());
					ac.isActiv=Boolean.getBoolean(br.readLine());
				}
				addNewAccount(ac); // adding the new account in ArrayList account 
			}
			br.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (NumberFormatException e)
		{	
			e.printStackTrace();
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
                
                try
		{
			BufferedReader br = new BufferedReader(new FileReader(new File("TransactionList.txt")));
			String from;
			
			while((from=br.readLine()) != null)
			{
                            Transaction t;
                            t=new Transaction(from,br.readLine(),br.readLine(), Double.parseDouble(br.readLine()), Double.parseDouble(br.readLine()), Double.parseDouble(br.readLine()));
                            transactions.add(t);
                            // adding new transaction in to the ArrayList
			}
			br.close();
                        
//                        System.out.println(transactions.size());
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (NumberFormatException e)
		{	
			e.printStackTrace();
		}
		
                System.out.print("Loaded Data");
	}
}
