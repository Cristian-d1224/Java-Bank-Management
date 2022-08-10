public class Savings extends Account {

    private static final double WITHDRAWAL_FEE = 5.00;

    public Savings(String id, String name, double balance){
        super(id, name, balance);
    }

    @Override
    public void deposit(double amount) {
        super.setBalance(super.round(super.getBalance() + amount));
    }

    @Override
    public boolean withdraw(double amount) {

        if (super.round(super.getBalance() - amount - WITHDRAWAL_FEE) < 0){
            System.out.println("Insufficient funds");
            return false;
        }


        super.setBalance(super.round(super.getBalance() - amount - WITHDRAWAL_FEE));
        return true;

    }

    public Savings(Savings source){
        super(source);
    }

    @Override
    public Account clone(){
        return new Savings(this);
    }

}
