package rd.boliche.frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public final class BowlingScoreFile 
{
	private BufferedReader file;
	
	public BowlingScoreFile(File s)
	{
		try
		{
			this.file = new BufferedReader(new FileReader(s));
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	BufferedReader getFile()
	{
		return this.file;
	}
}
