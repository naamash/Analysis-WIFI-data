package GUI;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import filtersPack.AND_filter;
import filtersPack.Filter;
import filtersPack.NOT_filter;
import filtersPack.filter_id;
import objects.hash;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class id extends JPanel {
	private JTextField path;
	private String id;

	/**
	 * Create the panel.
	 */
	public id(Filter []filters,Connect c) {
		setLayout(null);

		JLabel lblPleaseEnterId = new JLabel(" Please enter ID display");
		lblPleaseEnterId.setFont(new Font("Berlin Sans FB", Font.PLAIN, 43));
		lblPleaseEnterId.setBounds(12, 36, 426, 60);
		add(lblPleaseEnterId);

		path = new JTextField();
		path.setBounds(33, 128, 386, 46);
		add(path);
		path.setColumns(10);

		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id = path.getText();
					Filter ft = new filter_id(id);

					if (filters[1] != null && filters[0] != null) {
						filters[2] = ft;

						if (filters[1].getClass().getName().contains("AND_filter")) {

							c.and_filter(filters[0], filters[2]);
						} else if (filters[1].getClass().getName().contains("OR_filter")) {
							c.OR_filter(filters[0], filters[2]);
						}
					} else if (filters[1] != null && filters[0] == null) {
						filters[0] = ft;
					}

					else if (filters[0] == null && filters[1] == null) {
						filters[0] = ft;
						c.addfilter_ID(id);
					} 	
					JOptionPane.showMessageDialog(new JFrame(), "Filter by ID got finished");
					JOptionPane.showMessageDialog(new JFrame(), hash.HowMacAndRow(c.macs));
				}
				catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(new JFrame(), "Filter by ID failed :)");
				}

			}

		});
		btnNewButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 41));
		btnNewButton.setBounds(123, 206, 191, 46);
		add(btnNewButton);

	}
}

//NRD90M.G950FXXU1AQJ5

//32.17237425
//34.81350895