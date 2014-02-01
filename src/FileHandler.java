import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
 * En filehandler klass som �ndrar inneh�llet i en fil och tar texten
 * fr�n en textareai GUI. anropas fr�n controller.*/
public class FileHandler {
	
	private BufferedWriter output;
	
	public FileHandler(String filename) throws IOException{
		FileWriter fileStream = new FileWriter(filename);
		output = new BufferedWriter(fileStream);
	}
	
	//Den h�r metoden skriver all text till en txt fil.
	public void writeToFile(String line){
		try {
			output.write(line);
			output.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
