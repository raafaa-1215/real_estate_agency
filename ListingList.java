
/**
 * Write a description of class ListingList here.
 *
 * @author (Rafael Rodrigues e Nelson Santos)
 * @version (20/04/2024)
 */
public class ListingList
{
    // Atributos de classe
    private static final int MAX_HOUSES = 250;
    // Atributos de objeto
    private Listing [] allListings;
    private int activeListings;

    // Construtor
    public ListingList()
    {
        this.allListings = new Listing[MAX_HOUSES];
        this.activeListings = 0;
    }
    
    // Getters
    public int getActiveListings(){
        return this.activeListings;
    }
    
    // Métodos
    public void displayListings(){
        for(int i=0; this.allListings[i] != null; i++){
            this.allListings[i].displayHouse();
        }
    }
    
    public void addHouseListing(Listing house){
        this.allListings[this.activeListings] = house;
        this.activeListings += 1;
    }
    
    public void removeHouseListing(Listing house){
        for(int i=0; i < this.activeListings; i++){
            if(this.allListings[i] == house){
                this.allListings[i] = null;
            }
        }
        for(int i=0; i < this.activeListings; i++){
            if(this.allListings[i] == null && this.allListings[i+1] != null){
                this.allListings[i] = this.allListings[i+1];
                this.allListings[i+1] = null;
            }
        }
        this.activeListings -= 1;
    }
}
