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
		if(card instanceof EpidemicCard) { // si c une carte epidemie on doit la defausser
			this.discardPlayer.add(card);
		}
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
	public void DrawAInfectionCardWhenEpidemic(Player p) {

		InfectionCard card =this.drawInfection.pop();
		card.comportement(p);
		this.discardInfectionCard(card); // on defausse la carte
	}
	
	public void DrawAInfectionCard(Player p) {
		for(int i=0; i<this.getTotalInfectionRate(); i++) {
			InfectionCard card =this.drawInfection.pop();
			card.comportement(p);
			this.discardInfectionCard(card);  // on defausse la carte
		}
	}
	
	
	// FONCTIONS POUR DEFAUSSER LES CARTES 
	
	public void discardPlayerCard(PileCardPlayer card) {
		this.discardPlayer.add(card);
	}
	
	public void discardInfectionCard(InfectionCard card) {
		this.discardInfection.add(card);
	}


	// FONCTIONS POUR MELENGER LES DECKS

	public  void shufflePlayerCards(Stack<PileCardPlayer> playerCards) {

		Collections.shuffle(playerCards);
	}

	public  void shuffleInfectionCards(Stack<InfectionCard> iCards) {

		Collections.shuffle(iCards);
	}
	
	public void initializePlayersHandWithCard(int nbOfPlayers) {
        int nbCartesParJoueur = 0;
        
        if (nbOfPlayers == 2) {
            nbCartesParJoueur = 4;
        } else if (nbOfPlayers == 3) {
            nbCartesParJoueur = 3;
        } else if (nbOfPlayers == 4) {
            nbCartesParJoueur = 2;
        }
        for(Player player : this.getPlayers()) {
        	for(int i=0; i<nbCartesParJoueur; i++) {
        		this.DrawAPlayerCard(player);
            }
        	System.out.println(player.getName()+" has "+player.getCards().size()+" cards in his hand .");
        }
    }
	
	
    public void finalPreparePlayerCardPiles() {
        int nbCartesParTas = this.getDrawplayer().size() / 4;
        Stack<PileCardPlayer> tasDeCartes = new Stack<PileCardPlayer>();
        for (int i = 0; i < 4; i++) {
            int nbCartesDansCeTas = nbCartesParTas;
            Stack<PileCardPlayer> tas = new Stack<PileCardPlayer>();
            for (int j = 0; j < nbCartesDansCeTas; j++) {
                tas.push(this.getDrawplayer().pop());
            }
            
            // Insérer une carte épidémie dans le tas
            EpidemicCard eCard = new EpidemicCard();
            tas.push(eCard);
            for(PileCardPlayer card : tas) {
            	tasDeCartes.push(card);
            }
        }
        
        // Remplir la pile de cartes en empilant les tas
        for(PileCardPlayer card : tasDeCartes) {
        	this.getDrawplayer().push(card);
        }
        this.shufflePlayerCards(this.getDrawplayer());
    }
    
    
    
    public void initialInfection() {
    	Player p = this.getPlayers().get(0);
    	for(int i=0; i<3; i++) {
			InfectionCard card =this.drawInfection.pop();
			card.comportement(p);
			card.comportement(p);
			card.comportement(p);
			this.discardInfectionCard(card);  // on defausse la carte
		}
		
		for(int i=0; i<3; i++) {
			InfectionCard card =this.drawInfection.pop();
			card.comportement(p);
			card.comportement(p);
			this.discardInfectionCard(card);  // on defausse la carte
		}
		
		for(int i=0; i<3; i++) {
			InfectionCard card =this.drawInfection.pop();
			card.comportement(p);
			this.discardInfectionCard(card);  // on defausse la carte
		}
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






	public void askAndDisplayPlayersInfo() {
		int numPlayers = getNumberOfPlayers();
		getPlayerInfo(numPlayers);
	}


	private int getNumberOfPlayers() {
		boolean validInput = false;
		Scanner scanner = new Scanner(System.in);
		int numPlayers = 0;
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
		return numPlayers;
	}


	private void getPlayerInfo(int numPlayers) {
		City city = world.getSectors().get((int)(Math.random() * 5)).getCities().get((int)(Math.random() * 12));
		List<String> availableRoles = new ArrayList<>(Arrays.asList("doctor", "expert", "globetrotter", "scientist"));
		Scanner scanner = new Scanner(System.in);
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
						this.players.add(new GlobeTrotter(name,city,this));
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
		this.askAndDisplayPlayersInfo(); // demander les info des joueurs
		this.displayCards(); // affichage simple des cartes existantes dans le jeu
		this.initializePlayersHandWithCard(this.getPlayers().size()); // distribution de cartes 
		this.finalPreparePlayerCardPiles(); // preparation finale des piles de cartes joueurs
		this.initialInfection(); // infection initiale
	}





}
