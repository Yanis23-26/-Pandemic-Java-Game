package pandemic;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
public class PandemicMain {

	
	private static Boolean argumentsVerification(String args) {
		// Vérification de la présence d'arguments
        if (args.equals("")) {
            System.err.println("Aucun argument spécifié");
            System.exit(1);
        }

        // Vérification  argument
            File file = new File(args);
            if (!file.isFile()) {
            	System.out.println("L'argument '" + args + "' n'est pas un chemin valide vers un fichier");
            	return false;
            }
            else {
            	return true;
            }
         
	}		
	
	public static void main(String[] args) throws InterruptedException {
		
		try {
			Boolean validPath = false;
			Scanner scanner = new Scanner(System.in);
			String path = null;
			while (!validPath) {
				System.out.print("Please enter the path to your json file.\n");
				try {
					path = scanner.next();
					if (argumentsVerification(path)) {
						validPath = true;
					} else {
						System.out.println("E R R O R !");
					}
				} catch (InputMismatchException e) {
					System.out.println("Please enter a valid path.\n");
					scanner.next();
				}
			}
			Game game = new Game(path);
			game.play();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		

    }

	
	}


