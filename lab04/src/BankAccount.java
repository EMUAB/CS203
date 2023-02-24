
public class BankAccount {

    private String first, last;
    public int accNo;
    private double balance, loanAmount, initialBalance = 0;

    public BankAccount() {

    }

    public BankAccount(double initialBalance) {
        this.initialBalance = initialBalance;
    }

    public void setName(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public String getName() {
        return this.first + " " + this.last;
    }

    public int getAccNo() {
        return this.accNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setWithdrawal(double toWithdraw) {
        if (toWithdraw > this.balance) {
            System.out.println("Withdrawal cannot exceed current balance");
            return;
        } else {
            this.balance -= toWithdraw;
            //System.out.println(toWithdraw + "$ have been withdrawn from account. New balance is: " + getBalance());
        }
    }

    public void setDeposit(double toDeposit) {
        balance += toDeposit;
    }

    public void setLoan() {
        loanAmount += 5000;
        balance += 5000;
    }

    public double getLoan() {
        return loanAmount + ((5000 * 0.05)*3);
    }

    public boolean isArmstrong() {
        String accString = Integer.toString(getAccNo());
        int armTotal=0;
        for (int i = 0; i<3; i++){
            armTotal += Math.pow(Integer.parseInt(String.valueOf(accString.charAt(i))), 3);
        }
        if (armTotal == getAccNo()) {
            return true;
        }
        else {
            return false;
        }
    }

}
