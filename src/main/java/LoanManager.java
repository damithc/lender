public class LoanManager {
    private Loan[] loans = new Loan[100];
    private int loansCount = 0;

    public void addLoan(String borrower, int amount, double interestRate){
        Loan l = new Loan(borrower, amount, interestRate);
        loans[loansCount] = l;
        loansCount++;
        System.out.println(Loan.getMaxLoan());
    }

    public void setAsPaid(String borrower){
        for (int i=0; i< loansCount; i++){
            if (loans[i].getBorrower().equals(borrower)){
                loans[i].setAsPaid();
            }
        }
    }

    public void listLoans(){
        for (int i=0; i< loansCount; i++){
            if (!loans[i].isPaid()){
                System.out.println(loans[i].getDisplayString());
            }
        }
    }

    public double calculateProfitEarned(){
        double profit = 0;
        for (int i=0; i< loansCount; i++){
            // if the loan was repaid, add the interest to profit
            if (loans[i].isPaid()){
                profit = profit + loans[i].getProfit();
            }
        }
        return profit;
    }
}
