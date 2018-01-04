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
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class algo1 extends JPanel {
	private JTextField path;
	private JTextField mac;
	String link="";
	boolean correctLink;
	boolean correctMac;


	/**
	 * Create the panel.
	 */
	public algo1(Connect c) {
		setLayout(null);
		
		JLabel lblAlgo = new JLabel("Algo 1");
		lblAlgo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 35));
		lblAlgo.setBounds(170, 13, 115, 40);
		add(lblAlgo);
	
		JLabel lblEnterPathOf_1 = new JLabel("Enter MAC :");
		lblEnterPathOf_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 19));
		lblEnterPathOf_1.setBounds(170, 157, 115, 32);
		add(lblEnterPathOf_1);
		
		mac = new JTextField();
		mac.setColumns(10);
		mac.setBounds(90, 190, 261, 32);
		add(mac);
		
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
		bfolder.setBounds(143, 78, 131, 38);
		add(bfolder);
		
//		JButton bfile = new JButton("File");
//		bfile.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
//		bfile.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JFileChooser chooser = new JFileChooser();
//				FileNameExtensionFilter filter = new FileNameExtensionFilter("csv", "csv");
//				chooser.setFileFilter(filter);
//				String path = "";
//				chooser.setDialogTitle("Choose Csv File");
//				if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
//					path=chooser.getSelectedFile().getAbsolutePath();
//				}
//				path = path.replace("\\", "/");
//				link = path;
//			}
//		});
//		bfile.setBounds(143, 78, 131, 40);
//		add(bfile);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mac.getText().isEmpty()){
					correctMac = false;
					JOptionPane.showMessageDialog(new JFrame(), "Enter Mac please. This field can not be empty!");
				}
				else if(!mac.getText().isEmpty()){
					correctMac = true;
				}
//				if (correctMac){
//					if (link == ""){
//						JOptionPane.showMessageDialog(new JFrame(), "Choose folder or file please. This field can not be empty!");
//						correctLink = false;
//					}
//					else{
//						correctLink = true;
//					}
//				}
				if(correctLink&&correctMac){
					File file = new File(link);
					String mac1 = mac.getText();
					
					try {
						JOptionPane.showMessageDialog(new JFrame(), c.Algo1(file, mac1));
						JOptionPane.showMessageDialog(new JFrame(), "Algo1 Completed :)");
					//JOptionPane.showMessageDialog(new JFrame(), hash.HowMacAndRow(c.macs));
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(new JFrame(), "Algo1 failed :(");

					}
					
				}
			}
		});
		// C:\\Users\\hadar\\Desktop\\testing\\להריץ\\BM2\\WigleWifi_20171203084817.csv
		// 00:1a:dd:e3:06:e4
		btnEnter.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		btnEnter.setBounds(148, 234, 126, 40);
		add(btnEnter);
		
		JLabel lblChooseWigleWifi = new JLabel("Choose wigle wifi folder and save:");
		lblChooseWigleWifi.setFont(new Font("Berlin Sans FB", Font.PLAIN, 19));
		lblChooseWigleWifi.setBounds(73, 48, 298, 32);
		add(lblChooseWigleWifi);

	
	JButton btnNewButton_1 = new JButton("Save");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (link == ""){
				JOptionPane.showMessageDialog(new JFrame(), "Choose folder or file please. This field can not be empty!");
				correctLink = false;
			}
			else{
				correctLink = true;
			}
			if (correctLink){
				try {
					File folder = new File(link);
					//System.out.println(link2);
					c.macs = c.readWigle(folder);
					JOptionPane.showMessageDialog(new JFrame(), "The file was read successfully");
					JOptionPane.showMessageDialog(new JFrame(), hash.HowMacAndRow(c.macs));
				} 
				catch (Exception e2) {
					JOptionPane.showMessageDialog(new JFrame(), "The file was read failed");

				}
			}
		}
	});
	btnNewButton_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
	btnNewButton_1.setBounds(143, 120, 131, 38);
	add(btnNewButton_1);
	}
}