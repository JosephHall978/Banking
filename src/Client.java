import org.jetbrains.annotations.NotNull;

public class Client extends Money{
    private String firstName;
    private String lastName;
    private String[] date;
    private char pronouns;
    public Client(String firstName,String lastName,String[] date,char pronouns,double balance,double overdraft){
        super(balance,overdraft);
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
        this.pronouns = pronouns;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", date='" + date + '\'' +
                ", pronouns=" + pronouns +
                "}\n" + super.toString();
    }

    //getters
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String[] getDate(){
        return this.date;
    }
    public char getPronouns(){
        return this.pronouns;
    }

    //setters
    public boolean setFirstName(@NotNull String firstName){
        if(firstName.length() > 2) {
            this.firstName = firstName;
            return true;
        }
        else{
            return false;
        }
    }
    public boolean setLastName(@NotNull String lastName) {
        if(lastName.length() > 2){
            this.lastName = lastName;
            return true;
        }
        else{
            return false;
        }
    }
    public boolean setDate(String @NotNull [] date) {
        for(String element : date){
            if(element.length() < 1){
                return false;
            }
            try{
                int temp = Integer.parseInt(element);
            }
            catch(Exception e){
                return false;
            }
        }
        this.date = date;
        return true;
    }
    public boolean setPronouns(char pronouns) {
        char[] accept = new char[]{'m','f','n'};
        for(char option : accept) {
            if (pronouns == option){
                this.pronouns = pronouns;
                return true;
            }
        }
        return false;
    }
}
