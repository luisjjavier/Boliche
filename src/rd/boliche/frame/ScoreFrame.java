package rd.boliche.frame;
import java.io.BufferedReader;



public class ScoreFrame
{
	BufferedReader file;
	Score [] score = new Score[12];
	
	public ScoreFrame(BowlingScoreFile bf)
	{
		file = bf.getFile();
		fillFrame();
		completeScore();
	}
	
	private void fillFrame()
	{
		String s;
		try
		{
			for(int i = 0; i<10; i++)
			{
				s = file.readLine();
				score[i] = new Score(new Integer(s), new Integer(file.readLine()));
			}
			file.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	private void completeScore()
	{
		int j = (score[9].isStrike()) ? 12: (score[9].isSpare()) ? 11 : 10;
		for(int i = 0 ; i<j; i++)
		{
			if(i == 10 && (!score[9].isStrike() || !score[9].isSpare()))
				break;
			
			if(score[i].isStrike())
				score[i].addToTotal(score[i+1].getTotal() + score[i+2].getTotal());
			if(score[i].isSpare())
				score[i].addToTotal(score[i+1].getTotal() + score[i+1].getFirstScore());
			if(i>0)
				score[i].addToTotal(score[i-1].getTotal());
			score[i].printScore();
		}
	}
	
	public void print()
	{
		for(Score ss:score)
			if(ss != null)
				ss.printScore();
	}
}
