package ccv;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


public class GuiTest extends JFrame implements MouseListener
{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static boolean running = false ;
	private static int counter = 0; 
	private JPanel panel;
	private JLabel label;
	UpdateGu gu;
	Thread t;
	 
	public GuiTest() {
		gu = new UpdateGu();
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
	
		panel = new JPanel(new BorderLayout());
		panel.addMouseListener(this);
		panel.setPreferredSize(new Dimension(200, 200));
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
	
		label = new JLabel("0");
		panel.add(gu);
		add(panel);
		add(label);
		pack();
		setVisible(true);
	}
	
	
	public void invokeWindow() {
		
		t = new Thread( new Runnable() {
			@Override
			public void run() {
				
				while(true) {
					running = false;
					
					gu.repaint();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return;
					}
					running = true;
					gu.repaint();
					counter++;
					label.setText(String.valueOf(counter));
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return;
					}
				}
				
			}
		});
		
		t.start();
	}
	 
	 public static void main(String args[]) {
		 new GuiTest();
	 }

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		invokeWindow();
		
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		t.interrupt();
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	public class UpdateGu extends JPanel {

		private static final long serialVersionUID = 1L;
		
		public void paintComponent(Graphics g ) {
			if(running == true) {
				System.out.println("ziziziziziz");
				g.setColor(Color.GREEN);
				g.fillOval(0, 0, 20, 30);
			}
			else {
				System.out.println("bibibibibib");
				g.setColor(getBackground());
				g.fillRect(0, 0, 20, 30);
			}
		}
		

	}
	
	
}
