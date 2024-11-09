package model;

public class CurrentAccount extends Account{
	private double overDraftLimit;

	public CurrentAccount(int accountId, int customerId, Bank bank, String accountType, double balance,
			double overDraftLimit) {
		super(accountId, customerId, bank, accountType, balance);
		this.overDraftLimit = overDraftLimit;
	}

	public double getOverDraftLimit() {
		return overDraftLimit;
	}

	public void setOverDraftLimit(double overDraftLimit) {
		this.overDraftLimit = overDraftLimit;
	}

	@Override
	public String getAccountDetails() {
		// TODO Auto-generated method stub
		return "Current class with overdraftlimit is "+this.overDraftLimit;
	}

	@Override
	public String toString() {
		return "Current Account Details :\n Account Id: "+this.getAccountId()+
				"\n Customer Id: "+this.getCustomerId()+
				"\n Bank: "+this.getBank()+
				"\n Account Type: "+this.getAccountType()+
				"\n Balance: "+this.getBalance()+"\n OverDraftLimit: "+this.getOverDraftLimit();
	}
	
	
}
