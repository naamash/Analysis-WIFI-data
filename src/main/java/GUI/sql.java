package GUI;

import javax.swing.JPanel;
import javax.swing.JTextField;

import objects.hash;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class sql extends JPanel {
	private JTextField ipText;
	private JTextField userrText;
	private JTextField passText;
	private JTextField urllText;

	/**
	 * Create the panel.
	 */
	public sql(Connect c) {
		setLayout(null);
		
		ipText = new JTextField();
		ipText.setBounds(27, 46, 176, 43);
		add(ipText);
		ipText.setColumns(10);
		
		JLabel lblIp = new JLabel("IP");
		lblIp.setFont(new Font("Berlin Sans FB", Font.PLAIN, 35));
		lblIp.setBounds(101, 13, 39, 31);
		add(lblIp);
		
		userrText = new JTextField();
		userrText.setColumns(10);
		userrText.setBounds(240, 46, 176, 43);
		add(userrText);
		
		JLabel userText = new JLabel("user");
		userText.setFont(new Font("Berlin Sans FB", Font.PLAIN, 35));
		userText.setBounds(300, 13, 68, 31);
		add(userText);
		
		passText = new JTextField();
		passText.setColumns(10);
		passText.setBounds(240, 121, 176, 43);
		add(passText);
		
		JLabel pasText = new JLabel("password");
		pasText.setFont(new Font("Berlin Sans FB", Font.PLAIN, 35));
		pasText.setBounds(254, 87, 151, 31);
		add(pasText);
		
		JButton save = new JButton("save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ip = ipText.getText();
//				String port = portText.getText();
				String url = urllText.getText();
//				String web = webText.getText();
				String pas = passText.getText();
				String user = userrText.getText();  
//				c.sql(ip, url, user, pas);
				
				
				try {
					MySql.test_ex4_db(ip, url, pas,user);
					JOptionPane.showMessageDialog(new JFrame(), "The information from SQL got read successfully");
					JOptionPane.showMessageDialog(new JFrame(), hash.HowMacAndRow(c.macs));
				} catch (HeadlessException | IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(new JFrame(), "Problem with connecting to SQL");
				}

			}
		});
		save.setFont(new Font("Berlin Sans FB", Font.PLAIN, 35));
		save.setBounds(163, 242, 113, 45);
		add(save);
		
		urllText = new JTextField();
		urllText.setColumns(10);
		urllText.setBounds(27, 121, 176, 43);
		add(urllText);
		
		JLabel lblUrl = new JLabel("url");
		lblUrl.setFont(new Font("Berlin Sans FB", Font.PLAIN, 35));
		lblUrl.setBounds(87, 89, 53, 31);
		add(lblUrl);

	}
}
