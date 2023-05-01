import javax.swing.*;
import java.lang.Math;

/**
 * The finalRanking program implements functions that are 
 * related to determine the final ranking of the candidates/parties 
 * of the election as well as check for tie and flip a coin toss if 
 * necessary to determine the winner through an unbiased method. 
 *
 * @author Bryan Yen Sheng Lee
 * @author Cedric Tan Yee Shuen
 * @author Sherryl Ooi Shi Tyng
 * @version 1.0
 * @ since 2023-03-19
 */
public class finalRanking {

    /**
     * A constructor of the finalRanking class that takes in no parameter
     * and will checks if there is a tie.
     */
    public finalRanking () {
        checkForTie();
    }

    /**
     * A function that checks for tie and prompts users if they want to perform 
     * a coin toss. Performs a coin toss based on election type if there is a tie.
     * @return boolean indicating if there is a tie 
     */
    public boolean checkForTie () {
        rankings rank = new rankings();
        int yesOrNo;

        // Checks if election type is CPL
        if(fileSystem.electionType.equals("CPL")) {
            int totalSeats = fileSystem.numOfSeats;

            // Loops to check if there is a tie between parties 
            for (int i = 0; i < totalSeats; i++) {
                if(rankings.ranking[i] == rankings.ranking[i + 1] && (i+1) < totalSeats) {
                    if(rankings.ranking[i+1] == rankings.ranking[i+2] && i+2 < totalSeats) {
                        yesOrNo = JOptionPane.showConfirmDialog(null,"Do you want to run a pool coin toss","Pool Coin Toss",JOptionPane.YES_NO_OPTION);
                        if(yesOrNo == JOptionPane.YES_OPTION) {
                            poolCoinToss(i + 2);
                        }
                    }

                    else {
                        yesOrNo = JOptionPane.showConfirmDialog(null,"Do you want to run a fair coin toss","Fair Coin Toss",JOptionPane.YES_NO_OPTION);
                        if(yesOrNo == JOptionPane.YES_OPTION) {
                            fairCoinToss();
                        }
                    }
                }
            }
        }

        // Check if election type is IR
        else if(fileSystem.electionType.equals("IR")) {
            int totalSeats = fileSystem.numOfCandidates;

            // Loops to check if there is a tie between candidates
            for (int i = 0; i < totalSeats - 2; i++) {
                if(rankings.ranking[i] == rankings.ranking[i + 1] && (i+1) < totalSeats) {
                    if(rankings.ranking[i+1] == rankings.ranking[i+2] && i+2 < totalSeats) {
                        yesOrNo = JOptionPane.showConfirmDialog(null,"Do you want to run a pool coin toss","Pool Coin Toss",JOptionPane.YES_NO_OPTION);
                        if(yesOrNo == JOptionPane.YES_OPTION) {
                            poolCoinToss(i + 2);
                        }
                    }
                    
                    else {
                        yesOrNo = JOptionPane.showConfirmDialog(null,"Do you want to run a fair coin toss","Fair Coin Toss",JOptionPane.YES_NO_OPTION);
                        if(yesOrNo == JOptionPane.YES_OPTION) {
                            fairCoinToss();
                        }
                    }
                }
            }
        }

        // Invalid election type
        else {
            JOptionPane.showMessageDialog(null,"The election type is not recognized.","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
        }

        return false;
    }

    /**
     * A function that performs fair coin toss if there is a tie
     * between two parties or candidates. 
     * @return results 
     */
    public int fairCoinToss () {
        // Checks if election type is CPL
        if(fileSystem.electionType.equals("CPL")) {
            return (int)(Math.random() * 2) + 0;
        }

        // Checks if election type is IR
        else if(fileSystem.electionType.equals("IR")) {
            return (int)(Math.random() * 2) + 0;
        }

        // Displays error message if an error is detected 
        else {
            JOptionPane.showMessageDialog(null,"The election type is not recognized.","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    /**
     * A function that performs pool coin toss if there is a tie
     * between parties or candidates based on the range. 
     * @param range indicating the number of parties/ candidates with the same number of votes
     * @return integer indicating results 
     */
    public int poolCoinToss (int range) {
        // Checks if election type is CPL
        if(fileSystem.electionType.equals("CPL")) {
            return (int)(Math.random() * range) + 0;
        }

        // Checks if election type is IR
        else if(fileSystem.electionType.equals("IR")) {
            return (int)(Math.random() * range) + 0;
        }

        // Displays error message if an error is detected 
        else {
            JOptionPane.showMessageDialog(null,"The election type is not recognized.","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }
}
