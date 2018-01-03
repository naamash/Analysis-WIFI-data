package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
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

	/**
	 * Create the panel.
	 */
	public algo1(Connect c) {
		setLayout(null);
		
		JLabel lblAlgo = new JLabel("Algo 1");
		lblAlgo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 35));
		lblAlgo.setBounds(170, 13, 115, 40);
		add(lblAlgo);
		
//		path = new JTextField();
//		path.setBounds(31, 112, 393, 32);
//		add(path);
//		path.setColumns(10);
		
		
		JLabel lblEnterPathOf_1 = new JLabel("Enter MAC :");
		lblEnterPathOf_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 19));
		lblEnterPathOf_1.setBounds(170, 157, 115, 32);
		add(lblEnterPathOf_1);
		
		mac = new JTextField();
//		String check = "aba";
//		String macCheck = ""+mac; 
//		boolean correctMac = true;
//		
//		String []a = macCheck.split(":");
//		for (int i = 0; i < a.length; i++) {
//			if (a[i].length()!=2){
//				correctMac = false;
//				break;
//			}
//			else if (Character.isLetterOrDigit(check)){
//				correctMac = true;
//			}
//		}
		//1c:b9:c4:16:2d:e8
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
		bfolder.setBounds(143, 121, 131, 38);
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
		bfile.setBounds(143, 78, 131, 40);
		add(bfile);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				try {
					//String path1 = path.getText();
					File file = new File(link);
					String mac1 = mac.getText();
					JOptionPane.showMessageDialog(new JFrame(),c.Algo1(file, mac1));
//				} catch (Exception e2) {
//					System.out.println("Problem with opening files and normal Mac. Please try again.");
//				}
			}
		});
		// C:\\Users\\hadar\\Desktop\\testing\\להריץ\\BM2\\WigleWifi_20171203084817.csv
		// 00:1a:dd:e3:06:e4
		btnEnter.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		btnEnter.setBounds(148, 234, 126, 40);
		add(btnEnter);
		
		JLabel label = new JLabel("Enter path of wigle wifi folder or file :");
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 19));
		label.setBounds(76, 49, 305, 32);
		add(label);

	}

}