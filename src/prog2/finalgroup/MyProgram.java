package prog2.finalgroup;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyProgram implements Runnable{
    
    public static void main(String[] args) {
        
        try {
            MyProgram myProgram = new MyProgram();
            myProgram.run();
        }catch (Exception x){
            x.printStackTrace();
        }
        System.exit(0);
    }

    public void run(){
//        new CitizenMainMenu();
//        showPopulationPerDistrict();
        try {
            showSeniors();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        showResidents();
//        showNonResidents();
//        showMalePopulation();
//        showFemalePopulation();
    }
    public void showPopulationPerDistrict() throws IOException{
        MyProgramUtility programUtility = new MyProgramUtility();
        System.out.println("The Population of Citizens per District");

        Map<Integer, List<Citizen>> districtInfo = programUtility.populationPerDistrict();
        Set<Integer> districts = districtInfo.keySet();
        for (int d : districts) {
            List<Citizen> ctzen = districtInfo.get(d);
            int total = (int) ctzen.stream().count();
            String s = "District ";
            System.out.printf("%s%d: %d%n", s, d, total);
        }
    }

    public void showMalePopulation() throws IOException {
        MyProgramUtility programUtility = new MyProgramUtility();
        System.out.println("The Population of Male Citizens");
        List<Citizen> males = programUtility.malePopulation();
        int total = programUtility.listCounter(males);
        System.out.println("Male Citizens = " + total);
        males.forEach(System.out::println);
    }
    public void showFemalePopulation() throws IOException {
        MyProgramUtility programUtility = new MyProgramUtility();
        System.out.println("The Population of Female Citizens");
        List<Citizen> females = programUtility.femalePopulation();
        int total = programUtility.listCounter(females);
        System.out.println("Female Citizens = " + total);
        females.forEach(System.out::println);
    }

    public void showResidents() throws IOException {
        MyProgramUtility programUtility = new MyProgramUtility();
        System.out.println("The Number of Residents");
        List<Citizen> residents = programUtility.numberOfResidents();
        int total = programUtility.listCounter(residents);
        System.out.println("Residents = " + total);
        residents.forEach(System.out::println);
    }

    public void showNonResidents() throws IOException {
        MyProgramUtility programUtility = new MyProgramUtility();
        System.out.println("The Number of Non-Residents");
        List<Citizen> nonResidents = programUtility.numberOfNonResidents();
        int total = programUtility.listCounter(nonResidents);
        System.out.println("Non-Residents = " + total);
        nonResidents.forEach(System.out::println);
    }

    public void showSeniors() throws IOException {
        MyProgramUtility programUtility = new MyProgramUtility();
        System.out.println("The Number of Senior Citizens");
        List<Citizen> seniors = programUtility.seniorCitizenPopulation();
        int total = programUtility.listCounter(seniors);
        System.out.println("Senior Citizens = " + total);
        seniors.forEach(System.out::println);
    }

}