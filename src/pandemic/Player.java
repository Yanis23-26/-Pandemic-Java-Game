package pandemic;


public class Player{
    private String name;
    private int id;

    public Player(String name,int id){
        this.name=name;
        this.id=id;
    }
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
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