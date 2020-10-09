import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Patient {

    private int id;
    private String firstName, lastName, phoneNum, streetAddress, city, province;
    private LocalDate birthday;

    private final String phoneRegEx = "\\(?[2-9]\\d{2}\\)?[-\\s]?[2-9]\\d{2}[-\\s]?\\d{4}";
    private final String nameRegEx = "[A-Z][a-zA-Z\\-\\s']*";

    public Patient(String firstName, String lastName, String phoneNum, String streetAddress, String city, String province, LocalDate birthday) {
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNum(phoneNum);
        setStreetAddress(streetAddress);
        setCity(city);
        setProvince(province);
        setBirthday(birthday);
        //int id DBUtility.insertRecord();
        //setID(id);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        if(id > 0)
            this.id = id;
        else
            throw new IllegalArgumentException("Id must be greater than 0");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName.matches(nameRegEx))
            this.firstName = firstName;
        else
            throw new IllegalArgumentException("First name must start with upper case letter");
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName.matches(nameRegEx))
            this.lastName = lastName;
        else
            throw new IllegalArgumentException("First name must start with upper case letter");
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        if(phoneNum.matches(phoneRegEx))
            this.phoneNum = phoneNum;
        else
            throw new IllegalArgumentException("Phone number must be North American Dialing Plan");
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        if(!streetAddress.isBlank())
            this.streetAddress = streetAddress;
        else
            throw new IllegalArgumentException("Street name should have a number");
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if(!city.isBlank())
            this.city = city;
        else
            throw new IllegalArgumentException("City must be from the list: ");
    }

    public String getProvince() {
        return province;
    }

    public static List<String> getProvinceList(){
        ArrayList<String> provinces = new ArrayList(Arrays.asList("NL", "PE", "NS", "NB", "QC", "ON", "MB", "SK", "AB",
                "BC", "YT", "NT", "NU"));
        Collections.sort(provinces);
        return provinces;
    }

    public void setProvince(String province) {
        if(getProvinceList().contains(province))
            this.province = province;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        if(birthday.isBefore(LocalDate.now()) || birthday.isEqual(LocalDate.now())) {
            this.birthday = birthday;
            if(getAge() > 120){
                throw new IllegalArgumentException("Patient cannot be over 120 years of age");
            }
        }
        else
            throw new IllegalArgumentException("Birthday cannot be in the future");
    }

    public int getAge()
    {
        return Period.between(LocalDate.now(), birthday).getYears();
    }
}
