package testing;

import app.Mission;

public class MissionTest{
    public static void testSetCustomerWithString(){
        System.out.println("------------Test setCustomer with String as parameter------------------");
        Mission mission = new Mission.Builder()
                .setCustomer("MDA Corp,Business,Canada")
                .build();
        System.out.println("Customer Name: " + mission.getCustomer().getName());
        System.out.println("Customer Type: " + mission.getCustomer().getType());
        System.out.println("Customer Country: " + mission.getCustomer().getCountry());
        System.out.println();
    }

    public static void testSetLaunchDateWithString(){
        System.out.println("-----------Test setLaunchDate with String as parameter------------");
        Mission mission = new Mission.Builder()
                .setLaunchDate("28-Jun-15")
                .build();

        System.out.println("Year: " + mission.getLaunchDate().getYear());
        System.out.println("Month: " + mission.getLaunchDate().getMonth());
        System.out.println("Day: " + mission.getLaunchDate().getDay());
        System.out.println();
    }

    public static void testSetLaunchTimeWithString(){
        System.out.println("--------------Test setLaunchTime with String as parameter--------------");
        Mission mission = new Mission.Builder()
                                .setLaunchTime("11:22")
                                .build();
        System.out.println("Hour: " + mission.getLaunchTime().getHour());
        System.out.println("Minute: " + mission.getLaunchTime().getMinutes());
        System.out.println();
    }

    public static void testSetPayloadWithString(){
        System.out.println("------------Test setPayload with String as parameter------------------");
        Mission mission = new Mission.Builder()
                .setPayload("SpaceX CRS-4,Space Station Supplies,2216, Geostationary Transfer Orbit")
                .build();
        System.out.println("Payload Name: " + mission.getPayload().getName());
        System.out.println("Payload Type: " + mission.getPayload().getType());
        System.out.println("Payload Mass(kg): " + mission.getPayload().getMass());
        System.out.println("Payload orbit: " + mission.getPayload().getOrbit());
        System.out.println();
    }


    public static void main(String[] args){
        testSetLaunchTimeWithString();
        testSetLaunchDateWithString();
        testSetPayloadWithString();
        testSetCustomerWithString();
    }
}
