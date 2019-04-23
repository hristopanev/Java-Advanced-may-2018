package P05_say_Hello_Extend.personimpl;

import P05_say_Hello_Extend.person.Person;

public class Chinese extends BasePerson  implements Person {


   public Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "你好";
    }
}
