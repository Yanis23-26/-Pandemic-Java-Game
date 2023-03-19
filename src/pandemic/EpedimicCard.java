package pandemic;

public class EpedimicCard implements Card{
    private  String cityName;
    private String diseaseName;
    
    public EpedimicCard(String cityName;String diseaseName){
        this.cityName=cityName;
        this.diseaseName=diseaseName;
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