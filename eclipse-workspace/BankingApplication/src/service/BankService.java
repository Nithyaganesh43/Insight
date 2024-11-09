package service;

import java.sql.SQLException;

import dao.AccountDAO;
import dao.AccountDAOImpl;
import dao.BankDAO;
import dao.BankDAOImp;
import exception.AccountNotFoundException;
import exception.BankingException;
import model.Bank;

public class BankService {
	private final BankDAO bankDAO;
	private final AccountDAO accountDAO;
	
	public BankService(){
		this.bankDAO = new BankDAOImp();
		this.accountDAO = new AccountDAOImpl();
	}
	
	public Bank getBankById(int bank_id) throws SQLException, BankingException {
		return bankDAO.getBankByID(bank_id);
	}
	
	public void viewBankDetailsByAccountID(int acc_id) throws SQLException, AccountNotFoundException
	{
		bankDAO.viewBankDetailsByAccountID(acc_id);
	}
}
