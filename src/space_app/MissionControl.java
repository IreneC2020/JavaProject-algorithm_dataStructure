package space_app;

import java.util.Scanner;

/******************************************************************
 *  This program reads in the destination planet and earth mass
 *  and prints weights to the console screen.
 *
 ******************************************************************/

public class MissionControl {

    /*****************************************************************
     *  converts Astronaut weight from Newtons to lbs
     * ***************************************************************/
    public static double toLbs(Planet planet, double mass) {
        final double TO_LBS = 1.0 / 4.448;
        return planet.surfaceWeight(mass) * TO_LBS;
    }

    public static void compute(){

        Scanner console = new Scanner(System.in);
        System.out.print("Enter destination planet and earth mass: ");

        Planet other   = Planet.valueOf(console.next().toUpperCase());
        double mass    = console.nextDouble();
        print(other, mass);
        console.close();
    }

    public static void print(Planet other, double mass) {
        Planet earth = Planet.EARTH;

        System.out.printf("-------- %s Data --------- \n", other.name());
        System.out.println(" WEIGHT: N ");
        System.out.println("-----------------------------");
        System.out.printf("%-7s : %7.2f N \n", earth.name(), earth.surfaceWeight(mass));
        System.out.printf("%-7s : %7.2f N \n", other.name(), other.surfaceWeight(mass));

        System.out.println();
        System.out.println(" WEIGHT: LBS ");
        System.out.println("------------------------------");
        System.out.printf("%-7s : %7.2f N \n", earth.name(), toLbs(Planet.EARTH, mass));
        System.out.printf("%-7s : %7.2f N \n", other.name(), toLbs(other, mass));
    }

    public static void main(String[] args) {
        Planet planet = Planet.EARTH;
        System.out.println(planet.ordinal());
        planet = Planet.MARS;
        System.out.println(planet.ordinal());

        System.out.println(planet.surfaceWeight(10));

        Astronaut astronaut = new Astronaut.Builder()
                                            .setName("Tycho Brahe")
                                            .setAge(33)
                                            .setMass(55.35)
                                            .setPerson()
                                            .setMissions(12)
                                            .setRank(Rank.CAPTAIN)
                                            .setRole(Role.COMMANDER)
                                            .setStatus(Status.ACTIVE)
                                            .setDivision(Division.EXPLORATION)
                                            .build();

        System.out.println(astronaut);
        System.out.println();
        System.out.println(astronaut.profile(Planet.SATURN) );

    }
}
