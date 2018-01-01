package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Loc extends JPanel {
	private JTextField lat;
	private JTextField lon;
	private JTextField rad;

	/**
	 * Create the panel.
	 */
	public Loc(Connect c) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Write Lat");
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 33));
		lblNewLabel.setBounds(25, 35, 144, 40);
		add(lblNewLabel);
		
		JLabel lblWriteLon = new JLabel(" Write Lon");
		lblWriteLon.setFont(new Font("Berlin Sans FB", Font.PLAIN, 33));
		lblWriteLon.setBounds(25, 102, 144, 40);
		add(lblWriteLon);
		
		JLabel lblWriteRadious = new JLabel(" Write Radious");
		lblWriteRadious.setFont(new Font("Berlin Sans FB", Font.PLAIN, 33));
		lblWriteRadious.setBounds(25, 169, 210, 40);
		add(lblWriteRadious);
		
		lat = new JTextField();
		lat.setBounds(207, 42, 231, 40);
		add(lat);
		lat.setColumns(10);
		
		lon = new JTextField();
		lon.setColumns(10);
		lon.setBounds(207, 95, 231, 40);
		add(lon);
		
		rad = new JTextField();
		rad.setColumns(10);
		rad.setBounds(247, 169, 191, 40);
		add(rad);
		
		JButton btnNewButton = new JButton(" Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String lat1 = lat.getText();
				String lon1 = lon.getText();
				String rad1 = rad.getText();
				c.addfilter_LOC(lat1, lon1, Double.parseDouble(rad1));
			}
		});
		btnNewButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 33));
		btnNewButton.setBounds(121, 235, 191, 40);
		add(btnNewButton);

	}

}
