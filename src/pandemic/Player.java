package pandemic;


public class Player{
    private String name; // name for player
    private int id; // id for player

    public Player(String name,int id){
        this.name=name;
        this.id=id;
    }
    /**
    * @return id for player
     */

    public int getId(){
        return this.id;
    }
    /**
    * @return name for player 
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
		return (this.getName().equals(p.getName()) && this.getId()==p.getId());
	}

    public String toString(){
        return "name of player is "+this.getName()+" "+this.getId();
    }







}