package dao;

import java.sql.SQLException;

import exception.AccountNotFoundException;
import exception.BankingException;
import model.Bank;

public interface BankDAO {
	Bank getBankByID(int bank_id) throws SQLException, BankingException;
	 void viewBankDetailsByAccountID(int acc_id) throws SQLException, AccountNotFoundException;
}
