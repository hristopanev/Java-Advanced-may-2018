package repository;

import java.util.Map;
import java.util.TreeMap;

public class Repository {
    private TreeMap<Integer, Person> personMap;

    public Repository() {
        this.personMap = new TreeMap<>();
    }



    public void add(Person person){
        try {
            int id = this.personMap.lastKey();
            id++;
            this.personMap.put(id, person);
        }catch (Exception e){
            this.personMap.put(0, person);
        }

    }

    public void get(int id){
        this.personMap.get(id);
    }

    public boolean update(int id, Person newPerson){
        if (this.personMap.get(id) == null){
            return false;
        }
        this.personMap.put(id, newPerson);
            return true;
    }
    public boolean delete(int id){
        if (this.personMap.get(id) == null){
            return false;
        }
        this.personMap.remove(id);
        return true;
    }

    public int getCount(){
        return this.personMap.size();
    }



}
