package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import java.util.Scanner;
import utility.ArrayList;
import utility.List;

public class FileManager {
    private String               csvFileHeader;
    private final String         inputFileLocation;
    private final String         outDirectory;
    private final List<Mission>  list;

    public FileManager(String inputFileLocation, String outDirectory) {
        this.outDirectory        = outDirectory;
        this.inputFileLocation   = inputFileLocation;
        list                     = new ArrayList<>();
    }


    public void filterCustomerDataByName(String customerName, String csvLocation, String textLocation)
                                        throws FileNotFoundException{
        File csvFile            = new File(csvLocation);
        File textFile           = new File(textLocation);
        PrintStream csvStream   = new PrintStream(csvFile);
        PrintStream textStream  = new PrintStream(textFile);

        if(csvFile.exists() && textFile.exists()) {
            csvStream.println(csvFileHeader);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getCustomer().getName().equals(customerName)) {
                    csvStream.println(list.get(i).toCSVFormat());
                    textStream.println(list.get(i).toString());
                }
            }
        }
        csvStream.close();
        textStream.close();
    }

    public void filterNonZeroPayloadMass(String csvLocation, String textLocation)
            throws FileNotFoundException{
        File csvFile            = new File(csvLocation);
        File textFile           = new File(textLocation);
        PrintStream csvStream   = new PrintStream(csvFile);
        PrintStream textStream  = new PrintStream(textFile);

        if(csvFile.exists() && textFile.exists()) {
            csvStream.println(csvFileHeader);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getPayload().getMass() != 0.0) {
                    csvStream.println(list.get(i).toCSVFormat());
                    textStream.println(list.get(i).toString());
                }
            }
        }
        csvStream.close();
        textStream.close();
    }

    public void filterCustomerDataByTwoCountry(String customerCountry_1, String customerCountry_2,
                                               String csvLocation, String textLocation)
                                              throws FileNotFoundException {
        File csvFile           = new File(csvLocation);
        File textFile          = new File(textLocation);
        PrintStream csvStream  = new PrintStream(csvFile);
        PrintStream textStream = new PrintStream(textFile);

        if (csvFile.exists() && textFile.exists()) {
            csvStream.println(csvFileHeader);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getCustomer().getCountry().equals(customerCountry_1) ||
                        list.get(i).getCustomer().getCountry().equals(customerCountry_2)) {
                    csvStream.println(list.get(i).toCSVFormat());
                    textStream.println(list.get(i).toString());
                }
            }
            csvStream.close();
            textStream.close();
        }
    }

    public void filterCustomerByTwoCountryInConsole(String customerCountry_1, String customerCountry_2) {
        for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getCustomer().getCountry().equals(customerCountry_1) ||
                        list.get(i).getCustomer().getCountry().equals(customerCountry_2)) {
                    System.out.println(list.get(i));
                }
        }
    }

    public List<Mission> getList(){
        return list;
    }

    private Mission parse(String line) throws IllegalArgumentException {
        String[] str       = line.split(",");
        String[] column    = new String[16];

        //copy any smaller str data to larger array to fix issues with splitting.
        // since empty spot in txt file by using split won't work as what we expected
        for (int i = 0; i < str.length ; i++) {
            column[i]   = str[i];
        }

        //null values at the end is padded with empty strings
        if (str.length < column.length) {
            for (int i = str.length; i < column.length; i++) {
                column[i] = "";
            }
        }
        String      flightNumber    = column[0];
        Date        launchDate      = new Date(column[1]);
        Time        launchTime      = new Time(column[2]);
        String      launchSite      = column[3];
        String      vehicleType     = column[4];
        double      mass            = column[7].equals("") ? 0.0 : Double.parseDouble(column[7]);
        Payload     payload         = new Payload(column[5], column[6], mass, column[8] );
        Customer    customer        = new Customer(column[9], column[10], column[11]);
        String      missionOutcome  = column[12];
        String      failureReason   = column[13];
        String      landingType     = column[14];
        String      landingOutcome  = column [15];

        return new   Mission.Builder()
                .setFlightNumber(flightNumber)
                .setLaunchDate(launchDate)
                .setLaunchTime(launchTime)
                .setLaunchSite(launchSite)
                .setVehicleType(vehicleType)
                .setPayload(payload)
                .setCustomer(customer)
                .setMissionOutcome(missionOutcome)
                .setFailureReason(failureReason)
                .setLandingType(landingType)
                .setLandingOutcome(landingOutcome)
                .build();
    }

    public void read() throws FileNotFoundException {
        File    file      = new File(inputFileLocation);
        Scanner input     = new Scanner(file);
        Mission mission;

        if (input.hasNextLine())
            csvFileHeader = input.nextLine();

        while (input.hasNextLine()) {
            mission = parse(input.nextLine());
            list.add(mission);
        }
        input.close();
    }


    public void write() throws FileNotFoundException{
        PrintStream   output    = new PrintStream(outDirectory);
        StringBuilder builder   = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i).toCSVFormat()).append("\n");
        }
        output.println(csvFileHeader);
        output.print(builder);
        output.close();
    }
}
