package StaticId;

import banckAccount.BankAcaount;

import java.util.ArrayList;
import java.util.List;

public class Person {
    public static int personCount;

    private String name;
    private int age;
    private List<BankAcaount> acaounts;

    public Person(String name, int age){
        this(name, age, new ArrayList<>());
        personCount++;
    }

    public Person(String name, int age, List<BankAcaount> acc){
        this.name = name;
        this.age = age;
        this.acaounts = acc;
        personCount++;
    }


    public double getBalance(){
        return this.acaounts.stream().mapToDouble(BankAcaount::getBalance).sum();
    }

}
