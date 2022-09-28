

public class Bank {
    long AccNo;
    String AccName;

    enum AccountType {
        SAVING, CURRENT
    }

    int ROI;
    long Amount;

    void setAccName(String AccName) {
        this.AccName = AccName;
    }

    void getROI() {
        System.out.println(this.ROI);
    }

    void getAccName() {
        System.out.println(this.AccName);
    }


    String withdraw(int wd) {
        try {
            if (this.Amount >= wd) {
                this.Amount = this.Amount - wd;
                return ("success check_log.txt \n");
            } else {
                throw new InsufficientAmountException("Exception");
            }
        } catch (InsufficientAmountException e) {
            return ("InsufficientAmountException Can't Deduct.");
        }
    }

    Bank(long accNo, String accName, long amount) {
        this.AccNo = accNo;
        this.AccName = accName;
        this.Amount = amount;
    }


    String getDetails(int c) {
        String AccType = "";
        if (c == 1)
            AccType = String.valueOf(AccountType.SAVING);
        else if(c == 2){
            AccType = String.valueOf(AccountType.CURRENT);
        }
        else
        {
            System.out.println("please choose correct option");
        }
        return ("AccountName:" + this.AccName + "\n" + "AccountNo :" + this.AccNo + "\n" + "Amount:" + this.Amount + "\n" + "AccountType:" + AccType + "\n" + "Rate of Interest :" + ROI + "\n");
    }
}
class InsufficientAmountException extends Exception {
    public InsufficientAmountException(String message) {
        super(message);
    }
}


class BOI extends Bank {
    BOI(long accNo, String accName, long amount) {
        super(accNo, accName, amount);
        this.ROI = 12;
        System.out.println("BOI");
    }

}

class ICICI extends Bank {

    ICICI(long accNo, String accName, long amount) {
        super(accNo, accName, amount);
        this.ROI = 10;
        System.out.println("ICICI");
    }

}

class SBI extends Bank {
    SBI(long accNo, String accName, long amount) {
        super(accNo, accName, amount);
        this.ROI = 15;
        System.out.println("SBI");
    }

}
