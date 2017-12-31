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
		
		JButton btnNewButton = new JButton("New ");
		btnNewButton.setBounds(10, 228, 422, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String t = solik.getText();
				System.out.println(t);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		solik = new JTextField();
		solik.setBounds(104, 167, 116, 22);
		contentPane.add(solik);
		solik.setColumns(10);
		
		JLabel lblYyyy = new JLabel("yyyy");
		lblYyyy.setBounds(149, 85, 56, 16);
		contentPane.add(lblYyyy);
	}
}
