
/**
 * Write a description of class RealEstateAgency here.
 *
 * @author (Rafael Rodrigues e Nelson Santos)
 * @version (a version number or a date)
 */
public class RealEstateAgency
{
    // Atributos de classe
    private static final int MAX_AGENTS = 10;
    // Atributos de objeto
    private String name;
    private Agent [] agents;
    private ListingList allListings;
    private double earnings;

    // Construtores
    public RealEstateAgency(String name)
    {
        if(name != null){
            this.name = name;
            this.agents = new Agent[MAX_AGENTS];
            this.allListings = new ListingList();
            this.earnings = 0.0;
        } else {
            System.out.println("Nome de agência inválido!");
        }
    }

    // Getters
    public String getName(){
        return this.name;
    }
    
    public Agent [] getAgents(){
        return this.agents;
    }
    
    public ListingList getAllListings(){
        return this.allListings;
    }
    
    public double getEarnings(){
        return this.earnings;
    }
    
    // Métodos auxiliares
    private int selectAgent(){
        double minComissions = this.agents[0].getComissions();
        for(int i=0; agents[i] != null; i++){
            if(this.agents[i].getComissions() < minComissions){
                minComissions = this.agents[i].getComissions();
            }
        }
        for(int i=0; agents[i] != null; i++){
            if(this.agents[i].getComissions() == minComissions){
                if(this.agents[i].isAcceptingListings()){
                    return i;   
                }
            }
        }
        return -1;
    }
    
    // Métodos
    public void addListing(Listing house){
        int index = this.selectAgent();
        if(index != -1){
            if(house != null){
                this.agents[index].addAgentListing(house);
                this.allListings.addHouseListing(house); 
            }          
        } else {
            System.out.println("Sem agentes disponíveis!");
        }
    }
    
    public void sellListing(Listing house){
        if(house != null){
            for(int i=0; i < this.agents.length; i++){
                Listing [] houseArray = this.agents[i].getSellingHousesList();
                for(int j=0; j < houseArray.length; j++){
                    if(houseArray[j].getHouseNumber() == house.getHouseNumber()){
                        this.agents[i].markAsSold(house.getHouseNumber());
                    }
                }
            }
            this.allListings.removeHouseListing(house);
        }          
    }
    
    public void displayListingsLocatedAt(String city){
        int countResult = 0;
        if(city != null){
            Listing [] houseList = new Listing[this.allListings.getActiveListings()];
            for(int i=0; i < houseList.length; i++){
                if(houseList[i].getDetails().getAddress().getCity() == city){
                    houseList[i].displayHouse();  
                    countResult += 1;
                }
            }
            if(countResult == 0){
                System.out.println("Nenhuma casa encontrada na cidade introduzida!");
            }
        } else {
            System.out.println("Cidade inválida!");
        }
    }
    
    public void displayListingBetween(double minPrice, double maxPrice){
        int countResult = 0;
        if(minPrice != 0 && maxPrice != 0){
            if(minPrice < maxPrice){
                Listing [] houseList = new Listing[this.allListings.getActiveListings()];
                for(int i=0; i < houseList.length; i++){
                    if(houseList[i].getPrice() >= minPrice || houseList[i].getPrice() <= maxPrice){
                        houseList[i].displayHouse();
                        countResult += 1;
                    }
                }
                if(countResult == 0){
                    System.out.println("Nenhuma casa encontrada no intervalo de preços introduzido!");
                }   
            } else {
                System.out.println("Preço máximo tem de ser maior que o preço mínimo!");
            }
        } else {
            System.out.println("Parâmetros inválidos!");
        }
    }
    
    public void displayListingsWithYard(){
        int countResult = 0;
        Listing [] houseList = new Listing[this.allListings.getActiveListings()];
        for(int i=0; i < houseList.length; i++){
            if(houseList[i].getDetails().getHasBackyard() == true){
                houseList[i].displayHouse();
                countResult += 1;
            }
        }
        if(countResult == 0){
            System.out.println("Nenhuma casa encontrada no intervalo de preços introduzido!");
        }   
    }
    
    public void displayListings(){
        this.allListings.displayListings();
    }
    
    public void displayAgency(){
        System.out.println("*** Agência ***");
        System.out.println("Nome: " + this.name);
        System.out.println("Número de agentes: " + this.agents.length);
        System.out.println("Número de imóveis: " + this.allListings.getActiveListings());
        System.out.println("Lucro total: " + this.earnings + "€");
    }
}
