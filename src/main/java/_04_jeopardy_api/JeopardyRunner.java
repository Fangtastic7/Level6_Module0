package _04_jeopardy_api;

import _04_jeopardy_api.data_transfer_objects.Clue;

import javax.swing.*;

public class JeopardyRunner {

    public static void main(String[] args) {

        JeopardyApi jeopardyApi = new JeopardyApi();

        //create a score variable
        int score = 0;

        //add a for loop where i starts at 100,
        //continues while i <= 1000
        //increments by 100
        for(int i=100; i<=1000;i = i+100) {
        
            //if i == 700 or i == 900, continue;
            //there are no questions for these values
        	if(i==700 || i ==900) {
        		continue;
        	} else {
            //call the getClue() method with i
        		jeopardyApi.getClue(i);
            //save the question in a String variable
        		String question = jeopardyApi.getClue(i).getQuestion();
            //save the answer in a String variable
        		String answer = jeopardyApi.getClue(i).getAnswer();
            //save the title in a String variable
            //note that this is part of the Category object
        		String title = jeopardyApi.getClue(i).getCategory().getTitle(); //title for question
            //use a JOptionPane to display the question
        		String input = JOptionPane.showInputDialog(null, question, title,0 );
            //if they got the question correct, add the value of that question to their score
        		if(input.equalsIgnoreCase(answer)) {
        			score = score + i;
        		}
        	}
        }
        //tell the user their final score
        JOptionPane.showMessageDialog(null, "Your score: " + score);

    }

}
