import org.junit.jupiter.api.Assertions;//For junit 5
//import org.junit.Assert.assertEquals;// for JUnit 4
import org.junit.jupiter.api.Test;


class Testing{
    Client c = new Client("Joseph","Hall", new String[]{"23", "01", "2004"},'m',230000.01,500);//good client object to test with

    @Test
    public void test_getters(){
        Assertions.assertEquals("Joseph",c.getFirstName());
        Assertions.assertEquals("Hall",c.getLastName());
        Assertions.assertArrayEquals(new String[]{"23", "01", "2004"},c.getDate());//may need to use a different way to test
        Assertions.assertEquals('m',c.getPronouns());
        Assertions.assertEquals(230000.01,c.getBalance());
        Assertions.assertEquals(500,c.getOverdraft());
    }
    @Test
    public void test_setters_good(){
        Assertions.assertTrue(c.setFirstName("Joe"));
        Assertions.assertTrue(c.setLastName("Hell"));
        Assertions.assertTrue(c.setDate(new String[]{"23","01","2003"}));
        Assertions.assertTrue(c.setPronouns('n'));
        Assertions.assertTrue(c.setBalance(130000.10));
        Assertions.assertTrue(c.setOverdraft(500));
    }
    @Test
    public void test_setters_bad(){
        Assertions.assertFalse(c.setFirstName("J"));
        Assertions.assertFalse(c.setLastName("H"));
        Assertions.assertFalse(c.setDate(new String[]{"","01","2003"}));
        Assertions.assertFalse(c.setDate(new String[]{"23","","2003"}));
        Assertions.assertFalse(c.setDate(new String[]{"23","01",""}));
        Assertions.assertFalse(c.setPronouns('j'));
        Assertions.assertFalse(c.setOverdraft(-90));
    }
}