package rd.boliche;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public final class BowlingScoreFile
{
	private BufferedReader file;
	private ArrayList<Integer> extracted = new ArrayList<Integer>();
	private ArrayList<Integer> player1 = new ArrayList<Integer>();
	private ArrayList<Integer> player2 = new ArrayList<Integer>();
	
	
	public BowlingScoreFile(File f)
	{
		try
		{
			this.file = new BufferedReader(new FileReader(f));
			String s = null;
			while((s = this.file.readLine()) != null && this.extracted.size()<40) 
					this.extracted.add(new Integer(	s));
			if(this.extracted.size() % 2 != 0)
				this.extracted.add(new Integer(0));
			this.setPlayerOneScore();
			this.setPlayerTwoScore();
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	private void setPlayerOneScore()
	{
		for(int i = 0; i<this.extracted.size();)
		{
			this.player1.add(this.extracted.get(i));
			i++;
			this.player1.add(this.extracted.get(i));
			i+=3;
		}
	}
	
	public ArrayList<Integer> getPlayerOneScore()
	{
		return this.player1;
	}
	
	private void setPlayerTwoScore()
	{
		for(int i = 2; i<this.extracted.size();)
		{
			this.player2.add(this.extracted.get(i));
			i++;
			this.player2.add(this.extracted.get(i));
			i+=3;
		}
	}
	
	public ArrayList<Integer> getPlayerTwoScore()
	{
		return this.player2;
	}
}
