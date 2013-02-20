package rd.boliche;

import java.io.File;

import rd.boliche.frame.Score;
import rd.boliche.frame.ScoreFrame;
import rd.window.BowlingErrorWindow;
import rd.window.BowlingWindow;


public class Main 
{
	public static void main(String[] args) 
	{
		//new BowlingWindow();
		ScoreFrame sf = new ScoreFrame(new BowlingScoreFile(new File("src/rd/boliche/bowling.txt")));
		Score s = sf.getScoreOne()[0];
		System.out.println(s.getFirstScore() + "\\"+ s.getSecondScore());
	}
}