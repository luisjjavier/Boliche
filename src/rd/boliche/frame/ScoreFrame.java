package rd.boliche.frame;
import java.util.ArrayList;
import java.util.Iterator;

import rd.boliche.BowlingScoreFile;

public class ScoreFrame
{
	Score [] score1 = new Score[12];
	Score [] score2 = new Score[12];
	ArrayList<Integer> player1LineScore;
	ArrayList<Integer> player2LineScore;
	
	public ScoreFrame(BowlingScoreFile bf)
	{
		player1LineScore = bf.getPlayerOneScore();
		player2LineScore = bf.getPlayerTwoScore();
		setScoreOne();
		setScoreTwo();	
	}
	
	private void setScoreOne()
	{
		if(this.player1LineScore.isEmpty())
			return;
		int limit = this.player1LineScore.size()/2;
		int it = 0;
		for(int i = 0; i<limit; i++)
		{	
			this.score1[i] = new Score(this.player1LineScore.get(it), this.player1LineScore.get(it+1));
			it+=2;
		}
	}
	
	private void setScoreTwo()
	{
		if (this.player2LineScore.isEmpty())
			return;
		int limit = this.player2LineScore.size()/2;
		int it = 0;
		for(int i = 0; i<limit; i++)
		{	
			this.score2[i] = new Score(this.player2LineScore.get(it), this.player2LineScore.get(it+1));
			it+=2;
		}
	}
	
	
	private void completePlayerOneScore()
	{
		int limit = this.player1LineScore.size()/2;
		if(score1[11]!=null && score1[9].isStrike())
			limit = 12;
		else if(score1[10]!=null && score1[9].isSpare())
			limit = 11;
		for(int i = 0 ; i<limit; i++)
		{
			if(i == 10 && (!score1[9].isStrike() || !score1[9].isSpare()))
				break;
			
			if(score1[i].isStrike())
				score1[i].addToTotal(score1[i+1].getTotal() + score1[i+2].getTotal());
			if(score1[i].isSpare())
				score1[i].addToTotal(score1[i+1].getTotal() + score1[i+1].getFirstScore());
			if(i>0)
				score1[i].addToTotal(score1[i-1].getTotal());
		}
	}
	
	public Score [] getScoreOne()
	{
		return this.score1;
	}
	
	public Score [] getScoreTwo()
	{
		return this.score2;
	}

}
