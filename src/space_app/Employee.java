package space_app;

public class Employee extends Person {

    /*****************************************************************
     * State: data fields
     *        values for the final data fields are initialized.
     * ***************************************************************/
    private final Division division;
    private final Status status;

    /*****************************************************************
     * Constructor: Employee (Person, Station, boolean)
     *              values for the data fields are initialized.
     * ***************************************************************/
    public Employee(Person p, Division division, Status status) {
        super(p);
        this.division = division;
        this.status = status;
    }

    /**********************************************************
     * accessor: getDivision
     * 			 returns Division of Astronaut
     * ********************************************************/
    public Division getDivision() {
        return division;
    }

    /**********************************************************
     * accessor: getStatus
     * 			 returns active or retired if Astronaut is in
     * 			 active or retired status.
     * ********************************************************/
    public Status getStatus() {
        return status;
    }

    /**********************************************************
     * method: isActive
     * 		   returns working status of Astronaut being
     * 		   active or status.
     * ********************************************************/
    public  String isActive() {
        String answer;

        if ( getStatus() == Status.ACTIVE ) {
            answer = "Yes";
        } else {
            answer = "No";
        }
        return answer;
    }

    /*****************************************************************
     * accessor: profile
     *           gets the profile of Astronaut
     * ***************************************************************/
    public String toString( ) {
        return super.toString()       +
                "Division: 	   \t"    +  division    + "\n"	 +
                "Active: 	   \t"    +  isActive()  + "\n"	 ;
    }

}
