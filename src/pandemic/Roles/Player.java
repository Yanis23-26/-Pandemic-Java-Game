package pandemic.Roles;
import pandemic.Board.*;
import pandemic.actions.*;
import pandemic.Cards.*;
import java.util.ArrayList;
import java.util.List;



public abstract class Player{
    protected String name; // name for player
    protected City city ; // id for player
    protected List<PlayerCard> cartes; // les cartes du joueurs 
    protected List<Action> actions;// list des actions 
    protected Action actionWithRelation;//action avec laquelle est en relation 

    public Player(String name,City city  ){
        this.name=name;
        this.city=city;
        this.cartes = new ArrayList<>();
        this.actions = new ArrayList<>();
        this.initAllActions();
        this.actionWithRelation=this.initRoll();
    }
    
    public void initAllActions() {
    	this.actions.add(new MoveAction());
    	this.actions.add(new FindCureAction());
    	this.actions.add(new TreateDiseaseAction());
    	this.actions.add(new BuildAction());
    }
    public  void  role() {
    	this.actionWithRelation.actOn(this);
    };
    
    public abstract Action initRoll();
  
    /**
    * @return city of player
     */
    public List<PlayerCard> getCard() {
    	return this.cartes;
    }
    
    public City getCity(){
        return this.city;
    }
    /**
    * @return name of player 
     */
    public String getName(){
        return this.name;
    }
    /**
	 *  add a Card on the list of carte 
	 * @param card to add
	 */
    public void addCard(PlayerCard c) {
    	this.cartes.add(c);
    }
    /**
	 * change the city to the  player on the city
	 * @param city to change 
	 */
    public void setCity(City c) {
    	this.city = c;
    }
    /**
    * @param object de type player
    * @return true or false  
     */
    public boolean equals(Object o) {
	   if(! (o instanceof Player )) {
			return false;
		}
		 Player p= (Player) o;
		return (this.getName().equals(p.getName()) && this.getCity()==p.getCity());
	}

    public String toString(){
        return "name of player is "+this.getName()+"and his city is"+this.getCity();
    }
    
    
    
   
    
    
    






}