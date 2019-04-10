import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Donation {
    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private static long count = 0;

    private String id;
    private String date;
    private double amount;

    private String awardId;
    private String donorId;

    public Donation(double amount, String donorId) {
        id = "DN" + ++count;

        this.date = dateFormat.format(LocalDate.now());
        this.amount = amount;
        this.donorId = donorId;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public String getDonorId() {
        return donorId;
    }

    public void setDonorId(String donorId) {
        this.donorId = donorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Donation donation = (Donation) o;
        return Objects.equals(id, donation.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%-10.2f\t%s\t%s", id, date, amount, awardId, donorId);
    }
}
