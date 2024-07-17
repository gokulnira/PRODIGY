import java.util.Scanner;
import java.util.Random;
public class GuessingGame 
{
public static void main(String[] args) 
{
Scanner scanner = new Scanner(System.in);
Random random = new Random();
int randomNumber = random.nextInt(100) + 1; 
int numberOfAttempts = 0;
int userGuess = 0;
System.out.println("Welcome to the Guessing Game!");
System.out.println("I have generated a random number between 1 and 100. Can you guess what it is?");
while (userGuess != randomNumber) 
{
System.out.print("Enter your guess: ");
userGuess = scanner.nextInt();
numberOfAttempts++;
if (userGuess < randomNumber)
{
System.out.println("Your guess is too low. Try again.");
}
 else if (userGuess > randomNumber) 
{
 System.out.println("Your guess is too high. Try again.");
} else
{
System.out.println("Congratulations! You guessed the correct number.");
 System.out.println("It took you " + numberOfAttempts + " attempts to guess the number.");
}
}