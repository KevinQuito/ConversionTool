import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;


public class Game {
	Font font = new Font("arial", 1, 20);
	String input;
	double temp, solution;
	Container con;
	// string[] length is where we're going to store all the available conversions for length
	private static String[] length = {"kilometer", "meter", "centimeter"};
	private static String[] area = {"square meter", "square mile", "square foot"};
	private static String[] volume = {"liter", "cubic meter", "cubic foot"};
	private static String[] mass = {"kilogram", "pounds", "slug"};
	private static String[] speed = {"km/h", "ft/sec", "mi/h"};
	private static String[] density = {"gram per cubic centimeter", "pound per cubic foot", "slug per cubic foot"};
	private static String[] force = {"newton", "pound weight", "kilogram weight"};
	private static String[] energy = {"joule", "calorie", "kilowatt hour"};
	private static String[] power = {"watt", "horsepower", "kilowatt"};
	private static String[] pressure = {"newton per square meter", "pound force per square inch", "atmosphere"};

	JFrame frame;
	JTextPane textPane;
	JTextArea mainTextArea;
	JPanel panel, lengthButtonPanel, areaButtonPanel, volumeButtonPanel, massButtonPanel, speedButtonPanel,
	densityButtonPanel, forceButtonPanel, energyButtonPanel, powerButtonPanel, pressureButtonPanel;
	JButton lengthButton, areaButton, volumeButton, massButton, speedButton, densityButton,
	forceButton, energyButton, powerButton, pressureButton;
	JLabel label, conversionLabel;

	// drop down list
	// We need to use JComboBox if you want to make a drop down list
	// We're making boxLength1 and boxLength2 to indicate conversions from and to
	JComboBox<Object> boxLength1, boxLength2;



	LengthScreenHandler lsh = new LengthScreenHandler();
	AreaScreenHandler ash = new AreaScreenHandler();
	VolumeScreenHandler vsh = new VolumeScreenHandler();
	MassScreenHandler msh = new MassScreenHandler();
	SpeedScreenHandler ssh = new SpeedScreenHandler();
	DensityScreenHandler dsh = new DensityScreenHandler();
	ForceScreenHandler fsh = new ForceScreenHandler();
	EnergyScreenHandler esh = new EnergyScreenHandler();
	PowerScreenHandler posh = new PowerScreenHandler();
	PressureScreenHandler prsh = new PressureScreenHandler();

	//	boxLength1Handler bL1H = new boxLength1Handler();


	public Game() {
		frame = new JFrame("Conversion Tool");	// This creates a new window


		//		con = frame.getContentPane();


		// JPanel
		//		panel = new JPanel();
		//		panel.setBorder(BorderFactory.createEmptyBorder(-360,240, 10, 30));
		//		panel.setLayout(new GridLayout(0, 1));
		//		lengthButtonPanel = new JPanel();
		//		lengthButtonPanel.setBounds(0, 0, 10, 30);

		// JButton
		lengthButton = new JButton("Length");
		lengthButton.addActionListener(lsh);
		areaButton = new JButton("Area");
		areaButton.addActionListener(ash);
		volumeButton = new JButton("Volume");
		volumeButton.addActionListener(vsh);
		massButton = new JButton("Mass");
		massButton.addActionListener(msh);
		speedButton = new JButton("Speed");
		speedButton.addActionListener(ssh);
		densityButton = new JButton("Density");
		densityButton.addActionListener(dsh);
		forceButton = new JButton("Force");
		forceButton.addActionListener(fsh);
		energyButton = new JButton("Energy");
		energyButton.addActionListener(esh);
		powerButton = new JButton("Power");
		powerButton.addActionListener(posh);
		pressureButton = new JButton("Pressure");
		pressureButton.addActionListener(prsh);

		// JLabel
		label = new JLabel("What kind of factor do you want to convert?");


		// JPanel
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30)); // Formatting createEmptyBorder(top, bottom, left, right);
		panel.setLayout(new GridLayout(0, 1));
		panel.add(label);
		panel.add(lengthButton);
		panel.add(areaButton);
		panel.add(volumeButton);
		panel.add(massButton);
		panel.add(speedButton);
		panel.add(densityButton);
		panel.add(forceButton);
		panel.add(energyButton);
		panel.add(powerButton);
		panel.add(pressureButton);

		// then add the panel to the frame
		frame.add(panel, BorderLayout.CENTER);
		//		frame.setPreferredSize(new Dimension(720, 480));
		//		frame.setMinimumSize(new Dimension(720, 480));
		//		frame.setMaximumSize(new Dimension(720, 480));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		// Placing the Jbutton onto the JPanel
		//		panel.add(label);
		//		lengthButtonPanel.add(lengthButton);



		// Container
		//		con.add(panel);
		//		con.add(lengthButtonPanel);





		/*********************************************************************************************
		 * 
		 * Using methods to create/switch to the new screen when the user clicks on a button
		 * 
		 *********************************************************************************************
		 */

	}
	public void createLengthScreen() {
		panel.setVisible(false);

		// JLabel
		label = new JLabel("Enter the length you want to convert");

		// JPanel
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30)); // Formatting createEmptyBorder(top, bottom, left, right);
		panel.setLayout(new GridLayout(0, 1));

		JPanel userInputPanel = new JPanel();
		JTextField textField = new JTextField("Please Enter A Number", 15);
		userInputPanel.add(textField);

		textField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				input = textField.getText();
				int i = 0;
				// Convert the string to an integer
				try {
					i = Integer.parseInt(input);

					// print it out to console to see if it works
					System.out.println("int i = " + i);					
				}catch(NumberFormatException nfe){
					System.out.println("NumberFormatException: " + nfe.getMessage());
				}
				temp = i;
			}
		});

		/*****************************************************************************************
		 * ItemListener waits there until you click on one of the options and once you do,
		 * then it will do something. Usually an ItemListener takes in an ItemEvent object 
		 * as its parameter. Similar to addActionListener where we did lengthButton.addActionListener(lsh.
		 * But instead of having a new object like handler and have ItemEvent passed to the handler class
		 * we instead just put an anonymous inner class inside the addItemListener parameter and
		 * what it does is it implements the ItemListener class. Similar to actionPerformed(ActionEvent e),
		 * we must do itemStateChanged(ItemEvent e)
		 *****************************************************************************************/
		boxLength1 = new JComboBox<Object>(length);
		//		boxLength1.addItemListener(bL1H);
		boxLength1.addItemListener(
				new ItemListener() {	// This line of code is our declaration for an anonymous class that implements ItemListener		
					public void itemStateChanged(ItemEvent e) {
						if(e.getStateChange() == ItemEvent.SELECTED)  // This line of code is required so that the jcombobox first checks if the state has been changed
							// from the default value; if it has been selected or deselected, if you do not have that line of
							// code, then it will do the "getSelectedItem" twice and it'll execute the if statement twice
							lengthConverter();
					}
				});
		boxLength2 = new JComboBox<Object>(length);
		boxLength2.addItemListener(
				new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if(e.getStateChange() == ItemEvent.SELECTED)
							lengthConverter();
					}
				});
		conversionLabel = new JLabel("The conversion is ");
		/*****************************************************************************************
		 * If you want everything to appear on the same frame, then they have to be in the same
		 * panel, because if you just keep doing multiple frame.add instead of panel.add, then
		 * the program will just keep overwriting the current frame instead of having them all on
		 * the same frame
		 * 
		 *****************************************************************************************/
		panel.add(label);
		panel.add(userInputPanel);
		panel.add(boxLength1);
		panel.add(boxLength2);
		panel.add(conversionLabel);


		// adding panel to frame to make it appear
		frame.add(panel, BorderLayout.CENTER);
	}
	public void createAreaScreen() {
		panel.setVisible(false);
		
		// JLabel
		label = new JLabel("Enter the area you want to convert");

		// JPanel
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30)); // Formatting createEmptyBorder(top, bottom, left, right);
		panel.setLayout(new GridLayout(0, 1));

		JPanel userInputPanel = new JPanel();
		JTextField textField = new JTextField("Please Enter A Number", 15);
		userInputPanel.add(textField);

		textField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				input = textField.getText();
				int i = 0;
				// Convert the string to an integer
				try {
					i = Integer.parseInt(input);

					// print it out to console to see if it works
					System.out.println("int i = " + i);					
				}catch(NumberFormatException nfe){
					System.out.println("NumberFormatException: " + nfe.getMessage());
				}
				temp = i;
			}
		});

		/*****************************************************************************************
		 * ItemListener waits there until you click on one of the options and once you do,
		 * then it will do something. Usually an ItemListener takes in an ItemEvent object 
		 * as its parameter. Similar to addActionListener where we did lengthButton.addActionListener(lsh.
		 * But instead of having a new object like handler and have ItemEvent passed to the handler class
		 * we instead just put an anonymous inner class inside the addItemListener parameter and
		 * what it does is it implements the ItemListener class. Similar to actionPerformed(ActionEvent e),
		 * we must do itemStateChanged(ItemEvent e)
		 *****************************************************************************************/
		boxLength1 = new JComboBox<Object>(area);
		//		boxLength1.addItemListener(bL1H);
		boxLength1.addItemListener(
				new ItemListener() {	// This line of code is our declaration for an anonymous class that implements ItemListener		
					public void itemStateChanged(ItemEvent e) {
						if(e.getStateChange() == ItemEvent.SELECTED)  // This line of code is required so that the jcombobox first checks if the state has been changed
							// from the default value; if it has been selected or deselected, if you do not have that line of
							// code, then it will do the "getSelectedItem" twice and it'll execute the if statement twice
							areaConverter();
					}
				});
		boxLength2 = new JComboBox<Object>(area);
		boxLength2.addItemListener(
				new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if(e.getStateChange() == ItemEvent.SELECTED)
							areaConverter();
					}
				});
		conversionLabel = new JLabel("The conversion is ");
		/*****************************************************************************************
		 * If you want everything to appear on the same frame, then they have to be in the same
		 * panel, because if you just keep doing multiple frame.add instead of panel.add, then
		 * the program will just keep overwriting the current frame instead of having them all on
		 * the same frame
		 * 
		 *****************************************************************************************/
		panel.add(label);
		panel.add(userInputPanel);
		panel.add(boxLength1);
		panel.add(boxLength2);
		panel.add(conversionLabel);


		// adding panel to frame to make it appear
		frame.add(panel, BorderLayout.CENTER);		
	}
	public void createVolumeScreen() {
		panel.setVisible(false);
		

		// JLabel
		label = new JLabel("Enter the volume you want to convert");

		// JPanel
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30)); // Formatting createEmptyBorder(top, bottom, left, right);
		panel.setLayout(new GridLayout(0, 1));

		JPanel userInputPanel = new JPanel();
		JTextField textField = new JTextField("Please Enter A Number", 15);
		userInputPanel.add(textField);

		textField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				input = textField.getText();
				int i = 0;
				// Convert the string to an integer
				try {
					i = Integer.parseInt(input);

					// print it out to console to see if it works
					System.out.println("int i = " + i);					
				}catch(NumberFormatException nfe){
					System.out.println("NumberFormatException: " + nfe.getMessage());
				}
				temp = i;
			}
		});

		/*****************************************************************************************
		 * ItemListener waits there until you click on one of the options and once you do,
		 * then it will do something. Usually an ItemListener takes in an ItemEvent object 
		 * as its parameter. Similar to addActionListener where we did lengthButton.addActionListener(lsh.
		 * But instead of having a new object like handler and have ItemEvent passed to the handler class
		 * we instead just put an anonymous inner class inside the addItemListener parameter and
		 * what it does is it implements the ItemListener class. Similar to actionPerformed(ActionEvent e),
		 * we must do itemStateChanged(ItemEvent e)
		 *****************************************************************************************/
		boxLength1 = new JComboBox<Object>(volume);
		//		boxLength1.addItemListener(bL1H);
		boxLength1.addItemListener(
				new ItemListener() {	// This line of code is our declaration for an anonymous class that implements ItemListener		
					public void itemStateChanged(ItemEvent e) {
						if(e.getStateChange() == ItemEvent.SELECTED)  // This line of code is required so that the jcombobox first checks if the state has been changed
							// from the default value; if it has been selected or deselected, if you do not have that line of
							// code, then it will do the "getSelectedItem" twice and it'll execute the if statement twice
							volumeConverter();
					}
				});
		boxLength2 = new JComboBox<Object>(volume);
		boxLength2.addItemListener(
				new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if(e.getStateChange() == ItemEvent.SELECTED)
							volumeConverter();
					}
				});
		conversionLabel = new JLabel("The conversion is ");
		/*****************************************************************************************
		 * If you want everything to appear on the same frame, then they have to be in the same
		 * panel, because if you just keep doing multiple frame.add instead of panel.add, then
		 * the program will just keep overwriting the current frame instead of having them all on
		 * the same frame
		 * 
		 *****************************************************************************************/
		panel.add(label);
		panel.add(userInputPanel);
		panel.add(boxLength1);
		panel.add(boxLength2);
		panel.add(conversionLabel);


		// adding panel to frame to make it appear
		frame.add(panel, BorderLayout.CENTER);
	}
	public void createMassScreen() {
		panel.setVisible(false);

		// JLabel
		label = new JLabel("Enter the mass you want to convert");

		// JPanel
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30)); // Formatting createEmptyBorder(top, bottom, left, right);
		panel.setLayout(new GridLayout(0, 1));

		JPanel userInputPanel = new JPanel();
		JTextField textField = new JTextField("Please Enter A Number", 15);
		userInputPanel.add(textField);

		textField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				input = textField.getText();
				int i = 0;
				// Convert the string to an integer
				try {
					i = Integer.parseInt(input);

					// print it out to console to see if it works
					System.out.println("int i = " + i);					
				}catch(NumberFormatException nfe){
					System.out.println("NumberFormatException: " + nfe.getMessage());
				}
				temp = i;
			}
		});

		/*****************************************************************************************
		 * ItemListener waits there until you click on one of the options and once you do,
		 * then it will do something. Usually an ItemListener takes in an ItemEvent object 
		 * as its parameter. Similar to addActionListener where we did lengthButton.addActionListener(lsh.
		 * But instead of having a new object like handler and have ItemEvent passed to the handler class
		 * we instead just put an anonymous inner class inside the addItemListener parameter and
		 * what it does is it implements the ItemListener class. Similar to actionPerformed(ActionEvent e),
		 * we must do itemStateChanged(ItemEvent e)
		 *****************************************************************************************/
		boxLength1 = new JComboBox<Object>(mass);
		//		boxLength1.addItemListener(bL1H);
		boxLength1.addItemListener(
				new ItemListener() {	// This line of code is our declaration for an anonymous class that implements ItemListener		
					public void itemStateChanged(ItemEvent e) {
						if(e.getStateChange() == ItemEvent.SELECTED)  // This line of code is required so that the jcombobox first checks if the state has been changed
							// from the default value; if it has been selected or deselected, if you do not have that line of
							// code, then it will do the "getSelectedItem" twice and it'll execute the if statement twice
							massConverter();
					}
				});
		boxLength2 = new JComboBox<Object>(mass);
		boxLength2.addItemListener(
				new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if(e.getStateChange() == ItemEvent.SELECTED)
							massConverter();
					}
				});
		conversionLabel = new JLabel("The conversion is ");
		/*****************************************************************************************
		 * If you want everything to appear on the same frame, then they have to be in the same
		 * panel, because if you just keep doing multiple frame.add instead of panel.add, then
		 * the program will just keep overwriting the current frame instead of having them all on
		 * the same frame
		 * 
		 *****************************************************************************************/
		panel.add(label);
		panel.add(userInputPanel);
		panel.add(boxLength1);
		panel.add(boxLength2);
		panel.add(conversionLabel);

		// adding panel to frame to make it appear
		frame.add(panel, BorderLayout.CENTER);
	}
	public void createSpeedScreen() {
		panel.setVisible(false);

		// JLabel
		label = new JLabel("Enter the speed you want to convert");

		// JPanel
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30)); // Formatting createEmptyBorder(top, bottom, left, right);
		panel.setLayout(new GridLayout(0, 1));

		JPanel userInputPanel = new JPanel();
		JTextField textField = new JTextField("Please Enter A Number", 15);
		userInputPanel.add(textField);

		textField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				input = textField.getText();
				int i = 0;
				// Convert the string to an integer
				try {
					i = Integer.parseInt(input);

					// print it out to console to see if it works
					System.out.println("int i = " + i);					
				}catch(NumberFormatException nfe){
					System.out.println("NumberFormatException: " + nfe.getMessage());
				}
				temp = i;
			}
		});

		/*****************************************************************************************
		 * ItemListener waits there until you click on one of the options and once you do,
		 * then it will do something. Usually an ItemListener takes in an ItemEvent object 
		 * as its parameter. Similar to addActionListener where we did lengthButton.addActionListener(lsh.
		 * But instead of having a new object like handler and have ItemEvent passed to the handler class
		 * we instead just put an anonymous inner class inside the addItemListener parameter and
		 * what it does is it implements the ItemListener class. Similar to actionPerformed(ActionEvent e),
		 * we must do itemStateChanged(ItemEvent e)
		 *****************************************************************************************/
		boxLength1 = new JComboBox<Object>(speed);
		//		boxLength1.addItemListener(bL1H);
		boxLength1.addItemListener(
				new ItemListener() {	// This line of code is our declaration for an anonymous class that implements ItemListener		
					public void itemStateChanged(ItemEvent e) {
						if(e.getStateChange() == ItemEvent.SELECTED)  // This line of code is required so that the jcombobox first checks if the state has been changed
							// from the default value; if it has been selected or deselected, if you do not have that line of
							// code, then it will do the "getSelectedItem" twice and it'll execute the if statement twice
							speedConverter();
					}
				});
		boxLength2 = new JComboBox<Object>(speed);
		boxLength2.addItemListener(
				new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if(e.getStateChange() == ItemEvent.SELECTED)
							speedConverter();
					}
				});
		conversionLabel = new JLabel("The conversion is ");
		/*****************************************************************************************
		 * If you want everything to appear on the same frame, then they have to be in the same
		 * panel, because if you just keep doing multiple frame.add instead of panel.add, then
		 * the program will just keep overwriting the current frame instead of having them all on
		 * the same frame
		 * 
		 *****************************************************************************************/
		panel.add(label);
		panel.add(userInputPanel);
		panel.add(boxLength1);
		panel.add(boxLength2);
		panel.add(conversionLabel);

		// adding panel to frame to make it appear
		frame.add(panel, BorderLayout.CENTER);
	}
	public void createDensityScreen() {
		panel.setVisible(false);
		
		// JLabel
		label = new JLabel("Enter the density you want to convert");

		// JPanel
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30)); // Formatting createEmptyBorder(top, bottom, left, right);
		panel.setLayout(new GridLayout(0, 1));

		JPanel userInputPanel = new JPanel();
		JTextField textField = new JTextField("Please Enter A Number", 15);
		userInputPanel.add(textField);

		textField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				input = textField.getText();
				int i = 0;
				// Convert the string to an integer
				try {
					i = Integer.parseInt(input);

					// print it out to console to see if it works
					System.out.println("int i = " + i);					
				}catch(NumberFormatException nfe){
					System.out.println("NumberFormatException: " + nfe.getMessage());
				}
				temp = i;
			}
		});

		/*****************************************************************************************
		 * ItemListener waits there until you click on one of the options and once you do,
		 * then it will do something. Usually an ItemListener takes in an ItemEvent object 
		 * as its parameter. Similar to addActionListener where we did lengthButton.addActionListener(lsh.
		 * But instead of having a new object like handler and have ItemEvent passed to the handler class
		 * we instead just put an anonymous inner class inside the addItemListener parameter and
		 * what it does is it implements the ItemListener class. Similar to actionPerformed(ActionEvent e),
		 * we must do itemStateChanged(ItemEvent e)
		 *****************************************************************************************/
		boxLength1 = new JComboBox<Object>(density);
		//		boxLength1.addItemListener(bL1H);
		boxLength1.addItemListener(
				new ItemListener() {	// This line of code is our declaration for an anonymous class that implements ItemListener		
					public void itemStateChanged(ItemEvent e) {
						if(e.getStateChange() == ItemEvent.SELECTED)  // This line of code is required so that the jcombobox first checks if the state has been changed
							// from the default value; if it has been selected or deselected, if you do not have that line of
							// code, then it will do the "getSelectedItem" twice and it'll execute the if statement twice
							densityConverter();
					}
				});
		boxLength2 = new JComboBox<Object>(density);
		boxLength2.addItemListener(
				new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if(e.getStateChange() == ItemEvent.SELECTED)
							densityConverter();
					}
				});
		conversionLabel = new JLabel("The conversion is ");
		/*****************************************************************************************
		 * If you want everything to appear on the same frame, then they have to be in the same
		 * panel, because if you just keep doing multiple frame.add instead of panel.add, then
		 * the program will just keep overwriting the current frame instead of having them all on
		 * the same frame
		 * 
		 *****************************************************************************************/
		panel.add(label);
		panel.add(userInputPanel);
		panel.add(boxLength1);
		panel.add(boxLength2);
		panel.add(conversionLabel);


		// adding panel to frame to make it appear
		frame.add(panel, BorderLayout.CENTER);
	}
	public void createForceScreen() {
		panel.setVisible(false);
		
		// JLabel
		label = new JLabel("Enter the force you want to convert");

		// JPanel
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30)); // Formatting createEmptyBorder(top, bottom, left, right);
		panel.setLayout(new GridLayout(0, 1));

		JPanel userInputPanel = new JPanel();
		JTextField textField = new JTextField("Please Enter A Number", 15);
		userInputPanel.add(textField);

		textField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				input = textField.getText();
				int i = 0;
				// Convert the string to an integer
				try {
					i = Integer.parseInt(input);

					// print it out to console to see if it works
					System.out.println("int i = " + i);					
				}catch(NumberFormatException nfe){
					System.out.println("NumberFormatException: " + nfe.getMessage());
				}
				temp = i;
			}
		});

		/*****************************************************************************************
		 * ItemListener waits there until you click on one of the options and once you do,
		 * then it will do something. Usually an ItemListener takes in an ItemEvent object 
		 * as its parameter. Similar to addActionListener where we did lengthButton.addActionListener(lsh.
		 * But instead of having a new object like handler and have ItemEvent passed to the handler class
		 * we instead just put an anonymous inner class inside the addItemListener parameter and
		 * what it does is it implements the ItemListener class. Similar to actionPerformed(ActionEvent e),
		 * we must do itemStateChanged(ItemEvent e)
		 *****************************************************************************************/
		boxLength1 = new JComboBox<Object>(force);
		//		boxLength1.addItemListener(bL1H);
		boxLength1.addItemListener(
				new ItemListener() {	// This line of code is our declaration for an anonymous class that implements ItemListener		
					public void itemStateChanged(ItemEvent e) {
						if(e.getStateChange() == ItemEvent.SELECTED)  // This line of code is required so that the jcombobox first checks if the state has been changed
							// from the default value; if it has been selected or deselected, if you do not have that line of
							// code, then it will do the "getSelectedItem" twice and it'll execute the if statement twice
							forceConverter();
					}
				});
		boxLength2 = new JComboBox<Object>(force);
		boxLength2.addItemListener(
				new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if(e.getStateChange() == ItemEvent.SELECTED)
							forceConverter();
					}
				});
		conversionLabel = new JLabel("The conversion is ");
		/*****************************************************************************************
		 * If you want everything to appear on the same frame, then they have to be in the same
		 * panel, because if you just keep doing multiple frame.add instead of panel.add, then
		 * the program will just keep overwriting the current frame instead of having them all on
		 * the same frame
		 * 
		 *****************************************************************************************/
		panel.add(label);
		panel.add(userInputPanel);
		panel.add(boxLength1);
		panel.add(boxLength2);
		panel.add(conversionLabel);


		// adding panel to frame to make it appear
		frame.add(panel, BorderLayout.CENTER);
	}
	public void createEnergyScreen() {
		panel.setVisible(false);

		// JLabel
		label = new JLabel("Enter the energy you want to convert");

		// JPanel
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30)); // Formatting createEmptyBorder(top, bottom, left, right);
		panel.setLayout(new GridLayout(0, 1));

		JPanel userInputPanel = new JPanel();
		JTextField textField = new JTextField("Please Enter A Number", 15);
		userInputPanel.add(textField);

		textField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				input = textField.getText();
				int i = 0;
				// Convert the string to an integer
				try {
					i = Integer.parseInt(input);

					// print it out to console to see if it works
					System.out.println("int i = " + i);					
				}catch(NumberFormatException nfe){
					System.out.println("NumberFormatException: " + nfe.getMessage());
				}
				temp = i;
			}
		});

		/*****************************************************************************************
		 * ItemListener waits there until you click on one of the options and once you do,
		 * then it will do something. Usually an ItemListener takes in an ItemEvent object 
		 * as its parameter. Similar to addActionListener where we did lengthButton.addActionListener(lsh.
		 * But instead of having a new object like handler and have ItemEvent passed to the handler class
		 * we instead just put an anonymous inner class inside the addItemListener parameter and
		 * what it does is it implements the ItemListener class. Similar to actionPerformed(ActionEvent e),
		 * we must do itemStateChanged(ItemEvent e)
		 *****************************************************************************************/
		boxLength1 = new JComboBox<Object>(energy);
		//		boxLength1.addItemListener(bL1H);
		boxLength1.addItemListener(
				new ItemListener() {	// This line of code is our declaration for an anonymous class that implements ItemListener		
					public void itemStateChanged(ItemEvent e) {
						if(e.getStateChange() == ItemEvent.SELECTED)  // This line of code is required so that the jcombobox first checks if the state has been changed
							// from the default value; if it has been selected or deselected, if you do not have that line of
							// code, then it will do the "getSelectedItem" twice and it'll execute the if statement twice
							energyConverter();
					}
				});
		boxLength2 = new JComboBox<Object>(energy);
		boxLength2.addItemListener(
				new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if(e.getStateChange() == ItemEvent.SELECTED)
							energyConverter();
					}
				});
		conversionLabel = new JLabel("The conversion is ");
		/*****************************************************************************************
		 * If you want everything to appear on the same frame, then they have to be in the same
		 * panel, because if you just keep doing multiple frame.add instead of panel.add, then
		 * the program will just keep overwriting the current frame instead of having them all on
		 * the same frame
		 * 
		 *****************************************************************************************/
		panel.add(label);
		panel.add(userInputPanel);
		panel.add(boxLength1);
		panel.add(boxLength2);
		panel.add(conversionLabel);


		// adding panel to frame to make it appear
		frame.add(panel, BorderLayout.CENTER);
	}
	public void createPowerScreen() {
		panel.setVisible(false);

		// JLabel
		label = new JLabel("Enter the power you want to convert");

		// JPanel
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30)); // Formatting createEmptyBorder(top, bottom, left, right);
		panel.setLayout(new GridLayout(0, 1));

		JPanel userInputPanel = new JPanel();
		JTextField textField = new JTextField("Please Enter A Number", 15);
		userInputPanel.add(textField);

		textField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				input = textField.getText();
				int i = 0;
				// Convert the string to an integer
				try {
					i = Integer.parseInt(input);

					// print it out to console to see if it works
					System.out.println("int i = " + i);					
				}catch(NumberFormatException nfe){
					System.out.println("NumberFormatException: " + nfe.getMessage());
				}
				temp = i;
			}
		});

		/*****************************************************************************************
		 * ItemListener waits there until you click on one of the options and once you do,
		 * then it will do something. Usually an ItemListener takes in an ItemEvent object 
		 * as its parameter. Similar to addActionListener where we did lengthButton.addActionListener(lsh.
		 * But instead of having a new object like handler and have ItemEvent passed to the handler class
		 * we instead just put an anonymous inner class inside the addItemListener parameter and
		 * what it does is it implements the ItemListener class. Similar to actionPerformed(ActionEvent e),
		 * we must do itemStateChanged(ItemEvent e)
		 *****************************************************************************************/
		boxLength1 = new JComboBox<Object>(power);
		//		boxLength1.addItemListener(bL1H);
		boxLength1.addItemListener(
				new ItemListener() {	// This line of code is our declaration for an anonymous class that implements ItemListener		
					public void itemStateChanged(ItemEvent e) {
						if(e.getStateChange() == ItemEvent.SELECTED)  // This line of code is required so that the jcombobox first checks if the state has been changed
							// from the default value; if it has been selected or deselected, if you do not have that line of
							// code, then it will do the "getSelectedItem" twice and it'll execute the if statement twice
							powerConverter();
					}
				});
		boxLength2 = new JComboBox<Object>(power);
		boxLength2.addItemListener(
				new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if(e.getStateChange() == ItemEvent.SELECTED)
							powerConverter();
					}
				});
		conversionLabel = new JLabel("The conversion is ");
		/*****************************************************************************************
		 * If you want everything to appear on the same frame, then they have to be in the same
		 * panel, because if you just keep doing multiple frame.add instead of panel.add, then
		 * the program will just keep overwriting the current frame instead of having them all on
		 * the same frame
		 * 
		 *****************************************************************************************/
		panel.add(label);
		panel.add(userInputPanel);
		panel.add(boxLength1);
		panel.add(boxLength2);
		panel.add(conversionLabel);


		// adding panel to frame to make it appear
		frame.add(panel, BorderLayout.CENTER);
	}
	public void createPressureScreen() {
		panel.setVisible(false);

		// JLabel
		label = new JLabel("Enter the pressure you want to convert");

		// JPanel
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30)); // Formatting createEmptyBorder(top, bottom, left, right);
		panel.setLayout(new GridLayout(0, 1));

		JPanel userInputPanel = new JPanel();
		JTextField textField = new JTextField("Please Enter A Number", 15);
		userInputPanel.add(textField);

		textField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				input = textField.getText();
				int i = 0;
				// Convert the string to an integer
				try {
					i = Integer.parseInt(input);

					// print it out to console to see if it works
					System.out.println("int i = " + i);					
				}catch(NumberFormatException nfe){
					System.out.println("NumberFormatException: " + nfe.getMessage());
				}
				temp = i;
			}
		});

		/*****************************************************************************************
		 * ItemListener waits there until you click on one of the options and once you do,
		 * then it will do something. Usually an ItemListener takes in an ItemEvent object 
		 * as its parameter. Similar to addActionListener where we did lengthButton.addActionListener(lsh.
		 * But instead of having a new object like handler and have ItemEvent passed to the handler class
		 * we instead just put an anonymous inner class inside the addItemListener parameter and
		 * what it does is it implements the ItemListener class. Similar to actionPerformed(ActionEvent e),
		 * we must do itemStateChanged(ItemEvent e)
		 *****************************************************************************************/
		boxLength1 = new JComboBox<Object>(pressure);
		//		boxLength1.addItemListener(bL1H);
		boxLength1.addItemListener(
				new ItemListener() {	// This line of code is our declaration for an anonymous class that implements ItemListener		
					public void itemStateChanged(ItemEvent e) {
						if(e.getStateChange() == ItemEvent.SELECTED)  // This line of code is required so that the jcombobox first checks if the state has been changed
							// from the default value; if it has been selected or deselected, if you do not have that line of
							// code, then it will do the "getSelectedItem" twice and it'll execute the if statement twice
							pressureConverter();
					}
				});
		boxLength2 = new JComboBox<Object>(pressure);
		boxLength2.addItemListener(
				new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if(e.getStateChange() == ItemEvent.SELECTED)
							pressureConverter();
					}
				});
		conversionLabel = new JLabel("The conversion is ");
		/*****************************************************************************************
		 * If you want everything to appear on the same frame, then they have to be in the same
		 * panel, because if you just keep doing multiple frame.add instead of panel.add, then
		 * the program will just keep overwriting the current frame instead of having them all on
		 * the same frame
		 * 
		 *****************************************************************************************/
		panel.add(label);
		panel.add(userInputPanel);
		panel.add(boxLength1);
		panel.add(boxLength2);
		panel.add(conversionLabel);


		// adding panel to frame to make it appear
		frame.add(panel, BorderLayout.CENTER);
	}
	
	/*********************************************************************************************
	 * The calculations will just be done using these methods below
	 *			lengthConverter()
	 *
	 *
	 *********************************************************************************************/
	public void lengthConverter() {
		if(boxLength1.getSelectedItem() == "kilometer" && boxLength2.getSelectedItem() == "meter") {  // if statement determines what option you selected
			solution = temp * 1000;
			conversionLabel.setText("The conversion is " + solution);
		}else if (boxLength1.getSelectedItem() == "kilometer" && boxLength2.getSelectedItem() == "centimeter") {
			solution = temp * 100000;
			conversionLabel.setText("The conversion is " + solution);
		}else if (boxLength1.getSelectedItem() == "meter" && boxLength2.getSelectedItem() == "kilometer") {
			solution = temp / 1000;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == "meter" && boxLength2.getSelectedItem() == "centimeter") {
			solution = temp * 100;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == "centimeter" && boxLength2.getSelectedItem() == "kilometer") {
			solution = temp / 100000;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == "centimeter" && boxLength2.getSelectedItem() == "meter") {
			solution = temp / 100;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == boxLength2.getSelectedItem()) {
			conversionLabel.setText("The conversion is " + temp);
		}
	}
	public void areaConverter() {
		if(boxLength1.getSelectedItem() == "square meter" && boxLength2.getSelectedItem() == "square mile") {  // if statement determines what option you selected
			solution = temp / 2589988.1103;
			conversionLabel.setText("The conversion is " + solution);
		}else if (boxLength1.getSelectedItem() == "square meter" && boxLength2.getSelectedItem() == "square foot") {
			solution = temp * 10.763910417;
			conversionLabel.setText("The conversion is " + solution);
		}else if (boxLength1.getSelectedItem() == "square mile" && boxLength2.getSelectedItem() == "square meter") {
			solution = temp * 2589988.1103;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == "square mile" && boxLength2.getSelectedItem() == "square foot") {
			solution = temp * 27878400;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == "square foot" && boxLength2.getSelectedItem() == "square meter") {
			solution = temp / 10.763910417;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == "square foot" && boxLength2.getSelectedItem() == "square mile") {
			solution = temp / 27878400;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == boxLength2.getSelectedItem()) {
			conversionLabel.setText("The conversion is " + temp);
		}
	}
	public void volumeConverter() {
		if(boxLength1.getSelectedItem() == "liter" && boxLength2.getSelectedItem() == "cubic meter") {  // if statement determines what option you selected
			solution = temp / 1000;
			conversionLabel.setText("The conversion is " + solution);
		}else if (boxLength1.getSelectedItem() == "liter" && boxLength2.getSelectedItem() == "cubic foot") {
			solution = temp / 28.317;
			conversionLabel.setText("The conversion is " + solution);
		}else if (boxLength1.getSelectedItem() == "cubic meter" && boxLength2.getSelectedItem() == "liter") {
			solution = temp * 1000;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == "cubic meter" && boxLength2.getSelectedItem() == "cubic foot") {
			solution = temp * 35.315;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == "cubic foot" && boxLength2.getSelectedItem() == "liter") {
			solution = temp * 28.317;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == "cubic foot" && boxLength2.getSelectedItem() == "cubic meter") {
			solution = temp / 35.315;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == boxLength2.getSelectedItem()) {
			conversionLabel.setText("The conversion is " + temp);
		}
	}
	public void massConverter() {
		if(boxLength1.getSelectedItem() == "kilogram" && boxLength2.getSelectedItem() == "pounds") {  // if statement determines what option you selected
			solution = temp * 2.205;
			conversionLabel.setText("The conversion is " + solution);
		}else if (boxLength1.getSelectedItem() == "kilogram" && boxLength2.getSelectedItem() == "slug") {
			solution = temp / 14.594;
			conversionLabel.setText("The conversion is " + solution);
		}else if (boxLength1.getSelectedItem() == "pounds" && boxLength2.getSelectedItem() == "kilogram") {
			solution = temp / 2.205;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == "pounds" && boxLength2.getSelectedItem() == "slug") {
			solution = temp / 32.174;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == "slug" && boxLength2.getSelectedItem() == "kilogram") {
			solution = temp * 14.594;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == "slug" && boxLength2.getSelectedItem() == "pounds") {
			solution = temp * 32.174;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == boxLength2.getSelectedItem()) {
			conversionLabel.setText("The conversion is " + temp);
		}
	}
	public void speedConverter() {
		if(boxLength1.getSelectedItem() == "km/h" && boxLength2.getSelectedItem() == "ft/h") {  // if statement determines what option you selected
			solution = temp * 3281;
			conversionLabel.setText("The conversion is " + solution);
		}else if (boxLength1.getSelectedItem() == "km/h" && boxLength2.getSelectedItem() == "mi/h") {
			solution = temp / 1.609;
			conversionLabel.setText("The conversion is " + solution);
		}else if (boxLength1.getSelectedItem() == "ft/h" && boxLength2.getSelectedItem() == "km/h") {
			solution = temp / 3281;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == "ft/h" && boxLength2.getSelectedItem() == "mi/h") {
			solution = temp / 5280;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == "mi/h" && boxLength2.getSelectedItem() == "km/h") {
			solution = temp * 1.609;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == "mi/h" && boxLength2.getSelectedItem() == "ft/h") {
			solution = temp * 5280;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == boxLength2.getSelectedItem()) {
			conversionLabel.setText("The conversion is " + temp);
		}
	}
	public void densityConverter() {
		if(boxLength1.getSelectedItem() == "gram per cubic centimeter" && boxLength2.getSelectedItem() == "pound per cubic foot") {  // if statement determines what option you selected
			solution = temp * 62.428;
			conversionLabel.setText("The conversion is " + solution);
		}else if (boxLength1.getSelectedItem() == "gram per cubic centimeter" && boxLength2.getSelectedItem() == "slug per cubic foot") {
			solution = temp * 1.94;
			conversionLabel.setText("The conversion is " + solution);
		}else if (boxLength1.getSelectedItem() == "pound per cubic foot" && boxLength2.getSelectedItem() == "gram per cubic centimeter") {
			solution = temp / 62.428;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == "pound per cubic foot" && boxLength2.getSelectedItem() == "slug per cubic foot") {
			solution = temp / 32.174;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == "slug per cubic foot" && boxLength2.getSelectedItem() == "gram per cubic centimeter") {
			solution = temp / 1.94;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == "slug per cubic foot" && boxLength2.getSelectedItem() == "pound per cubic foot") {
			solution = temp * 32.174;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == boxLength2.getSelectedItem()) {
			conversionLabel.setText("The conversion is " + temp);
		}
	}
	public void forceConverter() {
		if(boxLength1.getSelectedItem() == "newton" && boxLength2.getSelectedItem() == "pound weight") {  // if statement determines what option you selected
			solution = temp * .2248;
			conversionLabel.setText("The conversion is " + solution);
		}else if (boxLength1.getSelectedItem() == "newton" && boxLength2.getSelectedItem() == "kilogram weight") {
			solution = temp * .1020;
			conversionLabel.setText("The conversion is " + solution);
		}else if (boxLength1.getSelectedItem() == "pound weight" && boxLength2.getSelectedItem() == "newton") {
			solution = temp * 4.448;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == "pound weight" && boxLength2.getSelectedItem() == "kilogram weight") {
			solution = temp * .4536;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == "kilogram weight" && boxLength2.getSelectedItem() == "newton") {
			solution = temp * 9.807;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == "kilogram weight" && boxLength2.getSelectedItem() == "pound weight") {
			solution = temp * 2.205;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == boxLength2.getSelectedItem()) {
			conversionLabel.setText("The conversion is " + temp);
		}
	}
	public void energyConverter() {
		if(boxLength1.getSelectedItem() == "joule" && boxLength2.getSelectedItem() == "calorie") {  // if statement determines what option you selected
			solution = temp * .2389;
			conversionLabel.setText("The conversion is " + solution);
		}else if (boxLength1.getSelectedItem() == "joule" && boxLength2.getSelectedItem() == "kilowatt hour") {
			solution = temp * .0000002778;
			conversionLabel.setText("The conversion is " + solution);
		}else if (boxLength1.getSelectedItem() == "calorie" && boxLength2.getSelectedItem() == "joule") {
			solution = temp / .2389;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == "calorie" && boxLength2.getSelectedItem() == "kilowatt hour") {
			solution = temp * .000001163;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == "kilowatt hour" && boxLength2.getSelectedItem() == "joule") {
			solution = temp / .0000002778;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == "kilowatt hour" && boxLength2.getSelectedItem() == "calorie") {
			solution = temp / .000001163;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == boxLength2.getSelectedItem()) {
			conversionLabel.setText("The conversion is " + temp);
		}
	}
	public void powerConverter() {
		if(boxLength1.getSelectedItem() == "watt" && boxLength2.getSelectedItem() == "horsepower") {  // if statement determines what option you selected
			solution = temp / 745.7;
			conversionLabel.setText("The conversion is " + solution);
		}else if (boxLength1.getSelectedItem() == "watt" && boxLength2.getSelectedItem() == "kilowatt") {
			solution = temp / 1000;
			conversionLabel.setText("The conversion is " + solution);
		}else if (boxLength1.getSelectedItem() == "horsepower" && boxLength2.getSelectedItem() == "watt") {
			solution = temp * 745.7;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == "horsepower" && boxLength2.getSelectedItem() == "kilowatt") {
			solution = temp / 1.341;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == "kilowatt" && boxLength2.getSelectedItem() == "horsepower") {
			solution = temp * 1.341;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == "kilowatt" && boxLength2.getSelectedItem() == "watt") {
			solution = temp * 1000;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == boxLength2.getSelectedItem()) {
			conversionLabel.setText("The conversion is " + temp);
		}
	}
	public void pressureConverter() {
		if(boxLength1.getSelectedItem() == "newton per square meter" && boxLength2.getSelectedItem() == "pound force per square inch") {  // if statement determines what option you selected
			solution = temp / 6894.76;
			conversionLabel.setText("The conversion is " + solution);
		}else if (boxLength1.getSelectedItem() == "newton per square meter" && boxLength2.getSelectedItem() == "atmosphere") {
			solution = temp / 101325;
			conversionLabel.setText("The conversion is " + solution);
		}else if (boxLength1.getSelectedItem() == "pound force per square inch" && boxLength2.getSelectedItem() == "newton per square meter") {
			solution = temp * 6894.76;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == "pound force per square inch" && boxLength2.getSelectedItem() == "atmosphere") {
			solution = temp / 14.696;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == "atmosphere" && boxLength2.getSelectedItem() == "newton per square meter") {
			solution = temp * 101325;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == "atmosphere" && boxLength2.getSelectedItem() == "pound force per square inch") {
			solution = temp * 14.696;
			conversionLabel.setText("The conversion is " + solution);
		}else if(boxLength1.getSelectedItem() == boxLength2.getSelectedItem()) {
			conversionLabel.setText("The conversion is " + temp);
		}
	}


	/***************************************************************************************
	 *
	 * Using class to implement ActionListener which uses a method
	 * 
	 **************************************************************************************
	 */
	//	public class boxLength1Handler implements ItemListener{
	//		public void itemStateChanged(ItemEvent e) {
	//			// TODO Auto-generated method stub
	//			if(boxLength1.getSelectedItem() == "kilometer" && boxLength2.getSelectedItem() == "meter") {  // if statement determines what option you selected
	//				System.out.println(temp * 1000);
	//		}else if (boxLength1.getSelectedItem() == "meter" && boxLength2.getSelectedItem() == "centimeter") {
	//			System.out.println(temp * 100);
	//		}
	//		}
	//		
	//	}
	public class LengthScreenHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			createLengthScreen();
		}
	}
	public class AreaScreenHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			createAreaScreen();
		}
	}
	public class VolumeScreenHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			createVolumeScreen();
		}
	}
	public class MassScreenHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			createMassScreen();
		}
	}
	public class SpeedScreenHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			createSpeedScreen();
		}
	}
	public class DensityScreenHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			createDensityScreen();
		}
	}
	public class ForceScreenHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			createForceScreen();
		}
	}
	public class EnergyScreenHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			createEnergyScreen();
		}
	}
	public class PowerScreenHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			createPowerScreen();
		}
	}
	public class PressureScreenHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			createPressureScreen();
		}
	}

	public static void main(String args[]) {
		new Game();
	}
}
