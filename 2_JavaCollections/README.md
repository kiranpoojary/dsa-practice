**[Links]()**

https://satishkathiriya99.medium.com/java-cheat-sheet-287da6e15e96

### LEGEND

> **_e = element (Object),_**
>
> **i = index**
>
> **_c = Collection_**

# Java Collection Framework

Java Collections Framework is a unified architecture for representing and manipulating collections, enabling efficient handling of data groups like lists, sets, and maps. It provides various interfaces (e.g., List, Set, Map) and concrete implementations (e.g., ArrayList, HashSet, HashMap) to manage collections with different properties and behaviors. Collections are dynamic, allowing elements to be added or removed at runtime. The framework includes utility classes like Collections for common tasks such as sorting, searching, and synchronization. Overall, Java Collections simplify data manipulation, ensuring flexibility, reusability, and performance.

## Static Methods of Collection

Java's Collections class (in the java.util package) provides several static methods that operate on or return collections. These utility methods include operations like sorting, searching, reversing, and more. Here's an overview of some of the most commonly used static methods in the Collections class.

### 1. Collection.swap(List<?> list, int i, int j)

Swaps the elements at the specified positions in the specified list

```java
list = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
Collections.swap(list, 1, 3);
System.out.println(list); // Output: [a, d, c, b]
```

### 2. Collection.sort(coll) // Sorts in natural order (ascending)

### 3. Collections.shuffle(coll); // Randomly shuffles the list

### 4. Collections.reverse(coll); // Reverses the order of elements in the list

### 5. Collections.binarySearch(coll, 4);

- **`binarySearch(List<? extends Comparable<? super T>> list, T key)`** : Searches the specified list for the specified object using the binary search algorithm.
- **`binarySearch(List<? extends T> list, T key, Comparator<? super T> c)`** : Searches the specified list using the binary search algorithm with a comparator.

int index = Collections.binarySearch(numbers, 4); // Performs binary search on a sorted list

### 6. Finding Minimum and Maximum

- **`min(Collection<? extends T> coll)`** : Returns the minimum element of the given collection, according to the natural ordering of its elements.
- **`min(Collection<? extends T> coll, Comparator<? super T> comp)`** : Returns the minimum element according to a comparator.
- **`max(Collection<? extends T> coll)`** : Returns the maximum element of the given collection, according to the natural ordering.
- **`max(Collection<? extends T> coll, Comparator<? super T> comp)`** : Returns the maximum element according to a comparator.

### 7. Collections.frequency(numbers, 3)

- int freq = Collections.frequency(numbers, 3); // Returns the frequency of the number 3 in the list

### 8. Unmodifiable Collections

- **`unmodifiableList(List<? extends T> list)`** : Returns an unmodifiable view of the specified list.
- **`unmodifiableSet(Set<? extends T> s)`** : Returns an unmodifiable view of the specified set.
- **`unmodifiableMap(Map<? extends K, ? extends V> m)`** : Returns an unmodifiable view of the specified map.

### 9. Collections.copy(destList, srcList);

List `<Integer>` destList = new ArrayList<>(Arrays.asList(new Integer[5]));

Collections.copy(destList, numbers); // Copies elements from numbers to destList

### 10. Collections.replaceAll(coll, 3, 33);

Replaces all occurrences of 3 with 33

### 11. Disjoint

disjoint(Collection `<?> c1, Collection<?>` c2):

Returns true if the two specified collections have no elements in common.

boolean isDisjoint = Collections.disjoint(list1, list2); // Checks if list1 and list2 have no elements in common

# Collections Implementations

## ArrayList `<String>` list = new ArrayList<>();

ArrayList is **not Synchronized, **Its equivalent synchronized class is **Vector.**

### **_Creation_**

#### create arrayList with initial value like below;

```java
List<Integer> arr = new ArrayList<>(Arrays.asList(10, 22, 12, 3, 0, 6));
```

#### Create with initial capacity

* When the `ArrayList` is created with an initial capacity, the internal array is filled with `null` references (not zeros or any other default values) for object types. For primitive types (like `int`), if you use a wrapper class like `Integer`, it will also be `null`.

```
List list = new ArrayList(50); // Initial capacity
```

#### Creating an ArrayList from existing set.

```
List<Integer> list = new ArrayList<>(set);
```

#### Create 2D ArrayList

##### Step-by-Step Example:

###### **1. Declare the 2D `ArrayList`:**

```java
ArrayList
```

###### **2. Initialize the Rows (Inner Lists):**

```java
for (int i = 0; i < 3; i++) {  // 3 is the number of rows you want
    twoDArrayList.add(new ArrayList<>());  // Initialize each row
}
```

###### **3. Add Elements to the 2D `ArrayList`:**

```java
twoDArrayList.get(0).add(1); // Adding element 1 to row 0, column 0
twoDArrayList.get(0).add(2); // Adding element 2 to row 0, column 1
twoDArrayList.get(1).add(3); // Adding element 3 to row 1, column 0
twoDArrayList.get(2).add(4); // Adding element 4 to row 2, column 0
```

###### **4. Print the 2D `ArrayList`:**

```java
for (ArrayList<Integer> row : twoDArrayList) {
    System.out.println(row);
}

//output
[1, 2]
[3]
[4]
```

#### Other creation example

List list = new ArrayList(oldList); // add collection

### **Methods**

#### 1. list.size();

#### 2. list.contains(e); //returns bool

#### 3. list.indexOf(e);

#### 4. list.lastIndexOf(e);

#### 5. list.get(i);

#### 6. list.set(i,e);  //rewrite specific index element

#### 7. list.add(e); // Add element

#### 8. list.add(i,e);

#### 9. list.addAll(c) // Add Collections

#### 10. list.addAll(i, c)

#### 11. list.remove(i); //returns bool : return at index

eg : arr.remove(3) -> this will remove element at index 3

#### 12. list.remove(e) or list.remove(object);//returns bool :

This is tricky in case of integer list,pass Integer object; NOTE: It will only remove first occurence of the object

#### 13. list.removeRange(int fromIndex, int toIndex)

#### 14. list.removeAll(Collection<?> c) // remove all of the elements that are contained in the specified collection.

#### 15. list.toArray(); // convert list to array

#### 16. list.clear(); //remove all element from the list

#### 17. list.replaceAll(UnaryOperator `<E>` operator)

e.g: list.replaceAll((element) -> element.toUpperCase());

#### 18. CopyOnWriteArrayList

* Its is a thread-safe version of list, thread safe means ability of multiple threads to access and modify a collection concurrently without causing data inconsistency or race conditions

<pre class="nj nk nl nm nn no np nq nr ax ns bj"><br class="Apple-interchange-newline"/>
List<String> list = new CopyOnWriteArrayList<>();
</pre>

### **_QUICK FACTS:_**

1. List indexes start from ‘0’, just like array index.
2. List allows “null”
3. List supports Generics and we should use it whenever possible. Using Generics with List will avoid ClassCastException at runtime.

## HashSet `<Integer>` set= new HashSet<>();

### Methods

#### 1. set.add(e);

If the element is not already present, then this method puts the element and returns `true`. If the element is already present, then it returns `false`.

#### 2. set.contains(e);

#### 3. set.remove(e);

#### 4. set.clear(); // remove all elements in set

#### 5. set.isEmpty();

NOTE: SORTING NOT POSSIBLE IN HASHSET //HashSet stores the elements in random order

_Then how to sort_

### **_QUICK FACTS:_**

1. HashSet does not allow duplicate elements.
2. HashSet allows only one null element.
3. The elements are inserted in random order in a HashSet .
4. A HashSet is internally backed by a HashMap .
5. initial capacity of 16 and a load factor of 0.75

## TreeSet `<Integer>` set= new TreeSet<>();

<pre class="nj nk nl nm nn no np nq nr ax ns bj"><br class="Apple-interchange-newline"/>
TreeSet<Integer> set = new TreeSet<>();
TreeSet<Integer> reverseSet =  new TreeSet<(Comparator.reverseOrder()); 

// with comparator as arguments
TreeSet<Integer> set = new TreeSet<>(list); // pass collection
</pre>

**S**ince all the elements are stored in sorted order in a **TreeSet** , storing elements should either implement the **Comparable** interface or a custom **Comparator** while creating the **TreeSet** .

### Methods

#### 1. set.add(e)

#### 2. set.addAll(Collection c);

#### 3. set.first() //Fetching the first element in TreeSet

#### 4. set.last(); // Fetching the last element in TreeSet

#### 5. set.headSet(40) // Fetching all the elements less than 40 | 40 is not inclusive.

#### 6. set.tailSet(40) // Fetching all the elements greater than 40 | 40 is not inclusive.

#### 7. set.remove(e);

#### 8. set.isEmpty();

#### 9. set.size();

#### 10. set.conatins(e);

### **_QUICK FACTS:_**

1. TreeSet does not allow duplicate elements.
2. TreeSet class doesn’t allow null elements.
3. Since elements are stored in a tree, the access and retrieval times are quite fast in a TreeSet .
4. The elements are stored in ascending order in a TreeSet .

### Difference between a HashSet and TreeSet

1. The HashSet allows one null element, whereas a TreeSet does not allow a null element.
2. The elements are stored in random order in a HashSet, whereas it is stored in sorted order in TreeSet.
3. HashSet is faster than Treeset for the operations like add, remove, contains, size, etc.

## HashMap<String, Integer> map= new HashMap<>();

##### _k = key, v = value_

#### Methods

- map.put(k,v);
- map.putIfAbsent(k,v);
- map.putAll(anotherMap);
- map.get(k) //returns v mapped to k
- map.getOrDefault(key , defaultValue); // If the `key` is not present in the `map`, it returns the default value `0` instead of `null`.

e.g: map.put(key, map.getOrDefault(key,0)+1); // very common to maintain frequency of the elements. . .

- map.remove(k) //returns v and removes it.
- map.size();
- map.containsKey(k);
- map.containsValue(v);

```
Map<String, Integer> stockPrice = new HashMap<>();
stockPrice.put("Oracle", 56);
stockPrice.put("Fiserv", 117);
stockPrice.put("BMW", 73);
stockPrice.put("Microsoft", 213);System.out.println(stockPrice.containsKey(“Oracle”));System.out.println(stockPrice.containsValue(73));
```

#### **Looping through a HashMap:**

- **map.entrySet();**

<pre class="nj nk nl nm nn no np nq nr ax ns bj"><br class="Apple-interchange-newline"/>
for(Map.Entry<String, Integer> element : map.entrySet()){
    element.getKey(); // use getKey() for key
    element.getValue(); //use getValue() for values.
}

</pre>

- **map.keySet();** // This method returns a **Set** containing all the keys present in the Map.
- **map.values();** This method returns a **Collection** containing all the values present in the Map.

```
Set<String> keys = stockPrice.keySet();
for(String key : keys) {
   System.out.println(key);
}

Collection<Integer> values = stockPrice.values();
for(Integer value : values) {
    System.out.println(value);
}
```

- **map.replace(K key, V oldValue, V newValue);** // replace value of the key k if value of the key is same as old value(bool))
- **map.replace(K key,V newValue);** // replace value of the key with new value
- **map.replaceAll( bifunction);**

<pre class="nj nk nl nm nn no np nq nr ax ns bj"><br class="Apple-interchange-newline"/>
stockPrice.replaceAll((k,v) -> v + 10);
</pre>

**_QUICK FACTS:_**

1. The keys should be unique.
2. HashMap allows only one `null` key.
3. The values can be null or duplicate.
4. The keys are stored in random order.
5. an initial capacity of 16 and **load factor** of 0.75

## TreeMap<String, Integer> treeMap = new TreeMap<>();

TreeMap: TreeMap is a class in the `java.utils` package that stores the keys in sorted order. Some of the features of **TreeMap** are:

REVERSE TREE MAP

#### **TreeMap<String, Integer> reverseMap = new TreeMap<>(Comparator.reverseOrder());**

```
// Creating a TreeMap using existing HashMap. This will store the elements in ascending order.
TreeMap<String, Integer> treeMap1 = new TreeMap<>(hashMap);

// Creating a TreeMap using existing TreeMap. This will store the elements in the same order as it was in the passed Map.
TreeMap<String, Integer> treeMap2 = new TreeMap<>(reverseMap);
```

#### Methods

- put(k,v);
- putAll(map);
- get(k);
- remove(k)
- firstKey() // gives smallest key ( since **TreeMap** stores elements in sorted order)
- firstEntry() // give smallest Entry
- lastKey() // give largest key
- lastEntry() // giva largest entry
- replace(key,value);
- replace(key,oldValue,newValue);

**_QUICK FACTS:_**

1. The entries in **TreeMap** are sorted in the natural ordering of its keys.
2. It does not allow null keys, however there can be null values.
3. The TreeMap is not thread-safe, although it can be made thread-safe using the `synchronizedMap()` method of the **Collections** class.
4. Since a **TreeMap** stores the keys in sorted order, the objects that we are storing in the **TreeMap** should either implement the **Comparable** interface or we should pass a **Comparator** while creating the **TreeMap** object.

## PriorityQueue `<Integer>` pq = new PriorityQueue<>()

//(max elements on top/descending order)

#### PriorityQueue `<Integer>` maxHeap = new PriorityQueue `<Integer>`((a,b) -> b-a); \*\*

Let’s say you want your own comparator, example, the pq has keys of a hashmap as it’s elements, and they need to be arranged according to their values in a hashmap.

pq = new PriorityQueue<>((a,b) -> map.get(a)-map.get(b));

You can define your own comparator separately( named MyComparator for example):

pq = new PriorityQueue<>(new MyComparator());

## String s = “hello”;

### Methods

#### 1. s.toCharArray();

#### 2. s.indexOf(substring);

#### 3. s.chatAt(i);

#### 4.s.toUpperCase();

#### 5. s1.equals(s2); //Note to self: DON’T DO “==” AGAIN AND WONDER WHY THE ANSWER IS CONSTANTLY INCORRECT

- s1.equalsIgnoreCase(s2);
- s1.compareTo(s2); //returns s1-s2, in dictionary order so a-b returns -1
- s1.contains(s2);
- s.length();
- s.startsWith(“hell”); //s.endsWith(“ello”), returns boolean
- s.substring(incl,excl); // incl: inclusive index, included, excl: exclusive index, excluded
- str_array = s.split(“ “);//return string array separated by spaces. “Hello world” returns [“Hello”,”world”]

## Iterator itr = array_name.iterator(); //or list.iterator()

- itr.hasNext(); //returns bool
- itr.next();
- itr.remove(); //removes curr element

## Random r = new Random();

- r.nextInt(n); //return a random int from 0 to n

OR

- Math.random(); //returns a random double between 0.0 and 1.0

## Stack `<Integer>` s = new Stack<>();

- s.push();
- s.peek();
- s.pop();
- s.empty(); //returns bool
- s.size();

## Queue `<Integer>` q = new ArrayList<>();

- q.add(e);
- q.remove(); //throws exception if empty
- q.poll(); //same as remove but returns null if empty
- q.peek();
- q.size();

## LINKED LIST :

//CREATTION
List `<Integer>` list = new LinkedList `<Integer>`();
List `<Integer>` list = new LinkedList `<Integer>`(oldList);

//ADD ELEMENTS
addLast(E e)
addFirst(E e)
add(int index, E element)
addAll(Collection c)
addAll(int index, Collection c)

//FETCHING
getFirst()
getLast()
get(int index)

//REMOVING
removeFirst()
removeLast()
remove(int index)
remove(E element) // first occurrence is removed.
removeLastOccurrence(E element)

//SORT
Collections.sort(linkedList);

## Other Useful Methods:

- Character.isDigit(c); //returns bool
- Character.isAlphabetic(c);
- Integer.parseInt(str); //if str = “1234”, it returns integer 1234.
- Float.parseFloat(str); //same as above for floats
- Integer.toBinaryString(num); //returns binary representation of num, input = 10 returns “1010”
- Arrays.asList(arr); //converts array to list
- Integer.MIN_VALUE //returns least possible int in Java
- object.hashCode(); //returns hashcode value for object
- IntegerList.get(i).intValue(); // to convert Integer to int;

## Comparator:

- arrList.sort(Comparator.reverseOrder()); // descending; default is ascending
- Arrays.sort(arr, (a.b)->b-a); //sorts in descending order
- Defining MySort to use in other sorting methods (example sort arrays based on their first element)

```java
public class MySort implements Comparator<int[]>{
       public int compare(int[] a, int[] b){
             return a[0]-b[0];
       }
}
```

And then using it like:

- Arrays.sort(arr, MySort)
- For ArrayLists, Collections.sort(arraylist, MyArrListSort());

## **Comparable VS Comparator**

the `Collections.sort()` method sorts the given List in ascending order. But the question is, how does the `sort()` method decide which element is smaller and which one is larger?

Each wrapper class(Integer, Double, or Long), String class, and Date class implements an interface called **Comparable** . This interface contains a `compareTo(T o)` method which is used by sorting methods to sort the Collection. This method returns a negative integer, zero, or a positive integer if **this** object is less than, equal to, or greater than the object passed as an argument.

```java
class Employee implements Comparable<Employee> {
    String name;
    int age;    public Employee(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Employee emp) {
        return (this.age - emp.age);
    }
	//We will sort the employee based on age in ascending order returns a negative integer, zero, or a positive integer as this employee age is less 	than, equal to, or greater than the specified object.
}

public class Vehicle implements Comparable<Vehicle> {
   String brand;
   Integer makeYear;
   public Vehicle(String brand, Integer makeYear) {
      super();
      this.brand = brand;
      this.makeYear = makeYear;
   }
   @Override
   public int compareTo(Vehicle o) {
   //Using the compareTo() method of String class.
       return this.brand.compareTo(o.brand);
   }
}
```

If we use the `Collections.sort(List<T> list)` method to sort an **ArrayList** , then the class whose objects are stored in the **ArrayList** must implement the Comparable interface. If the **ArrayList** stores an Integer, a Long, or a String, then we don’t need to worry as these classes already implement the Comparable interface. But if the **ArrayList** stores a custom class object, then that class must implement the Comparable interface.

If we need some flexibility in sorting, we should use the Comparator interface instead of the Comparable interface. The Comparator interface has a method, `compare(T o1, T o2)`, which takes two objects, o1 and o2 as parameters. It returns -1 if o1 << o2, 1 if o1 >> o2 and 0 if o1 is equal to o2.

If we need to use the Comparator interface, then we can’t use the `Collections.sort(List<T> t)` method as `T` should implement the Comparable interface. There is another overloaded method, `sort(List<T> list, Comparator<? super T> c)`, that takes the list as well as a Comparator object as input. It then sorts the List on the basis of logic, which is provided in the Comparator implementation.

```java
import java.util.Comparator;  public class BrandComparator implements Comparator<Vehicle> {

   @Override
   public int compare(Vehicle o1, Vehicle o2) {
      return o1.brand.compareTo(o2.brand);
   }
}
```
