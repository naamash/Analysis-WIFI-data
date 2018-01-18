package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import filtersPack.Filter;
import filtersPack.NOT_filter;
import filtersPack.filter_id;
import objects.hash;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class withoutID extends JPanel {
	private JTextField id;

	/**
	 * Create the panel.
	 */
	public withoutID(Filter[] filters,Connect c) {
		setLayout(null);
		
		JLabel label = new JLabel(" Please enter ID display");
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 43));
		label.setBounds(12, 37, 426, 60);
		add(label);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(33, 129, 386, 46);
		add(id);
		
		JButton button = new JButton("Enter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String id1 = id.getText();
					Filter ft = new filter_id(id1);
					Filter filter = new NOT_filter(ft);
					if (!(""+filters).equals("null") && !(""+filters[0]).equals("null")) {
						filters[2] = filter;

						if (filters[1].getClass().getName().contains("AND_filter")) {

							c.and_filter(filters[0], filters[2]);
							JOptionPane.showMessageDialog(new JFrame(), "Filters got finished");
							JOptionPane.showMessageDialog(new JFrame(), hash.HowMacAndRow(c.macs));
							filters_writeAndRead.write_filter("matala two\\filter that have been choose.txt", filters);
							JOptionPane.showMessageDialog(new JFrame(), "Information file about filters saved as 'filter that have been choose.txt' in this project in 'matala two' folder.");

						} else if (filters[1].getClass().getName().contains("OR_filter")) {
							c.OR_filter(filters[0], filters[2]);
							JOptionPane.showMessageDialog(new JFrame(), "Filters got finished");
							JOptionPane.showMessageDialog(new JFrame(), hash.HowMacAndRow(c.macs));
							filters_writeAndRead.write_filter("matala two\\filter that have been choose.txt", filters);
							JOptionPane.showMessageDialog(new JFrame(), "Information file about filters saved as 'filter that have been choose.txt' in this project in 'matala two' folder.");

						}
					} else if (!(""+filters[1]).equals("null") && (""+filters[0]).equals("null")) {
						filters[0] = filter;
						JOptionPane.showMessageDialog(new JFrame(), "Filter eccepted");
					}

					else if ((""+filters[0]).equals("null") && (""+filters[1]).equals("null")) {
						filters[0] = filter;
						c.NOT_filter_ID(id1);
						JOptionPane.showMessageDialog(new JFrame(), "Filters got finished");
						JOptionPane.showMessageDialog(new JFrame(), hash.HowMacAndRow(c.macs));
						filters_writeAndRead.write_filter("matala two\\filter that have been choose.txt", filters);
						JOptionPane.showMessageDialog(new JFrame(), "Information file about filters saved as 'filter that have been choose.txt' in this project in 'matala two' folder.");
					} 
					
				} 
				catch (Exception e2) {
					JOptionPane.showMessageDialog(new JFrame(), "Filter by NOT-ID failed");
				}
			}
		});
		button.setFont(new Font("Berlin Sans FB", Font.PLAIN, 41));
		button.setBounds(123, 207, 191, 46);
		add(button);
		
		JLabel label_1 = new JLabel(" NOT");
		label_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		label_1.setBounds(188, 0, 56, 28);
		add(label_1);

	}

}
