package streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamExamples {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A","B","X","N","D","F","N","X");

        //Collecting from one list to another list
        List<String> newList = list.stream().filter(s -> !(s.equals(""))).collect(Collectors.toList());
        System.out.println("Initial elements: "+newList);


        //Natural sorting and printing
        System.out.println("Sorted elements: ");
        newList.stream().sorted().forEach(e -> System.out.println(e));
//        newList.stream().filter(e -> !e.isEmpty()).collect(Collectors.toList());

        System.out.println("Reverse Sorted elements: ");
        newList.stream().sorted(Comparator.reverseOrder()).forEach(e -> System.out.println(e));

        //Removed elements by distinct() operation
        System.out.println("Unique elements: ");
        newList.stream().distinct().forEach(System.out::println);
//        newList.stream().distinct().collect(Collectors.toList());

        //Stream process review/debugging using peek()
        System.out.println("Debugging elements: ");
        newList.stream().peek(e -> System.out.println("Element is: "+e))
                .distinct().map(e -> e+"$$").forEach(e -> System.out.println(e));

        //Getting 1st 'N' element from list
        System.out.println("Getting Limited elements: ");
        newList.stream().sorted().limit(3).forEach(e -> System.out.println(e));

        //Removing 'N' element from top and getting rest
        System.out.println("Removed N elements from top: ");
        newList.stream().skip(2).forEach(e -> System.out.println(e));

        // Creating a List of Lists
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("Geeks", "For"),
                Arrays.asList("GeeksForGeeks", "A computer portal"),
                Arrays.asList("Java", "Programming")
        );

        System.out.println("Before flatMap: ");
        System.out.println(listOfLists);

        System.out.println("After flatMap: ");

        listOfLists.stream().flatMap(l -> l.stream()).forEach(e -> System.out.println(e));

        long count = listOfLists.stream().flatMap(l -> l.stream()).count();
        System.out.println("Words# : "+count);

        System.out.println("Using skip and limit: ");
        listOfLists.stream().flatMap(l -> l.stream()).sorted(Comparator.reverseOrder()).peek(e -> System.out.println("Element "+e)).skip(2).limit(1).forEach(e -> System.out.println(e));

        Stream<String> newS = newList.stream().filter(l -> l.length()!=0);

        //Missing element from sorted and unsorted array


        List<Person> persons = new ArrayList<>();
        persons.add(new Person(10,"Juned", new Address("Ghazipur")));
        persons.add(new Person(11,"Shiva", new Address("Gonda")));
        persons.add(new Person(12,"Hamid", new Address("Uttraula")));
        persons.add(new Person(13,"Salman", new Address("Balrampur")));
        persons.add(new Person(14,"Aftab", new Address("Tulsipur")));
        persons.add(new Person(15,"Ashwani", new Address("Kanpur")));
        persons.add(new Person(16,"Udbhav", new Address("Lucknow")));
        persons.add(new Person(17,"Firoz", new Address("Balrampur")));
        persons.add(new Person(18,"Ashutosh", new Address("Tulsipur")));
        persons.add(new Person(19,"Umair", new Address("Kanpur")));
        persons.add(new Person(20,"Imran", new Address("Lucknow")));

        System.out.println(persons);

        //Collecting names only from employee list
        List<String> pList = persons.stream().map(Person::getName).collect(Collectors.toList());

        System.out.println(pList);

        //Convert to map as key -> id and value -> name
        Map<Integer, String> pMap = persons.stream().collect(Collectors.toMap(Person::getId, Person::getName));
        System.out.println(pMap);

        Map<Integer, List<Person>> cityMap = persons.stream().collect(Collectors.groupingBy(Person::getId));
        System.out.println(cityMap);
    }

}

class Person {
    private int id;
    private String name;
    private Address address;

    public Person(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
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
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address.getCity() +
                '}';
    }
}

class Address {
    private String city;

    public Address(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}