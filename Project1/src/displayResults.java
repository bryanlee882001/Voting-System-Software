import java.io.*;
import javax.swing.*;

/**
 * The displayResults program implements functions that are 
 * related to displaying the final results of the election
 * based on the election type as well as generate an audit 
 * file for a completed election. 
 *
 * @author Bryan Yen Sheng Lee
 * @author Cedric Tan Yee Shuen
 * @author Sherryl Ooi Shi Tyng
 * @version 1.0
 * @ since 2023-03-19
 */
public class displayResults {

    /**
     * A constructor of the displayResults class that takes in no parameter
     * and will display the results based on the final rankings.
     */
    public displayResults () {
        finalRanking rank = new finalRanking();
        showResults();
    }

    /**
     * A function of the showResults class that generates the audit file for 
     * completed elections based on election type.
     */
    public void generateAuditFile () {
        try {
            JFrame parentFrame = new JFrame();
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save audit file");
    
            int userSelection = fileChooser.showSaveDialog(parentFrame);
     
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File outputFile = fileChooser.getSelectedFile();
                System.out.println("Save as file: " + outputFile.getAbsolutePath());

                // File outputFile = new File("auditFile.csv");
                outputFile.createNewFile();
                PrintWriter output = new PrintWriter(outputFile);
                StringBuffer csvData = new StringBuffer("");
                
                csvData.append("Election type: " + fileSystem.electionType + "\n");
                if(fileSystem.electionType.equals("CPL")) {
                    csvData.append("Number of Parties: " + fileSystem.numOfCandidates + "\n");
                    csvData.append("Parties joined election: " + fileSystem.allCandidates + "\n");
                    for(int i = 0; i < fileSystem.numOfCandidates; i++) {
                        csvData.append("Candidates of party " + fileSystem.candidates[i] + ": " + fileSystem.candidatesList[i] + "\n");
                    }
                    csvData.append("Total seats elected: " + fileSystem.numOfSeats + "\n");
                    csvData.append("Total number of voters: " + fileSystem.numOfVotes + "\n");
        
                    for(int i = 0; i < fileSystem.numOfCandidates; i++) {
                        if(rankings.ranking[i] != -1) {
                            csvData.append(i+1 + "'s rank is party " + fileSystem.candidates[rankings.ranking[i]] + "\n");
                        }
                    }
                    csvData.append("The final winners of the election are parties: \n");
                    for(int i = 0; i < fileSystem.numOfSeats; i++) {
                        if(rankings.ranking[i] != -1) {
                            csvData.append(i+1 + "'s rank is party " + fileSystem.candidates[rankings.ranking[i]] + "\n");
                        }
                    }
                }
                
                else if(fileSystem.electionType.equals("IR")){
                    csvData.append("Number of Candidates: " + fileSystem.numOfCandidates + "\n");
                    csvData.append("Candidates joined election: " + fileSystem.allCandidates + "\n");
                    csvData.append("Total number of voters: " + fileSystem.numOfVotes + "\n");
        
                    for(int i = 0; i < fileSystem.numOfCandidates; i++) {
                        if(rankings.ranking[i] != -1) {
                            csvData.append(i+1 + "'s rank is candidate " + fileSystem.candidates[rankings.ranking[i]] + "\n");
                        }
                    }
                    csvData.append("The final winner of the election is candidate "  + fileSystem.candidates[rankings.ranking[0]] + "\n");
                }
        
                output.write(csvData.toString());
                output.close();
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * A function of the showResults class that shows the final result of the 
     * election based on the election type. 
     */
    public void showResults () {

        int yesOrNo = JOptionPane.showConfirmDialog(null,"Do you want to generate Audit File?","Generate Audit File",JOptionPane.YES_NO_OPTION);
        if(yesOrNo == JOptionPane.YES_OPTION) {
            generateAuditFile();
        }

        JFrame frame = new JFrame ("Final Results");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        JTextArea textArea  = new JTextArea();

        textArea.append("Election type: " + fileSystem.electionType + "\n");

        // Checks if election type is CPL
        if(fileSystem.electionType.equals("CPL")) {
            textArea.append("Number of Parties: " + fileSystem.numOfCandidates + "\n");
            textArea.append("Parties joined election: " + fileSystem.allCandidates + "\n");
            for(int i = 0; i < fileSystem.numOfCandidates; i++) {
                textArea.append("Candidates of party " + fileSystem.candidates[i] + ": " + fileSystem.candidatesList[i] + "\n");
            }
            textArea.append("Total seats elected: " + fileSystem.numOfSeats + "\n");
            textArea.append("Total number of voters: " + fileSystem.numOfVotes + "\n");

            for(int i = 0; i < fileSystem.numOfCandidates; i++) {
                if(rankings.ranking[i] != -1) {
                    textArea.append(i+1 + "'s rank is party " + fileSystem.candidates[rankings.ranking[i]] + "\n");
                }
            }
            textArea.append("The final winners of the election are parties: \n");
            for(int i = 0; i < fileSystem.numOfSeats; i++) {
                if(rankings.ranking[i] != -1) {
                    textArea.append(i+1 + "'s rank is party " + fileSystem.candidates[rankings.ranking[i]] + "\n");
                }
            }
        }

        // Checks if election type is IR
        else if(fileSystem.electionType.equals("IR")){
            textArea.append("Number of Candidates: " + fileSystem.numOfCandidates + "\n");
            textArea.append("Candidates joined election: " + fileSystem.allCandidates + "\n");
            textArea.append("Total number of voters: " + fileSystem.numOfVotes + "\n");

            for(int i = 0; i < fileSystem.numOfCandidates; i++) {
                if(rankings.ranking[i] != -1) {
                    textArea.append(i+1 + "'s rank is candidate " + fileSystem.candidates[rankings.ranking[i]] + "\n");
                }
            }
            textArea.append("The final winner of the election is candidate "  + fileSystem.candidates[rankings.ranking[0]] + "\n");
        }

        frame.add(textArea);
        textArea.setEditable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
