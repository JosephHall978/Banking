import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javafx.util.Pair;
public class CSV {
    private final String fileName;
    public ArrayList<Client> clientList = new ArrayList<>();
    public CSV(String fileName){
        this.fileName = fileName;
        get_client();
    }

    private void get_client(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = br.readLine()) != null){
                if(line.charAt(0) != '|'){
                    Client object = create_client(line);
                    clientList.add(object);
                }
            }
        }
        catch (Exception e){
            System.out.print(e.getMessage());
        }
    }
    public Pair<Client, Integer> search_client(String search_fName,String search_lName){
        int position = 0;
        for(Client client : clientList) {
            if (client.getFirstName().equals(search_fName) && client.getLastName().equals(search_lName)) {
                return new Pair<>(client,position);
            }
            else {
                position++;
            }
        }
        throw new IllegalArgumentException("Client match not found.");
    }

    public void delete_client(String fName, String lName){
        Pair<Client, Integer> pair = search_client(fName,lName);
        clientList.remove(pair.getKey());
    }

    public <T> boolean edit_client(String oFName,String oLName,T value, int option){
        Pair<Client, Integer> pair =  search_client(oFName,oLName);
        Client currentClient = pair.getKey();
        boolean valid;
        switch(option){
            case 1://first name
                valid = currentClient.setFirstName((String) value);
                if(valid) {
                    clientList.set(pair.getValue(), currentClient);
                }
                else{
                    return false;
                }
                break;
            case 2://last name
                valid = currentClient.setLastName((String) value);
                if(valid) {
                    clientList.set(pair.getValue(), currentClient);
                }
                else{
                    return false;
                }
                break;
            case 3://date
                valid = currentClient.setDate((String[]) value);
                if(valid) {
                    clientList.set(pair.getValue(), currentClient);
                }
                else{
                    return false;
                }
                break;
            case 4://pronoun
                valid = currentClient.setPronouns((char) value);
                if(valid) {
                    clientList.set(pair.getValue(), currentClient);
                }
                else{
                    return false;
                }
                break;
            case 5://deposit money
                valid = currentClient.addBalance((double) value);
                if(valid) {
                    clientList.set(pair.getValue(), currentClient);
                }
                else{
                    return false;
                }
                break;
            case 6://withdraw money
                valid = currentClient.subBalance((double) value);
                if(valid) {
                    clientList.set(pair.getValue(), currentClient);
                }
                else{
                    return false;
                }
                break;
            case 7://change overdraft
                valid = currentClient.setOverdraft((double) value);
                if(valid) {
                    clientList.set(pair.getValue(), currentClient);
                }
                else{
                    return false;
                }
                break;
            default:
                return false;
        }
        return false;
    }
    public void commit_changes(){
        ArrayList<String> lines = new ArrayList<>();
        for(Client client : clientList){
            String[] line = new String[6];
            line[0] = client.getFirstName();
            line[1] = client.getLastName();
            String dateString = String.join("/",client.getDate());
            line[2] = dateString;
            line[3] = Character.toString(client.getPronouns());
            line[4] = Double.toString(client.getBalance());
            line[5] = Double.toString(client.getOverdraft());
            lines.add(String.join(",",line));
        }
        try{
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName,false));
        String header = "|first_name,last_name,date,pronoun,balance,overdraft|\n";
        bw.write(header);
        for(String line : lines){
                bw.write(line+"\n");
            }
            bw.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    private Client create_client(String line){
        String[] items = line.split(",");
        if(items[0].equals("|first_name")){
            throw new RuntimeException("Header");
        }
        else{
            char pronoun = StringConvert.string_to_char(items[3]);
            double balance = StringConvert.string_to_double(items[4]);
            double overdraft = StringConvert.string_to_double(items[5]);
            String[] date = items[2].split("/");
            return new Client(items[0],items[1],date,pronoun,balance,overdraft);
        }
    }
}
