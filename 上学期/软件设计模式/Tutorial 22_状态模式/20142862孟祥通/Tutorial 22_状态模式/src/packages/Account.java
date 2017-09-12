package packages;

public class Account
{
	private AccountState state;
	private String owner;
	public Account(String owner,double init)
	{
		this.owner=owner;
		this.state=new GreenState(init,this);
	}
	
	public void setState(AccountState state)
	{
		this.state=state;
	}
	
	public AccountState getState()
	{
		return this.state;
	}
	
	public void setName(String owner)
	{
		this.owner=owner;
	}
	
	public String getName()
	{
		return this.owner;
	}
	
    public void deposit(double amount)
    {	
		state.deposit(amount);
    }
    
	public void withdraw(double amount)
	{
		state.withdraw(amount);
	}
}