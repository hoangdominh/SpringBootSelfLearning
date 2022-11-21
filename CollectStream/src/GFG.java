import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GFG {
    public static Map toMap(User user1,User user2, User user3){
        Map<Integer,User> userMap;
        userMap = Stream.of(user1,user2,user3).collect(Collectors.toMap(User::getUserId, user -> user));
        return userMap;
    }

    public static void main(String[] args) {
        User user1 = new User(1, "Minh", "Na Bo");

        User user2 = new User(2, "Hoang", "Na San");

        User user3 = new User(3, "Ninh", "Hat Lot");

        List<User> userMap = new ArrayList<>();

        userMap.add(user1);
        userMap.add(user2);
        userMap.add(user3);

        System.out.println(userMap);
        System.out.println("==================================================");
        System.out.println(toMap(user1, user2, user3));

        System.out.println("==================================================");

        Map<Integer, String> hMap = new HashMap<Integer,String>();
        hMap.put(1,"Java");
        hMap.put(2,"Javascript");
        hMap.put(3,"PHP");
        hMap.put(4,"C#");
        hMap.put(5,"C++");

        hMap.forEach((key,value) -> System.out.println( key + " - " + value));

        System.out.println("==================================================");
        List<String> languages = Arrays.asList("Java", "C#", "C++", "PHP", "Javascript");

        System.out.println("Iterating by passing lambda expression: ");
        languages.forEach(lang -> System.out.println(lang));

        System.out.println("Iterating by passing method reference: ");
        languages.forEach(System.out::println);

    }
}
