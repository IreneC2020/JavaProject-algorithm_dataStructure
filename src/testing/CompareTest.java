package testing;

import app.Date;
import app.Mission;
import app.Payload;
import app.Time;
import coordinates.Point;
import coordinates.Rectangle;
import utility.List;
import utility.ArrayList;

import static modules.TModule.binarySearch;
import static modules.TModule.quickSort;
import static modules.TModule.linearSearch;

public class CompareTest {

    public static void compareDates(){
        System.out.println();
        System.out.println("*****************COMPARE DATE**********************************");
        System.out.println();
        List<Date> list = new ArrayList<>();
        list.add(new Date("24-Mar-06"));
        list.add(new Date("21-Mar-07"));
        list.add(new Date("3-Aug-08"));
        list.add(new Date("28-Sep-08"));
        list.add(new Date("14-Jul-09"));
        list.add(new Date("4-Jun-10"));
        list.add(new Date("8-Dec-10"));
        list.add(new Date("22-May-12"));
        list.add(new Date("8-Oct-12"));
        list.add(new Date("24-Mar-06"));

        System.out.println("------- DATE: before sorting --------");
        for(int i = 0; i < list.size(); i++) {
            System.out.println("element " + i + ": " + list.get(i));
        }
        System.out.println();
        System.out.println("------- DATE: ordering by month, then day, then year using comparable--------");
        quickSort(list);
        for(int i = 0; i < list.size(); i++) {
            System.out.println("element " + i + " : " + list.get(i));
        }
        System.out.println();
        System.out.println("------- DATE: ordering by month, then day, then year, using comparator--------");
        quickSort(list, Date::compareDates);
        for(int i = 0; i < list.size(); i++) {
            System.out.println("element " + i + " : " + list.get(i));
        }
    }

    public static void compareMissions(){
        Mission mission1 = new Mission.Builder()
                                .setFlightNumber("F1-1")
                                .setLaunchDate("24-Mar-06")
                                .setLaunchTime("22:30")
                                .setLaunchSite("Marshall Islands")
                                .setVehicleType("Falcon 1")
                                .setPayload("SpaceX CRS-1,Space Station Supplies,600,Low Earth Orbit")
                                .setCustomer("NASA,Government,United States")
                                .setMissionOutcome("Failure")
                                .setFailureReason("Collision During Launch")
                                .setLandingType("Parachute")
                                .setLandingOutcome("Failure")
                                .build();
        Mission mission2 = new Mission.Builder()
                                .setFlightNumber("F9-6")
                                .setLaunchDate("29-Sep-13")
                                .setLaunchTime("16:00")
                                .setLaunchSite("Vandenberg AFB SLC-4E")
                                .setVehicleType("Falcon 9 (v1.1)")
                                .setPayload("CASSIOPE,Communication/Research Satellite,500,Polar Orbit")
                                .setCustomer("MDA Corp,Business,Canada")
                                .setMissionOutcome("Success")
                                .setFailureReason("")
                                .setLandingType("Ocean")
                                .setLandingOutcome("Failure")
                                .build();
        Mission mission3 = new Mission.Builder()
                                .setFlightNumber("F9-19")
                                .setLaunchDate("28-Jun-15")
                                .setLaunchTime("14:21")
                                .setLaunchSite("Cape Canaveral AFS LC-40")
                                .setVehicleType("Falcon 9 (v1.1)")
                                .setPayload("X CRS-7,Space Station Supplies,1952,Low Earth Orbit")
                                .setCustomer("NASA,Government,United States")
                                .setMissionOutcome("Failure")
                                .setFailureReason("Vehicle Explosion During Flight\n")
                                .setLandingType("None")
                                .setLandingOutcome("Failure")
                                .build();
        System.out.println();
        System.out.println("*****************COMPARE MISSIONS**********************************");
        System.out.println();
        List<Mission> list = new ArrayList<>();
        list.add(mission1);
        list.add(mission2);
        list.add(mission3);
        System.out.println("------- MISSION: before sorting --------");
        for(int i = 0; i < list.size(); i++) {
            System.out.println("element " + i + ": " + list.get(i).toCSVFormat());
        }
        System.out.println();
        System.out.println("------- MISSION: ordering by Payload, using comparable--------");
        quickSort(list);
        for(int i = 0; i < list.size(); i++) {
            System.out.println("element " + i + " : " + list.get(i).toCSVFormat());
        }
        System.out.println();
        System.out.println("---------MISSION ANOTHER LIST: before sorting-------");
        List<Mission> list1 = new ArrayList<>();
        list1.add(mission3);
        list1.add(mission2);
        list1.add(mission1);
        for(int i = 0; i < list1.size(); i++) {
            System.out.println("element " + i + " : " + list1.get(i).toCSVFormat());
        }
        System.out.println();
        System.out.println("------- MISSION: ordering by Payload, using comparator--------");
        quickSort(list, Mission::compareMissions);
        for(int i = 0; i < list.size(); i++) {
            System.out.println("element " + i + " : " + list.get(i).toCSVFormat());
        }

    }

    public static void comparePayloads(){
        System.out.println();
        System.out.println("*****************COMPARE PAYLOADS**********************************");
        System.out.println();
        List<Payload> list = new ArrayList<>();
        list.add(new Payload("AsiaSat 8, Communication Satellite, 4535, Geostationary Transfer Orbit"));
        list.add(new Payload("AsiaSat 6, Communication Satellite, 4428, Geostationary Transfer Orbit"));
        list.add(new Payload("SpaceX CRS-4,Space Station Supplies,2216, Geostationary Transfer Orbit"));
        list.add(new Payload("Eutelsat 115 West B (Satmex 7),Communication Satellite,4159,Geostationary Transfer Orbit"));
        list.add(new Payload("Jason-3,Weather Satellite,553,Low Earth Orbit"));

        System.out.println("------- PAYLOAD: before sorting --------");
        for(int i = 0; i < list.size(); i++) {
            System.out.println("element " + i + ": " + list.get(i));
        }
        System.out.println();
        System.out.println("------- PAYLOAD: ordering by name, type, then mass, using comparable--------");
        quickSort(list);
        for(int i = 0; i < list.size(); i++) {
            System.out.println("element " + i + " : " + list.get(i));
        }
        System.out.println();
        System.out.println("------- PAYLOAD: ordering by mass, name, then type, using comparator--------");
        quickSort(list, Mission::comparePayloads); // set up compare method in mission class
        quickSort(list, Payload::comparePayloads); // set up compare method in payload class

        for(int i = 0; i < list.size(); i++) {
            System.out.println("element " + i + " : " + list.get(i));
        }
    }


    public static void comparePoints(){
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        List<Point> list = new ArrayList<>();
        list.add(new Point(6, 5));
        list.add(new Point(8, 6));
        list.add(new Point(3, 7));
        list.add(new Point(7, 9));
        list.add(new Point(2, 5));
        list.add(new Point(5, 4));
        list.add(new Point(5, 6));
        list.add(new Point(1, 8));
        list.add(new Point(7, 5));
        list.add(new Point(4, 8));

        System.out.println("------- dimensions: before sorting --------");
        for(int i = 0; i < list.size(); i++) {
            System.out.println("element " + i + ": " + list.get(i));
        }
        System.out.println();

        System.out.println("------- dimensions: natural ordering --------");
        quickSort(list);

        for(int i = 0; i < list.size(); i++) {
            System.out.println("element " + i + " : " + list.get(i));
        }
    }

    public static void compareRectangles(){
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        List<Rectangle> list = new ArrayList<>();
        list.add(new Rectangle(7, 9));
        list.add(new Rectangle(5, 4));
        list.add(new Rectangle(8, 6));
        list.add(new Rectangle(3, 7));
        list.add(new Rectangle(1, 8));
        list.add(new Rectangle(6, 5));
        list.add(new Rectangle(4, 8));
        list.add(new Rectangle(7, 5));
        list.add(new Rectangle(2, 5));
        list.add(new Rectangle(5, 9));

        System.out.println("------- dimensions: before sorting --------");
        for(int i = 0; i < list.size(); i++) {
            System.out.println("element " + i + ": " + list.get(i));
        }

        System.out.println();
        System.out.println("------- dimensions: natural ordering --------");
        quickSort(list);

        for(int i = 0; i < list.size(); i++) {
            System.out.println("element " + i + " : " + list.get(i));
        }

        System.out.println();
        System.out.println("------- areas: different ordering --------");
        quickSort(list, Rectangle::compareAreas);

        // use for i loop instead of for each loop, for each loop is not support by utility.List
        for (int i = 0; i < list.size(); i++){ //Rectangle rectangle : list)
            System.out.println(list.get(i) + ": " + list.get(i).area());
        }

        System.out.println();
        System.out.println("------- perimeters: different ordering --------");
        quickSort(list, Rectangle::comparePerimeters);

        // use for i loop instead of for each loop, for each loop is not support by utility.List
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i) + ": " + list.get(i).perimeter());
        }
    }

    public static void compareTimes(){
        System.out.println();
        System.out.println("*****************COMPARE TIME**********************************");
        System.out.println();
        List<Time> list = new ArrayList<>();
        list.add(new Time("11:22"));
        list.add(new Time("21:01"));
        list.add(new Time("15:13"));
        list.add(new Time("02:33"));
        list.add(new Time("01:55"));
        list.add(new Time("9:12"));
        list.add(new Time("20:22"));
        list.add(new Time("19:20"));
        list.add(new Time("18:25"));
        list.add(new Time("05:25"));

        System.out.println("------- TIME: before sorting --------");
        for(int i = 0; i < list.size(); i++) {
            System.out.println("element " + i + ": " + list.get(i));
        }
        System.out.println();

        System.out.println("------- TIME: ordering by hours , minutes, using comparable--------");
        quickSort(list);
        for(int i = 0; i < list.size(); i++) {
            System.out.println("element " + i + " : " + list.get(i));
        }
        System.out.println();
        System.out.println("------- TIME: ordering by hours , minutes, using comparable--------");
        quickSort(list, Time::compareTimes);
        for(int i = 0; i < list.size(); i++) {
            System.out.println("element " + i + " : " + list.get(i));
        }
    }

    public static void findDate(){
        System.out.println();
        System.out.println("***************FIND DATE***********************");
        System.out.println();
        List<Date> list = new ArrayList<>();
        list.add(new Date("24-Mar-06"));
        list.add(new Date("21-Mar-07"));
        list.add(new Date("3-Aug-08"));
        list.add(new Date("28-Sep-08"));
        list.add(new Date("14-Jul-09"));
        list.add(new Date("4-Jun-10"));
        list.add(new Date("8-Dec-10"));
        list.add(new Date("22-May-12"));
        list.add(new Date("8-Oct-12"));
        list.add(new Date("24-Mar-06"));
        Date date1 = new Date("8-Oct-12");
        System.out.println("Date List: ");
        for(int i = 0; i < list.size(); i++) {
            System.out.println("element " + i + ": " + list.get(i));
        }
        System.out.println();
        System.out.println("Where is date1(8-Oct-12) located?: " + binarySearch(list, date1));
        //System.out.println(date1);
    }

    public static void findMission() {
        System.out.println();
        System.out.println("***************FIND MISSION***********************");
        System.out.println();
        Mission mission1 = new Mission.Builder()
                .setFlightNumber("F1-1")
                .setLaunchDate("24-Mar-06")
                .setLaunchTime("22:30")
                .setLaunchSite("Marshall Islands")
                .setVehicleType("Falcon 1")
                .setPayload("SpaceX CRS-1,Space Station Supplies,600,Low Earth Orbit")
                .setCustomer("NASA,Government,United States")
                .setMissionOutcome("Failure")
                .setFailureReason("Collision During Launch")
                .setLandingType("Parachute")
                .setLandingOutcome("Failure")
                .build();
        Mission mission2 = new Mission.Builder()
                .setFlightNumber("F9-6")
                .setLaunchDate("29-Sep-13")
                .setLaunchTime("16:00")
                .setLaunchSite("Vandenberg AFB SLC-4E")
                .setVehicleType("Falcon 9 (v1.1)")
                .setPayload("CASSIOPE,Communication/Research Satellite,500,Polar Orbit")
                .setCustomer("MDA Corp,Business,Canada")
                .setMissionOutcome("Success")
                .setFailureReason("")
                .setLandingType("Ocean")
                .setLandingOutcome("Failure")
                .build();
        Mission mission3 = new Mission.Builder()
                .setFlightNumber("F9-19")
                .setLaunchDate("28-Jun-15")
                .setLaunchTime("14:21")
                .setLaunchSite("Cape Canaveral AFS LC-40")
                .setVehicleType("Falcon 9 (v1.1)")
                .setPayload("X CRS-7,Space Station Supplies,1952,Low Earth Orbit")
                .setCustomer("NASA,Government,United States")
                .setMissionOutcome("Failure")
                .setFailureReason("Vehicle Explosion During Flight\n")
                .setLandingType("None")
                .setLandingOutcome("Failure")
                .build();
        System.out.println();
        List<Mission> list = new ArrayList<>();
        list.add(mission1);
        list.add(mission2);
        list.add(mission3);
        System.out.println("Mission List");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("element " + i + ": " + list.get(i).toCSVFormat());
        }
        System.out.println();
        System.out.println("Where is mission2 located?: " + binarySearch(list, mission2));
    }

    public static void findPayload(){
        System.out.println();
        System.out.println("***************FIND PAYLOAD***********************");
        System.out.println();
        List<Payload> list = new ArrayList<>();
        list.add(new Payload("AsiaSat 8, Communication Satellite, 4535, Geostationary Transfer Orbit"));
        list.add(new Payload("AsiaSat 6, Communication Satellite, 4428, Geostationary Transfer Orbit"));
        list.add(new Payload("SpaceX CRS-4,Space Station Supplies,2216, Geostationary Transfer Orbit"));
        list.add(new Payload("Eutelsat 115 West B (Satmex 7),Communication Satellite,4159,Geostationary Transfer Orbit"));
        list.add(new Payload("Jason-3,Weather Satellite,553,Low Earth Orbit"));
        Payload payload = new Payload("SpaceX CRS-4,Space Station Supplies,2216, Geostationary Transfer Orbit");

        System.out.println("Payload List: ");
        for(int i = 0; i < list.size(); i++) {
            System.out.println("element " + i + ": " + list.get(i));
        }
        System.out.println();
        System.out.println("payload: SpaceX CRS-4,Space Station Supplies,2216, Geostationary Transfer Orbit");
        System.out.println("Where is payload located?: " + binarySearch(list, payload));
    }


    public static void findPoint(){
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();

        Point p1 = new Point(1, 3);
        Point p2 = new Point(5, 8);
        Point p3 = new Point(3, 9);
        Point p4 = new Point(2, 7);
        Point p5 = new Point(1, 8);

        Point[] points = {p1, p4, p5, p2, p3,};

        System.out.println("Where is p2 located?: " + linearSearch(points, p2));
    }

    public static void findTime(){
        System.out.println();
        System.out.println("***************FIND TIME***********************");
        System.out.println();
        List<Time> list = new ArrayList<>();
        list.add(new Time("11:22"));
        list.add(new Time("21:01"));
        list.add(new Time("15:13"));
        list.add(new Time("02:33"));
        list.add(new Time("01:55"));
        list.add(new Time("9:12"));
        list.add(new Time("20:22"));
        list.add(new Time("19:20"));
        list.add(new Time("18:25"));
        list.add(new Time("05:25"));
        Time time1 = new Time("01:55");

        System.out.println("Time List: ");
        for(int i = 0; i < list.size(); i++) {
            System.out.println("element " + i + ": " + list.get(i));
        }
        System.out.println();
        System.out.println("Where is time1(01:55) located?: " + binarySearch(list, time1));
    }

    public static void intro(){
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" \t \t C O M P A R E   O B J E C T S  ");
        System.out.println(" \t \t    T E S T    P R O G R A M");
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        intro();
        findPoint();
        comparePoints();
        compareRectangles();

        compareDates();
        compareMissions();
        comparePayloads();
        compareTimes();

        findDate();
        findPayload();
        findTime();
        findMission();
    }
}
