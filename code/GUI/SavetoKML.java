package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class SavetoKML extends JPanel {
	private JTextField textField;
	String name="";
	boolean correct = false;
	
	/**
	 * Create the panel.
	 */
	public SavetoKML(Connect c) {
		setLayout(null);
		JButton button = new JButton("choose folder ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("Choose Folder");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);

				String path = "";
				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					File f = chooser.getSelectedFile();
					path = f.getAbsolutePath();
				}
				path = path.replace("\\", "/");
				name = path;
			}
		});
		button.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		button.setBounds(106, 93, 241, 52);
		add(button);
		
		JLabel lblNewLabel = new JLabel("Save to KML");
		lblNewLabel.setBounds(141, 36, 173, 62);
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(72, 198, 341, 32);
		add(textField);
		
		JLabel label = new JLabel("enter name of file");
		label.setFont(new Font("Dialog", Font.PLAIN, 20));
		label.setBounds(154, 168, 157, 32);
		add(label);
		
		JButton button_1 = new JButton("Enter");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty()){
					correct = false;
					JOptionPane.showMessageDialog(new JFrame(), "Enter name again. This field can not be empty!");
				}
				if(!textField.getText().isEmpty()){
					correct = true;
				}
				if (correct){
					String path1 = name+"/"+textField.getText();
					System.out.println("gg   "+path1);
					c.saveTOkml(path1);
				}
				
			}
		});
		button_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		button_1.setBounds(185, 241, 85, 32);
		add(button_1);

	}
}