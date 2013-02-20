package window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

import rd.boliche.BowlingScoreFile;
import rd.boliche.frame.ScoreFrame;
public class BowlingWindow extends JFrame implements ActionListener
{
	private File f;
	private JFileChooser chooser = new JFileChooser();
	private JButton b1 =new JButton("get");
	private JPanel p1 = new JPanel();
	private JTextArea t1 = new JTextArea();
	
	public BowlingWindow()
	{
		this.b1.setActionCommand("GET");
		this.b1.addActionListener(this);
		this.add(t1);
		this.p1.add(b1);
		this.add(p1);
		this.p1.setAlignmentY(100);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.pack();
		this.setSize(800,600);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public File getFile()
	{
		return this.f;
	}

	public void actionPerformed(ActionEvent e) 
	{
		if (e.getActionCommand() == "GET")
		{
			int val = chooser.showOpenDialog(this);
			if(val == chooser.APPROVE_OPTION)
			{
				this.f = chooser.getSelectedFile();
				new ScoreFrame(new BowlingScoreFile(this.f));
			}
		}
	}
}

