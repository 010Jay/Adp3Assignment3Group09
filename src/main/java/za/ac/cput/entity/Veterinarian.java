package za.ac.cput.entity;
/*
    Veterinarian.java
    Veterinarian Entity with builder Pattern
    Author: Nonhlahla Hlungwani (218160658)
    Date: 04 June 2021
 */

public class Veterinarian {
    private int vetId;
    private String name;
    private String surname;
    private long phoneNumber;
    private String emailAddress;

    public Veterinarian(Builder builder) {
        this.vetId = builder.vetId;
        this.name = builder.name;
        this.surname = builder.surname;
        this.phoneNumber = builder.phoneNumber;
        this.emailAddress = builder.emailAddress;
    }
    public void VaccinateDog()
    {
        System.out.println("The dog is Vaccinated");
    }

    @Override
    public String toString() {
        return "Veterinarian{" +
                "vetId=" + vetId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    public static class Builder{
        private int vetId;
        private String name;
        private String surname;
        private long phoneNumber;
        private String emailAddress;

        public Builder setVetId(int vetId) {
            this.vetId = vetId;
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

        public Builder setPhoneNumber(long phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }
        public Veterinarian build()
        {
            return new Veterinarian(this);
        }
        public Builder copy(Veterinarian veterinarian)
        {
            this.vetId = veterinarian.vetId;
            this.name =  veterinarian.name;
            this.surname =  veterinarian.surname;
            this.phoneNumber =  veterinarian.phoneNumber;
            this.emailAddress =  veterinarian.emailAddress;
            return this;
        }
    }
}

