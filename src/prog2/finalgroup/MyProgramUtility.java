package prog2.finalgroup;

/**
 * OUTPUT INFO?
 * no. male citizens
 * no. female citizens
 * Population of citizens per district
 * No. of resident and non resident  citizens
 * no. senior citizens
 *
/**
 *
 *
 *
 * Population per District
 *  District 1: 124
 *  District 2: 134
 *  and so on...
 *
 *  Male citizens
 *      Number of males: 231
 *      we can show the list
 *
 * feMale citizens
 *      Number of females: 231
 *      we can show the list
 *
 *  Senior citizen
 *  Number of senior citizens: 502
 *  we can also show the list of seniors
 *
 *  Residents
 *      Number of residents: 2341
 *      we can show list
 * */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
public class MyProgramUtility {
    public List<Citizen> readDataFileIntoList() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("res/data.csv"));
        List<Citizen> citizenList = new ArrayList<>();
        String[] data;
        String[] data2;
        String[] data3;
        String lineOfText;
        boolean resident;
        String address;
        try {
            do {
                lineOfText = reader.readLine();

                if (lineOfText != null) {
                    // Check if line has "" usually it checks if the address part has ""
                    if (lineOfText.contains("\"")) {
                        data = lineOfText.split("\"");
                        data2 = data[0].split(",");
                        data3 = data[2].split(",");

                        resident = data3[2].equalsIgnoreCase("Resident");
                        //solution: if it has "" we will split them into 3 parts data[0](data before address), data[1](address), data[3](data after address)
                        //next replace all the commas in address with |
                        // Then after all that we should remove the double quotes from the address
                        citizenList.add(new Citizen(data2[0], data2[1], data2[2], data[1].replaceAll(",","|"),
                                Integer.parseInt(data3[1]), resident, Integer.parseInt(data3[3]), data3[4].charAt(0)));
                    }else {// just normally split them through commas if address don't have ""
                        data = lineOfText.split(",");
                        resident = data[5].equalsIgnoreCase("Resident");
                        citizenList.add(new Citizen(data[0], data[1], data[2], data[3].replaceAll(",","|"),
                                Integer.parseInt(data[4]), resident, Integer.parseInt(data[6]), data[7].charAt(0)));
                    }
                }
            } while (lineOfText != null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return citizenList;
    }



    public List<Citizen> seniorCitizenPopulation() throws IOException {
        List<Citizen> citizens1 = readDataFileIntoList();
        List<Citizen> seniors = citizens1.stream()
                .filter(citizen -> citizen.getAge() >= 60)
                .collect(Collectors.toList());

        return seniors;
    }

    public List<Citizen> numberOfResidents() throws IOException {
        List<Citizen> citizens2 = readDataFileIntoList();
        List<Citizen> residents = citizens2.stream()
                .filter(citizen -> citizen.isResident())//.filter(Citizen::isResident)
                .collect(Collectors.toList());

        return residents;
    }

    public List<Citizen> numberOfNonResidents() throws IOException {
        List<Citizen> citizens3 = readDataFileIntoList();
        List<Citizen> nonResidents = citizens3.stream()
                .filter(citizen -> citizen.isResident() != true)
                .collect(Collectors.toList());
        return nonResidents;
    }

    public List<Citizen> malePopulation() throws IOException {
        List<Citizen> citizens4 = readDataFileIntoList();
        List<Citizen> maleCitizens = citizens4.stream()
                .filter(citizen -> citizen.getGender() == 'M')
                .collect(Collectors.toList());

        return maleCitizens;
    }
    public List<Citizen> femalePopulation() throws IOException {
        List<Citizen> citizens5 = readDataFileIntoList();
        List<Citizen> femaleCitizens = citizens5.stream()
                .filter(citizen -> citizen.getGender() == 'F')
                .collect(Collectors.toList());

        return femaleCitizens;
    }
    public Map<Integer, List<Citizen>> populationPerDistrict() throws IOException {
        List<Citizen> citizens = readDataFileIntoList();
        Map<Integer, List<Citizen>> districtInfo = citizens.stream()
                .collect(Collectors.groupingBy(Citizen::getDistrict));
        return districtInfo;
    }

    public int listCounter(List<Citizen> citizens){
        int total = (int) citizens.stream().count();
        return total;
    }
}
