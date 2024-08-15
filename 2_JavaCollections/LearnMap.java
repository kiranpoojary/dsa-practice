import java.util.HashMap;
import java.util.Map;

public class LearnMap {
    public static void main(String[] args) {
        Map<String, Integer> numbers = new HashMap<>();
        numbers.put("One", 1);
        numbers.put("Two", 2);
        System.out.println(numbers);
        System.out.println("numbers.get(\"One\") " + numbers.get("One"));
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
