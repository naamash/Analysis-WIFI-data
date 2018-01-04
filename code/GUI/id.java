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
					String filter = "";
					String id = path.getText();
					if (!id.substring(0, 8).equals("display=")){
						id = "display="+id;
					}
					Filter ft = new filter_id(id);
					if (!((""+filters[1]).equals("null")) && !(""+filters[0]).equals("null")) {
						filters[2] = ft;
						if (filters[1].getClass().getName().contains("AND_filter")) {
							if (!c.and_filter(filters[0], filters[2])){
								JOptionPane.showMessageDialog(new JFrame(), "You must insert choose B");
							}
							JOptionPane.showMessageDialog(new JFrame(), "Filters got finished");
							JOptionPane.showMessageDialog(new JFrame(), hash.HowMacAndRow(c.macs));
							filters_writeAndRead.write_filter("matala two\\filter that have been choose.txt", filters);
						} else if (filters[1].getClass().getName().contains("OR_filter")) {
							c.OR_filter(filters[0], filters[2]);
							JOptionPane.showMessageDialog(new JFrame(), "Filters got finished");
							JOptionPane.showMessageDialog(new JFrame(), hash.HowMacAndRow(c.macs));
							filters_writeAndRead.write_filter("matala two\\filter that have been choose.txt", filters);
						}
					} else if (!(""+filters[1]).equals("null") && (""+filters[0]).equals("null")) {
						filters[0] = ft;
						JOptionPane.showMessageDialog(new JFrame(), "Filter eccepted");

//						filter = "ID*"+id+",";
					}
					else if ((""+filters[0]).equals("null") && (""+filters[1]).equals("null")) {
						filters[0] = ft;
						c.addfilter_ID(id);
						JOptionPane.showMessageDialog(new JFrame(), "Filter by ID got finished");
						JOptionPane.showMessageDialog(new JFrame(), hash.HowMacAndRow(c.macs));
						filters_writeAndRead.write_filter("matala two\\filter that have been choose.txt", filters);
//						filter = "ID*"+id+",";
					}
				}
				catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(new JFrame(), "Filter by ID failed :(");
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