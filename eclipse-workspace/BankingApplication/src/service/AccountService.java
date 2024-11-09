package service;

import java.sql.SQLException;

import dao.AccountDAO;
import dao.AccountDAOImpl;
import exception.AccountNotFoundException;
import exception.InvalidAccountTypeException;
import model.Account;
import model.CurrentAccount;
import model.SavingsAccount;

public class AccountService {
	
	private final AccountDAO accountDAO;
	
	public AccountService()
	{
		this.accountDAO = new AccountDAOImpl();
	}
	
	public void createAccount(Account account) throws SQLException, InvalidAccountTypeException 
	{
		accountDAO.createAccount(account);
	}
	
	public void updateDetails(Account account) throws SQLException, InvalidAccountTypeException 
	{
		accountDAO.updateDetails(account);
	}
	
	public void viewDetails(int acc_id) throws SQLException {
		accountDAO.viewAccount(acc_id);
	}
	
	public void deleteAccount(int acc_id) throws SQLException {
		accountDAO.deleteAccount(acc_id);
	}
	
	public void createSavingsAccount(SavingsAccount savingsaccount) throws SQLException, InvalidAccountTypeException, AccountNotFoundException 
	{
		accountDAO.createSavingsAccount(savingsaccount);
	}
	
	
	public void createCurrentAccount(CurrentAccount currentaccount) throws SQLException, InvalidAccountTypeException, AccountNotFoundException
	{
		accountDAO.createCurrentAccount(currentaccount);
	}
}
