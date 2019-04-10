import java.util.Objects;

public class Card {
    private String number;
    private char type;
    private String expiryDate;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return type == card.type &&
                Objects.equals(number, card.number) &&
                Objects.equals(expiryDate, card.expiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, type, expiryDate);
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%s", number, type, expiryDate);
    }
}
