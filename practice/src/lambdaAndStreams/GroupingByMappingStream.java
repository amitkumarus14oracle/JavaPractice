package lambdaAndStreams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class GroupingByMappingStream {
    public static void main(String[] args) {
        List<Person> persons= Arrays.asList(
          new Person("sara", 12, "female"),
                new Person("sara", 13, "female"),
                new Person("saransh", 12, "male"),
                new Person("saransh", 14, "male"),
                new Person("amit", 15, "male"),
                new Person("akash", 17, "male"),
                new Person("ali", 16, "male")
        );
        Map<String, Person> map = new HashMap<>();
        map = persons.stream().collect(Collectors.toMap(e-> e.getName()+"-"+e.getAge(),
                e->e));
        System.out.println(map);
        Map<String, List<Person>> personMap = new HashMap<>();
        personMap = persons.stream().collect(Collectors.groupingBy(Person::getName));
        System.out.println(personMap);
        Map<String, List<Integer>> ageMap = new HashMap<>();
        ageMap = persons.stream().collect(Collectors.groupingBy(Person::getName,
                Collectors.mapping(Person::getAge, toList())));
        System.out.println(ageMap);
    }
}
class Person {
    String name;
    int age;
    String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
