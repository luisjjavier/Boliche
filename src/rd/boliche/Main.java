package rd.boliche;

import java.io.File;
import java.io.FileNotFoundException;
import rd.boliche.frame.BowlingScoreFile;
import rd.boliche.frame.ScoreFrame;


public class Main 
{
	public static void main(String[] args) 
	{
		ScoreFrame sc = null;
		try
		{
			File f = new File("src/rd/boliche/bowling.txt");
			if(!f.exists())
				throw new FileNotFoundException("El archivo no existe");
			sc = new ScoreFrame(new BowlingScoreFile(f));
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		catch(ArrayIndexOutOfBoundsException e1)
		{
			System.out.println("Introduzca un archivo");
			System.exit(-1);
		}
		
		sc.print();
	}
}