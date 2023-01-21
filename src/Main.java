public class Main {
    public static void main(String args[]){
        CSV c = new CSV("src/MOCK_DATA.csv");
        UserInterface cli = new UserInterface("src/MOCK_DATA.csv");
        cli.commandLine();
    }
}