package app;

public class Payload implements Comparable<Payload> {
    private final String name;
    private final String type;
    private final double mass;
    private final String orbit;

    public Payload(){
        this(null, null, 0.0, null);
    }

    public Payload(String payload){
        String[] str = payload.split(",");
        this.name    = str[0];
        this.type    = str[1];
        this.mass    = Double.parseDouble(str[2]);
        this.orbit   = str[3];
    }

    public Payload(String name, String type, double mass, String orbit) {
        this.name    = name;
        this.type    = type;
        this.mass    = mass;
        this.orbit   = orbit;
    }

    public static int comparePayloads(Payload first, Payload second){
        if (first.mass != second.mass)
            return Double.compare(first.mass, second.mass);
        else if( !first.name.equals(second.name))
            return first.name.compareTo(second.name);
        else if (!first.type.equals(second.type))
            return first.type.compareTo(second.type);
        return first.orbit.compareTo(second.orbit);
    }

    @Override
    public int compareTo(Payload other) {
        if(!name.equals(other.name))
            return name.compareTo(other.name);
        else if (mass != other.mass)
            return Double.compare(mass, other.mass);
        else if (!type.equals(other.type))
            return type.compareTo(other.type);
        return orbit.compareTo(other.orbit);
    }

    public boolean equals(Object obj){
        if(obj instanceof Payload){
            Payload other = (Payload) obj;
            return name.equals(other.name) &&
                   type.equals(other.type) &&
                    mass == other.mass     &&
                    orbit.equals(other.orbit);
        }
        return false;
    }

    public double getMass() {
        return mass;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getOrbit() {
        return orbit;
    }

    public String toCSVFormat(){
        return name +"," + type + "," + mass + "," + orbit;
    }

    public String toString() {
        return "Payload Name: " + name +
                ", Payload Type: " + type +
                ", Payload Mass (kg): " + mass +
                ", Payload Orbit: " + orbit ;
    }

}
