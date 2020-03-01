import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * @author Pinhas
 * 
 * java GUI count to 10 by theread
 * 
 *
 */
public class Gui implements ActionListener {
	
	private JTextField textField;
	private JFrame frame;
	private JPanel panel_2;
	private JLabel lable;
	private JPanel panel_1;
	private JButton start;
	private JButton stop;
	private Thread t;
	
	
	/**
	 * @param constractor
	 */
	public Gui(){
		
		frame = new JFrame("phone number");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocation(new Point(50,50));
		//frame.setPreferredSize(new Dimension(600,400));
		Container cp = frame.getContentPane();
		cp.setLayout(new BoxLayout( cp , BoxLayout.Y_AXIS));
		
		panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(200,30));
		panel_2.setBorder(BorderFactory.createEmptyBorder());
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		lable = new JLabel("Enter number      ");
		textField = new JTextField(10);
		textField.setText("0");
		panel_2.add(lable);
		panel_2.add(textField);
		frame.add(panel_2);
		
		
		panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(200,30));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		frame.add(panel_1);
		start = new JButton("start");
		start.addActionListener(this);
		stop = new JButton("stop");
		stop.setEnabled(false);
		stop.addActionListener(this);
		panel_1.add(start);
		panel_1.add(stop);
		
		frame.pack();
		frame.setVisible(true);
		
		
		
		
		
	}

	public static void main(String[] args) {
		new Gui();

	}

	/**
	 * @param n
	 * 
	 * run a thread to update the JLable 
	 */
	public void invokeinitWindow(int n){
		t = new Thread( new Runnable(){
			
				public void run() {
					int num_1 = n;
					while(num_1 <= 10 ) {
						textField.setText(String.valueOf(num_1++));
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
							return;
						}
					}
					textField.setText("0");
					start.setEnabled(true);
					stop.setEnabled(false);
				}
			}
		);
		
		t.start();
		
	}
	
	/**
	 * split the actions for each button
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		int num = Integer.parseInt(textField.getText());
		if(e.getSource() == start) {
			start.setEnabled(false);
			stop.setEnabled(true);
			
			invokeinitWindow(num);
			
			
		}
		else if(e.getSource() == stop) {
			
			
			t.interrupt(); //stop the thread
			
			start.setEnabled(true);
			stop.setEnabled(false);
		}
	}
	

}
