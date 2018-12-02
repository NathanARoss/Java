/**
 * Define a class that grades a driver exam and provides methods that return if
 * the student passed, #of correct answers, #of wrong answers, and an array of
 * the question numbers that the student answered wrong
 * 
 * Input: student's answers
 * Processing: count of correct answers, list of incorrect answers
 * Output: if the student passed, student's score, list of wrong answers
 * 
 * Written by Nathan Ross
 * Last edited 4/23/2017
 */

package ch7_assignment;

import java.util.Scanner;
import java.lang.Character;

public class DriverExam
{
    //20 chars long, the list of correct answers
    final static char[] CORRECT_ANSWERS = "BDAACABACDBCDADCCBDA".toCharArray();
    
    //minimum score needed to pass
    final static int PASSING_SCORE = 15;
    
    final int totalCorrect;
    final int[] wrongAnswerList;

    /**
     * Entry point
     * @param args command line arguments (unused)
     */
    public static void main(String[] args)
    {
        final char[] studentAnswers = inputStudentAnswers();
        
        DriverExam newExam = new DriverExam(studentAnswers);
        
        if (newExam.passed())
            System.out.println("Congradulations!  You passed.");
        else
            System.out.println("You failed.  Better luck next time.");
        
        System.out.printf("Score: %d/%d%n", newExam.totalCorrect(), studentAnswers.length);
        
        //print a list of question numbers the student answered wrong
        System.out.printf("You missed %d questions:", newExam.totalIncorrect());
        for (int questionIndex : newExam.questionsMissed()) //questionsMissed() is called only once
            System.out.printf(" %d", questionIndex + 1);
        
        System.out.println("");
    }
    
    /**
     * Input all 20 questions from the user.  Validate that only A, B, C, or D
     * is entered.  a, b, c, or d are also accepted.
     * @return array of 20 chars containing student's answers
     */
    private static char[] inputStudentAnswers()
    {
        Scanner keyboard = new Scanner(System.in);
        final char[] studentAnswers = new char[CORRECT_ANSWERS.length];
        
        //run input validation loop inside input loop
        for (int i = 0; i < studentAnswers.length; ++i)
        {
            char answer = 0;
            boolean valid = false;
            
            System.out.printf("Enter answer for question %d: ", i + 1);
            
            do
            {
                String input = keyboard.nextLine();
                
                if (!input.isEmpty())
                {
                    answer = Character.toUpperCase(input.charAt(0));
                    valid = (answer >= 'A' && answer <= 'D');
                }
                
                if (!valid)
                    System.out.print("Enter A, B, C, or D: ");
                
            } while (!valid);
            
            //add the new answer to the answers array now that we've verified it
            studentAnswers[i] = answer;
        }
        
        return studentAnswers;
    }
    
    /**
     * No argument constructor acts as if the student did not take the exam
     * score of 0, all answers are wrong
     */
    public DriverExam()
    {
        totalCorrect = 0;
        wrongAnswerList = new int[CORRECT_ANSWERS.length];
        
        for (int i = 0; i < wrongAnswerList.length; ++i)
            wrongAnswerList[i] = i;
    }
    
    /**
     * char array constructor grades the test, stores the score in totalCorrect,
     * and stores the list of failed answer question indexes in wrongAnswerList
     * @param studentAnswers 
     */
    public DriverExam(char[] studentAnswers)
    {        
        int totalCorrect = 0;
        for (int i = 0; i < studentAnswers.length; ++i)
        {
            if (studentAnswers[i] == CORRECT_ANSWERS[i])
                ++totalCorrect;
        }
        
        //the local "int totalCorrect" allows this.totalCorrect to be final
        this.totalCorrect = totalCorrect;
        
        //I loop through the studentAnswers array twice to allocate exactly
        //as much memory as I need for the wrongAnswerList
        wrongAnswerList = new int[20 - totalCorrect];
        int wrongAnswerCount = 0;
        for (int i = 0; i < studentAnswers.length; ++i)
        {
            if (studentAnswers[i] != CORRECT_ANSWERS[i])
            {
                wrongAnswerList[wrongAnswerCount] = i;
                ++wrongAnswerCount;
            }
        }
    }
    
    //return if score is high enough to pass
    public boolean passed()
    {
        return (totalCorrect >= PASSING_SCORE);
    }
    
    //return count of correct answers
    public int totalCorrect()
    {
        return totalCorrect;
    }
    
    //return count of incorrect answers
    public int totalIncorrect()
    {
        return wrongAnswerList.length;
    }
    
    //returns a copy of the an array containing the question numbers missed
    public int[] questionsMissed()
    {
        //return a copy of the array instead of the array itself to protect
        //the private data.  In C++, I'd return a constant array reference
        int[] copyOfWrongAnswerList = new int[wrongAnswerList.length];
        for (int i = 0; i < wrongAnswerList.length; ++i)
            copyOfWrongAnswerList[i] = wrongAnswerList[i];
        
        return copyOfWrongAnswerList;
    }
}
