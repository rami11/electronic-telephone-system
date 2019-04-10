public class Sponsor extends Person {

    private static int count = 0;

    public Sponsor(String firstName, String lastName) {
        super(firstName, lastName);

        setId("S" + ++count);
    }
}
