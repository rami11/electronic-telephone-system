public class Award implements Comparable<Award> {

    private static long count = 0;

    private String id;
    private String description;
    private double value;
    private double minDonation;
    private int originalQty;
    private int availableQty;
    private String sponsorId;

    public Award(String description, double value, double minDonation, int originalQty, int availableQty, String sponsorId) {
        id = "A" + ++count;

        this.description = description;
        this.value = value;
        this.minDonation = minDonation;
        this.originalQty = originalQty;
        this.availableQty = availableQty;
        this.sponsorId = sponsorId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getMinDonation() {
        return minDonation;
    }

    public void setMinDonation(double minDonation) {
        this.minDonation = minDonation;
    }

    public int getOriginalQty() {
        return originalQty;
    }

    public void setOriginalQty(int originalQty) {
        this.originalQty = originalQty;
    }

    public int getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(int availableQty) {
        this.availableQty = availableQty;
    }

    public String getSponsorId() {
        return sponsorId;
    }

    public void setSponsorId(String sponsorId) {
        this.sponsorId = sponsorId;
    }

    public void deduct(int value) {

    }

    @Override
    public String toString() {
        return String.format(
                "%s\t%-10s\t$ %-10.2f\t$ %-10.2f\t%d\t%d\t%s", id, description, value, minDonation, originalQty, availableQty, sponsorId
        );
    }

    @Override
    public int compareTo(Award o) {
        return (int) (o.getValue() - this.getValue());
    }
}
