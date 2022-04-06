package testing;

import app.Customer;
import app.Date;
import app.Mission;
import app.Month;
import app.Payload;
import app.Time;


public class FirstAppTest {

    public static void main(String[] args)  {
        System.out.println("--------------Customer------------");
        Customer testCustomer = new Customer("A_Customer", "A_Type", "A_Country");
        System.out.println("Customer toCSVFormat: " + testCustomer.toCSVFormat());
        System.out.println("Getters: " + testCustomer.getCountry() + "," + testCustomer.getType() + "," + testCustomer.getName());

        System.out.println("\n--------------Date------------");
        Date testDate = new Date("07-Dec-08");
        System.out.println("Date toCSVFormat: " + testDate.toCSVFormat());

        System.out.println("\n--------------Time------------");
        Time testTime = new Time("01:22");
        System.out.println("Time toCSVFormat: " + testTime.toCSVFormat());

        System.out.println("\n--------------Payload------------");
        Payload testPayload = new Payload("Name", "Type", 0.33, "Orbit");
        System.out.println("Payload toCSVFormat: " + testPayload.toCSVFormat());
        System.out.println("Getters: " + testPayload.getName() + "," + testPayload.getType() + ","
                + testPayload.getMass() + "," + testPayload.getOrbit());

        System.out.println("\n--------------Mission------------");
        Mission testMission = new Mission.Builder()
                .setFlightNumber("F1-3")
                .setLaunchDate(testDate)
                .setLaunchTime(testTime)
                .setLaunchSite("Launch Site")
                .setVehicleType("Vehicle Type")
                .setPayload(testPayload)
                .setCustomer(testCustomer)
                .setMissionOutcome("Mission Outcome")
                .setFailureReason("Failure Reason")
                .setLandingType("Landing type")
                .setLandingOutcome("Landing outcome")
                .build();

        Mission newMission = new Mission.Builder()
                .setFlightNumber("F1-3")
                .setLaunchDate("07-Dec-08")
                .setLaunchTime("01:22")
                .setLaunchSite("Launch Site")
                .setVehicleType("Vehicle Type")
                .setPayload(testPayload)
                .setCustomer(testCustomer)
                .setMissionOutcome("Mission Outcome")
                .setFailureReason("Failure Reason")
                .setLandingType("Landing type")
                .setLandingOutcome("Landing outcome")
                .build();
        System.out.println("Mission toCSVFormat: " + testMission.toCSVFormat());
        System.out.println("Now, use updated set methods for LaunchDate, LaunchTime, PayLoad, Customer");
        System.out.println("Mission toCSVFormat: " + newMission.toCSVFormat());

        System.out.println(Month.JAN);
        System.out.println(Month.FEB);
        System.out.println(Month.MAR);
        System.out.println(Month.APR);
        System.out.println(Month.MAY);
        System.out.println(Month.JUN);
        System.out.println(Month.JUL);
        System.out.println(Month.AUG);
        System.out.println(Month.SEP);
        System.out.println(Month.OCT);
        System.out.println(Month.NOV);
        System.out.println(Month.DEC);
    }
}
