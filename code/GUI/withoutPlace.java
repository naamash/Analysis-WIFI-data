package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import filtersPack.Filter;
import filtersPack.NOT_filter;
import filtersPack.filter_location;
import objects.hash;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class withoutPlace extends JPanel {
	private JTextField lat;
	private JTextField lon;
	private JTextField rad;

	/**
	 * Create the panel.
	 */
	public withoutPlace(Filter []filters,Connect c) {
		setLayout(null);

		JLabel label = new JLabel(" Write Lat");
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 33));
		label.setBounds(25, 23, 144, 40);
		add(label);

		JLabel label_1 = new JLabel(" Write Lon");
		label_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 33));
		label_1.setBounds(25, 90, 144, 40);
		add(label_1);

		lat = new JTextField();
		lat.setColumns(10);
		lat.setBounds(207, 30, 231, 40);
		add(lat);

		lon = new JTextField();
		lon.setColumns(10);
		lon.setBounds(207, 83, 231, 40);
		add(lon);

		rad = new JTextField();
		rad.setColumns(10);
		rad.setBounds(247, 157, 191, 40);
		add(rad);

		JLabel label_2 = new JLabel(" Write Radious");
		label_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 33));
		label_2.setBounds(25, 157, 210, 40);
		add(label_2);

		JButton button = new JButton(" Enter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String lat1 = lat.getText();
					String lon1 = lon.getText();
					String rad1 = rad.getText();
					Filter ft = new filter_location(lat1, lon1, Double.parseDouble(rad1));
					Filter filter = new NOT_filter(ft);
					if (!(""+filters[1]).equals("null") && !(""+filters[0]).equals("null")) {
						filters[2] = filter;

						if (filters[1].getClass().getName().contains("AND_filter")) {

							c.and_filter(filters[0], filters[2]);
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
						filters[0] = filter;
						JOptionPane.showMessageDialog(new JFrame(), "Filter eccepted");

					}

					else if ((""+filters[0]).equals("null") && (""+filters[1]).equals("null")) {
						filters[0] = filter;
						c.NOT_filter_LOC(lat1, lon1, Double.parseDouble(rad1));
						JOptionPane.showMessageDialog(new JFrame(), "Filters got finished");
						JOptionPane.showMessageDialog(new JFrame(), hash.HowMacAndRow(c.macs));
						filters_writeAndRead.write_filter("matala two\\filter that have been choose.txt", filters);
					} 				
					
				} 
				catch (Exception e2) {
					JOptionPane.showMessageDialog(new JFrame(), "Filter by NOT-location failed");
				}
			}
		});
		button.setFont(new Font("Berlin Sans FB", Font.PLAIN, 33));
		button.setBounds(121, 223, 191, 40);
		add(button);

		JLabel label_3 = new JLabel(" NOT");
		label_3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		label_3.setBounds(168, 0, 56, 28);
		add(label_3);

	}

}
