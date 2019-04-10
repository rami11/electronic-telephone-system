import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EtsManager {

    private List<Donor> donors;
    private List<Donation> donations;
    private List<Sponsor> sponsors;
    private List<Award> awards;

    public EtsManager() {
        awards = new ArrayList<>();
        donors = new ArrayList<>();
        donations = new ArrayList<>();

        /*SPONSORS*/
        sponsors = Arrays.asList(
                new Sponsor("Fadi", "Serapian"),
                new Sponsor("Rami", "Serapian"),
                new Sponsor("Camille", "Serapian")
        );

        /*DONORS*/
        donors.addAll(Arrays.asList(
                new Donor("Rami", "Serapian", "2300 Timens Boul.", "438 830 8292"),
                new Donor("Georges", "Sayer", "4322 Saint Castin", "514 432 5433")
        ));

        /*AWARDS*/
        awards.addAll(Arrays.asList(
                new Award("TV", 600, 1200, 6, 6, "S1"),
                new Award("Calendar", 20, 40, 50, 50, "S3"),
                new Award("BBQ", 50, 100, 15, 15, "S2"),
                new Award("Meal for 2", 200, 400, 15, 15, "S2")
        ));
    }

    public List<Donor> getDonors() {
        return donors;
    }

    public void setDonors(List<Donor> donors) {
        this.donors = donors;
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }

    public List<Sponsor> getSponsors() {
        return sponsors;
    }

    public void setSponsors(List<Sponsor> sponsors) {
        this.sponsors = sponsors;
    }

    public List<Award> getAwards() {
        return awards;
    }

    public void setAwards(List<Award> awards) {
        this.awards = awards;
    }

    public void addDonor(Donor newDonor) {
        donors.add(newDonor);
    }

    public void addSponsor(Sponsor newSponsor) {
        sponsors.add(newSponsor);
    }

    public void addAward(Award newAward) {
        awards.add(newAward);
    }

    public void addDonation(Donation newDonation) {
        donations.add(newDonation);
    }

    private <E> void displayList(List<E> list) {
        StringBuilder strBuilder = new StringBuilder();
        list.forEach(element -> strBuilder.append(element).append('\n'));
        System.out.println(strBuilder.length() == 0 ? "Empty!\n" : strBuilder.toString());
    }

    public void displayDonors() {
        displayList(donors);
    }

    public void displaySponsors() {
        displayList(sponsors);
    }

    public void displayAwards() {
        displayList(awards);
    }

    public void displayDonations() {
        displayList(donations);
    }

    private Award selectAward(double amount) {
        List<Award> sortedByValueAwards = awards.stream().sorted().collect(Collectors.toList());

        for (Award award : sortedByValueAwards) {
            if (amount >= award.getMinDonation()) {
                return award;
            }
        }
        return null;
    }

    private Award giveAward(Donation donation) {
        Award award = selectAward(donation.getAmount());
        if (award == null) {
            System.err.println("Donation value is low; no awards is available for such amount.");
        }

        if (award != null && award.getAvailableQty() > 0) {
            award.setAvailableQty(award.getAvailableQty() - 1);
            donation.setAwardId(award.getId());
            return award;
        }
        return null;
    }

    public void donate(Donor donor, double amount) {

        Donation newDonation = new Donation(amount, donor.getId());
        addDonation(newDonation);

        Award awardGranted = giveAward(newDonation);
        if (awardGranted != null) {
            System.out.println("Award [" + awardGranted + "] granted to donor: " + donor);
        } else {
            System.err.println("No award granted!");
        }
    }

    public Donor findDonor(String id) {
        for (Donor donor : donors) {
            if (donor.getId().equalsIgnoreCase(id)) {
                return donor;
            }
        }
        return null;
    }

    public void displayOptions() {
        String options = "\n1. Display sponsors." +
                "\n2. Display awards." +
                "\n3. Display donors." +
                "\n4. Display donations." +
                "\n5. Add donor." +
                "\n6. Donate." +
                "\n7. Exit.";

        System.out.println(options);
    }

}
