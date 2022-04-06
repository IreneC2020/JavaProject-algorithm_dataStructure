package space_app;

public class Person {
    /*****************************************************************
     * State: data fields
     *        values for the final data fields are initialized.
     * ***************************************************************/
    protected final String  name;
    protected final int     age;
    protected final double  mass;

    /*****************************************************************
     * Constructor: Person (Person)
     * 				This is a copy constructor.
     *              values for the data fields are initialized.
     * ***************************************************************/
    public Person( Person p ){
        this.name = p.name;
        this.age =  p.age;
        this.mass = p.mass;
    }

    /*****************************************************************
     * Constructor: Person (String, double, double)
     *              values for the data fields are initialized.
     * ***************************************************************/
    public Person( String name, int age, double mass){
        this.name = name;
        this.age =  age;
        this.mass = mass;
    }

    /*****************************************************************
     * accessor: getAge
     *           gets the age of Person
     * ***************************************************************/
    public int getAge() {
        return age;
    }

    /*****************************************************************
     * accessor: getName
     *           gets the name of Person
     * ***************************************************************/
    public String getName( ) {
        return name;
    }

    /*****************************************************************
     * accessor: getMass
     *           gets the mass of Person
     * ***************************************************************/
    public double getMass() {
        return mass;
    }

    /*****************************************************************
     * accessor: toString
     *           gets the profile of Astronaut
     * ***************************************************************/
    public String toString( ) {
        return "Name: 		   \t"   +  name      + "\n"	 +
                "Age: 		   \t"   +  age       + "\n"	 +
                "Mass: 		   \t"   +  mass      + "\n"	 ;
    }


}
