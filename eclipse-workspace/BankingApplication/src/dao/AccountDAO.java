package dao;

import java.sql.SQLException;

import exception.AccountNotFoundException;
import exception.InvalidAccountTypeException;
import model.Account;
import model.CurrentAccount;
import model.SavingsAccount;

public interface AccountDAO {
	void createAccount(Account account) throws SQLException, InvalidAccountTypeException;
	void createSavingsAccount(SavingsAccount savingsAccount)throws SQLException ,AccountNotFoundException;
	void createCurrentAccount(CurrentAccount savingsAccount)throws SQLException ,AccountNotFoundException;
	void updateDetails(Account account) throws SQLException, InvalidAccountTypeException;
	void viewAccount(int acc_id)throws SQLException;
	void deleteAccount(int acc_id)throws SQLException;
}
