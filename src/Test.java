import org.junit.jupiter.api.Assertions;//For junit 5
//import org.junit.Assert.assertEquals;// for JUnit 4
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class Testing{
    @Test
    public void test(){
        Client c = new Client("Joseph","Hall", new String[]{"23", "01", "2004"},'m',230000.01,500);
        String clientString="Client{firstName='Joseph', lastName='Hall', date='23/01/2004', pronouns=m}Money{balance=230000.01, overdraft=500.0}";
        Assertions.assertNotNull(c);
    }
}