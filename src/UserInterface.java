import java.util.Scanner;
public class UserInterface {
    public String fileName;
    private CSV c;
    public UserInterface(String fileName){
        this.fileName = fileName;
        c = new CSV(fileName);
    }
    private void print_all_clients(){
        for(Client client : c.clientList){
            System.out.println(client.getFirstName()+"\t"+client.getLastName()+"\t"+client.getBalance()+"\t"+client.getOverdraft());
        }
    }
    public void commandLine(){
        boolean flag = true;
        while(flag) {
            Scanner input = new Scanner(System.in);
            System.out.println("1. Print client list\n2. Edit client\n3. Delete client\n4.Commit Changes");
            System.out.print("Select Option: ");
            int option;
            try {
                option = input.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid Input");
                option = 999;
            }
            String firstName;
            String lastName;
            switch (option) {
                case 1:
                    print_all_clients();
                    break;
                case 2:
                    System.out.print("First name: ");
                    firstName = input.next();
                    System.out.print("Last name: ");
                    lastName = input.next();
                    //c.search_client();
                    System.out.println("1. First name\n2. Last name \n3. Date of birth\n4. Pronouns\n5. Deposit\n6. Withdraw\n7. Overdraft");
                    int opt;
                    try {
                        System.out.print("Select Option to edit: ");
                        opt = input.nextInt();
                    } catch (Exception e) {
                        break;
                    }
                    switch (opt) {
                        case 1:
                            System.out.print("Enter new first name: ");
                            String newFName = input.next();
                            c.edit_client(firstName, lastName, newFName, 1);
                            break;
                        case 2:
                            System.out.print("Enter new last name: ");
                            String newLName = input.next();
                            c.edit_client(firstName, lastName, newLName, 2);
                            break;
                        case 3:
                            System.out.print("Enter new day: ");
                            String newDay = input.next();
                            System.out.print("Enter new month: ");
                            String newMonth = input.next();
                            System.out.print("Enter new year: ");
                            String newYear = input.next();
                            String[] newDate = new String[]{newDay, newMonth, newYear};
                            c.edit_client(firstName, lastName, newDate, 3);
                            break;
                        case 4:
                            System.out.print("Enter new pronoun character: ");
                            char newPronoun = (input.next()).charAt(0);
                            c.edit_client(firstName, lastName, newPronoun, 4);
                            break;
                        case 5:
                            System.out.print("Enter amount to be deposited: ");
                            double deposit = input.nextDouble();
                            c.edit_client(firstName, lastName, deposit, 5);
                            break;
                        case 6:
                            System.out.print("Enter amount to be deopisited: ");
                            double withdraw = input.nextDouble();
                            c.edit_client(firstName, lastName, withdraw, 6);
                            break;
                        case 7:
                            System.out.print("Enter new overdraft: ");
                            double overdraft = input.nextDouble();
                            c.edit_client(firstName, lastName, overdraft, 7);
                            break;
                        default:
                            System.out.print("Didn't do anything hmm...");
                    }
                    break;
                case 3:
                    System.out.print("First name: ");
                    firstName = input.next();
                    System.out.print("Last name: ");
                    lastName = input.next();
                    c.delete_client(firstName, lastName);
                    break;
                case 4:
                    c.commit_changes();
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
