import java.time.LocalDate;

public class TestPatient {
    public static void main (String[] args) {
        Patient fred = new Patient("Fred", "Flintstone", "4165551234", "12 HappyVale Dr.",
                "Stroud", "ON", LocalDate.of(2000, 12, 14));
        System.out.printf("%s %s is patient ID: %d", fred.getFirstName(), fred.getLastName(), fred.getID());
    }
}
