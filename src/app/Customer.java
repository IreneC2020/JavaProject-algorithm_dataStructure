package app;

public class Customer {
    private final String name;
    private final String type;
    private final String country;

    public Customer(){
        this(null, null, null);
    }

    public Customer(String name, String type, String country){
        this.name      = name;
        this.type      = type;
        this.country   = country;
    }

    public Customer(String customer){
        String[] str    = customer.split(",");
        this.name       = str[0];
        this.type       = str[1];
        this.country    = str[2];
    }

    public boolean equals(Object obj) {
        if (obj instanceof Customer) {
            Customer other = (Customer) obj;
            return country.equals(other.country) && name.equals(other.name) && type.equals(other.type);
        }
        return false;
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String toCSVFormat(){
        return String.format("%s,%s,%s", name, type, country );
    }

    public String toString() {
        return String.format("Customer Name: %s, Customer Type: %s, Customer Country: %s" , name, type, country );
    }
}
