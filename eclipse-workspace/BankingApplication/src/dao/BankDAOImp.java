package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exception.AccountNotFoundException;
import exception.BankingException;
import model.Bank;
import utility.DBConnection;

public class BankDAOImp implements BankDAO{

	@Override
	public Bank getBankByID(int bank_id) throws SQLException, BankingException{
		// TODO Auto-generated method stub
		Bank bk = null;
		String query = "SELECT * FROM bank where bank_id = ?";
		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query))
		{
			ps.setInt(1, bank_id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return new Bank(bank_id,rs.getString("bank_name"),rs.getString("bank_branch"));
			}
			throw new BankingException("Bank not found by ID "+ bank_id);
		}
		
	}

	@Override
	public void viewBankDetailsByAccountID(int acc_id) throws SQLException, AccountNotFoundException {
		// TODO Auto-generated method stub
		String query = "SELECT bank_id from account where account_id = ?";
		int bank_id;
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query))
		{
			ps.setInt(1, acc_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())bank_id = rs.getInt("bank_id");
			else throw new AccountNotFoundException("Invalid account ID..");
		}
		
		query = "SELECT * from bank where bank_id = ?";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query))
		{
			ps.setInt(1, bank_id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("Bank_ID: "+rs.getInt("bank_id"));
				System.out.println("Bank_name: "+rs.getString("bank_name"));
				System.out.println("Bank_branch: "+rs.getString("bank_branch"));
			}
		}
	}
}
