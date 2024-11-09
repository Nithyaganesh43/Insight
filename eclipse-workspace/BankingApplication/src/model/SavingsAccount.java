package model;

public class SavingsAccount extends Account{
	private double interestRate;
	
	public SavingsAccount(int accountId, int customerId, Bank bank, String accountType, double balance,double interestRate) {
		super(accountId, customerId, bank, accountType, balance);
		// TODO Auto-generated constructor stub
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public String getAccountDetails() {
		// TODO Auto-generated method stub
		return "Savings class with interest rate is "+this.interestRate;
	}
	
	@Override
	public String toString() {
		return "Savings Account Details :\n Account Id: "+this.getAccountId()+
				"\n Customer Id: "+this.getCustomerId()+
				"\n Bank: "+this.getBank()+
				"\n Account Type: "+this.getAccountType()+
				"\n Balance: "+this.getBalance()+
				"\n Interest Rate: "+this.getInterestRate();
	}

}
