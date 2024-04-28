package casino_game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class GUI {
	static int dim_x, dim_y;
	static String player_name;
	static double deposit;
	
	public static void main_game_menu(int x, int y) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame win = new JFrame();
		win.setSize(new Dimension(x, y));
		
		//win.setIconImage(new ImageIcon("default.png").getImage());
		
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		win.getContentPane().setLayout(null);
		
		JLabel hello = new JLabel("Enter Name:");
		hello.setBounds(new Rectangle(32, 32, 288, 64));
		hello.setFont(new Font("Segoi UI", Font.BOLD, 44));
		hello.setVisible(true);
		
		win.add(hello);
		
		JTextField name_in = new JTextField("Enter name...");
		name_in.setBounds(new Rectangle(320, 32, 384, 64));
		name_in.setFont(new Font("Segoi UI", Font.BOLD, 44));
		name_in.setVisible(true);
		win.add(name_in);
		
		JButton name_confirm = new JButton("Confirm Name");
		name_confirm.setBounds(new Rectangle(320, 160, 384, 64));
		name_confirm.setFont(new Font("Segoi UI", Font.BOLD, 44));
		name_confirm.setVisible(true);
		name_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame[] frame_arr = {win};
				GUI.player_name = name_in.getText();
				System.out.println("Hello, " + GUI.player_name);
				deposit_page(frame_arr);
			}
		});
		win.add(name_confirm);
		
		win.repaint();
		win.setVisible(true);
	}
	
	public static void deposit_page(JFrame[] frame) {
		frame[0].getContentPane().removeAll();
		frame[0].revalidate();
		
		JLabel enter_label = new JLabel("Enter Deposit:");
		enter_label.setBounds(new Rectangle(32, 32, 320, 64));
		enter_label.setFont(new Font("Segoi UI", Font.BOLD, 44));
		enter_label.setVisible(true);
		frame[0].add(enter_label);
		
		JTextField deposit_in = new JTextField("Enter deposit...");
		deposit_in.setBounds(new Rectangle(384, 32, 384, 64));
		deposit_in.setFont(new Font("Segoi UI", Font.BOLD, 44));
		deposit_in.setVisible(true);
		frame[0].add(deposit_in);
		
		JButton deposit_confirm = new JButton("Confirm Deposit");
		deposit_confirm.setBounds(new Rectangle(320, 160, 384, 64));
		deposit_confirm.setFont(new Font("Segoi UI", Font.BOLD, 44));
		deposit_confirm.setVisible(true);
		deposit_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.deposit = Double.parseDouble(deposit_in.getText());
				System.out.printf("Initial Deposit =  $%.2f\n",GUI.deposit);
				main_gamble_page(frame);
			}
		});
		frame[0].add(deposit_confirm);
		
		frame[0].repaint();
		frame[0].setVisible(true);
	}
	
	public static void main_gamble_page(JFrame[] frame) {
		frame[0].getContentPane().removeAll();
		frame[0].revalidate();
		
		JLabel rules = new JLabel("RULES OF THE GAME");
		rules.setBounds(new Rectangle(32, 32, 512, 64));
		rules.setFont(new Font("Segoi UI", Font.BOLD, 36));
		rules.setVisible(true);
		frame[0].add(rules);
		
		frame[0].repaint();
		frame[0].setVisible(true);
	}
}
