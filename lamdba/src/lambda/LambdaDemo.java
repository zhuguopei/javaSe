package lambda;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * User: 86131
 * Date: 2020/2/13
 */
public class LambdaDemo {

    public static void main(String[] args) {
        String[] array = new String[]{"Apple", "Lemon", "Orange", "banana"};

        Arrays.sort(array, (s1, s2) -> {
            return s1.compareTo(s2);
        });
        System.out.println(String.join(", ", array));

        List<Person> list = new ArrayList<>();
        Person p1 = new Person("张11",1,1);
        Person p2 = new Person("张21",2,2);
        Person p3 = new Person("张31",3,3);
        Person p4 = new Person("张14",4,4);
        Person p5 = new Person("张51",5,5);
        Person p6 = new Person("张16",6,6);
        Person p101 = new Person("张101",101,101);
        list.add(p1);
        list.add(p1);
        list.add(p1);
        list.add(p2);
        list.add(p4);
        list.add(p3);
        list.add(p6);
        list.add(p5);
        list.add(p101);


      /*  list.forEach(item -> {
            item.setName(item.getName() + "开发");
            System.out.println(item.toString() + "\n");
        });*/


        /**
         * 2.stream()流操作
         */

        // 去重 distinct， collect(Collectors.toList()) 封装成集合
        List<Person> personList = list.stream().distinct().collect(Collectors.toList());
        personList.forEach(item -> System.out.println(item));

        System.out.println("\n");

        // 排序 sorted((o1,o2) -> 返回值)
        List<Person> sortedList = list.stream().sorted((o1,o2) -> o1.getAge() - o2.getAge()).collect(Collectors.toList());
        sortedList.forEach(item -> System.out.println(item));


        System.out.println("\n");


        // 过滤 filter(item{})
        List<Person> filterList = list.stream().filter(item -> item.getName().equals("张1")).collect(Collectors.toList());
        filterList.forEach(item -> System.out.println(item));
        System.out.println("\n");

        // 提取元素 map()
        List<String> nameList = list.stream().map(item -> item.getName()).collect(Collectors.toList());
        nameList.forEach(item -> System.out.println(item));

        System.out.println("\n");
        List<Integer> AgeList = list.stream().map(item -> item.getAge()).collect(Collectors.toList());
        AgeList.forEach(item -> System.out.println(item));
        System.out.println("\n");
        List<Integer> sortedAgeList = AgeList.stream().sorted(((o1, o2) -> o1.compareTo(o2))).collect(Collectors.toList());
        sortedAgeList.forEach(item -> System.out.println(item));

        System.out.println("\n");
        // 统计 sum()
        int sum = list.stream().mapToInt(Person::getAge).sum();
        System.out.println(sum);

        OptionalInt max = list.stream().mapToInt(Person::getAge).max();
        System.out.println(max);

        OptionalInt min = list.stream().mapToInt(Person::getAge).min();
        System.out.println(min);

        OptionalDouble average = list.stream().mapToDouble(Person::getAge).average();
        System.out.println(average);

        // 根据属性分组 Collectors.groupingBy()
        Map<Integer, List<Person>> map = list.stream().collect(Collectors.groupingBy(Person::getAge));
        // map 遍历
        map.forEach((key, value) -> System.out.println( key + " : " + value));

    }







}
