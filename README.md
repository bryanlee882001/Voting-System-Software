# Voting System Software
# Authors: <br />
<h3>Bryan Lee <h3 />
<h3>Cedric Tan <h3 />
<h3>Sherryl Ooi <h3 />

Voting System Software is capable of performing two types of elections — Instant Runoff Voting (Plurality/Majority type) and Party List Voting using Closed Party List (CPL). This software allows users to input multiple .csv files containing election information and ballots. The voting system processes the inputted files, counts the ballots, breaks tie, determines the winner, and displays the final results. Furthermore, users have the option to generate an election audit file at the end of the program. 



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
  
<h1> Detailed Descriptions </h1>
There are numerous types of voting algorithms and in the United States, we typically use plurality voting where each voter is allowed to vote for only one candidate, and the candidate who polls the most votes is elected. It is rare for an election to be tied but if that occurs, there is typically a runoff between the tied candidates. For example, there have been three cases in history where there was a tie in the Electoral College for a presidential election. The House of Representatives then decided who was president by voting. For small sized, local elections a run-off may occur or even a coin flip can decide the outcome in some cases. Much research has been performed on voting theory and some believe that the other types of voting are better than our style of voting. <br />

We created a voting system that is capable of performing two types of elections: 

# 1. Instant Runoff Voting (IRV) 
Instant Runoff Voting is also known as "majority preferential voting." It is used in elections that allows voters to rank candidates in order of preference. In an IRV election, voters are asked to rank the candidates from their favorite to least favorite. If a candidate receives a majority of first-choice votes, they are declared the winner. However, if no candidate receives a majority of first-choice votes, the candidate with the least number of first-choice votes is eliminated, and their votes are redistributed to the remaining candidates according to the second-choice preferences of those voters. This process continues until a candidate receives a majority of votes, and they are declared the winner. IRV is designed to ensure that the winning candidate has broad support from a majority of voters and can help to avoid vote-splitting and tactical voting. 

# 2. Party List Voting using Closed Party List (CPL)
A closed party list election is a type of electoral system in which voters cast their ballots for a political party rather than for individual candidates. Each party presents a list of candidates, and the number of seats that each party is awarded in the legislature is determined by the proportion of votes that the party receives. In a closed party list system, the order of the candidates on each party's list is predetermined by the party leadership, and voters have no say in the selection of individual candidates. The seats that are won by each party are then filled by the candidates on their list in the order that they appear. This system can help to ensure that the legislature reflects the overall preferences of the electorate, but it can also make it difficult for individual candidates to be elected based on their own merits, and can give a lot of power to the party leadership in determining who gets elected.







  
  
