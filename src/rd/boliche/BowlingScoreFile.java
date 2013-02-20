package rd.boliche;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import rd.window.BowlingErrorWindow;


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
			while((s = this.file.readLine()) != null && this.extracted.size()<48) //va llenando la lista extracted del archivo
			{
				this.extracted.add(new Integer(	s));
			}
			
			if(extracted.size() == 0)
				throw new IllegalStateException("no se puede usar un archivo vacio");  //no se le da soporte a 
			
			if(this.extracted.size() % 2 != 0) //si falta el segundo tiro de cualquier jugador se asume como 0
				this.extracted.add(new Integer(0));
			
			if(this.extracted.size()>0)
				this.setPlayerOneScore();				
			if(this.extracted.size()>2) //si el segundo jugador todavia no a jugado por primera vez no pone su score
				this.setPlayerTwoScore();
		}
		catch(Exception e)
		{
			new BowlingErrorWindow(e.getLocalizedMessage());
			//System.exit(-1);
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
