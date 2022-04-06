package app;

public class Mission implements Comparable<Mission>{
    private final String      flightNumber;
    private final Date        launchDate;
    private final Time        launchTime;
    private final String      launchSite;
    private final String      vehicleType;
    private final Payload     payload;
    private final Customer    customer;
    private final String      missionOutcome;
    private final String      failureReason;
    private final String      landingType;
    private final String      landingOutcome;

    public Mission(Builder builder){
       this.flightNumber    = builder.flightNumber;
       this.launchDate      = builder.launchDate;
       this.launchTime      = builder.launchTime;
       this.launchSite      = builder.launchSite;
       this.vehicleType     = builder.vehicleType;
       this.payload         = builder.payload;
       this.customer        = builder.customer;
       this.missionOutcome  = builder.missionOutcome;
       this.failureReason   = builder.failureReason;
       this.landingType     = builder.landingType;
       this.landingOutcome  = builder.landingOutcome;
    }

    public static int comparePayloads(Payload first, Payload second){
        if (first.getMass() != second.getMass())
            return Double.compare(first.getMass(), second.getMass());
        else if( !first.getName().equals(second.getName()))
            return first.getName().compareTo(second.getName());
        else if (!first.getType().equals(second.getType()))
            return first.getType().compareTo(second.getType());
        return first.getOrbit().compareTo(second.getOrbit());
    }

    @Override
    public int compareTo(Mission other) {
        return payload.compareTo(other.payload);
    }

    public static int compareMissions(Mission first, Mission second){
        return comparePayloads(first.getPayload(), second.getPayload());
    }

    public boolean equals(Object obj){
        if(obj instanceof Mission) {
            Mission other = (Mission) obj;
            return flightNumber.equals(other.flightNumber)      &&
                   launchDate.equals(other.launchDate)          &&
                    launchTime.equals(other.launchTime)         &&
                    launchSite.equals(other.launchSite)         &&
                    vehicleType.equals(other.vehicleType)       &&
                    payload.equals(other.payload)               &&
                    customer.equals(other.customer)             &&
                    missionOutcome.equals(other.missionOutcome) &&
                    failureReason.equals(other.failureReason)   &&
                    landingType.equals(other.landingType)       &&
                    landingOutcome.equals(other.landingOutcome);
        }
        return false;
    }

    public Customer getCustomer() {
        return customer;
    }
    public Date getLaunchDate() {
        return launchDate;
    }

    public Time getLaunchTime() {
        return launchTime;
    }
    public Payload getPayload() {
        return payload;
    }

    public String toCSVFormat() {
        return flightNumber + "," + launchDate.toCSVFormat() + "," + launchTime.toCSVFormat() + "," +
                launchSite + "," + vehicleType + "," + payload.toCSVFormat() + "," +
                customer.toCSVFormat() + "," + missionOutcome + "," + failureReason + "," +
                landingType + "," + landingOutcome;
    }
    public String toString() {
        return "Mission: " +
                "\nFlightNumber: " + flightNumber + "\n" +
                launchDate + "\n" + launchTime +
                "\nLaunchSite: " + launchSite +
                "\nVehicleType: " + vehicleType +
                "\n" + payload + "\n" + customer +
                "\nMissionOutcome: " + missionOutcome +
                "\nFailureReason: " + failureReason +
                "\nLandingType: " + landingType +
                "\nLandingOutcome: " + landingOutcome + "\n\n";
    }

    /*****************************************************************
     * Nested Class: Builder
     *               populates the data fields of Outer Class.
     * ***************************************************************/
    public static class Builder {
        private String      flightNumber;
        private Date        launchDate;
        private Time        launchTime;
        private String      launchSite;
        private String      vehicleType;
        private Payload     payload;
        private Customer    customer;
        private String      missionOutcome;
        private String      failureReason;
        private String      landingType;
        private String      landingOutcome;

        public Builder(){
            flightNumber    = "";
            launchDate      = new Date();
            launchTime      = new Time();
            launchSite      = "";
            vehicleType     = "";
            payload         = new Payload();
            customer        = new Customer();
            missionOutcome  = "";
            failureReason   = "";
            landingType     = "";
            landingOutcome  = "";
        }

        public Builder setFlightNumber(String flightNumber){
            this.flightNumber = flightNumber;
            return this;
        }

        public Builder setLaunchDate(Date launchDate){
            this.launchDate = launchDate;
            return this;
        }

        public Builder setLaunchDate(String launchDate){
            this.launchDate = new Date(launchDate);
            return this;
        }

        public Builder setLaunchTime(Time launchTime){
            this.launchTime = launchTime;
            return this;
        }

        public Builder setLaunchTime(String launchTime){
            this.launchTime = new Time(launchTime);
            return this;
        }

        public Builder setLaunchSite(String launchSite) {
            this.launchSite = launchSite;
            return this;
        }

        public Builder setVehicleType(String vehicleType) {
            this.vehicleType = vehicleType;
            return this;
        }

        public Builder setPayload(Payload payload) {
            this.payload = payload;
            return this;
        }

        public Builder setPayload(String payload) {
            this.payload = new Payload(payload);
            return this;
        }

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder setCustomer(String customer){
            this.customer = new Customer(customer);
            return this;
        }

        public Builder setMissionOutcome(String missionOutcome) {
            this.missionOutcome = missionOutcome;
            return this;
        }

        public Builder setFailureReason(String failureReason) {
            this.failureReason = failureReason;
            return this;
        }

        public Builder setLandingType(String landingType) {
            this.landingType = landingType;
            return this;
        }

        public Builder setLandingOutcome(String landingOutcome) {
            this.landingOutcome = landingOutcome;
            return this;
        }

        public Mission build(){
            return new Mission(this);
        }
    }
}
