package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exception.AccountNotFoundException;
import exception.InvalidAccountTypeException;
import model.Account;
import model.CurrentAccount;
import model.SavingsAccount;
import utility.DBConnection;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public void createAccount(Account account) throws SQLException,  InvalidAccountTypeException{
		// TODO Auto-generated method stub
		String qurey = "INSERT INTO account(customer_id,bank_id,account_type,balance) values (?,?,?,?)";
		try (
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(qurey))
			{
				ps.setInt(1, account.getCustomerId());
				ps.setInt(2, account.getBank().getBank_id());
				ps.setString(3, account.getAccountType());
				ps.setDouble(4, account.getBalance());
				
				int result = ps.executeUpdate();
				
				if(result == 0) {
					throw new InvalidAccountTypeException("Account type is not recognized");
				}
				else {
					System.out.println("Successfull Created a user");
				}
		
		}
	}
	
	
	@Override
	public void createSavingsAccount(SavingsAccount savingsAccount) throws SQLException, AccountNotFoundException {
		// TODO Auto-generated method stub
		int account_id = getAccountID(savingsAccount.getCustomerId());
		String query = "INSERT INTO savingsaccount(accout_id,interest_rate) values (?,?)";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query))
		{
			
			ps.setInt(1, account_id);
			ps.setDouble(2, savingsAccount.getInterestRate());
			int result = ps.executeUpdate();
			
			if(result==0)System.out.println("Savings Account is not Created");
			else System.out.println("Savings Account Created successfully");
		}
		
	}
	
	@Override
	public void createCurrentAccount(CurrentAccount currentAccount) throws SQLException, AccountNotFoundException {
		// TODO Auto-generated method stub
		int account_id = getAccountID(currentAccount.getCustomerId());
		String query = "INSERT INTO currentaccount(account_id,overdraft_limit) values (?,?)";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query))
		{
			ps.setInt(1, account_id);
			ps.setDouble(2, currentAccount.getOverDraftLimit());
			int result = ps.executeUpdate();
			
			if(result==0)System.out.println("Current Account is not Created");
			else System.out.println("Current Account Created successfully");
		}
		
	}
	
	static int  getAccountID(int cus_id) throws SQLException, AccountNotFoundException {
		String query = "SELECT account_id from account where customer_id = ?";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query))
		{
			ps.setInt(1, cus_id);
			ResultSet rs = ps.executeQuery();
			
			if(!(rs.next())) {
				throw new AccountNotFoundException("Customer Id is not valid ");
			}
			
			return rs.getInt("account_id");
			
		}
	}

	@Override
	public void updateDetails(Account account) throws SQLException, InvalidAccountTypeException {
		// TODO Auto-generated method stub
		
		String query = "UPDATE account set customer_id = ?, account_type = ?, balance = ? where account_id = ?";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query) )
		{
			ps.setInt(1,account.getCustomerId());
			ps.setString(2, account.getAccountType());
			ps.setDouble(3, account.getBalance());
			ps.setInt(4,account.getAccountId());
			
			int res = ps.executeUpdate();
			
			if(res>0) {
				System.out.println("Successfully updated");
			}
			else {
				System.out.println("Updation failed");
			}
		}
		
	}

	@Override
	public void viewAccount(int acc_id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM account where account_id = ?";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query))
		{
			ps.setInt(1, acc_id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("Account Id: "+rs.getInt("account_id"));
				System.out.println("Customer Id: "+rs.getInt("customer_id"));
				System.out.println("Bank Id: "+rs.getInt("bank_id"));
				System.out.println("Account Type: "+rs.getString("account_type"));
				System.out.println("Balance: "+rs.getDouble("balance"));
			}
		}
	}

	@Override
	public void deleteAccount(int acc_id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "DELETE FROM account where account_id = ?";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query))
		{
			ps.setInt(1, acc_id);
			int res = ps.executeUpdate();
			
			if(res>0) {
				System.out.println("Successfully deleted");
			}
			else {
				System.out.println("Deletion failed");
			}
		}
	}

	
	
	
	
}
