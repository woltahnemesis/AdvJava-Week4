import java.time.LocalDate;

public class TestPatient {
    public static void main (String[] args) {
        Patient patient = new Patient("Bard", "Bobby", "9655551234", "12 HappyVale Dr.",
                "Bradford", "ON", LocalDate.of(2000, 12, 14));
        System.out.printf("%s %s is patient ID: %d", patient.getFirstName(), patient.getLastName(), patient.getID());
    }
}