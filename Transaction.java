import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Transaction implements Comparable<Transaction>{

    @Override
    public int compareTo(Transaction o) {
        return Double.compare(this.timestamp, o.timestamp);
    }

    public enum Type {WITHDRAW, DEPOSIT};
    private Type type;
    private long timestamp;
    private String id;
    private double amount;


    public Transaction(Type type, long timestamp, String id, double amount) {

        if (id == null || id.isBlank() || amount < 0){
            throw new IllegalArgumentException("INVALID PARAMS");
        }

        this.type = type;
        this.timestamp = timestamp;
        this.id = id;
        this.amount = amount;
    }

    public Transaction(Transaction source) {
        this.type = source.type;
        this.timestamp = source.timestamp;
        this.id = source.id;
        this.amount = source.amount;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {

        if (id ==  null || id.isBlank()){
            throw new IllegalArgumentException("INVALID ID");
        }

        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {

        if (amount < 0){
            throw new IllegalArgumentException("INVALID AMOUNT");
        }

        this.amount = amount;
    }

    public String returnDate(){
        Date date = new Date(this.timestamp * 1000);
        return new SimpleDateFormat("dd-MM-yyyy").format(date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return timestamp == that.timestamp && Double.compare(that.amount, amount) == 0 && type == that.type && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, timestamp, id, amount);
    }

    @Override
    public String toString(){
        return (type) + "   " +
                "\t" + this.returnDate() + "" +
//                "\t" +  + this.getId() + "" +
                "\t" + this.getAmount() + "";
    }
}
