package google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Children> childrens;

    public Person(String name) {
        this.name = name;
        this.car = null;
        this.company = null;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.childrens = new ArrayList<>();
    }

    public Person(String name, Company company){
        this(name);
        this.company = company;
    }

    public Person(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    public Person(String name, Parent parent){
        this(name);
        this.parents.add(parent);
    }

    public Person(String name, Pokemon pokemon){
        this.name=name;
        this.pokemons.add(pokemon);
    }
    public Person(String name, Children children){
        this(name);
        this.childrens.add(children);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public List<Parent> getParents() {
        return this.parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public List<Children> getChildrens() {
        return this.childrens;
    }

    public void setChildrens(List<Children> childrens) {
        this.childrens = childrens;
    }


    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(this.getName()).append("\n");

        output.append("Company:").append("\n");
        if (this.getCompany() != null) {
            output.append(this.getCompany().toString()).append("\n");
        }

        output.append("Car:").append("\n");
        if (this.getCar() != null) {
            output.append(this.getCar().toString()).append("\n");
        }

        output.append("Pokemon:").append("\n");
        StringBuilder pokemonsBuilder = new StringBuilder();
        if (this.getPokemons().size() != 0) {
            for (Pokemon pokemon : this.getPokemons()) {
                pokemonsBuilder.append(pokemon.toString()).append("\n");
            }
            output.append(pokemonsBuilder);
        }

        output.append("Parents:").append("\n");
        if (this.getParents().size() != 0) {
            StringBuilder parentBuilder = new StringBuilder();
            for (Parent parent : this.getParents()) {
                parentBuilder.append(parent.toString()).append("\n");
            }
            output.append(parentBuilder);
        }

        output.append("Children:").append("\n");
        if (this.getChildrens().size() != 0) {
            StringBuilder childBuilder = new StringBuilder();
            for (Children child : this.getChildrens()) {
                childBuilder.append(child.toString()).append("\n");
            }
            output.append(childBuilder);
        }


        return output.toString();
    }
}
