package prog2.finalgroup;

public class Citizen implements Comparable<Citizen>{
    private String fullName;
    private String email;
    private String address;
    private int age;
    private boolean resident;
    private int district;
    private char gender;

    public Citizen(String firstName, String lastName, String email, String address, int age, boolean resident, int district, char gender) {
        this.fullName = firstName + " " + lastName;
        this.email = email;
        this.address = address;
        this.age = age;
        this.resident = resident;
        this.district = district;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", resident=" + resident +
                ", district=" + district +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public int compareTo(Citizen o) {
        return fullName.compareTo(o.getFullName());
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public boolean isResident() {
        return resident;
    }

    public int getDistrict() {
        return district;
    }

    public char getGender() {
        return gender;
    }
}