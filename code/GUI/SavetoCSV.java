package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import filtersPack.ChooseFilter;
import objects.hash;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class SavetoCSV extends JPanel {
	private JTextField pathnamefile;
	String name="";
	boolean correctName;
	boolean correctfolder;

	/**
	 * Create the panel.
	 */
	public SavetoCSV(Connect c) {
		setLayout(null);
		JButton btnChooseFolder = new JButton("choose folder ");
		btnChooseFolder.addActionListener(new ActionListener() {
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
					System.out.println(path);
				}

				path = path.replace("\\", "/");
				name = path;	

			}
		});
		btnChooseFolder.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		btnChooseFolder.setBounds(94, 95, 241, 52);
		add(btnChooseFolder);


		JLabel lblSaveToCsv = new JLabel("Save to CSV");
		lblSaveToCsv.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		lblSaveToCsv.setBounds(129, 22, 173, 62);
		add(lblSaveToCsv);

		pathnamefile = new JTextField();
		pathnamefile.setColumns(10);
		pathnamefile.setBounds(60, 200, 341, 32);
		add(pathnamefile);

		JLabel lblEnterNameOf = new JLabel("enter name of file");
		lblEnterNameOf.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblEnterNameOf.setBounds(142, 170, 157, 32);
		add(lblEnterNameOf);

		JButton button = new JButton("Enter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pathnamefile.getText().isEmpty()){
					correctName = false;
					JOptionPane.showMessageDialog(new JFrame(), "Enter name please. This field can not be empty!");
				}
				else if(!pathnamefile.getText().isEmpty()){
					correctName = true;
				}
				if (correctName){
					if (name == ""){
						JOptionPane.showMessageDialog(new JFrame(), "Choose folder please. This field can not be empty!");
						correctfolder = false;
					}
					else{
						correctfolder = true;
					}
				}
				if(correctfolder&&correctName){
					String path1 = name+"/"+pathnamefile.getText();
					try {
						c.saveTOcsv(path1);
						JOptionPane.showMessageDialog(new JFrame(), "Write to csv file Completed :)");
						JOptionPane.showMessageDialog(new JFrame(), hash.HowMacAndRow(c.macs));

					} catch (Exception e2) {
						JOptionPane.showMessageDialog(new JFrame(), "Write to csv file failed :(");
					}
				}
			}
		});
		button.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		button.setBounds(173, 243, 85, 32);
		add(button);
	}
}