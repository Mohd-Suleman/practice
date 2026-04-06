package cloning;

public class ImmutableExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        Bank bank = new Bank();
        bank.setName("HDFC");
        Account acc = new Account(10, "Suleman", bank);

        System.out.println(acc);
        acc.getBank().setName("Axis");
        System.out.println(acc);


    }
}

final class Account {
    private final int id;
    private final String name;
    private final Bank bank;

    public Account(int id, String name, Bank bank) {
        this.id = id;
        this.name = name;
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bank=" + bank.getName() +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Bank getBank() throws CloneNotSupportedException {
        return (Bank)bank.clone();
//        return new Bank();
    }
}

class Bank  implements Cloneable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}