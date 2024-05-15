
/**
 * Write a description of class Address here.
 *
 * @author (Rafael Rodrigues e Nelson Santos)
 * @version (10/04/2024)
 */
public class Address
{
    // Atributos de objeto
    private String street;
    private String postalCode;
    private String city;

    // Construtores
    public Address(String street, String postalCode, String city)
    {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
    }
    
    public Address(String city)
    {
        this.street = "indefinido";
        this.postalCode = "indefinido";
        this.city = city;
    }
    
    // Getters
    public String getStreet(){
        return this.street;
    }
    
    public String getPostalCode(){
        return this.postalCode;
    }
    
    public String getCity(){
        return this.city;
    }
    
    // Métodos
    public void displayAdress(){
        System.out.println("Rua: " + this.getStreet());
        System.out.println("Código postal: " + this.getPostalCode());
        System.out.println("City: " + this.getCity());
    }
}
