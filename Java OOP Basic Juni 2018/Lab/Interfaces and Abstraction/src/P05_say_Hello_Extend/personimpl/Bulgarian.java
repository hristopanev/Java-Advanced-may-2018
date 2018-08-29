package P05_say_Hello_Extend.personimpl;

import P05_say_Hello_Extend.person.Person;

public class Bulgarian extends BasePerson implements Person {


    public Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Здравей!";
    }
}
