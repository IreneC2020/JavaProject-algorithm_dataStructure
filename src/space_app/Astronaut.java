package space_app;

public class Astronaut extends Employee {

    /*****************************************************************
     * State: data fields
     *        values for the final data fields are initialized.
     * ***************************************************************/
    protected final int   missions;
    protected final Rank  rank;
    protected final Role  role;

    /*****************************************************************
     * Constructor: Astronaut(Builder)
     *              values for the final data fields are initialized.
     * ***************************************************************/
    public Astronaut(Builder builder) {
        super(builder.person, builder.division, builder.status);
        this.missions = builder.missions;
        this.rank     = builder.rank;
        this.role     = builder.role;
    }

    /*****************************************************************
     * accessor: getMissions
     *           gets the number of missions of Astronaut
     * ***************************************************************/
    public int getMissions() {
        return missions;
    }

    /*****************************************************************
     * accessor: getRank
     *           gets the rank of Astronaut
     * ***************************************************************/
    public Rank getRank() {
        return rank;
    }

    /*****************************************************************
     * accessor: getRole
     *           gets the role of Astronaut
     * ***************************************************************/
    public Role getRole() {
        return role;
    }

    /*****************************************************************
     * accessor: profile
     *           gets the profile of Astronaut
     *           calls its inherited methods methods from Person +
     *           Employee
     * ***************************************************************/
    public String profile(Planet planet) {
        return "------------------ Astronaut ----------------"   + "\n"	 +
                "Name: 		   \t"    +  getName()                + "\n"	 +
                "Age: 		   \t"    +  getAge()                 + "\n"	 +
                "Division: 	   \t"    +  getDivision()            + "\n"	 +
                "Active Status: \t"   +  isActive()               + "\n"	 +
                "Rank:       \t \t"   +  rank		              + "\n"	 +
                "Role:       \t \t"   +  role		              + "\n"	 +
                "No. of Missions:\t"  +  missions		          + "\n"	 +
                "Mass: 		   \t"    +  getMass()    + " kg"     + "\n"     +
                "Earth Weight: \t\t"  +  toPounds(Planet.EARTH)   + " lbs"   + "\n"	+
                "Planet: 	   \t"    +  planet                   + "\n"     +
                "Planet Weight:\t\t"  +  toPounds(planet)         + " lbs"   + "\n";
    }

    /*****************************************************************
     * method: toPounds
     *         converts Astronaut weight from Newtons to lbs
     * ***************************************************************/
    public double toPounds(Planet planet) {
        final double TO_LBS = 1.0 / 4.448;
        return planet.surfaceWeight( getMass() ) * TO_LBS;
    }

    /*****************************************************************
     * method: toString
     *         overrides the toString methods inherited from Employee
     *         + Person to given more information.
     * ***************************************************************/
    public String toString( ) {
        return "------------------ Astronaut ----------------"   + "\n"	 +
                super.toString()							     +
                "Rank:        \t \t"  +  rank		             + "\n"	 +
                "Role:        \t \t"  +  role		             + "\n"	 +
                "No. of Missions:\t"  +  missions		         + "\n"	 +
                "Earth Weight: \t\t"  +  toPounds(Planet.EARTH)  + " lbs"+ "\n"	;
    }


    /*****************************************************************
     * Nested Class: Builder
     *               populates the data fields of Outer Class.
     * ***************************************************************/
    public static class Builder {

        private String   name;
        private int      age;
        private double   mass;
        private int      missions;
        private Rank   	 rank;
        private Role     role;
        private Division division;
        private Status   status;
        private Person   person;

        /*************************************************
         * Constructor: Builder
         *              constructor for inner class
         * ***********************************************/
        public Builder() {
            this.name      = null;
            this.age       = 0;
            this.mass      = 0;
            this.rank      = null;
            this.role      = null;
            this.division  = null;
            this.status    = null;
            this.missions  = 0;
            this.person    = null;
        }

        /*****************************************************************
         * mutator: setName - Person
         *          sets/modifies name data field of Builder
         * ***************************************************************/
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        /*****************************************************************
         * mutator: setAge - Person
         *          sets/modifies age data field of Builder
         * ***************************************************************/
        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        /*****************************************************************
         * mutator: setMass - Person
         *          sets/modifies mass data field of Builder
         * ***************************************************************/
        public Builder setMass(double mass) {
            this.mass = mass;
            return this;
        }

        /*****************************************************************
         * mutator: setPerson - Person
         *          sets/modifies mass data field of Builder
         * ***************************************************************/
        public Builder setPerson(Person p) {
            this.person = p;
            return this;
        }

        /*****************************************************************
         * mutator: setPerson - Person
         *          sets/modifies mass data field of Builder
         * ***************************************************************/
        public Builder setPerson() {
            this.person = new Person(name, age, mass);
            return this;
        }

        /*****************************************************************
         * mutator: set status - Employee
         *          sets/modifies division location data field of Builder
         * ***************************************************************/
        public Builder setStatus(Status status) {
            this.status = status;
            return this;
        }

        /*****************************************************************
         * mutator: setStation - Employee
         *          sets/modifies division location data field of Builder
         * ***************************************************************/
        public Builder setDivision(Division division) {
            this.division = division;
            return this;
        }

        /*****************************************************************
         * mutator: setMissions - Astronaut
         *          sets/modifies number of missions data field of Builder
         * ***************************************************************/
        public Builder setMissions(int missions) {
            this.missions = missions;
            return this;
        }

        /*****************************************************************
         * mutator: setRank - Astronaut
         *          sets/modifies number of missions data field of Builder
         * ***************************************************************/
        public Builder setRank(Rank rank) {
            this.rank = rank;
            return this;
        }

        /*****************************************************************
         * mutator: setRole - Astronaut
         *          sets/modifies role data field of Builder
         * ***************************************************************/
        public Builder setRole(Role role) {
            this.role = role;
            return this;
        }

        /*****************************************************************
         * method: Astronaut
         *         returns the Astronaut with all the set values
         * ***************************************************************/
        public Astronaut build() {
            return new Astronaut(this);
        }
    }
}
