package rd.window;
<<<<<<< HEAD

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
=======
>>>>>>> 573b99bda4c939c3a6100ebabf4ee2a4fb971410
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

<<<<<<< HEAD
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class BowlingWindow extends JFrame implements ActionListener
{

	private JFileChooser chooser = new JFileChooser();
	JTextPane textPane;
	private JLabel lblPlayer;
	private JLabel lblPlayer_1;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BowlingWindow window = new BowlingWindow();
					window.this.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public BowlingWindow() 
	{
		super("Bowling Scores");
		initialize();
		this.setVisible(true);
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		//this = new JFrame();
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(this);
		btnBrowse.setActionCommand("Browse");
		btnBrowse.setBounds(306, 27, 117, 25);
		this.getContentPane().add(btnBrowse);
		
		JLabel lblFile = new JLabel("File:");
		lblFile.setBounds(39, 32, 70, 15);
		this.getContentPane().add(lblFile);
		
		textPane = new JTextPane();
		textPane.setBounds(77, 27, 217, 25);
		this.getContentPane().add(textPane);
		
		lblPlayer = new JLabel("Player 1:");
		lblPlayer.setBounds(12, 123, 70, 15);
		this.getContentPane().add(lblPlayer);
		
		lblPlayer_1 = new JLabel("Player 2:");
		lblPlayer_1.setBounds(12, 193, 70, 15);
		this.getContentPane().add(lblPlayer_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand() == "Browse")
=======
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
>>>>>>> 573b99bda4c939c3a6100ebabf4ee2a4fb971410
		{
			int val = chooser.showOpenDialog(this);
			if(val == chooser.APPROVE_OPTION)
			{
<<<<<<< HEAD
				this.textPane.setText(chooser.getSelectedFile().toString());
=======
				this.f = chooser.getSelectedFile();
				new ScoreFrame(new BowlingScoreFile(this.f));
>>>>>>> 573b99bda4c939c3a6100ebabf4ee2a4fb971410
			}
		}
	}
}
<<<<<<< HEAD
=======

>>>>>>> 573b99bda4c939c3a6100ebabf4ee2a4fb971410
