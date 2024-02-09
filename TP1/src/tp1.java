import java.util.Scanner;

public class tp1 {

    public static void main(String[] args) {
        int secnum = 10;

        while (true) {
            System.out.print("Enter an integer: "); 
            Scanner ss = new Scanner(System.in); 
            int num = ss.nextInt();

            if (num > secnum) {
                System.out.println("The number you entered is greater than the secret number.\n");
            } else if (num < secnum) {
                System.out.println("The number you entered is less than the secret number.\n");
            } else {
                System.out.println("Congratulations!\nBravo"); 
                break;
            }
        }
    }
}
