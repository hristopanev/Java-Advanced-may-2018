package repository;

public class Person {
    private String name;
    private Integer age;
    private  String birthDate;

    public Person(String name, Integer age, String birthDate) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("%s, %d, %s%n", this.getName(), this.getAge(), this.getBirthDate());
    }
}
