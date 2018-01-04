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

public class algo2_Mac_Signal extends JPanel {
	private JTextField mac1;
	private JTextField mac2;
	private JTextField mac3;
	private JTextField sig1;
	private JTextField sig2;
	private JTextField sig3;
	String link2="";
	boolean correctlink2;
	boolean correctmac1;
	boolean correctmac2;
	boolean correctmac3;
	boolean correctsig1;
	boolean correctsig2;
	boolean correctsig3;


	/**
	 * Create the panel.
	 */
	public algo2_Mac_Signal(Connect c) {
		setLayout(null);

		JLabel lblAlgo = new JLabel("Algo 2");
		lblAlgo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 35));
		lblAlgo.setBounds(168, 0, 115, 40);
		add(lblAlgo);

		JLabel lblEnterPathOf = new JLabel("Enter wigle folder or file :");
		lblEnterPathOf.setFont(new Font("Berlin Sans FB", Font.PLAIN, 19));
		lblEnterPathOf.setBounds(114, 40, 206, 32);
		add(lblEnterPathOf);

		JLabel lblEnterMac = new JLabel("Enter MAC1:");
		lblEnterMac.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblEnterMac.setBounds(0, 128, 89, 32);
		add(lblEnterMac);

		JLabel lblEnterMac_1 = new JLabel("Enter MAC2:");
		lblEnterMac_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblEnterMac_1.setBounds(0, 162, 89, 32);
		add(lblEnterMac_1);

		JLabel lblEnterMac_2 = new JLabel("Enter MAC3:");
		lblEnterMac_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblEnterMac_2.setBounds(0, 197, 89, 32);
		add(lblEnterMac_2);

		mac1 = new JTextField();
		mac1.setColumns(10);
		mac1.setBounds(79, 128, 140, 32);
		add(mac1);

		mac2 = new JTextField();
		mac2.setColumns(10);
		mac2.setBounds(79, 162, 140, 32);
		add(mac2);

		mac3 = new JTextField();
		mac3.setColumns(10);
		mac3.setBounds(79, 197, 140, 32);
		add(mac3);

		JLabel lblEnterSignal = new JLabel("Enter Signal1:");
		lblEnterSignal.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblEnterSignal.setBounds(223, 128, 89, 32);
		add(lblEnterSignal);

		JLabel lblEnterSignal_1 = new JLabel("Enter Signal2:");
		lblEnterSignal_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblEnterSignal_1.setBounds(223, 162, 89, 32);
		add(lblEnterSignal_1);

		JLabel lblEnterSignal_2 = new JLabel("Enter Signal3:");
		lblEnterSignal_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblEnterSignal_2.setBounds(223, 197, 89, 32);
		add(lblEnterSignal_2);
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
				//System.out.println("path  "+ path);
				//File folder = new File(path);

			}
		});
		bfolder2.setBounds(76, 78, 131, 38);
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
		bfile2.setBounds(223, 77, 131, 40);
		add(bfile2);

		sig1 = new JTextField();
		sig1.setColumns(10);
		sig1.setBounds(310, 128, 140, 32);
		add(sig1);

		sig2 = new JTextField();
		sig2.setColumns(10);
		sig2.setBounds(310, 163, 140, 32);
		add(sig2);

		sig3 = new JTextField();
		sig3.setColumns(10);
		sig3.setBounds(310, 197, 140, 32);
		add(sig3);

		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(sig1.getText().isEmpty()){
					correctsig1 = false;
					JOptionPane.showMessageDialog(new JFrame(), "Enter Signal1 please. This field can not be empty!");
				}
				if(!sig1.getText().isEmpty()){
					correctsig1 = true;
				}
				if(mac1.getText().isEmpty()){
					correctmac1 = false;
					JOptionPane.showMessageDialog(new JFrame(), "Enter Mac1 please. This field can not be empty!");
				}
				if(!mac1.getText().isEmpty()){
					correctmac1 = true;
				}
				if (link2 == ""){
					JOptionPane.showMessageDialog(new JFrame(), "Choose folder or file wigle please. This field can not be empty!");
					correctlink2 = false;
				}
				else{
					correctlink2 = true;
				}
				if (correctlink2&&correctmac1){
					File folder = new File(link2);
					String macc1 = mac1.getText();
					String macc2 = mac2.getText();
					String macc3 = mac3.getText();
					String sigs1 = sig1.getText();
					String sigs2 = sig2.getText();
					String sigs3 = sig3.getText();
					try {
						JOptionPane.showMessageDialog(new JFrame(), c.Algo2User(folder, macc1, macc2, macc3, sigs1, sigs2, sigs3));
						JOptionPane.showMessageDialog(new JFrame(), "Algo1 Completed :)");
						JOptionPane.showMessageDialog(new JFrame(), hash.HowMacAndRow(c.macs));
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(new JFrame(), "Algo1 failed :)");

					}
				}
			}
		});
		btnNewButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		btnNewButton.setBounds(155, 242, 128, 45);
		add(btnNewButton);

	}

}

//00:1a:dd:e3:06:e4      -78
//00:25:86:cc:00:f8      -86
//a0:4f:d4:3b:e9:01      -84