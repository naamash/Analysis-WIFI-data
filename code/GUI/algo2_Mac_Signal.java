package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class algo2_Mac_Signal extends JPanel {
	private JTextField path;
	private JTextField mac1;
	private JTextField mac2;
	private JTextField mac3;
	private JTextField sig2;
	private JTextField sig3;

	/**
	 * Create the panel.
	 */
	public algo2_Mac_Signal(Connect c) {
		setLayout(null);
		
		JLabel lblAlgo = new JLabel("Algo 2");
		lblAlgo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 35));
		lblAlgo.setBounds(168, 0, 115, 40);
		add(lblAlgo);
		
		path = new JTextField();
		path.setColumns(10);
		path.setBounds(28, 83, 393, 32);
		add(path);
		
		JLabel lblEnterPathOf = new JLabel("Enter path of DataBase folder or file :");
		lblEnterPathOf.setFont(new Font("Berlin Sans FB", Font.PLAIN, 19));
		lblEnterPathOf.setBounds(66, 50, 315, 32);
		add(lblEnterPathOf);
		
		JLabel lblEnterMac = new JLabel("Enter MAC1:");
		lblEnterMac.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblEnterMac.setBounds(0, 128, 89, 32);
		add(lblEnterMac);
		
		JLabel lblEnterMac_1 = new JLabel("Enter MAC2:");
		lblEnterMac_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblEnterMac_1.setBounds(0, 162, 89, 32);
		add(lblEnterMac_1);
		
		JLabel lblEnterMac_2 = new JLabel("Enter MAC3:");
		lblEnterMac_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblEnterMac_2.setBounds(0, 197, 89, 32);
		add(lblEnterMac_2);
		
		mac1 = new JTextField();
		mac1.setColumns(10);
		mac1.setBounds(79, 128, 140, 32);
		add(mac1);
		
		mac2 = new JTextField();
		mac2.setColumns(10);
		mac2.setBounds(79, 162, 140, 32);
		add(mac2);
		
		mac3 = new JTextField();
		mac3.setColumns(10);
		mac3.setBounds(79, 197, 140, 32);
		add(mac3);
		
		JLabel lblEnterSignal = new JLabel("Enter Signal1:");
		lblEnterSignal.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblEnterSignal.setBounds(223, 128, 89, 32);
		add(lblEnterSignal);
		
		JLabel lblEnterSignal_1 = new JLabel("Enter Signal2:");
		lblEnterSignal_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblEnterSignal_1.setBounds(223, 162, 89, 32);
		add(lblEnterSignal_1);
		
		JLabel lblEnterSignal_2 = new JLabel("Enter Signal3:");
		lblEnterSignal_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblEnterSignal_2.setBounds(223, 197, 89, 32);
		add(lblEnterSignal_2);
		
		JTextField sig1 = new JTextField();
		sig1.setColumns(10);
		sig1.setBounds(310, 128, 140, 32);
		add(sig1);
		
		sig2 = new JTextField();
		sig2.setColumns(10);
		sig2.setBounds(310, 163, 140, 32);
		add(sig2);
		
		sig3 = new JTextField();
		sig3.setColumns(10);
		sig3.setBounds(310, 197, 140, 32);
		add(sig3);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String path1 = path.getText();
					File folder = new File(path1);
					String macc1 = mac1.getText();
					String macc2 = mac2.getText();
					String macc3 = mac3.getText();
					String sigs1 = sig1.getText();
					String sigs2 = sig2.getText();
					String sigs3 = sig3.getText();
					System.out.println("66666666");
					;
					JOptionPane.showMessageDialog(new JFrame(), c.Algo2User(folder, macc1, macc2, macc3, sigs1, sigs2, sigs3));
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(new JFrame(), "promlem with algo2 by user.");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		btnNewButton.setBounds(155, 242, 128, 45);
		add(btnNewButton);

	}

}
