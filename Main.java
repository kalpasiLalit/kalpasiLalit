import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    static StringBuilder str1 = new StringBuilder();


    public static void cases(Bank User, int c) {
        LocalDateTime time = LocalDateTime.now();
        Scanner sc = new Scanner(System.in);
        logMaker(User.getDetails(c));
        System.out.println(User.getDetails(c));
        System.out.println("Want to Withdraw press 'y', otherwise 'n'");
        int x = sc.next().charAt(0);
        if (x == 'y' || x == 'Y') {
            System.out.println("Enter Amount : ");
            logMaker("Deduction @" + "time :" + time);
            int amt = sc.nextInt();
            logMaker(Integer.toString(amt));
            logMaker("\n" + User.withdraw(amt));
            logMaker("\n Amount AVAILABLE :" + User.Amount);
            if(amt <= User.Amount){
                System.out.println("Withdraw amount successfully");
            }else{
                System.out.println("You have not sufficient balance.");
            }
        } else
            System.out.println("Your Withdraw process is canceled.");
        System.exit(0);
    }

    public static void Display() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Bank Account Type : \nPress 1 for Saving Account. \nPress 2 for Current Account.");
        int accTyp = sc.nextInt();
        System.out.println("Press 1 for SBI bank Details " + "\nPress 2 for BOI Bank Details" + "\nPress 3 for ICICI Bank Details");
        int bankDtl = sc.nextInt();

        switch (bankDtl) {
            case 1: {
                Bank bank = new SBI(4500, "Lalit", 5000000);
                cases(bank, accTyp);
            }
            break;
            case 2: {
                Bank bank = new BOI(5521, "Vineet Rathi", 7000);
                cases(bank, accTyp);
            }
            break;
            case 3: {
                Bank bank = new ICICI(5487, "naman", 10000);
                cases(bank, accTyp);
            }
            break;
            default:
                System.out.println("Please enter above 1-3 option only");
                break;
        }
    }

    public static void logMaker(String str) {
        str1.append(str);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt"));

            for (int i = 0; i < str1.length(); i++)
                bw.write(str1.charAt(i));
            bw.close();

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void main(String[] args) {
        Display();

    }
}
