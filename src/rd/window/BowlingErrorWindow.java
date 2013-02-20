package rd.window;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;

public class BowlingErrorWindow extends JOptionPane
{
	private JFrame frame;
	public BowlingErrorWindow(String s) 
	{
		this.showMessageDialog(null,s,"Warning", JOptionPane.WARNING_MESSAGE);
	}
}
