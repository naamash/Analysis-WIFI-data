package GUI;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class sql extends JPanel {
	private JTextField ipText;
	private JTextField portText;
	private JTextField userrText;
	private JTextField passText;
	private JTextField webText;
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
		
		portText = new JTextField();
		portText.setColumns(10);
		portText.setBounds(27, 121, 176, 43);
		add(portText);
		
		JLabel urlText = new JLabel("port");
		urlText.setFont(new Font("Berlin Sans FB", Font.PLAIN, 35));
		urlText.setBounds(76, 87, 62, 31);
		add(urlText);
		
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
				c.sql(ip, url, user, pas);
				JOptionPane.showMessageDialog(new JFrame(), "The information from SQL got read successfully");

			}
		});
		save.setFont(new Font("Berlin Sans FB", Font.PLAIN, 35));
		save.setBounds(163, 242, 113, 45);
		add(save);
		
		webText = new JTextField();
		webText.setColumns(10);
		webText.setBounds(240, 195, 176, 43);
		add(webText);
		
		JLabel lblWeb = new JLabel("web");
		lblWeb.setFont(new Font("Berlin Sans FB", Font.PLAIN, 35));
		lblWeb.setBounds(288, 163, 80, 31);
		add(lblWeb);
		
		urllText = new JTextField();
		urllText.setColumns(10);
		urllText.setBounds(27, 195, 176, 43);
		add(urllText);
		
		JLabel lblUrl = new JLabel("url");
		lblUrl.setFont(new Font("Berlin Sans FB", Font.PLAIN, 35));
		lblUrl.setBounds(87, 163, 53, 31);
		add(lblUrl);

	}
}
