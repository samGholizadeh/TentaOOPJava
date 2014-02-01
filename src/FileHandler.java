import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
 * En filehandler klass som ändrar innehållet i en fil och tar texten
 * från en textareai GUI. anropas från controller.*/
public class FileHandler {
	
	private BufferedWriter output;
	
	public FileHandler(String filename) throws IOException{
		FileWriter fileStream = new FileWriter(filename);
		output = new BufferedWriter(fileStream);
	}
	
	//Den här metoden skriver all text till en txt fil.
	public void writeToFile(String line){
		try {
			output.write(line);
			output.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
