package za.ac.cput.Entity;

/*
    Dog.java
    Entity for the Dog
    Author: Jason Jaftha (217009301)
    Date: 03 June 2021
 */

public class Dog {

    //Attributes
        private int dogId, age, vetId;
        private String name, color, breed, vaccinationStatus;
        private boolean isPuppy;
        private char gender;

    //Constructor
        private Dog(Builder builder)
        {
            this.dogId = builder.dogId;
            this.name = builder.name;
            this.age = builder.age;
            this.color = builder.color;
            this.isPuppy = builder.isPuppy;
            this.gender = builder.gender;
            this.breed = builder.breed;
            this.vetId = builder.vetId;
            this.vaccinationStatus = builder.vaccinationStatus;
        }

    //Builder class
        public static class Builder
        {

            //Attributes
                private int dogId, age, vetId;
                private String name, color, breed, vaccinationStatus;
                private boolean isPuppy;
                private char gender;

            //Initialize the builder
                public Builder setDogId(int id)
                {
                    this.dogId = id;
                    return this;
                }

                public Builder setName(String name)
                {
                    this.name = name;
                    return this;
                }

                public Builder setAge(int age)
                {
                    this.age = age;
                    return this;
                }

                public Builder setColor(String color)
                {
                    this.color = color;
                    return this;
                }

                public Builder setIsPuppy(boolean isPuppy)
                {
                    this.isPuppy = isPuppy;
                    return this;
                }

                public Builder setGender(char gender)
                {
                    this.gender = gender;
                    return this;
                }

                public Builder setBreed(String breed)
                {
                    this.breed = breed;
                    return this;
                }

                public Builder setVetId(int vetId)
                {
                    this.vetId = vetId;
                    return this;
                }

                public Builder setVaccinationStatus(String vaccinationStatus)
                {
                    this.vaccinationStatus = vaccinationStatus;
                    return this;
                }

            //Return a Dog instance with the attributes from the builder
                public Dog build()
                {
                    return new Dog(this);
                }

            //Clone/Copy method
                public Builder copy(Dog dog)
                {
                    this.dogId = dog.dogId;
                    this.name = dog.name;
                    this.age = dog.age;
                    this.color = dog.color;
                    this.isPuppy = dog.isPuppy;
                    this.gender = dog.gender;
                    this.breed = dog.breed;
                    this.vetId = dog.vetId;
                    this.vaccinationStatus = dog.vaccinationStatus;

                    return this;
                }
        }

    //toString method
        @Override
        public String toString() {
            return "Dog{" +
                    "dogId=" + dogId +
                    ", age=" + age +
                    ", vetId=" + vetId +
                    ", name='" + name + '\'' +
                    ", color='" + color + '\'' +
                    ", breed='" + breed + '\'' +
                    ", vaccinationStatus='" + vaccinationStatus + '\'' +
                    ", isPuppy=" + isPuppy +
                    ", gender=" + gender +
                    '}';
        }
}
