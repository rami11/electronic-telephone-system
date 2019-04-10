public class Donor extends Person {

    private static int count = 0;

    private String address;
    private String telephone;
    /*private Card card = new Card();*/

    public Donor(String firstName, String lastName, String address, String telephone) {
        super(firstName, lastName);

        this.address = address;
        this.telephone = telephone;

        setId("DR" + ++count);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /*public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }*/

    @Override
    public String toString() {
        return String.format("%s\t%s\t%s", super.toString(), address, telephone/*, card*/);
    }
}
