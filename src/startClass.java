import javax.swing.*;

import java.awt.*;
import java.io.IOException;


public class startClass {
	
	/*
	 * Delade upp hela programmet i model view controller
	 * */
	
	public static void main(String[] args) throws IOException{
		FileHandler fileHandler = new FileHandler("text.txt");
		Controller controller = new Controller(fileHandler);
	    GUI frame = new GUI(controller);
	    frame.setSize(600, 400);
	    frame.setTitle("Journal");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    frame.setVisible(true);
	}
}
