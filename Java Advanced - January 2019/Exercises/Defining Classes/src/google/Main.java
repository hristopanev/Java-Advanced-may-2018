package google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        Map<String, Person> people = new LinkedHashMap<>();

        while (!line.equals("End")){

            String[] data = line.split("\\s+");
            String name = data[0];
            String token = data[1];
            String tokenName = data[2];

            Person person = people.get(name);
            if (person == null){
                person = new Person(name);
            }

            if (token.equals("company")){
                String department = data[3];
                double salary = Double.parseDouble(data[4]);

                Company company = new Company(tokenName, department, salary);
                person.setCompany(company);
            }else if (token.equals("pokemon")){
                String pokemonType = data[3];

                Pokemon pokemon = new Pokemon(tokenName, pokemonType);
                person.getPokemons().add(pokemon);
            }else if (token.equals("parents")){
                String birthday = data[3];

                Parent parent = new Parent(tokenName, birthday);
                person.getParents().add(parent);
            }else if (token.equals("children")){
                String birthday = data[3];

                Children children = new Children(tokenName, birthday);
                person.getChildrens().add(children);
            }else if (token.equals("car")){
                int carSpeed = Integer.parseInt(data[3]);

                Car car = new Car(tokenName, carSpeed);
                person.setCar(car);
            }

            people.put(name, person);

            line = reader.readLine();
        }

        String printName = reader.readLine();
        System.out.println(people.get(printName));
    }
}
