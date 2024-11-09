package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import exception.AccountNotFoundException;
import exception.BankingException;
import exception.InvalidAccountTypeException;
import model.Account;
import model.Bank;
import model.CurrentAccount;
import model.SavingsAccount;
import service.AccountService;
import service.BankService;
import utility.DBConnection;

public class BankController {
	
	private final AccountService accountService;
	private final BankService bankService;
	private final BufferedReader br;
	
	public BankController()
	{
		this.accountService = new AccountService();
		this.bankService = new BankService();
		this.br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void start() throws NumberFormatException, IOException, SQLException, BankingException, InvalidAccountTypeException, AccountNotFoundException
	{
		
		int choice;
		do {
			displayMenu();
			choice = Integer.parseInt(br.readLine());
			
			switch(choice) {
			case 1:
				createAccount();
				break;
			case 2:
				updateDetails();
				break;
			case 3:
				viewAccount();
				break;
			case 4:
				viewBankDetailsByAccountID();
				break;
			case 5:
				deleteAccount();
				break;
			case 0:
				System.out.println("Exiting the application...!");
				System.out.println("Thankyou");
				System.exit(0);
			default:
				System.out.println("Enter a valid input");
			}
		}while(true);
	}
	
	public void displayMenu() {
		System.out.println();
		System.out.println("----------------------------------------------------");
		System.out.println("-----------------Banking Application----------------");
		System.out.println("-----------------1. Create Account------------------");
		System.out.println("-----------------2. Update details -----------------");
		System.out.println("-----------------3. View Account--------------------");
		System.out.println("-----------------4. View bank details---------------");
		System.out.println("-----------------5. Delete Account------------------");
		System.out.println("-----------------0.Exit-----------------------------");
		System.out.println("----------------------------------------------------");
		System.out.println("Enter your choice: ");
		System.out.println();
	}
	
	public void createAccount() throws NumberFormatException, IOException, SQLException, BankingException, InvalidAccountTypeException, AccountNotFoundException 
	{
		System.out.println("Enter Customer Id: ");
		int cus_id = Integer.parseInt(br.readLine());
		System.out.println("Enter Bank Id: ");
		int bank_id = Integer.parseInt(br.readLine());
		System.out.println("Enter the initial Balance: ");
		double initial_bal = Integer.parseInt(br.readLine());
		System.out.println("Enter the account type (Savings/Current): ");
		String acc_type = br.readLine().toLowerCase();
		Bank bank = bankService.getBankById(bank_id);
		
		bank.setBank_id(bank_id);
		if(acc_type.equals("savings")) {
			System.out.println("Enter Interest rate: ");
			double interest = Double.parseDouble(br.readLine());
			accountService.createAccount(new SavingsAccount(0,cus_id,bank,acc_type,initial_bal,interest));
			accountService.createSavingsAccount(new SavingsAccount(0,cus_id,bank,acc_type,initial_bal,interest));
		}
		else if(acc_type.equals("current")) {
			System.out.println("Enter the overDraftlimit: ");
			double overDraftlimit = Double.parseDouble(br.readLine());
			accountService.createAccount(new CurrentAccount(0,cus_id,bank,acc_type,initial_bal,overDraftlimit));
			accountService.createCurrentAccount(new CurrentAccount(0,cus_id,bank,acc_type,initial_bal,overDraftlimit));
		}
		else {
			System.out.println("Invalid Account type");
		}
		
		
	}
	
	public void updateDetails() throws NumberFormatException, IOException, SQLException, InvalidAccountTypeException, BankingException
	{
		System.out.println("Enter the account ID to update datails: ");
		System.out.println("Enter account_id: ");
		int acc_id = Integer.parseInt(br.readLine());
		System.out.println("Enter customer_id: ");
		int cus_id = Integer.parseInt(br.readLine());
		System.out.println("Enter bank_id: ");
		int bank_id = Integer.parseInt(br.readLine());
		System.out.println("Enter balance to change: ");
		double balance = Double.parseDouble(br.readLine());
		System.out.println("Enter account type(Savings/current)");
		String acc_type = br.readLine().toLowerCase();
		Bank bank = bankService.getBankById(bank_id);
		bank.setBank_id(bank_id);
		
		if("savings".equals(acc_type)) {
			System.out.println("Enter the interest rate: ");
			double interest = Double.parseDouble(br.readLine());
			accountService.updateDetails(new SavingsAccount(acc_id,cus_id,bank,acc_type,balance,interest));
		}
		else {
			System.out.println("Enter the overDraftLimit: ");
			double overDraftLimit =  Double.parseDouble(br.readLine());
			accountService.updateDetails(new SavingsAccount(acc_id,cus_id,bank,acc_type,balance,overDraftLimit));
		}
		
		
	}
	
	public void viewAccount() throws NumberFormatException, IOException, SQLException
	{
		System.out.println("Enter the account ID to view details: ");
		int acc_id = Integer.parseInt(br.readLine());
		accountService.viewDetails(acc_id);
	}
	
	public void deleteAccount() throws NumberFormatException, IOException, SQLException
	{
		System.out.println("Enter the account ID to be deleted: ");
		int acc_id = Integer.parseInt(br.readLine());
		accountService.deleteAccount(acc_id);
	}
	
	
	public void viewBankDetailsByAccountID() throws SQLException, AccountNotFoundException, NumberFormatException, IOException{
		System.out.println("Enter the account ID: ");
		int acc_id = Integer.parseInt(br.readLine());
		bankService.viewBankDetailsByAccountID(acc_id);
	}
}

































