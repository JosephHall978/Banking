public class StringConvert{
    public StringConvert(){}

    public static int string_to_int(String str){
        try{
            int number = Integer.parseInt(str);
            return number;
        }
        catch (NumberFormatException ex){
            return 0;
        }
    }

    public static double string_to_double(String str){
        try{
            double number = Double.parseDouble(str);
            return number;
        }
        catch (NumberFormatException ex){
            return 0;
        }
    }

    public static char string_to_char(String str){
        char c = str.charAt(0);
        return c;
    }
}
