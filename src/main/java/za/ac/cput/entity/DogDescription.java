package za.ac.cput.entity;

/*
   Entity for the DogDescription
    Author: Sinoxolo Jaca
    Date: 04 June 2021
 */

public class DogDescription {

    private int id;
    private String type;

    private DogDescription(Builder builder){

        this.id = builder.id;
        this.type = builder.type;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "dogDescription{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }

    public static class Builder {

        private int id;
        private String type;

        public Builder setId(int id){

            this.id = id;
            return this;
        }


        public Builder setType(String type){
            this.type = type;
            return this;
        }

        public Builder copy(DogDescription desc){

            this.id = desc.id;
            this.type = desc.type;

            return this;
        }

        public DogDescription build(){

            return new DogDescription(this);
        }


    }
}
