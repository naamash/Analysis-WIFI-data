package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class withoutID extends JPanel {
	private JTextField id;

	/**
	 * Create the panel.
	 */
	public withoutID(Connect c) {
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
				String id1 = id.getText();
				c.NOT_filter_ID(id1);
			}
		});
		button.setFont(new Font("Berlin Sans FB", Font.PLAIN, 41));
		button.setBounds(123, 207, 191, 46);
		add(button);

	}

}
