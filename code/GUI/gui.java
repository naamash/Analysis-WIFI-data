package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import filtersPack.Filter;

import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gui {
	Filter filters[] = new Filter[3];
	private JFrame frame;
	Connect c;
	private JPanel Home;
	private JPanel readwigle;
	private JPanel OrA;
	private JPanel read46;
	private JPanel algo1;
	private JPanel dataBase_Mac_Signal;
	private JPanel algo2_folders;
	private JPanel SavetoCSV;
	private JPanel SavetoKML;
	private JPanel id;
	private JPanel Loc;
	private JPanel Time;
	private JPanel withoutID;
	private JPanel withoutPlace;
	private JPanel withoutTime;
	private JPanel current;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		c=new Connect();

		frame = new JFrame();
		frame.setBounds(100, 100, 776, 459);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().setLayout(null);

		Home=new Home(c); 
		frame.getContentPane().add(Home);
		current = Home;

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenu mnNew = new JMenu("New");
		mnFile.add(mnNew);

		JButton btnWhigleWififolder = new JButton("Wigle wifi folder or file");
		btnWhigleWififolder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				readwigle = new readwigle(c);
				frame.getContentPane().add(readwigle);
				current = readwigle;
			}
		});
		mnNew.add(btnWhigleWififolder);

		JButton btnCsvCols = new JButton("CSV 46 cols file");
		btnCsvCols.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				read46 = new read46(c);
				frame.getContentPane().add(read46);
				current = read46;
			}
		});
		mnNew.add(btnCsvCols);

		JMenu mnNewMenu = new JMenu("Algo");
		menuBar.add(mnNewMenu);

		JMenu mnAlgo_1 = new JMenu("Algo1");
		mnNewMenu.add(mnAlgo_1);

		JButton btnFolderAndMac = new JButton("Folder and Mac");
		btnFolderAndMac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				algo1 = new algo1(c);
				frame.getContentPane().add(algo1);
				current = algo1;

			}
		});
		mnAlgo_1.add(btnFolderAndMac);

		JMenu mnAlgo = new JMenu("Algo2");
		mnNewMenu.add(mnAlgo);

		JButton btnFolder = new JButton("Enter folder");
		btnFolder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				algo2_folders = new algo2_folders(c);
				frame.getContentPane().add(algo2_folders);
				current = algo2_folders;
			}
		});
		mnAlgo.add(btnFolder);

		JButton btnMacAndSignal = new JButton("Enter Mac and Signal");
		btnMacAndSignal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				dataBase_Mac_Signal = new algo2_Mac_Signal(c);
				frame.getContentPane().add(dataBase_Mac_Signal);
				current = dataBase_Mac_Signal;
			}
		});
		mnAlgo.add(btnMacAndSignal);

		JMenu mnFilters = new JMenu("Filter DataBase");
		menuBar.add(mnFilters);

		JMenu mnOneFilter = new JMenu("One Filter");
		mnFilters.add(mnOneFilter);

		JMenu mnBy = new JMenu("By");
		mnOneFilter.add(mnBy);

		JButton btnTime = new JButton("Time");
		btnTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				withoutTime = new withoutTime(filters,c);
				frame.getContentPane().add(withoutTime);
				current = withoutTime;

			}
		});
		mnBy.add(btnTime);



		JButton btnId = new JButton("ID Display");
		mnBy.add(btnId);


		JButton btnLocation = new JButton("Location");
		mnBy.add(btnLocation);

		JMenu mnWithoutnot = new JMenu("Without(NOT)");
		mnOneFilter.add(mnWithoutnot);

		JButton btnTime_1 = new JButton("Time");
		btnTime_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				withoutTime = new withoutTime(filters,c);
				frame.getContentPane().add(withoutTime);
				current = withoutTime;

			}
		});
		mnWithoutnot.add(btnTime_1);

		JButton btnIdDisplay = new JButton("ID Display");
		btnIdDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				withoutID = new withoutID(filters,c);
				frame.getContentPane().add(withoutID);
				current = withoutID;
			}
		});
		mnWithoutnot.add(btnIdDisplay);

		JButton btnLocation_1 = new JButton("Location");
		btnLocation_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				withoutPlace = new withoutPlace(filters,c);
				frame.getContentPane().add(withoutPlace);
				current = withoutPlace;
			}
		});
		mnWithoutnot.add(btnLocation_1);
		btnLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				Loc = new Loc(filters,c);
				frame.getContentPane().add(Loc);
				current = Loc;
			}
		});
		btnId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				id=new id(filters,c); 
				frame.getContentPane().add(id);
				current = id;

			}
		});
		btnTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				Time = new Time(filters,c);
				frame.getContentPane().add(Time);
				current = Time;
			}
		});

		JMenu mnTwoFilters = new JMenu("Two Filters");
		mnFilters.add(mnTwoFilters);

		JMenu mnOr = new JMenu("OR");
		mnTwoFilters.add(mnOr);

		JMenu mnChooseA = new JMenu("choose A");
		mnOr.add(mnChooseA);

		JButton OtimeA = new JButton("Time");
		OtimeA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				Time = new Time(filters,c);
				frame.getContentPane().add(Time);
				current = Time;
			}
		});
		mnChooseA.add(OtimeA);

		JButton OidA = new JButton("ID Display");
		OidA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				id = new id(filters,c);
				frame.getContentPane().add(id);
				current = id;
			}
		});
		mnChooseA.add(OidA);

		JButton OlocA = new JButton("Location");
		OlocA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				Loc = new Loc(filters,c);
				frame.getContentPane().add(Loc);
				current = Loc;
			}
		});
		mnChooseA.add(OlocA);

		JButton OtimeAN = new JButton("NOT Time");
		OtimeAN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				withoutTime = new withoutTime(filters,c);
				frame.getContentPane().add(withoutTime);
				current = withoutTime;
			}
		});
		mnChooseA.add(OtimeAN);

		JButton OidAN = new JButton("NOT ID Display");
		OidAN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				withoutID = new withoutID(filters,c);
				frame.getContentPane().add(withoutID);
				current = withoutID;
			}
		});
		mnChooseA.add(OidAN);

		JButton OlocAN = new JButton("NOT Location");
		OlocAN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				withoutPlace = new withoutPlace(filters,c);
				frame.getContentPane().add(withoutPlace);
				current = withoutPlace;
			}
		});
		mnChooseA.add(OlocAN);

		JMenu mnChooseB = new JMenu("choose B");
		mnOr.add(mnChooseB);

		JButton OtimeB = new JButton("Time");
		OtimeB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				Time = new Time(filters,c);
				frame.getContentPane().add(Time);
				current = Time;

			}
		});
		mnChooseB.add(OtimeB);

		JButton OidB = new JButton("ID Display");
		OidB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				id = new id(filters,c);
				frame.getContentPane().add(id);
				current = id;
			}
		});
		mnChooseB.add(OidB);

		JButton OlocB = new JButton("Location");
		OlocB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				Loc = new Loc(filters,c);
				frame.getContentPane().add(Loc);
				current = Loc;
			}
		});
		mnChooseB.add(OlocB);

		JButton OtimeBN = new JButton("NOT Time");
		OtimeBN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				withoutTime = new withoutTime(filters,c);
				frame.getContentPane().add(withoutTime);
				current = withoutTime;
			}
		});
		mnChooseB.add(OtimeBN);

		JButton OidBN = new JButton("NOT ID Display");
		OidBN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				withoutID = new withoutID(filters,c);
				frame.getContentPane().add(withoutID);
				current = withoutID;
			}
		});
		mnChooseB.add(OidBN);

		JButton OlocBN = new JButton("NOT Location");
		OlocBN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				withoutPlace = new withoutPlace(filters,c);
				frame.getContentPane().add(withoutPlace);
				current = withoutPlace;
			}
		});
		mnChooseB.add(OlocBN);

		JMenu mnAnd = new JMenu("AND");
		mnTwoFilters.add(mnAnd);

		JMenu menu = new JMenu("choose A");
		mnAnd.add(menu);

		JButton AtimeA = new JButton("Time");
		AtimeA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				Time = new Time(filters,c);
				frame.getContentPane().add(Time);
				current = Time;
			}
		});
		menu.add(AtimeA);

		JButton AidA = new JButton("ID Display");
		AidA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				id = new id(filters,c);
				frame.getContentPane().add(id);
				current = id;
			}
		});
		menu.add(AidA);

		JButton AlocA = new JButton("Location");
		AlocA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				withoutPlace = new withoutPlace(filters,c);
				frame.getContentPane().add(withoutPlace);
				current = withoutPlace;
			}
		});
		menu.add(AlocA);

		JButton AtimeAN = new JButton("NOT Time");
		menu.add(AtimeAN);

		JButton AidAN = new JButton("NOT ID Display");
		menu.add(AidAN);

		JButton AlocAN = new JButton("NOT Location");
		menu.add(AlocAN);

		JMenu menu_1 = new JMenu("choose B");
		mnAnd.add(menu_1);

		JButton AtimeB = new JButton("Time");
		AtimeB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				Time = new Time(filters,c);
				frame.getContentPane().add(Time);
				current = Time;
			}
		});
		menu_1.add(AtimeB);

		JButton AidB = new JButton("ID Display");
		AidB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				Time = new Time(filters,c);
				frame.getContentPane().add(Time);
				current = Time;
			}
		});
		menu_1.add(AidB);

		JButton AlocB = new JButton("Location");
		AlocB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				withoutPlace = new withoutPlace(filters,c);
				frame.getContentPane().add(withoutPlace);
				current = withoutPlace;
			}
		});
		menu_1.add(AlocB);

		JButton AtimeBN = new JButton("NOT Time");
		menu_1.add(AtimeBN);

		JButton AidBN = new JButton("NOT ID Display");
		menu_1.add(AidBN);

		JButton AlocBN = new JButton("NOT Location");
		menu_1.add(AlocBN);

		JMenu mnSaveDatabase = new JMenu("Save DataBase");
		menuBar.add(mnSaveDatabase);

		JButton btnToCsv = new JButton("To CSV");
		btnToCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				SavetoCSV = new SavetoCSV(c);
				frame.getContentPane().add(SavetoCSV);
				current = SavetoCSV;
			}
		});
		mnSaveDatabase.add(btnToCsv);

		JButton btnToKml = new JButton("To KML");
		btnToKml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				SavetoKML = new SavetoKML(c);
				frame.getContentPane().add(SavetoKML);
				current = SavetoKML;
			}
		});
		mnSaveDatabase.add(btnToKml);
	}

}
