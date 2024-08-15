import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LearnTreeMap {

    public static void main(String[] args) {
        Map<String, Integer> numbers = new TreeMap<>();
        numbers.put("One", 1);
        numbers.put("Two", 2);
        System.out.println(numbers);
        System.out.println("containsKey    " + numbers.containsKey("Two"));
        System.out.println("containsValue  " + numbers.containsValue(2));
        System.out.println("isEmpty  " + numbers.isEmpty());

        // put if key not exist: avoids overriding of value
        numbers.putIfAbsent("Ten", 10);
        System.out.println(numbers);

        for (Map.Entry<String, Integer> e : numbers.entrySet()) {
            System.out.println(e);
            System.out.println("getKey    " + e.getKey());
            System.out.println("getValue  " + e.getValue());
        }

        for (String key : numbers.keySet()) {
            System.out.println("Key  " + key);
        }
        for (Integer value : numbers.values()) {
            System.out.println("Value  " + value);
        }
        numbers.clear();
        System.out.println(numbers);

    }
}
