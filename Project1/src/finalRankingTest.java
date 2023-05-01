import org.junit.Test;
import static org.junit.Assert.*;

public class finalRankingTest {
    
    finalRanking finalrank = new finalRanking();


    @Test
    // This test case checks if checkfortie() performs fair coin toss if election type is CPL
    public void test1_checkForTie(){
        
        fileSystem.electionType = "CPL";
        fileSystem.numOfSeats = 3;
        rankings.ranking = new int[]{1, 2, 2};
        assertFalse(finalrank.checkForTie());
        
    }


    @Test
    // This test case checks if checkfortie() performs pool coin toss if election type is IR
    public void test2_checkForTie(){
        
        fileSystem.electionType = "IR";
        fileSystem.numOfSeats = 4;
        rankings.ranking = new int[]{1, 3, 3, 3};
        assertTrue(finalrank.checkForTie());
        
    }


    @Test
    // This test case checks if checkfortie() is invalid 
    public void test3_checkForTie(){
        
        fileSystem.electionType = "Invalid";
        fileSystem.numOfSeats = 3;
        rankings.ranking = new int[]{1, 2, 3};
        assertFalse(finalrank.checkForTie());
        
    }


    @Test
    // This test case checks if checkfortie() is not needed 
    public void test4_checkForTie(){
        
        fileSystem.electionType = "IR";
        fileSystem.numOfSeats = 3;
        rankings.ranking = new int[]{1, 2, 3};
        assertFalse(finalrank.checkForTie());
        
    }


    @Test
    // This test case checks if fairCoinToss() performs a test for CPL 
    public void test5_fairCoinToss() {
        
        fileSystem.electionType = "CPL";
        int result = finalrank.fairCoinToss();
        // check if winner is either 0 or 1
        assertTrue(result == 0 || result == 1);

    }


    @Test
    // This test case checks if fairCoinToss() performs a test for IR 
    public void test6_fairCoinToss() {
        
        fileSystem.electionType = "IR";
        int result = finalrank.fairCoinToss();
        // check if winner is either 0 or 1
        assertTrue(result == 0 || result == 1);

    }



    @Test
    // This test case checks if poolCoinToss() performs a test for CPL 
    public void test7_poolCoinToss() {
        
        fileSystem.electionType = "CPL";
        fileSystem.numOfSeats = 3;
        int result = finalrank.poolCoinToss(3);
        // check if winner is either 0,1,2
        assertTrue(result >= 0 && result <= 2);

    }


    @Test
    // This test case checks if poolCoinToss() performs a test for IR
    public void test8_poolCoinToss() {

        fileSystem.electionType = "IR";
        int result = finalrank.poolCoinToss(5);
        // check if winner is either 0,1,2,3,4
        assertTrue(result >= 0 && result <= 4);

    }


    @Test
    // This test case checks if poolCoinToss() performs a test if not IR or CPL
    public void test9_poolCoinToss() {

        fileSystem.electionType = "Another Election Type";
        int final_result = finalrank.poolCoinToss(5);
        // check if there is no winner 
        assertEquals(0, final_result);

    }

}
