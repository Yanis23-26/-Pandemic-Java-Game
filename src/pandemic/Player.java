package pandemic;



public abstract class Player{
    private String name; // name for player
    private City city ; // id for player
  

    public Player(String name,City city  ){
        this.name=name;
        this.city=city;
        
    }
    
    
    public abstract void  action();
  
    /**
    * @return city of player
     */

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