package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;

import filtersPack.Filter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrB extends JPanel {

	/**
	 * Create the panel.
	 */
	public OrB(Filter []filters,Connect c) {
		setLayout(null);
		
		JLabel label = new JLabel("B");
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		label.setBounds(194, 21, 21, 35);
		add(label);
		
		JRadioButton timeB = new JRadioButton("Time");
		timeB.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		timeB.setBounds(115, 65, 185, 25);
		add(timeB);
		
		JRadioButton locB = new JRadioButton("Location");
		locB.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		locB.setBounds(115, 95, 185, 25);
		add(locB);
		
		JRadioButton idB = new JRadioButton("ID display");
		idB.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		idB.setBounds(115, 125, 185, 25);
		add(idB);
		
		JRadioButton nottimeB = new JRadioButton("NOT Time");
		nottimeB.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		nottimeB.setBounds(115, 155, 185, 25);
		add(nottimeB);
		
		JRadioButton notlocB = new JRadioButton("NOT Location");
		notlocB.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		notlocB.setBounds(115, 185, 185, 25);
		add(notlocB);
		
		JRadioButton notidB = new JRadioButton("NOT ID display");
		notidB.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		notidB.setBounds(115, 215, 185, 25);
		add(notidB);
		
		JButton button = new JButton("Enter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		button.setBounds(141, 262, 114, 38);
		add(button);

		ButtonGroup groupA  = new ButtonGroup();
		groupA.add(timeB);
		groupA.add(locB);
		groupA.add(idB);
		groupA.add(nottimeB);
		groupA.add(notlocB);
		groupA.add(notidB);
		timeB.setSelected(true);
		
		
	}

}
