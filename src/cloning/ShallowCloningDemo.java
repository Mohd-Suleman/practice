package cloning;

public class ShallowCloningDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Personal person = new Personal();
        person.setId(10);
        person.setName("Suleman");
        Address address = new Address();
        address.setCity("Balrampur");
        person.setAddress(address);

        /** A shallow copy of an object copies all the member fields, but it does not copy objects that the fields refer to.
         * Instead, the references to these objects are copied, meaning both the original and the copied object refer to the same objects.
         * By default, the clone() method provides a shallow copy.*/
        Personal person2 = (Personal)person.clone();
        System.out.println("Initial person1: "+person);
        System.out.println("Initial person2: "+person2);

        person2.setName("Neha");
        person2.getAddress().setCity("Gonda");

        System.out.println("After modification....");

        System.out.println("Initial person1: "+person);
        System.out.println("Initial person2: "+person2);
    }
}


class Personal implements Cloneable {
    private int id;
    private String name;
    private Address address;

    public int getId() {
        return id;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();

    }

    public void setId(int id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address.getCity() +
                '}';
    }
}

class Address {
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
