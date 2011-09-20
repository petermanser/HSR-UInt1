package u1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;


public class Listener extends javax.swing.JFrame {

	private final Color up = new Color(240, 60, 60);
	private final Color down = new Color(70, 190, 100);
	private final Color resized = new Color(220, 190, 40);
	private final Color white = new Color(255, 255, 255);

	private JLabel lblDemo;
	private JButton add;
	private JPanel detector;

	private int counter = 0;

	private int mousePosY = 0;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Listener inst = new Listener();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public Listener() {
		super();
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				detector.setBackground(resized);
			}
		});
		initGUI();
	}

	private void initGUI() {
		try {
			KeyboardFocusManager kfm = KeyboardFocusManager.getCurrentKeyboardFocusManager();
			kfm.addKeyEventDispatcher(new KeyEventDispatcher() {
				@Override
				public boolean dispatchKeyEvent(KeyEvent e) {
					if (e.getID() == 402) {
						if (e.getKeyCode() == 38) {
							detector.setBackground(detector.getBackground().darker());
						} else if (e.getKeyCode() == 40) {
							detector.setBackground(detector.getBackground().brighter());
						}
					}
					
					return false;
				}
			});
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

			{
				lblDemo = new JLabel();
				getContentPane().add(lblDemo, BorderLayout.NORTH);
				lblDemo.setText("ListenerDemo");
			}
			{
				add = new JButton("add Button");
				add.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						addNewButton();
					}
				});
				getContentPane().add(add, BorderLayout.SOUTH);
			}
			{
				detector = new JPanel();
				detector.addContainerListener(new ContainerAdapter() {
					@Override
					public void componentAdded(ContainerEvent arg0) {
						detector.setBackground(white);
					}
				});
				detector.addMouseMotionListener(new MouseMotionAdapter() {
					@Override
					public void mouseMoved(MouseEvent arg0) {
						if (arg0.getY() > mousePosY) {
							detector.setBackground(down);
						} else if (arg0.getY() < mousePosY) {
							detector.setBackground(up);
						}
						mousePosY = arg0.getY();
					}
				});
				getContentPane().add(detector, BorderLayout.CENTER);
				detector.setBorder(new LineBorder(new java.awt.Color(0, 0, 0),
						1, false));
				detector.setPreferredSize(new java.awt.Dimension(200, 200));
				detector.setSize(200, 200);
			}
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addNewButton() {
		detector.add(new JButton(counter++ + ""));
		detector.validate();
	}

}
