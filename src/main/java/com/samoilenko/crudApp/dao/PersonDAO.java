package com.samoilenko.crudApp.dao;

import com.samoilenko.crudApp.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;
    private static int PEOPLE_COUNT;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tom", 22, "tom@gmai.com"));
        people.add(new Person(++PEOPLE_COUNT, "Bob", 21, "bob@mail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Mike", 44, "mike@mail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Katy", 33, "katy@mail.com"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);

    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person person){
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(person.getName());
        personToBeUpdated.setAge(person.getAge());
        personToBeUpdated.setEmail(person.getEmail());
    }

    public void delete(int id){
        people.removeIf(p -> p.getId() == id);
    }
}
