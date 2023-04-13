package pandemic;
import java.io.FileNotFoundException;
import pandemic.Board.*;
import pandemic.actions.*;
import pandemic.Cards.*;
import pandemic.Roles.*;
import java.util.*;
import java.util.Collections;
import java.util.Scanner;


/**
 * Game's class
 */
public class Game {

	/* Game's map */
	private World world;
	/* Player's draw */
	private Stack<PileCardPlayer> drawPlayer;
	/** The player discard*/
	private Stack<PileCardPlayer> discardPlayer;
	/* Infection's draw */
	private Stack<InfectionCard> drawInfection;
	/** The Infection discard*/
	private Stack<InfectionCard> discardInfection;
	/* List of Players */
	private ArrayList<Player> players;
	/* totalInfectionRate*/
	private int totalInfectionRate;
	/* nb of Station*/
	private int actualNbOfStations ;
	
	

	
	
	public Game(String path) throws FileNotFoundException {
		this.world = new World(path);
		this.drawPlayer = new Stack<PileCardPlayer>();
		this.drawInfection = new Stack<InfectionCard>();
		this.players = new ArrayList<Player>();
		this.totalInfectionRate=2;
		this.actualNbOfStations=0;
		this.initializeDraw();
		this.discardPlayer=new Stack<PileCardPlayer>();
		this.discardInfection = new Stack<InfectionCard>();
		this.initializeDisease();
		
	}
	
	/*
	 * Get game's world
	 * @return game's world
	 */
	public World getWorld() {
		return this.world;
	}
	
	/*
	 * Get totalInfectionRate
	 * @return totalInfectionRate
	 */
	public int getTotalInfectionRate() {
		return this.totalInfectionRate;
	}
	
	/*
	 * Get actual nb of resarshStation
	 * @return  nb of resarshStation
	 */
	public int getactualNbOfStations() {
		return this.actualNbOfStations;
	}
	
	
	/*
	 * increase the total infectionRate
	 */
	public void IncreasedInfectionRate() {
		this.totalInfectionRate+=1;
	}

	
	/*
	 * Get infection's draw
	 * @return infection's draw
	 */
	public Stack<InfectionCard> getDrawInfection(){
		return this.drawInfection;
	}
	
	/*
	 * Get infection's discard
	 * @return infection's discard
	 */
	public Stack<InfectionCard> getDiscardInfection(){
		return this.discardInfection;
	}
	
	/*
	 * Get player's draw
	 * @return player's draw
	 */
	public Stack<PileCardPlayer> getDrawplayer(){
		return this.drawPlayer;
	}
	
	/*
	 * Get player's discard
	 * @return player's discard
	 */
	public Stack<PileCardPlayer> getDiscardplayer(){
		return this.discardPlayer;
	}
	
	
	
	/*
	 * Initialize all draw
	 */
	public void initializeDraw() {
		//creation des cartes
		
				for(Sector sector : world.getSectors()) {
					this.drawPlayer.push( new EpidemicCard());
					for(City city : sector.getCities()) {
						PlayerCard pCard = new PlayerCard(city,sector.getSectorDisease());
						InfectionCard iCard = new InfectionCard(city,sector.getSectorDisease());
						this.drawPlayer.push(pCard);
						this.drawInfection.push(iCard);
					}
				}
				this.shufflePlayerCards(this.drawPlayer);
				this.shuffleInfectionCards(this.drawInfection);
	}

	
	
	/**
	 * a player take a card 
	 * @param p the player who take a card
	 */
	public void DrawAPlayerCard(Player p) {
		
		PileCardPlayer card = this.drawPlayer.pop();
		card.comportement(p);
	}
	
	public ArrayList<Player> getPlayers(){
		return this.players;
	}
	
	
	public void initializeDisease() {
		for(Sector sector : world.getSectors()) {
			for(City city : sector.getCities()) {
				city.initDisease(this.getWorld().getSectors().get(0).getSectorDisease());
				city.initDisease(this.getWorld().getSectors().get(1).getSectorDisease());
				city.initDisease(this.getWorld().getSectors().get(2).getSectorDisease());
				city.initDisease(this.getWorld().getSectors().get(3).getSectorDisease());
			}
		}
	}
	
	
	/**
	 * a player take a infection card
	 */
	public void DrawAInfectionCard(Player p) {
		
		InfectionCard card =this.drawInfection.pop();
		System.out.println("La carte infection prise ajoute à la ville :"+ card.getCity().getName()+ " le virus :" + card.getDisease().getName());
		card.comportement(p);
	}
	
	
	// FONCTIONS POUR MELENGER LES DECKS
	
	public  void shufflePlayerCards(Stack<PileCardPlayer> playerCards) {
		
		Collections.shuffle(playerCards);
	}
	
	public  void shuffleInfectionCards(Stack<InfectionCard> iCards) {
		
		Collections.shuffle(iCards);
	}

	/**
	une fonction pour la vérification d'un mélange de cartes
	@param drawInfection la pile des cartes
	@return true ou false  
	*/

	
    public static boolean checkInfectionCardsShuffled(Stack<InfectionCard> drawInfection) {
        boolean bienMélanger = true;
        for (int i = 0; i < drawInfection.size() - 1; i++) {
            InfectionCard carteCourante = drawInfection.get(i);
            InfectionCard carteSuivante = drawInfection.get(i + 1);
            if (drawInfection.indexOf(carteCourante) < drawInfection.indexOf(carteSuivante)) {
                // on vérifie si la cartecourante est toujours placé avant la cartesuivante
                bienMélanger = false;
                break;
            }
        }
        return bienMélanger;
    }
	
	
	
	
	
	//Les fonctions d affichages :
	
	//display intro
		public void displayIntro() {
		System.out.println("##########################################");
	    System.out.println("#             P A N D E M I C             #");
	    System.out.println("#                 G A M E                #");
	    System.out.println("##########################################\n");
	    System.out.println("Welcome to Pandemic Game! In this game, you will work as a team to stop the spread of deadly diseases across the globe.\n");
	    System.out.println("Each player will take on a specific role with unique abilities, such as a scientist who can discover a cure faster or a medic who can treat multiple infected people at once.\n");
	    System.out.println("You must work together to collect the necessary cards and research stations, discover cures, and treat and eradicate the diseases before they become too widespread.\n");
	    System.out.println("Are you ready to save the world? Let's begin!\n");
	    System.out.println("##########################################\n");
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Press any key to continue...");
	    scanner.nextLine();
	    
		}
		
		
		
		
		/// Demander le nombre de joueurs
		public void displayPlayersInfo() {
		// on choisis une ville au hasard ou nos joueurs vont apparaitre
		City city = world.getSectors().get((int)(Math.random() * 5)).getCities().get((int)(Math.random() * 12));	
		int numPlayers = 0;
		boolean validInput = false;
		Scanner scanner = new Scanner(System.in);
		while (!validInput) {
		System.out.print("How many players will be playing? (2-4) ");
		try {
		numPlayers = scanner.nextInt();
		if (numPlayers >= 2 && numPlayers <= 4) {
		validInput = true;
		} else {
		System.out.println("Please enter a number between 2 and 4.");
		}
		} catch (InputMismatchException e) {
		System.out.println("Please enter a valid number.");
		scanner.next();
		}
		}

		// Définir les rôles disponibles
		List<String> availableRoles = new ArrayList<>(Arrays.asList("doctor", "expert", "globetrotter", "scientist"));

		// Demander le nom et le rôle de chaque joueur
		scanner.nextLine();
		for (int i = 0; i < numPlayers; i++) {
		System.out.printf("\nPlayer %d, enter your name: ", i + 1);
		String name = scanner.nextLine();


		boolean validRole = false;
		while (!validRole) {
		    System.out.printf("Choose your role, %s. Available roles: %s ", name, availableRoles.toString());
		    String role = scanner.nextLine().toLowerCase();
		    if (availableRoles.contains(role)) {
		        switch (role) {
		            case "doctor":
		            	this.players.add(new Doctor(name,city,this));
		                break;
		            case "expert":
		            	this.players.add(new Expert(name,city,this));
		                break;
		            case "globetrotter":
		            	this.players.add(new GlobePlotter(name,city,this));
		                break;
		            case "scientist":
		            	this.players.add(new Scientist(name,city,this));
		                break;
		        }
		        availableRoles.remove(role);
		        validRole = true;
		    } else {
		        System.out.println("Invalid role. Please choose one of the available roles.");
		    }
		}

		}
		}
		
		
		//display Cards 
		public void displayCards() {
			
			System.out.println(); 
			System.out.println("Voici toutes les cartes presentes dans le jeu : ");
			System.out.println(); 
			// Carte Player
			System.out.println("+  48 PLAYER CARD  +"); 
			System.out.println("+------------------+");
			System.out.println("|      Player      |");
			System.out.println("|                  |");
			System.out.println("|     City Name    |");
			System.out.println("|    Disease Name  |");
			System.out.println("|                  |");
			System.out.println("|                  |");
			System.out.println("|                  |");
			System.out.println("+------------------+");

			// Carte Infection
			System.out.println("+ 48 INFECTION CARD +"); 
			System.out.println("+------------------+");
			System.out.println("|    Infection     |");
			System.out.println("|                  |");
			System.out.println("|     City Name    |");
			System.out.println("|    Disease Name  |");
			System.out.println("|                  |");
			System.out.println("|                  |");
			System.out.println("|                  |");
			System.out.println("+------------------+");

			// Carte Epidemic
			System.out.println("+ 4 EPIDEMIC CARD  +");
			System.out.println("+------------------+");
			System.out.println("|     Epidemic     |");
			System.out.println("|                  |");
			System.out.println("|                  |");
			System.out.println("|                  |");
			System.out.println("|                  |");
			System.out.println("|                  |");
			System.out.println("|                  |");
			System.out.println("+------------------+");
		}
	
	
	
	
	



	public void play() {
		this.displayIntro();
		this.displayPlayersInfo();
		this.displayCards();
	}

	
	
	
	
}
