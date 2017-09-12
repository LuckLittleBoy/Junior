public class PeopleSay
{
	private ISayLanguage say;
    public void sayEnglish()
    {
    	say.say();
    }
	public ISayLanguage getSay()
	{
		return say;
	}

	public void setSay(ISayLanguage say)
	{
		this.say = say;
	}
}
