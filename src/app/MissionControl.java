package app;

import java.io.File;
import java.io.FileNotFoundException;
import static modules.UModule.quickSort;

public class MissionControl {

    public static void main(String[] args) throws FileNotFoundException {
        String inputLocation = "." + File.separator + "data"
                + File.separator + "spacex_mission_data.csv";
        String outputDirectory  = "." + File.separator + "results" + File.separator ;
        FileManager fileManager = new FileManager(inputLocation, outputDirectory + "results-excel.csv");
        fileManager.read();
        fileManager.write();

        // sorting non zero payload mass
        String nonZeroTextFileLocation = "." + File.separator + "results" + File.separator + "nonZero.txt";
        String nonZeroCsvFileLocation  = "." + File.separator + "results" + File.separator + "nonZero.csv";
        quickSort(fileManager.getList(), Mission::compareMissions); // by payload masses
        fileManager.filterNonZeroPayloadMass(nonZeroCsvFileLocation, nonZeroTextFileLocation);

        // filter NASA
        String textFileLocation = "." + File.separator + "results" + File.separator + "NASA.txt";
        String csvFileLocation  = "." + File.separator + "results" + File.separator + "NASA.csv";
        fileManager.filterCustomerDataByName("NASA", csvFileLocation, textFileLocation);

        // filter Bermuda and Thailand
        String countryTextFileLocation = "." + File.separator + "results" + File.separator + "country.txt";
        String countryCsvFileLocation  = "." + File.separator + "results" + File.separator + "country.csv";
        fileManager.filterCustomerDataByTwoCountry("Bermuda", "Thailand",
                                                    countryCsvFileLocation, countryTextFileLocation);

        // filter Israel and France and print in console
        fileManager.filterCustomerByTwoCountryInConsole("France", "Israel");
    }
}
