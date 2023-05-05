package com.crio.codingame.commands;

import java.util.List;

import com.crio.codingame.entities.Contest;
import com.crio.codingame.entities.Level;
import com.crio.codingame.exceptions.QuestionNotFoundException;
import com.crio.codingame.exceptions.UserNotFoundException;
import com.crio.codingame.services.IContestService;

public class CreateContestCommand implements ICommand{

    private final IContestService contestService;

    public CreateContestCommand(IContestService contestService) {
        this.contestService = contestService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute create method of IContestService and print the result.
    // Also Handle Exceptions and print the error messsages if any.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["CREATE_CONTEST","CRIODO2_CONTEST","LOW Monica","40"]
    // or
    // ["CREATE_CONTEST","CRIODO1_CONTEST","HIGH","Ross"]
    // Hint - Use Parameterized Exceptions in the Service class to match with the Unit Tests Output.

    @Override
    public void execute(List<String> tokens) {

        try {
            String title = tokens.get(1);
            String level = tokens.get(2);
            String creator = tokens.get(3);
            Integer numQuestion = null;
            if(tokens.size() > 4){
                numQuestion = Integer.parseInt(tokens.get(4));
            }
            Contest contest = contestService.create(title, Level.valueOf(level), creator, numQuestion);
            System.out.println(contest);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}
