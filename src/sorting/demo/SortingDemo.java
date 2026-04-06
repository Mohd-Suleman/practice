package sorting.demo;


import java.util.*;

public class SortingDemo implements Comparable<SortingDemo> {
    private int accountNumber;
    private String accountName;
    private String accountType;


    @Override
    public int compareTo(SortingDemo o) {
        return (o.accountNumber - this.accountNumber);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return  "AccountNumber=" + accountNumber +
                ", AccountName='" + accountName + '\'' +
                ", AccountType='" + accountType + '\'' +
                '}';
    }

    public static void main(String arg[]) {
        SortingDemo demo = new SortingDemo();
        demo.setAccountNumber(100);
        demo.setAccountName("Suleman");
        demo.setAccountType("Salary");

        SortingDemo demo1 = new SortingDemo();
        demo1.setAccountNumber(200);
        demo1.setAccountName("Salma");
        demo1.setAccountType("Saving");

        List<SortingDemo> list = new ArrayList<>();
        list.add(demo);
        list.add(demo1);

        Collections.sort(list);

        System.out.println(list);

        Collections.sort(list, new NameComparator());

        System.out.println(list);

    }
}


class NameComparator implements Comparator<SortingDemo> {

    @Override
    public int compare(SortingDemo o1, SortingDemo o2) {
        return o1.getAccountName().compareTo(o2.getAccountName());
    }
}