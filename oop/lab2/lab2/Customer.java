package lab2;

public class Customer {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private int creditCardId;
    private double accountBalance;

    public Customer(int id, String surname, String name, String patronymic, String address, int creditCardId, double accountBalance) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.creditCardId = creditCardId;
        this.accountBalance = accountBalance;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return this.patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCreditCardId() {
        return this.creditCardId;
    }

    public void setCreditCardId(int creditCardId) {
        this.creditCardId = creditCardId;
    }

    public double getAccountBalance() {
        return this.accountBalance;
    }

    public void setAccountBalance(double value) {
        this.accountBalance = value;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", surname=" + surname +
                ", name=" + name +
                ", patronymic=" + patronymic +
                ", address=" + address +
                ", creditCardId=" + creditCardId +
                ", accountBalance=" + accountBalance +
                "}";
    }
}
