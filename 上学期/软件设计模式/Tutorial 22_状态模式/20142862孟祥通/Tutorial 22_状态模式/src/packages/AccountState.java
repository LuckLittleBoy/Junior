package packages;

public abstract class AccountState
{
	protected Account acc;
	protected double balance=0;

    public abstract void stateCheck(double amount);
	
    public void deposit(double amount)
    {
    	System.out.println(acc.getName() + "存款" + amount + "元。");
		this.balance+=amount;
		stateCheck(amount);
		System.out.println("剩余存款为：" + this.balance);
    }
    
	public void withdraw(double amount)
	{
		System.out.println(acc.getName() + "取款" + amount + "元。");
		this.balance-=amount;
		stateCheck(amount);
		System.out.println("剩余存款为：" + this.balance);
	}
	
	public void setBalance(double balance) {
		this.balance = balance; 
	}

	public double getBalance() {
		return (this.balance); 
	}
}