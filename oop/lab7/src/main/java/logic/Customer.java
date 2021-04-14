package logic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

public class Customer implements Comparable<Customer>, Serializable {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private int creditCardId;
    private double accountBalance;

    @JsonCreator
    public Customer(@JsonProperty("id") int id,
                    @JsonProperty("surname") String surname,
                    @JsonProperty("name") String name,
                    @JsonProperty("patronymic") String patronymic,
                    @JsonProperty("address") String address,
                    @JsonProperty("creditCardId") int creditCardId,
                    @JsonProperty("accountBalance") double accountBalance) {
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
        return  id + " " +
                surname + " " +
                name + " " +
                patronymic + " " +
                address + " " +
                creditCardId + " " +
                accountBalance;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && creditCardId == customer.creditCardId && Double.compare (customer.accountBalance, accountBalance) == 0 && Objects.equals (surname, customer.surname) && Objects.equals (name, customer.name) && Objects.equals (patronymic, customer.patronymic) && Objects.equals (address, customer.address);
    }

    @Override
    public int hashCode () {
        return Objects.hash (id, surname, name, patronymic, address, creditCardId, accountBalance);
    }

    @Override
    public int compareTo (Customer o) {
        if (accountBalance != o.accountBalance) {
            return Double.compare(accountBalance, o.accountBalance);
        } else {
            return Integer.compare(creditCardId, o.creditCardId);
        }
    }
}
