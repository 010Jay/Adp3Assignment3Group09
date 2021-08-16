/*Customer.java
Entity for the Customer
Author:Andy William Hine (219259038)
Date:04 June 2021
 */

package za.ac.cput.entity;

public class Customer
{
    public int getCustomerID() {
        return customerID;
    }

        private int customerID;
        private String name,surname,emailAddress,homeAddress;
        private long phoneNumber;

    public Customer() {}
    public Customer(Builder builder)
        {
            this.customerID = builder.customerID;
            this.name = builder.name;
            this.surname = builder.surname;
            this.emailAddress = builder.emailAddress;
            this.homeAddress = builder.homeAddress;
            this.phoneNumber = builder.phoneNumber;
        }


    public String getDescription() {
        return getDescription();
    }

    public int multiply(int cusNum1, int cusNum2) {
        return cusNum1*cusNum2;
    }

    public static class Builder
    {

        private int customerID;
        private String name,surname,emailAddress,homeAddress;
        private long phoneNumber;

        public Builder setCustomerID(int customerID) {
            this.customerID = customerID;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Builder setHomeAddress(String homeAddress) {
            this.homeAddress = homeAddress;
            return this;
        }

        public Builder setPhoneNumber(long phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
        public Customer build()
        {
            return new Customer(this);
        }

        public Builder copy(Customer customer)
        {
            this.customerID = customer.customerID;
            this.name = customer.name;
            this.surname = customer.surname;
            this.emailAddress = customer.emailAddress;
            this.homeAddress = customer.homeAddress;
            this.phoneNumber = customer.phoneNumber;

            return this;
        }
    }

    @Override
        public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    }


