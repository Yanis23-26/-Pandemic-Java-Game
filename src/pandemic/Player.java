package pandemic;


public class Player{
    private String name; // name for player
    private City city ; // id for player

    public Player(String name,City city ){
        this.name=name;
        this.city=city;
    }
    /**
    * @return city of player
     */

    public int getCity(){
        return this.city;
    }
    /**
    * @return name of player 
     */
    public String getName(){
        return this.name;
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
    
    
    public abstract void build() {
    	
    }
    
    public abstract void findCure() {
    	
    }
    
    public abstract void reatDisease() {
    	
    }
    
    
    
    
    






}