package rd.boliche.frame;

public final class Score 
{
	private int score1;
	private int score2;
	private int scoreTotal;
	
	Score(int s1, int s2)
	{
		try
		{
			this.score1 = s1;
			this.score2 = s2;
			if(s1+s2>10)
				throw new IllegalStateException("Numero de puntuacion pasada");
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			System.exit(-1);
		}
		this.scoreTotal = s1+s2; 
	}

	public void printScore()
	{
			if(this.isStrike())
				System.out.println("X  | |");
			else if(this.isSpare())
				System.out.println(this.score1 + "  |"+"/|");
			else if (this.score2 == 0)
				System.out.println(this.score1 + "  |"+"-|");
			else if(this.score1 + this.score2 <10)
				System.out.println(this.score1+"  |"+this.score2+"|");
				
		
		System.out.println(this.scoreTotal+"\n");
	}
	
	public void addToTotal(int num)
	{
		this.scoreTotal += num;
	}
	
	public int getTotal()
	{
		return this.scoreTotal;
	}
	
	public int getFirstScore()
	{
		return this.score1;
	}
	
	public boolean isStrike()
	{
		return (this.score1==10) ? true:false;
	}
	
	public boolean isSpare()
	{
		if(this.score1 != 10 && (this.score1 + this.score2 == 10))
			return true;
		return false;
	}
}