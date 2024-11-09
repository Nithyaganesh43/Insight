package model;

import java.util.Date;

public class DepositTransaction extends Transaction{
	private String depositMethod;
	
	public DepositTransaction(int transaction_id, int account_id, String transaction_type, double amount,
			Date transactionDate,String depositMethod) {
		super(transaction_id, account_id, transaction_type, amount, transactionDate);
		// TODO Auto-generated constructor stub
		this.depositMethod = depositMethod;
	}
	
	public String getDepositMethod() {
		return depositMethod;
	}
	public void setDepositMethod(String depositMethod) {
		this.depositMethod = depositMethod;
	}

	@Override
	public String getTransactionDetails() {
		// TODO Auto-generated method stub
		return "Transaction type is "+this.depositMethod;
	}
	
	
	
	
}
