package cloning;

public class DeepCloning {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student1  = new Student();
        student1.setId(101);
        student1.setName("Salma");

        /** A deep copy, on the other hand, duplicates everything directly or indirectly referenced by the fields in the original object.
         * This means the cloned object does not share references with the original object; it creates a completely independent copy.
         */
        Subject subject = new Subject();
        subject.setSubjectName("Maths");
        student1.setSubject(subject);

        System.out.println("Initial person1: "+student1);

        Subject subject2 = new Subject();
        subject2.setSubjectName("Hindi");
        student1.setSubject(subject2);

        System.out.println("Modifying person1: "+student1);


        Student student2 = (Student)student1.clone();
        student2.setName("Niyaz");
        student2.getSubject().setSubjectName("English");

        System.out.println("After modification....");

        System.out.println("Initial Subject: "+student1);
        System.out.println("Modified Subject: "+student2);


    }

}

class Student implements Cloneable {
    private int id;
    private String name;
    private Subject subject;

    public Object clone() throws CloneNotSupportedException {
        Student cloned = (Student)super.clone();
        cloned.subject = (Subject) subject.clone();
        return cloned;


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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject=" + subject.getSubjectName() +
                '}';
    }
}

class Subject implements Cloneable {
    private String subjectName;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
