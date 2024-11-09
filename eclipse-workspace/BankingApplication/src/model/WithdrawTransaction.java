package model;

import java.util.Date;

public class WithdrawTransaction extends Transaction{
	private String withdrawMethod;

	public WithdrawTransaction(int transaction_id, int account_id, String transaction_type, double amount,
			Date transactionDate, String withdrawMethod) {
		super(transaction_id, account_id, transaction_type, amount, transactionDate);
		this.withdrawMethod = withdrawMethod;
	}

	public String getWithdrawMethod() {
		return withdrawMethod;
	}

	public void setWithdrawMethod(String withdrawMethod) {
		this.withdrawMethod = withdrawMethod;
	}

	@Override
	public String getTransactionDetails() {
		// TODO Auto-generated method stub
		return "Transaction type is "+this.withdrawMethod;
	}
	
	
}
