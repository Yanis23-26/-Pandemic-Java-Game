package pandemic;
import java.io.FileNotFoundException;
import pandemic.Board.*;
import pandemic.actions.*;
import pandemic.Cards.*;
import pandemic.Roles.*;
import java.util.*;
import java.util.Collections;



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
		initializationListPlayer();
		
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

	
	/*
	 * Initialize the list of Players
	 */
	public void initializationListPlayer() {
		// La ville sur laquelle les 4 joueurs vont se trouver :
		City city = world.getSectors().get(0).getCities().get(0);
		this.players.add(new GlobePlotter("manil",city));
		this.players.add(new Doctor("rayane",city));
		this.players.add(new Scientist("yanis",city));
		this.players.add(new Expert("anes",city));
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
	
	
	
	
	

	
	/*
	 * Main game loop
	 */
	public void play() {
		/*
		 * tire 2 cartes de la pile des cartes infection et réalise l’infection associée
		 
		- pour chaque joueur tire 2 cartes 
		 -de la pile des cartes joueurs et les ajoute à la main du joueur, le cas échéant déclenche une épidémie
		*/
		DrawAInfectionCard(this.players.get(0));
		DrawAInfectionCard(this.players.get(0));
		
		for(Player p : this.players) {
			DrawAPlayerCard(p);
			DrawAPlayerCard(p);
		}
		
		
	}
}
