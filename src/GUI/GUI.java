/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import code.Board;
import code.Location;
import code.Game;

public class GUI extends javax.swing.JFrame {

	private Board newBoard;
	private ArrayList<JToggleButton> buttonList = new ArrayList<JToggleButton>();

	private ArrayList<String> Redclues = new ArrayList<String>();
	private ArrayList<String> Blueclues = new ArrayList<String>();
	private ArrayList<String> Greenclues = new ArrayList<String>();
	boolean assassinRevealed = false;
	int teamDisable = 0;
	private int count = 0;

	// Variables declaration - do not modify
	private javax.swing.JMenuBar fileMenu;
	private javax.swing.JMenuItem newGame2Team;
	private javax.swing.JMenuItem newGame3Team;
	private javax.swing.JMenuItem quitGame;
	private javax.swing.JMenu GameMenuItem;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JTextField clueTextField;
	private javax.swing.JTextField countTextField;
	private javax.swing.JOptionPane jOptionPane;
	private javax.swing.JTextArea clueAndCount;
	private javax.swing.JCheckBox spymasterKey;
	private javax.swing.JLabel clueLabel;
	private javax.swing.JLabel countLabel;
	private javax.swing.JLabel cluesandcountsLabel;
	private javax.swing.JLabel turnsLabel;
	private javax.swing.JButton endTurn;
	private javax.swing.JMenuItem easterEgg;
	private javax.swing.JButton nosey;
	private javax.swing.JMenuItem easterEggThree;
	// End of variables declaration

	/**
	 * Creates new form GUI
	 */
	public GUI() {
		newBoard = new Board(false);
		initComponents();
		initButtons(newBoard.getLocations());
	}

	public GUI(ActionEvent evt) {
		newBoard = new Board(true);
		newBoard.getGame().setTeam(true);
		initComponents();
		initButtons(newBoard.getLocations());
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 **/

	@SuppressWarnings("unchecked")
	private void initComponents() {
		// declaring new swing components;
		fileMenu = new javax.swing.JMenuBar();
		GameMenuItem = new javax.swing.JMenu();
		newGame2Team = new javax.swing.JMenuItem();
		newGame3Team = new javax.swing.JMenuItem();
		quitGame = new javax.swing.JMenuItem();
		jOptionPane = new javax.swing.JOptionPane();
		jScrollPane1 = new javax.swing.JScrollPane();
		jScrollPane2 = new javax.swing.JScrollPane();
		jScrollPane3 = new javax.swing.JScrollPane();
		clueTextField = new javax.swing.JTextField();
		countTextField = new javax.swing.JTextField();
		clueAndCount = new javax.swing.JTextArea();
		spymasterKey = new javax.swing.JCheckBox();
		clueLabel = new javax.swing.JLabel();
		countLabel = new javax.swing.JLabel();
		cluesandcountsLabel = new javax.swing.JLabel();
		turnsLabel = new javax.swing.JLabel();
		endTurn = new javax.swing.JButton();
		easterEgg = new javax.swing.JMenuItem();
		nosey = new javax.swing.JButton();
		easterEggThree = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(new java.awt.FlowLayout());

		// start buttons and listeners

		newGame2Team.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				newGame2TeamMouseClicked(evt);
			}
		});
		newGame3Team.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				newGame3TeamMouseClicked(evt);
			}
		});

		quitGame.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				quitGameActionPerformed(evt);
			}
		});

		// Easter Egg
		easterEgg.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					easterEggClick(evt);
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}		
			}	
		});
		
		//Easter Egg
		easterEggThree.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					easterEggClickThree(evt);
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}		
			}	
		});
		
		
		nosey.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					easterEggClickTwo(evt);
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}		
			}	
		});
		

		// end buttons;
		
		spymasterKey.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (spymasterKey.isSelected()) {
					if (newBoard.getGame().getTurn() == 4 || newBoard.getGame().getTurn() == 5
							|| newBoard.getGame().getTurn() == 6) {
						for (int i = 0; i < newBoard.getLocations().size(); i++) {
							buttonList.get(i).setText(newBoard.getLocation(i).getPerson().getRole());
						}
					}
				} else {
					for (int i = 0; i < newBoard.getLocations().size(); i++) {
						if (buttonList.get(i).getModel().isSelected() == false) {
							buttonList.get(i).setText(newBoard.getLocation(i).getCodename());
						}
					}

				}

			}

		});

		// keylistener for enter key
		clueTextField.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String text = clueTextField.getText();
				// this clause is supposed to always catch the exception, pretty neat way to
				// check if the user entered a number;
				try {
					int clue = Integer.parseInt(text);
				} catch (NumberFormatException ex) {
					clueEntered(text);
					JOptionPane.showMessageDialog(null, "Clue Inputed: Please enter Count", "Clue inputed",
							JOptionPane.INFORMATION_MESSAGE);
				}
				clueTextField.setText("");

			}

		});

		countTextField.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String text = countTextField.getText();
				try {
					int count = Integer.parseInt(text);
					countEntered(count);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Invalid Count, please try again", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
				countTextField.setText("");
				NextTurn();
			}

		});

		endTurn.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				for (int i = 0; i < buttonList.size(); i++) {
					if (buttonList.get(i).getModel().isSelected() == true) {
						buttonList.get(i).setText(newBoard.getLocation(i).getPerson().getRole());
						newBoard.getLocation(i).getPerson().setRevealed(true);
					}
				}
				NextTurn();
			}
		});
		// end button listeners

		/* Customize all textboxes */
		clueAndCount.setColumns(63);
		clueAndCount.setRows(3);
		clueAndCount.setEditable(false);

		// Text area where you type in your clue;
		clueTextField.setColumns(63);

		countTextField.setColumns(63);

		endTurn.setText("End Turn");
		clueLabel.setText("Enter Clue: ");
		countLabel.setText("Enter Count: ");
		turnsLabel.setText("Turn:  Red Team Spy Master");
		cluesandcountsLabel.setText("Clues and Counts: ");
		spymasterKey.setText("Reveal all roles " + newBoard.getGame().getTeam());
		GameMenuItem.setText("File");
		quitGame.setText("Quit");

		newGame2Team.setText("New 2-Team Game");
		newGame3Team.setText("New 3-Team Game");
		
		//Easter Egg
		easterEggThree.setText("New 4-Team Game");

		// Easter Egg
		nosey.setOpaque(false);
		nosey.setContentAreaFilled(false);
		
		easterEgg.setText("Everybody Hertz");

		Font f = new Font("Sanserif", Font.BOLD, 20);
		turnsLabel.setFont(f);
		// setviewports for all textboxes
		jScrollPane1.setViewportView(clueTextField);
		jScrollPane2.setViewportView(countTextField);
		jScrollPane3.setViewportView(clueAndCount);
		// End text area;

		endTurn.setPreferredSize(new Dimension(100, 50));
		spymasterKey.setPreferredSize(new Dimension(150, 50));
		turnsLabel.setPreferredSize(new Dimension(350, 50));
		// add everything
		GameMenuItem.add(newGame2Team);
		GameMenuItem.add(newGame3Team);
		
		//Easter Egg 3
		GameMenuItem.add(easterEggThree);
		
		GameMenuItem.add(quitGame);

		// EE
		GameMenuItem.add(easterEgg);
		

		fileMenu.add(GameMenuItem);

		setJMenuBar(fileMenu);
		// changes
		getContentPane().add(clueLabel);
		getContentPane().add(jScrollPane1);
		getContentPane().add(countLabel);
		getContentPane().add(jScrollPane2);
		getContentPane().add(cluesandcountsLabel);
		getContentPane().add(jScrollPane3);
		getContentPane().add(spymasterKey);
		getContentPane().add(endTurn);
		getContentPane().add(turnsLabel);
		getContentPane().add(nosey);
		// dimensions of the window
		setPreferredSize(new Dimension(730, 600));
		setMaximumSize(new Dimension(730, 600));
		setMinimumSize(new Dimension(730, 600));

		setResizable(false);
		pack();

	}
	// end init components method

	// this method will check which teams spymaster entered the clue in the text
	// area and add it to the GUI;
	// UPDATED TO SUPPORT 3 TEAM
	private void clueEntered(String clue) {
		if (newBoard.getGame().checkIfClueLegal(clue.toUpperCase(), newBoard.getLocations())) {
			if (newBoard.getGame().getTurn() == 4) {
				Redclues.add(clue);
			} else if (newBoard.getGame().getTurn() == 5) {
				Blueclues.add(clue);
			} else if (newBoard.getGame().getTeam() && newBoard.getGame().getTurn() == 6) {
				Greenclues.add(clue);
			}
		}
	}

	// this method will check which teams spymaster entered the count and add it to
	// the GUI;
	// UPDATED TO SUPPORT 3 TEAM
	private void countEntered(int count) {
		newBoard.getGame().setCount(count + newBoard.getGame().getCount());
		this.count = newBoard.getGame().getCount();
		if (newBoard.getGame().getTurn() == 4) {
			appendClueandCount(Redclues, newBoard.getGame().getCount());
		} else if (newBoard.getGame().getTurn() == 5) {
			appendClueandCount(Blueclues, newBoard.getGame().getCount());
		} else if (newBoard.getGame().getTeam()) {
			if (newBoard.getGame().getTurn() == 6) {
				appendClueandCount(Greenclues, newBoard.getGame().getCount());
			}
		}
	}

	private void appendClueandCount(ArrayList<String> clues, int counts) {
		clueAndCount.setText("");
		for (int i = 0; i < clues.size(); i++) {
			clueAndCount.append(" | " + clues.get(i) + " : " + counts);
		}
	}

	private void quitGameActionPerformed(java.awt.event.ActionEvent evt) {
		// Exits the application
		System.exit(0);
	}

	// AKA Restart the game
	// UPDATED TO SUPPORT 3 TEAM
	private void newGame2TeamMouseClicked(ActionEvent evt) {
		try {
			restartApplication(new Runnable() {
				public void run() {
					new GUI().setVisible(true);
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// AKA Restart the game
	// UPDATED TO SUPPORT 3 TEAM
	private void newGame3TeamMouseClicked(ActionEvent evt) { // DOESNT WORK
		dispose();
		GUI game = new GUI(evt);
		game.setVisible(true);
	}

	private void makeButtonsUnclickable() {
		for (JToggleButton s : buttonList) {
			s.setEnabled(false);
			s.invalidate();
		}
	}

	// Start EE Method
	private void easterEggClick(ActionEvent evt) throws URISyntaxException {
		try {
			Desktop.getDesktop().browse(new URL("https://www.cse.buffalo.edu/~mhertz/").toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void easterEggClickTwo(ActionEvent evt) throws URISyntaxException {
		try {
			Desktop.getDesktop().browse(new URL("https://ih0.redbubble.net/image.188572854.9815/sticker,375x360-bg,ffffff.png").toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void easterEggClickThree(ActionEvent evt) throws URISyntaxException {
		try {
			Desktop.getDesktop().browse(new URL("https://www.youtube.com/watch?v=dQw4w9WgXcQ").toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// End EE method

	private void makeButtonsclickable() {
		for (JToggleButton s : buttonList) {
			if (s.getModel().isSelected() == true) {
				s.setEnabled(false);
				s.invalidate();
			} else {
				s.setEnabled(true);
				s.invalidate();
			}
		}
	}

	/**
	 * @param i
	 *            the integer representing the disabled team This method needs to
	 *            disable a given team that reveals an assassin if the other
	 *            assassin has not been revealed.
	 */
	public void teamDisable(int i) {
		i = newBoard.getGame().getTurn();
		if (i == 3) {
			teamDisable = 3;
		}
		if (i == 2) {
			teamDisable = 2;
		}
		if (i == 1) {
			teamDisable = 1;
		}
	}

	// UPDATED FOR 3 TEAM GAME

	private void NextTurn() {
		if (newBoard.getGame().getTurn() == 4) {
			newBoard.getGame().setTurn(1);
			makeButtonsclickable();
			JOptionPane.showMessageDialog(this, "Turn: Red Team");
			turnsLabel.setText("Turn: Red Team");
			for (int i = 0; i < newBoard.getLocations().size(); i++) {
				if (buttonList.get(i).getModel().isSelected() == false) {
					buttonList.get(i).setText(newBoard.getLocation(i).getCodename());
				}
			}
		} else if (newBoard.getGame().getTurn() == 1) {

			newBoard.getGame().setTurn(5);
			makeButtonsUnclickable();
			JOptionPane.showMessageDialog(this, "Turn: Blue Spy Master");
			turnsLabel.setText("Turn: Blue Team Spy Master");

		} else if (newBoard.getGame().getTurn() == 5) {

			newBoard.getGame().setTurn(2);
			makeButtonsclickable();
			JOptionPane.showMessageDialog(this, "Turn: Blue Team");
			turnsLabel.setText("Turn: Blue Team");
			for (int i = 0; i < newBoard.getLocations().size(); i++) {
				if (buttonList.get(i).getModel().isSelected() == false) {
					buttonList.get(i).setText(newBoard.getLocation(i).getCodename());
				}
			}
		} else {
			if (newBoard.getGame().getTeam() == true) { // if its 3-team
				if (newBoard.getGame().getTurn() == 2) {
					newBoard.getGame().setTurn(6);
					makeButtonsclickable();
					JOptionPane.showMessageDialog(this, "Turn: Green Team Spy Master");
					turnsLabel.setText("Turn: Green Team Spy Master");
					for (int i = 0; i < newBoard.getLocations().size(); i++) {
						if (buttonList.get(i).getModel().isSelected() == false) {
							buttonList.get(i).setText(newBoard.getLocation(i).getCodename());
						}
					}
				} else if (newBoard.getGame().getTurn() == 6) {
					newBoard.getGame().setTurn(3);
					makeButtonsclickable();
					JOptionPane.showMessageDialog(this, "Turn: Green Team");
					turnsLabel.setText("Turn: Green Team");
					for (int i = 0; i < newBoard.getLocations().size(); i++) {
						if (buttonList.get(i).getModel().isSelected() == false) {
							buttonList.get(i).setText(newBoard.getLocation(i).getCodename());
						}
					}
				} else {
					newBoard.getGame().setTurn(4);
					JOptionPane.showMessageDialog(this, "Turn: Red Team Spy Master");
					makeButtonsUnclickable();
					turnsLabel.setText("Turn: Red Team Spy Master");
				}
			} else {
				newBoard.getGame().setTurn(4);
				JOptionPane.showMessageDialog(this, "Turn: Red Team Spy Master");
				makeButtonsUnclickable();
				turnsLabel.setText("Turn: Red Team Spy Master");
			}
		}
		if (spymasterKey.isSelected()) {
			spymasterKey.setSelected(false);
		}
		if (newBoard.getGame().getTurn() == 4 || newBoard.getGame().getTurn() == 5 || newBoard.getGame().getTurn() == 6
				|| newBoard.getGame().getTurn() == 0) {
			spymasterKey.getModel().setEnabled(true);
		} else {
			spymasterKey.getModel().setEnabled(false);
		}
	}

	/**
	 * @param evt
	 *            A button click
	 * @param btn
	 *            The button being clicked This method controls the main buttons
	 *            when a button is clicked this method runs, this method should
	 *            start next turn, check if anyone won, set the button text to the
	 *            role of that location, set the button unclickable, set the
	 *            location instance to revealed the actionlistener for this method
	 *            is found inside initButtons();
	 */
	private void personClicked(ActionEvent evt, JToggleButton btn) {
		String roleRevealed = "";
		int idx = 0;
		for (int i = 0; i < buttonList.size(); i++) {
			if (btn == buttonList.get(i))
				idx = i;
		}
		roleRevealed = newBoard.getLocation(idx).getPerson().getRole();
		btn.setText(roleRevealed);
		if (roleRevealed.equals("Innocent") || newBoard.getGame().getCount() == 0) {
			NextTurn();
		}
		if (roleRevealed.equals("RedAgent") && newBoard.getGame().getTurn() == 1) {
			newBoard.getGame().setCount(newBoard.getGame().getCount() - 1);
		} else if (roleRevealed.equals("RedAgent") && newBoard.getGame().getTurn() != 1) {
			newBoard.getGame().setCount(newBoard.getGame().getCount() - 1);
			NextTurn();
		}
		if (roleRevealed.equals("BlueAgent") && newBoard.getGame().getTurn() == 2) {
			newBoard.getGame().setCount(newBoard.getGame().getCount() - 1);
		} else if (roleRevealed.equals("BlueAgent") && newBoard.getGame().getTurn() != 2) {
			newBoard.getGame().setCount(newBoard.getGame().getCount() - 1);
			NextTurn();
		}
		if (roleRevealed.equals("GreenAgent") && newBoard.getGame().getTurn() == 3) {
			newBoard.getGame().setCount(newBoard.getGame().getCount() - 1);
		} else if (roleRevealed.equals("GreenAgent") && newBoard.getGame().getTurn() != 3) {
			newBoard.getGame().setCount(newBoard.getGame().getCount() - 1);
			NextTurn();
		}
		if (newBoard.getGame().getTeam() == false) {
			if (roleRevealed.equals("Assassin")) {
				int result = JOptionPane.showConfirmDialog(this,
						newBoard.getGame().assassinRevealed(newBoard.getLocations()) + " team wins!\nPlay Again?", null,
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.NO_OPTION) {
					System.exit(0);
				}
				if (result == JOptionPane.YES_OPTION) {
					try {
						restartApplication(new Runnable() {
							public void run() {
								new GUI().setVisible(true);
							}
						});
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			if (newBoard.redAgentsRevealed() == 9) {
				int result = JOptionPane.showConfirmDialog(this, "Red team wins!\nPlay Again?", null,
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.NO_OPTION) {
					System.exit(0);
				}
				if (result == JOptionPane.YES_OPTION) {
					try {
						restartApplication(new Runnable() {
							public void run() {
								new GUI().setVisible(true);
							}
						});
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (newBoard.blueAgentsRevealed() == 8) {
					int resultTwo = JOptionPane.showConfirmDialog(this, "Blue team wins!\nPlay Again?", null,
							JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.NO_OPTION) {
						System.exit(0);
					}
					if (resultTwo == JOptionPane.YES_OPTION) {
						try {
							restartApplication(new Runnable() {
								public void run() {
									new GUI().setVisible(true);
								}
							});
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}

			} else {
				if (roleRevealed.equals("Assassin") && assassinRevealed == false) {
					assassinRevealed = true;
					teamDisable(newBoard.getGame().getTurn());
					NextTurn();

				} else if (roleRevealed.equals("Assassin") && assassinRevealed == true) {
					int result = JOptionPane.showConfirmDialog(this,
							newBoard.getGame().assassinRevealed(newBoard.getLocations()) + " team wins!\nPlay Again?",
							null, JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.NO_OPTION) {
						System.exit(0);
					}
					if (result == JOptionPane.YES_OPTION) {
						try {
							restartApplication(new Runnable() {
								public void run() {
									new GUI().setVisible(true);
								}
							});
						} catch (IOException e) {
							e.printStackTrace();
						}
					}

				}
				if (newBoard.redAgentsRevealed() == 6) {
					int resultThree = JOptionPane.showConfirmDialog(this, "Red team wins!\nPlay Again?", null,
							JOptionPane.YES_NO_OPTION);
					if (resultThree == JOptionPane.NO_OPTION) {
						System.exit(0);
					}
					if (resultThree == JOptionPane.YES_OPTION) {
						try {
							restartApplication(new Runnable() {
								public void run() {
									new GUI().setVisible(true);
								}
							});
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (newBoard.blueAgentsRevealed() == 5) {
						int resultFour = JOptionPane.showConfirmDialog(this, "Blue team wins!\nPlay Again?", null,
								JOptionPane.YES_NO_OPTION);
						if (resultFour == JOptionPane.NO_OPTION) {
							System.exit(0);
						}
						if (resultFour == JOptionPane.YES_OPTION) {
							try {
								restartApplication(new Runnable() {
									public void run() {
										new GUI().setVisible(true);
									}
								});
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
					if (newBoard.greenAgentsRevealed() == 5) {
						int resultFive = JOptionPane.showConfirmDialog(this, "Green team wins!\nPlay Again?", null,
								JOptionPane.YES_NO_OPTION);
						if (resultFive == JOptionPane.NO_OPTION) {
							System.exit(0);
						}
						if (resultFive == JOptionPane.YES_OPTION) {
							try {
								restartApplication(new Runnable() {
									public void run() {
										new GUI().setVisible(true);
									}
								});
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}

	// initializes the buttons
	private void initButtons(ArrayList<Location> Board) {

		for (int i = 0; i < Board.size(); i++) {
			JToggleButton btn = new JToggleButton();
			String codeName = Board.get(i).getCodename();
			btn.setText(codeName);
			btn.setPreferredSize(new Dimension(120, 40));
			btn.setEnabled(true);
			// action listener for all the character buttons;
			btn.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					personClicked(evt, btn);
				}
			});
			buttonList.add(btn);
			getContentPane().add(btn);
			makeButtonsUnclickable();

		}
	}

	/**
	 * DO NOT MODIFY runs the GUI application;
	 * 
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new GUI().setVisible(true);
			}
		});
	}

	/**
	 * Sun property pointing the main class and its arguments.
	 */
	public static final String SUN_JAVA_COMMAND = "sun.java.command";

	/**
	 * this is a huge method DO NOT MODIFY Restart the current Java application
	 * 
	 * @param runBeforeRestart
	 *            some custom code to be run before restarting
	 * @throws IOException
	 */
	public static void restartApplication(Runnable runBeforeRestart) throws IOException {
		try {
			// java binary
			String java = System.getProperty("java.home") + "/bin/java";
			// vm arguments
			List<String> vmArguments = ManagementFactory.getRuntimeMXBean().getInputArguments();
			StringBuffer vmArgsOneLine = new StringBuffer();
			for (String arg : vmArguments) {
				// if it's the agent argument : we ignore it otherwise the
				// address of the old application and the new one will be in conflict
				if (!arg.contains("-agentlib")) {
					vmArgsOneLine.append(arg);
					vmArgsOneLine.append(" ");
				}
			}
			// init the command to execute, add the vm args
			final StringBuffer cmd = new StringBuffer("\"" + java + "\" " + vmArgsOneLine);

			// program main and program arguments
			String[] mainCommand = System.getProperty(SUN_JAVA_COMMAND).split(" ");
			// program main is a jar
			if (mainCommand[0].endsWith(".jar")) {
				// if it's a jar, add -jar mainJar
				cmd.append("-jar " + new File(mainCommand[0]).getPath());
			} else {
				// else it's a .class, add the classpath and mainClass
				cmd.append("-cp \"" + System.getProperty("java.class.path") + "\" " + mainCommand[0]);
			}
			// finally add program arguments
			for (int i = 1; i < mainCommand.length; i++) {
				cmd.append(" ");
				cmd.append(mainCommand[i]);
			}
			// execute the command in a shutdown hook, to be sure that all the
			// resources have been disposed before restarting the application
			Runtime.getRuntime().addShutdownHook(new Thread() {
				@Override
				public void run() {
					try {
						Runtime.getRuntime().exec(cmd.toString());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
			// execute some custom code before restarting
			if (runBeforeRestart != null) {
				runBeforeRestart.run();
			}
			// exit
			System.exit(0);
		} catch (Exception e) {
			// something went wrong
			throw new IOException("Error while trying to restart the application", e);
		}
	}

}
