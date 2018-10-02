import java.util.Scanner;

public class TowersOfHanoi {

   public static void main(String[] args) {
    Scanner SC = new Scanner(System.in);
    System.out.println("Please input number of discs:");
    int n = SC.nextInt();
    System.out.println("Number of moves to complete is: " + ((Math.pow(2,n))-1));
  }
}
 