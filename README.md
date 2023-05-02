# Voting System Software
# Authors: <br />
Bryan Lee <br />
Cedric Tan <br />
Sherryl Ooi <br />

<h1>Instructions  </h1>
Instructions to run the program:

```
# Run in terminal
cd Voting-System-Software

# Compile Java source code
javac fileSystem.java
javac countBallot.java
javac rankings.java
javac finalRanking.java
javac displayResult.java
javac votingSystem.java

# Run the program
java votingSystem
```

User can select any .csv files that include all the ballots informations. Or there are some test files included in the `/testing` folder for user to try the program. The system will run the program and count the rankings for the election. The user can choose to download the audit file and/or just view the results at the final GUI.
  
<h1> Introduction </h1>
There are numerous types of voting algorithms and in the United States, we typically use plurality voting where each voter is allowed to vote for only one candidate, and the candidate who polls the most votes is elected. It is rare for an election to be tied but if that occurs, there is typically a runoff between the tied candidates. For example, there have been three cases in history where there was a tie in the Electoral College for a presidential election. The House of Representatives then decided who was president by voting. For small sized, local elections a run-off may occur or even a coin flip can decide the outcome in some cases. Much research has been performed on voting theory and some believe that the other types of voting are better than our style of voting.


  
  
