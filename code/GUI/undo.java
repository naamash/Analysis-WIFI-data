package GUI;

import javax.swing.JPanel;

import objects.hash;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class undo extends JPanel {

	/**
	 * Create the panel.
	 */
	public undo(Connect c) {
		setLayout(null);
		
		JButton btnNewButton = new JButton("Delete filter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (c.macsBefore.isEmpty()){	
					JOptionPane.showMessageDialog(new JFrame(), "You have to insert DataBase in first!");
				}
				else{
					c.UNDO();
				JOptionPane.showMessageDialog(new JFrame(), hash.HowMacAndRow(c.macs));
				JOptionPane.showMessageDialog(new JFrame(),"Undo got finished. Choose your new choice from menu.");
				}
			}
		});
		btnNewButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		btnNewButton.setBounds(138, 121, 159, 51);
		add(btnNewButton);

	}
}
