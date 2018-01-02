package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JRadioButton;

import filtersPack.Filter;
import filtersPack.OR_filter;
import GUI.Time;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrA extends JPanel {

	JPanel Time;
	JPanel Loc;
	
	/**
	 * Create the panel.
	 */
	public OrA(Filter [] filters,Connect c) {
		setLayout(null);
		
		JRadioButton timeA = new JRadioButton("Time");
//		timeA.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if(e.getSource().equals(timeA))
//				{
//					if(timeA.isSelected())
//					{
//						
//						Time time= new Time(filters, c);
//						time.setVisible(true);
//						
//					}
//				}
//			}
//		});
		timeA.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		timeA.setBounds(136, 61, 114, 25);
		add(timeA);
		
		JRadioButton locA = new JRadioButton("Location");
		locA.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		locA.setBounds(136, 91, 125, 25);
		add(locA);
		
		JRadioButton idA = new JRadioButton("ID display");
		idA.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		idA.setBounds(136, 121, 133, 25);
		add(idA);
		
		JRadioButton nottimeA = new JRadioButton("NOT Time");
		nottimeA.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		nottimeA.setBounds(136, 151, 149, 25);
		add(nottimeA);
		
		JRadioButton notlocA = new JRadioButton("NOT Location");
		notlocA.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		notlocA.setBounds(136, 181, 185, 25);
		add(notlocA);
		
		JRadioButton notidA = new JRadioButton("NOT ID display");
		notidA.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		notidA.setBounds(136, 211, 185, 25);
		add(notidA);
		
		JLabel lblNewLabel = new JLabel("A");
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblNewLabel.setBounds(190, 17, 21, 35);
		add(lblNewLabel);
		

		ButtonGroup groupA  = new ButtonGroup();
		groupA.add(locA);
		groupA.add(timeA);
		groupA.add(idA);
		groupA.add(nottimeA);
		groupA.add(notlocA);
		groupA.add(notidA);
		notidA.setSelected(true);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(timeA.isSelected())
					{
						Time time= new Time(filters, c);
						time.setVisible(true);
						System.out.println("nereeeeeeeeeeeeeettttttttttt");
					}
			}
		});
		btnEnter.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		btnEnter.setBounds(158, 245, 103, 42);
		add(btnEnter);
		
	}
	
}
