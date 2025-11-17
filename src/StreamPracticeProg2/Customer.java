package StreamPracticeProg2;

public class Customer {
    private String id;
    private String name;
    private String country;
    private int age;
    private int yearsOfMembership;
    private double balance;
    private int loyaltyScore;
    private int numberOfTransactions;

    public Customer(String id, String name, String country, int age, int yearsOfMembership,
                    double balance, int loyaltyScore, int numberOfTransactions) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.age = age;
        this.yearsOfMembership = yearsOfMembership;
        this.balance = balance;
        this.loyaltyScore = loyaltyScore;
        this.numberOfTransactions = numberOfTransactions;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getCountry() { return country; }
    public int getAge() { return age; }
    public int getYearsOfMembership() { return yearsOfMembership; }
    public double getBalance() { return balance; }
    public int getLoyaltyScore() { return loyaltyScore; }
    public int getNumberOfTransactions() { return numberOfTransactions; }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", age=" + age +
                ", yearsOfMembership=" + yearsOfMembership +
                ", balance=" + balance +
                ", loyaltyScore=" + loyaltyScore +
                ", transactions=" + numberOfTransactions +
                '}';
    }
}
