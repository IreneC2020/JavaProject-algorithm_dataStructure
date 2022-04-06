package space_app;

public enum Planet {
    /************************************************************
     * Values: can be set with parameters.
     * ***********************************************************/
    MERCURY(3.18E23, 2.43E6),
    VENUS  (4.88E24, 6.06E6),
    EARTH  (5.98E24, 6.37E6),
    MARS   (6.42E23, 3.37E6),
    JUPITER(1.90E27, 6.99E7),
    SATURN (5.68E26, 5.85E7),
    URANUS (8.68E25, 2.33E7),
    NEPTUNE(1.03E26, 2.21E7);

    /************************************************************
     * State: data fields
     * 		  mass, radius and surface gravity
     * ***********************************************************/
    private final double mass;					// in kilo-grams
    private final double radius;				// in meters
    private final double surfaceGravity;		// in m/s.s
    private static final double G      = 6.67300E-11;

    /*****************************************************************
     * Constructor: Planet (double, double)
     * 				Enums may only have private constructors.
     * ***************************************************************/
    private Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        this.surfaceGravity = G * mass / (radius * radius);
    }

    /**********************************************************
     * returns mass of planet
     * @return mass
     * ********************************************************/
    public double mass( ) {
        return mass;
    }

    /**********************************************************
     * returns radius of planet
     * @return radius
     * ********************************************************/
    public double radius( ) {
        return radius;
    }

    /**********************************************************
     * returns weight of a person on the surface of planet
     * @return weight of person
     * ********************************************************/
    public double surfaceWeight(double mass) {
        return mass * surfaceGravity;
    }

    /**********************************************************
     * returns String representation of planet
     * @return planet
     * ********************************************************/
    public String toString() {
        return this.name() + "( " + mass + "  kg, " + radius + " m )";
    }

}
