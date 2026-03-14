package mashreq;

import java.util.*;
import java.util.stream.Collectors;

public class User {
    private int id;
    private String name;
    private int age;
    public User(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args){
        List<User> userList =  Arrays.asList(
                new User(1,"Neelam", 29),
                new User(2,"Neha", 27),
                new User(3,"Santosh", 28)
        );
        //nameWithSortedAge
        // map id with name
        //Get the oldest user (Best & simple)

       //==========================================================================================
        // map id with name
        Map<Integer,String> idWithName = userList.stream().collect(Collectors.toMap(User::getId,User::getName));
        System.out.println(idWithName); // {1=Neelam, 2=Neha, 3=Santosh}
        //Get the oldest user (Best & simple)
        User oldestEmp = userList.stream().max(Comparator.comparingInt(User::getAge)).get();
        System.out.println(oldestEmp); //User{id=1, name='Neelam', age=29}
        Map.Entry<String,Integer> oldestEmp1 = userList.stream().max(Comparator.comparingInt(User::getAge))
                .map(s->Map.entry(s.getName(),s.getAge())).get();
System.out.println(oldestEmp1); //Neelam=29

Map<String,Integer> nameWithSortedAge = userList.stream().sorted(Comparator.comparingInt(User::getAge))
        .collect(Collectors.toMap(User::getName,User::getAge,(e1,e2)->e1,LinkedHashMap::new));
System.out.println(nameWithSortedAge); //{Neha=27, Santosh=28, Neelam=29}

    }
}
