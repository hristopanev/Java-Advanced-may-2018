package P05_say_Hello_Extend.personimpl;

import P05_say_Hello_Extend.person.Person;

public class European extends BasePerson implements Person {

    public European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return super.sayHello();
    }
}
