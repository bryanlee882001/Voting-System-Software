import java.io.*;
import javax.swing.*;
import javax.swing.JFileChooser;

/**
 * The fileSystem program implements functions that are 
 * related to perform file handling within the voting system software. 
 *
 * @author Bryan Yen Sheng Lee
 * @author Cedric Tan Yee Shuen
 * @author Sherryl Ooi Shi Tyng
 * @version 1.0
 * @ since 2023-03-19
 */
public class fileSystem {

    // Instance variables that are used in fileSystem class
    static String electionType;
    static int numOfCandidates;
    static String allCandidates;
    static String [] candidates;
    static int numOfSeats;
    static int numOfVotes;
    static int [][] ballot;
    static String[] candidatesList;


    /**
     * A constructor of the fileSystem class that takes in no parameter
     * and will open the selected files. It displays a message indicating 
     * if the file can be opened.
     */
    public fileSystem() {
        
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        // Checks selected file to see if approve (yes, ok) is chosen
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());

            // Opens selected file 
            openFile(selectedFile);
        }

        else {
            JOptionPane.showMessageDialog(null,"There is an error opening the file.","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * A function of the fileSystem class that reads in a file type 
     * and opens the file if the file format is correct. It displays 
     * a message indicating if the file can be opened.
     * @param fileName - a file type indicating the file name   
     */
    public static void openFile(File fileName) {

        // checks if file format is correct
        if(checkFileFormat(fileName)) {
            JOptionPane.showMessageDialog(null,"The file is open.","INFO MESSAGE",JOptionPane.INFORMATION_MESSAGE);
            readFile(fileName);
        }

        // Displays error message if an error is detected
        else {
            JOptionPane.showMessageDialog(null,"There is an error opening the file.","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * A function of the fileSystem class that reads in a file type 
     * and checks if the file format is correct.
     * @param fileName - a file type indicating the file name
     * @return boolean indicating if file format is correct
     */
    public static boolean checkFileFormat (File fileName) {

        // checks if file type is .csv
        if(getFileExtension(fileName).equals("csv")) {
            return true;
        }
        
        if (fileName == null) {
            return false;
        }

        return false;
    }

    /**
     * A function of the fileSystem class that takes in a file type 
     * and reads the CSV file starting from the first line to indicate election type. 
     */
    public static void readFile (File fileName) {
        
        // Read lines inside CSV file 
        try {
            
            // Variables to store information that is read from CSV file
            BufferedReader file = new BufferedReader(new FileReader(fileName));
            electionType = file.readLine();
            numOfCandidates = Integer.parseInt(file.readLine());
            allCandidates = file.readLine();
            candidates = new String[numOfCandidates];
	        candidates = allCandidates.split(", ");

            // Read in values based on election type
            if(electionType.equals("CPL")) {
                candidatesList = new String [numOfCandidates];
                for(int i = 0; i < numOfCandidates; i++) {
                    candidatesList[i] = file.readLine();
                }
                numOfSeats = Integer.parseInt(file.readLine());
                numOfVotes = Integer.parseInt(file.readLine());
            }

            else if (electionType.equals("IR")) {
                numOfVotes = Integer.parseInt(file.readLine());
            }

            // Invalid election type
            else {
                JOptionPane.showMessageDialog(null,"The election type is not recognized.","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
            }

            ballot = new int [numOfVotes][numOfCandidates];
            
            String CurrentLine;
            int x = 0;

            // While loop to read in number of candidates from CSV file 
            while ((CurrentLine = file.readLine()) != null)
            {
                // Splits the line into array of strings based on commas 
                String [] fileLine = CurrentLine.split(",", -1);

                // Adds the candidates' ranking into ballot array 
                for(int i = 0; i < numOfCandidates; i++) {
                    if(fileLine[i] != "") {
                        ballot[x][i] = Integer.parseInt(fileLine[i]);
                    }
                    else {
                        ballot[x][i] = 0;
                    }
                }
                x++;
            }

            // Close file 
            file.close();

        }

        // Displays error message if an error is detected 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"There is an error opening the file.","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }

    /**
     * A function that takes in a file type and gets the file extension
     * @param fullName - a file type indicating the name of the file
     * @return string indicating file type after "." in file name
     */
    public static String getFileExtension(File fullName) {

        String fileName = fullName.getName();
        int dotIndex = fileName.lastIndexOf('.');

        // Returns string indicating file type after "." in file name
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }
}