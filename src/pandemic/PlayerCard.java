package pandemic;

public class PlayerCard implements Card{

    private String name;
    private City city;

    public PlayerCard(String name,City city){
        this.name=name;
        this.city=city;
    }
    /**
    *@return name of city 
     */ 
    public City getCity(){
        return this.city;
    }

    public Disease getDisease();
  

    public void comportement();

      
} 