package streams;

import javafx.util.converter.TimeStringConverter;

import java.sql.Timestamp;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperations {
    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "Yanksha", 28, 123, "F", "HR", "Blore", 2020));
        empList.add(new Employee(2, "Francesca", 29, 120, "F", "HR", "Hyderabad", 2015));
        empList.add(new Employee(3, "Ramesh", 30, 115, "M", "HR", "Chennai", 2014));
        empList.add(new Employee(4, "Melanie", 32, 125, "F", "HR", "Chennai", 2013));

        empList.add(new Employee(5, "Padma", 22, 150, "F", "IT", "Noida", 2013));
        empList.add(new Employee(6, "Milad", 27, 140, "M", "IT", "Gurugram", 2017));
        empList.add(new Employee(7, "Uzma", 26, 130, "F", "IT", "Pune", 2016));
        empList.add(new Employee(8, "Ali", 23, 145, "M", "IT", "Trivandam", 2015));
        empList.add(new Employee(9, "Ram", 25, 160, "M", "IT", "Blore", 2010));

//        System.out.println(empList);

        //Group employee by city
        Map<String, List<Employee>> cityMap = empList.stream().collect(Collectors.groupingBy(Employee::getCity));
        System.out.println(cityMap);

        //Find the count of male and female employees present in the organization
        Map<String, Long> genderList = empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(genderList);

        //Print the names of all departments in the organization.
        empList.stream().map(Employee::getDeptName).distinct().forEach(System.out::println);

        //Print employee details whose age is greater than 28.
        List<Employee> ageList = empList.stream().filter(employee -> employee.getAge()>28).collect(Collectors.toList());
        System.out.println(ageList);

        //Grouping by age
        Map<Integer, List<Employee>> ageGroupList = empList.stream().collect(Collectors.groupingBy(Employee::getAge));
        System.out.println(ageGroupList);

        //Getting list of single attribute from Employee list, such as Employee name
        List<String> empNameList = empList.stream().map(Employee::getName).collect(Collectors.toList());
        System.out.println(empNameList);


        List<String> deptList = empList.stream().map(Employee::getCity).distinct().collect(Collectors.toList());
        System.out.println("Distinct Departments: "+deptList);
        empList.stream().map(Employee::getCity).distinct().collect(Collectors.toList()).forEach(e -> System.out.println(e));


        //Get youngest employee
        Stream<Employee> employeeStream = empList.stream().sorted(Comparator.comparing(Employee::getAge)).limit(1);
        employeeStream.forEach(emp -> System.out.println(emp.getAge()));

        Optional<Employee> employeeOptional = empList.stream().min(Comparator.comparing(Employee::getAge));

        if(employeeOptional.isPresent())
            System.out.println(employeeOptional.get().getName()+" : "+employeeOptional.get().getAge());

        //** Finding Employees by Age Range
        //** Finding Department with Highest Number of Employees
        empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get();

        //Finding and Sorting Employees by City
        List<Employee> empByCityList = empList.stream().distinct().sorted(Comparator.comparing(Employee::getCity)).collect(Collectors.toList());
        for(Employee e: empByCityList) {
            System.out.println(e.getCity());
        }


        // Sorting Employees by Name and Age
        List<Employee> sortedByNameThenAge = empList.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getName)).collect(Collectors.toList());
        System.out.println(sortedByNameThenAge);



    }
}


class Employee {
    private int id;
    private String name;
    private int age;
    private long salary;
    private String gender;
    private String deptName;
    private String city;
    private int yearOfJoining;

    public Employee(int id, String name, int age, long salary, String gender,
                    String deptName, String city, int yearOfJoining) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        this.deptName = deptName;
        this.city = city;
        this.yearOfJoining = yearOfJoining;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                ", deptName='" + deptName + '\'' +
                ", city='" + city + '\'' +
                ", yearOfJoining='" + yearOfJoining + '\'' +
                '}';
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }
}
