
/**
 * Write a description of class Agent here.
 *
 * @author (Rafael Rodrigues e Nelson Santos)
 * @version (10/04/2024)
 */
public class Agent
{
    // Atributos de classe
    private static final int MAX_HOUSES = 25;
    // Atributos de objeto
    private String name;
    private Listing [] sellingHousesList;
    private int listedHouses;
    private double comissions;
    private int soldHouses;

    // Construtores
    public Agent(String name)
    {
        if(name != null){
            this.name = name;
            this.sellingHousesList = new Listing[MAX_HOUSES];
            this.listedHouses = 0;
            this.comissions = 0.0;
            this.soldHouses = 0;   
        } else {
            System.out.println("Nome de agente inválido!");
        }
    }

    // Getters
    public String getName(){
        return this.name;
    }
    
    public Listing [] getSellingHousesList(){
        return this.sellingHousesList;
    }
    
    public int getListedHouses(){
        return this.listedHouses;
    }
    
    public double getComissions(){
        return this.comissions;
    }
    
    public int getSoldHouses(){
        return this.soldHouses;
    }
    
    // Métodos
    public void displayAgent(){
        System.out.println("Nome: " + this.getName());
        System.out.println("Imóveis à venda: " + this.listedHouses);
        System.out.println("Comissões: " + this.getComissions() + "€");
        System.out.println("Imóveis vendidos: " + this.getSoldHouses());
    }
    
    public void displayAgentListings(){
        for(int i = 0; i < this.listedHouses; i++){
            this.sellingHousesList[i].displayHouse();
        }
    }
    
    public boolean isAcceptingListings(){
        for(int i = 0; i < MAX_HOUSES; i++){
            if(this.sellingHousesList[i] == null){
                return true;
            }
        }
        return false;
    }
    
    public void addAgentListing(Listing house){
        if(this.isAcceptingListings()){
            for(int i = 0; i < MAX_HOUSES; i++){
                if(this.sellingHousesList[i] == null){
                    this.sellingHousesList[i] = house;
                    this.listedHouses += 1;
                    break;
                }
            }
        }
    }
    
    public void markAsSold(int houseNumber){
        int oldSoldHouses = this.getSoldHouses();
        for(int i = 0; i < this.listedHouses; i++){
            if(this.sellingHousesList[i].getHouseNumber() == houseNumber){
                this.soldHouses += 1;
                this.listedHouses -= 1;
                this.comissions = this.sellingHousesList[i].getPrice();
                this.sellingHousesList[i] = null;
            }
        }
        if(oldSoldHouses == this.getSoldHouses()){
            System.out.println("Casa de número " + houseNumber + " não foi encontrada!");
        } else {
            for(int i = 0; i < this.listedHouses; i++){
                if(this.sellingHousesList[i] == null && i+1 < MAX_HOUSES){
                    this.sellingHousesList[i] = this.sellingHousesList[i+1];
                    this.sellingHousesList[i+1] = null;
                }
            }
        }
    }
}
