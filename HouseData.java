
/**
 * Write a description of class HouseData here.
 *
 * @author (Rafael Rodrigues e Nelson Santos)
 * @version (10/04/2024)
 */
public class HouseData
{
    // Atributos de objeto
    private Address address;
    private double area;
    private boolean hasBackyard;

    // Construtores
    public HouseData(String street, String postalCode, String city, double area)
    {
        this.address = new Address(street, postalCode, city);
        this.area = area;
        this.hasBackyard = false;
    }
    
    public HouseData(String street, String postalCode, String city, double area, boolean hasBackyard)
    {
        this.address = new Address(street, postalCode, city);
        this.area = area;
        this.hasBackyard = hasBackyard;
    }
    
    public HouseData(String city, boolean hasBackyard)
    {
        this.address = new Address(city);
        this.hasBackyard = hasBackyard;
    }
    
    // Getters
    public Address getAddress(){
        return this.address;
    }
    
    public double getArea(){
        return this.area;
    }
    
    public boolean getHasBackyard(){
        return this.hasBackyard;
    }
    
    // Métodos
    public void displayHouseData(){
        System.out.println("Área: " + this.getArea() + "m/2");
        if(this.getHasBackyard()){
            System.out.println("Tem quintal: Sim");    
        } else {
            System.out.println("Tem quintal: Não"); 
        }
        System.out.println("--- Morada ---");
        this.address.displayAdress();
    }
}
