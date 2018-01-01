package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class gui extends JFrame {

	private JPanel contentPane;
	private JTextField solik;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui frame = new gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton addcsv = new JButton("enter");
		addcsv.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		addcsv.setBounds(130, 184, 153, 38);
		addcsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String t = solik.getText();
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(addcsv);
		
		solik = new JTextField();
		solik.setBounds(78, 107, 301, 38);
		contentPane.add(solik);
		solik.setColumns(10);
		
		JLabel lblYyyy = new JLabel("please add csv file");
		lblYyyy.setFont(new Font("Berlin Sans FB", Font.PLAIN, 45));
		lblYyyy.setBounds(42, 37, 337, 51);
		contentPane.add(lblYyyy);
		
		JLabel lblPath = new JLabel("path");
		lblPath.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblPath.setBounds(12, 107, 68, 38);
		contentPane.add(lblPath);
	}
}
