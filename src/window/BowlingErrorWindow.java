package window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class BowlingErrorWindow implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		JOptionPane.showMessageDialog(new BowlingWindow(), e);
		
	}
}
