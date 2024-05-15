
/**
 * Write a description of class Listing here.
 *
 * @author (Rafael Rodrigues e Nelson Santos)
 * @version (10/04/2024)
 */
public class Listing
{
    // Atributos de classe
    private static int houseCounter = 1;
    // Atributos de objeto
    private int houseNumber;
    private double price;
    private HouseData details;

    // Construtores
    public Listing(double price, String street, String postalCode, String city, double area)
    {
        this.houseNumber = houseCounter++;
        this.price = price;
        this.details = new HouseData(street, postalCode, city, area);
    }
    
    public Listing(double price, String street, String postalCode, String city, double area, boolean hasBackyard)
    {
        this.houseNumber = houseCounter++;
        this.price = price;
        this.details = new HouseData(street, postalCode, city, area, hasBackyard);
    }
    
    public Listing(double price, String city, boolean hasBackyard)
    {
        this.houseNumber = houseCounter++;
        this.price = price;
        this.details = new HouseData(city, hasBackyard);
    }
    
    // Getters
    public int getHouseNumber(){
        return this.houseNumber;
    }
    
    public double getPrice(){
        return this.price;
    }
    
    public HouseData getDetails(){
        return this.details;
    }
    
    // Métodos
    public boolean isLocatedAt(String city){
        if(this.details.getAddress().getCity().equals(city)){
            return true;
        }
        return false;
    }
    
    public void displayHouse(){
        System.out.println("***** Imóvel *****");
        System.out.println("Número do imóvel: " + this.getHouseNumber());
        System.out.println("Preço: " + this.getPrice() + "€");
        System.out.println("<--- Detalhes --->");
        this.details.displayHouseData();
    }
}
