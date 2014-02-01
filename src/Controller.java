
public class Controller {
	
	//Skapade en simpel controller f�r att  f� b�ttre koll.
	//Konstruktorn tar FileHandler som argument och initialiserar
	//instance variabeln. Inga konstigheter.
	
	private FileHandler fileHandler;
	
	public Controller(FileHandler fileHandler){
		this.fileHandler = fileHandler;
	}
	
	public void saveDraft(String line){
		fileHandler.writeToFile(line);
	}
}
