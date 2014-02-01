import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStreamWriter;

import javax.swing.*;

/*
 * Simpelt GUI som skapar det visuella. Det extendar JFrame som är
 * en container för alla andra grafiska komponeneter. Jag har en inre
 * JPanel och en yttre. Sen så har jag Jbuttons med actionlisteners
 * och har olika funktionalitet. Inga konstigheter. En tråd skapas när
 * man trycker på startCounter knappen sleepar 1s varje loop.*/
public class GUI extends JFrame {
	Controller controller;
	
	private JButton addEntry;
	private JButton saveJournal;
	private JButton startCounter;
	
	private JTextArea outputArea;
	private JTextField counterArea;
	private JTextField inputArea;
	
	private JPanel innerPanel;
	private JPanel outerPanel;
	
	//Konstruktorn som skapar GUI't tar en controller referens som argument.
	public GUI(final Controller controller){
		this.controller = controller;
		
		innerPanel = new JPanel(new GridLayout(5, 1));
		
		inputArea = new JTextField();
		inputArea.setEditable(true);
		
		addEntry = new JButton("Add Entry");
		addEntry.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Villkor som kollar om det finns något input.
				if(inputArea.getText() != null){
					String input = inputArea.getText();
					outputArea.append(input + "\n");
					inputArea.setText("");
				}
			}
		});
		
		//Tar det som finns som finns i outputTextArea
		//och anropar controllerns saveDraft metod som i sin tur sparar
		//texten i textfil.
		saveJournal = new JButton("Save Journal");
		saveJournal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.saveDraft(outputArea.getText());
			}
		});
		
		startCounter = new JButton("Start Counter");
		startCounter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * Skapar en ny tråd anonymt och anger en anonym Runnable
				 * klass som argument. I run metoden så skapar jag en
				 * oändlig loop som sleepar 1 sekund varje gång.*/
				new Thread(new Runnable(){

					@Override
					public void run() {
						int counter = 0;
						while(true){
							counter++;
							counterArea.setText(""+counter);
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}).start();
			}
		});
		
		counterArea = new JTextField();
		counterArea.setBackground(Color.GRAY);
		counterArea.setEditable(false);
		
		//Lägger alla komponenter i innerpanel för att sedan lägga
		//de i outerpanel. Sist läggs de i Jframe med add() metoden.
		innerPanel.add(inputArea);
		innerPanel.add(addEntry);
		innerPanel.add(saveJournal);
		innerPanel.add(startCounter);
		innerPanel.add(counterArea);
		
		outputArea = new JTextArea();
		outputArea.setEditable(false);
		
		outerPanel = new JPanel(new GridLayout(1, 2));
		outerPanel.add(outputArea);
		outerPanel.add(innerPanel);
		
		add(outerPanel);
	}
	
}
