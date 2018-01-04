package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import objects.hash;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.ActionEvent;

public class algo2_folders extends JPanel {
	private JTextField save;
	String link="";
	String link2="";
	String name = "";
	boolean correctName;
	boolean correctlink;
	boolean correctlink2;
	boolean correctfolder;


	/**
	 * Create the panel.
	 */
	public algo2_folders(Connect c) {
		setLayout(null);

		JLabel label = new JLabel("Algo 2");
		label.setFont(new Font("Dialog", Font.PLAIN, 27));
		label.setBounds(183, 0, 80, 32);
		add(label);

		JLabel lblEnterPathOf_1 = new JLabel("Choose lesses information folder or file :");
		lblEnterPathOf_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 19));
		lblEnterPathOf_1.setBounds(55, 90, 345, 32);
		add(lblEnterPathOf_1);

		JLabel lblEnterPathFor = new JLabel("Enter name of file");
		lblEnterPathFor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 19));
		lblEnterPathFor.setBounds(0, 226, 151, 32);
		add(lblEnterPathFor);

		JButton bfolder2 = new JButton("Folder");
		bfolder2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("Folder");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);
				chooser.showOpenDialog(null);
			}
		});
		bfolder2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		bfolder2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				link2 = path;
			}
		});
		bfolder2.setBounds(78, 119, 131, 38);
		add(bfolder2);

		JButton bfile2 = new JButton("File");
		bfile2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		bfile2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("csv", "csv");
				chooser.setFileFilter(filter);
				String path = "";
				chooser.setDialogTitle("Choose Csv File");
				if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					path=chooser.getSelectedFile().getAbsolutePath();
				}
				path = path.replace("\\", "/");
				link2 = path;
			}
		});
		bfile2.setBounds(219, 118, 131, 40);
		add(bfile2);

		JButton bfolder = new JButton("Folder");
		bfolder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("Folder");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);
				chooser.showOpenDialog(null);
			}
		});
		bfolder.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		bfolder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				link = path;
				//System.out.println("path  "+ path);
				//File folder = new File(path);

			}
		});
		bfolder.setBounds(78, 52, 131, 38);
		add(bfolder);

		JButton bfile = new JButton("File");
		bfile.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		bfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("csv", "csv");
				chooser.setFileFilter(filter);
				String path = "";
				chooser.setDialogTitle("Choose Csv File");
				if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					path=chooser.getSelectedFile().getAbsolutePath();
				}
				path = path.replace("\\", "/");
				link = path;
			}
		});

		JButton btnChooseFolder = new JButton("choose folder");
		btnChooseFolder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("Choose Folder for saving there");
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
		btnChooseFolder.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		btnChooseFolder.setBounds(145, 186, 143, 32);
		add(btnChooseFolder);





		bfile.setBounds(219, 51, 131, 40);
		add(bfile);

		save = new JTextField();
		save.setColumns(10);
		save.setBounds(155, 226, 262, 32);
		add(save);

		JButton button = new JButton("Enter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(save.getText().isEmpty()){
					correctName = false;
					JOptionPane.showMessageDialog(new JFrame(), "Enter name of file please. This field can not be empty!");
				}
				if(!save.getText().isEmpty()){
					correctName = true;
				}
				if (link == ""){
					JOptionPane.showMessageDialog(new JFrame(), "Choose folder or file wigle please. This field can not be empty!");
					correctlink = false;
				}
				else{
					correctlink = true;
				}
				if (link2 == ""){
					JOptionPane.showMessageDialog(new JFrame(), "Choose folder or file with lesses information please. This field can not be empty!");
					correctlink2 = false;
				}
				else{
					correctlink2 = true;
				}
				if (name == ""){
					JOptionPane.showMessageDialog(new JFrame(), "Choose folder please. This field can not be empty!");
					correctfolder = false;
				}
				else{
					correctfolder = true;
				}

				if (correctName&&correctlink&&correctlink2&&correctfolder){
					File folder1 = new File(link);
					File folder2 = new File(link2);
					String path1 = name+"/"+save.getText();
					try {
						c.Algo2Folder(folder1, folder2, path1);
						JOptionPane.showMessageDialog(new JFrame(), "Algo1 Completed :)");
						JOptionPane.showMessageDialog(new JFrame(), hash.HowMacAndRow(c.macs));
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(new JFrame(), "Algo1 failed :)");

					}
				}
			}
		});
		button.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		button.setBounds(151, 269, 113, 32);
		add(button);

		JLabel lblChooseWigleWifi = new JLabel("Choose wigle wifi folder or file :");
		lblChooseWigleWifi.setFont(new Font("Berlin Sans FB", Font.PLAIN, 19));
		lblChooseWigleWifi.setBounds(88, 24, 262, 32);
		add(lblChooseWigleWifi);

		JLabel lblForSave = new JLabel("For save");
		lblForSave.setFont(new Font("Dialog", Font.PLAIN, 19));
		lblForSave.setBounds(183, 155, 80, 32);
		add(lblForSave);

	}

}