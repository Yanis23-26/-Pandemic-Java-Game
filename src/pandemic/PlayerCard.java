package pandemic;

public class PlayerCard implements Card{

    private String name;
    private String cityName;

    public PlayerCard(String name;String cityName){
        this.name=name;
        this.cityName=cityName;
    }
    /**
    *@return name of city 
     */ 
    public String getCityName(){
        return this.cityName;
    }

    public void Comportement(){

    }    
} 