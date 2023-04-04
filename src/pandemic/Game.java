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
	private Stack<PlayerCard> drawPlayer; 
	/* Infection's draw */
	private Stack<InfectionCard> drawInfection;
	/* epidemic Cards */
	private Stack <EpidemicCard> drawEpidemic;
	/* List of Players */
	private ArrayList<Player> players;

	
	

	
	
	public Game() throws FileNotFoundException {
		this.world = new World();
		this.drawPlayer = new Stack<PlayerCard>();
		this.drawInfection = new Stack<InfectionCard>();
		this.drawEpidemic = new Stack<EpidemicCard>();
		this.players = new ArrayList<Player>();
		initializeDraw();
		
	}
	
	/*
	 * Get game's world
	 * @return game's world
	 */
	public World getWorld() {
		return this.world;
	}
	
	/*
	 * Get infection's draw
	 * @return infection's draw
	 */
	public Stack<InfectionCard> getDrawInfection(){
		return this.drawInfection;
	}
	
	/*
	 * Get player's draw
	 * @return player's draw
	 */
	public Stack<PlayerCard> getDrawplayer(){
		return this.drawPlayer;
	}
	
	
	
	/*
	 * Initialize all draw
	 */
	public void initializeDraw() {
		//creation des cartes
		
				for(Sector sector : world.getSectors()) {
					drawEpidemic.push( new EpidemicCard());
					for(City city : sector.getCities()) {
						PlayerCard pCard = new PlayerCard(city,sector.getSectorDisease());
						InfectionCard iCard = new InfectionCard(city,sector.getSectorDisease());
						drawPlayer.push(pCard);
						drawInfection.push(iCard);
					
					}
				}
	}

	
	
	/**
	 * a player take a card 
	 * @param p the player who take a card
	 */
	public void DrawAPlayerCard(Player p) {
		
		PlayerCard card = this.drawPlayer.pop();
		card.comportement(p);
	}
	
	
	/**
	 * a player take a infection card
	 */
	public void DrawAInfectionCard(Player p) {
		
		InfectionCard card =this.drawInfection.pop();
		System.out.println("La carte infection prise ajoute à la ville :"+ card.getCity().getName()+ " le virus :" + card.getDisease().getName());
		card.comportement(p);
	}
	
	public void DrawAEpidemicCard() {
		
		EpidemicCard card =this.drawEpidemic.pop();
		card.comportement();
	}
	
	// FONCTIONS POUR MELENGER LES DECKS
	
	public  void shufflePlayerCards(Stack<PlayerCard> playerCards) {
	    Collections.shuffle(playerCards);
	}
	
	public  void shuffleInfectionCards(Stack<InfectionCard> iCards) {
	    Collections.shuffle(iCards);
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
		Scanner scanner = null;
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
		            	this.players.add(new Doctor(name,city));
		                break;
		            case "expert":
		            	this.players.add(new Expert(name,city));
		                break;
		            case "globetrotter":
		            	this.players.add(new GlobePlotter(name,city));
		                break;
		            case "scientist":
		            	this.players.add(new Scientist(name,city));
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
	
	
	
	
	



	public void play() {
	}
}
