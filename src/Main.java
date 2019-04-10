import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        EtsManager manager = new EtsManager();

        Scanner sc = new Scanner(System.in);

        while (true) {
            manager.displayOptions();
            System.out.println("\nChoose an option: ");
            String option = sc.nextLine();

            switch (option) {
                case "1":
                    manager.displaySponsors();
                    break;
                case "2":
                    manager.displayAwards();
                    break;
                case "3":
                    manager.displayDonors();
                    break;
                case "4":
                    manager.displayDonations();
                    break;
                case "5":
                    addDonor(sc, manager);
                    break;
                case "6":
                    donate(sc, manager);
                    break;
                case "7":
                    System.exit(0);
                    break;
                default:
                    System.err.println("Not an option!");
                    break;
            }
        }
    }

    private static void addDonor(Scanner sc, EtsManager manager) {
        System.out.println("Enter donor's first name: ");
        String firstName = sc.nextLine();

        System.out.println("Enter donor's last name: ");
        String lastName = sc.nextLine();

        System.out.println("Enter donor's address: ");
        String address = sc.nextLine();

        System.out.println("Enter donor's telephone: ");
        String telephone = sc.nextLine();

        Donor newDonor = new Donor(firstName, lastName, address, telephone);
        manager.addDonor(newDonor);

        System.out.println("Donor of id '" + newDonor.getId() + "' was added successfully!");
    }

    private static void donate(Scanner sc, EtsManager manager) {
        System.out.println("Enter donor's ID: ");
        String donorId = sc.nextLine();

        Donor donor = manager.findDonor(donorId);
        if (donor == null) {
            System.err.println("\nDonor of id '" + donorId + "' does not exist!");
            return;
        }

        System.out.println("Enter amount to donate: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        manager.donate(donor, amount);
    }


}
