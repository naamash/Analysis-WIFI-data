package GUI;

import javax.swing.JPanel;

import objects.hash;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class clear extends JPanel {

	/**
	 * Create the panel.
	 */
	public clear(Connect c) {
		setLayout(null);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (c.macsBefore.isEmpty()){	
					JOptionPane.showMessageDialog(new JFrame(), "Nothing to clear!");
				}
				else{
					c.CLEAR();
				try {
					JOptionPane.showMessageDialog(new JFrame(), hash.HowMacAndRow(c.macs));
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(new JFrame(),"Clear got finished. Add new file or folder from menu.");
				}
			}
		});
		btnClear.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		btnClear.setBounds(133, 121, 159, 51);
		add(btnClear);

	}

}
