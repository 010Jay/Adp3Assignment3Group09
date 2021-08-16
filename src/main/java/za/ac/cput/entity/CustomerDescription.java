package za.ac.cput.entity;

public class CustomerDescription
{
    private int id;

    private CustomerDescription(CustomerDescription.Builder builder){

        this.id = builder.id;

    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "customerDescription{" +
                "id=" + id +
                '}';
    }

    public static class Builder {

        private int id;

        public CustomerDescription.Builder setId(int id){

            this.id = id;
            return this;
        }

        public CustomerDescription.Builder copy(CustomerDescription customerDesc){

            this.id = customerDesc.id;

            return this;
        }

        public CustomerDescription build(){

            return new CustomerDescription(this);
        }
    }
}
