**[Links]()**

*https://satishkathiriya99.medium.com/java-cheat-sheet-287da6e15e96*


### LEGEND

> ***e = element (Object),***
>
> * **i = index ,** *
>
> ***c = Collection***

# ArrayList `<String>` list = new ArrayList<>();

ArrayList is **not Synchronized, **Its equivalent synchronized class is **Vector.**


#### ***Creation***

<pre class="nj nk nl nm nn no np nq nr ax ns bj"><br class="Apple-interchange-newline"/>
List list = new ArrayList(); // Empty Constructor
List list = new ArrayList(50); // Initial capacity
List list = new ArrayList(oldList);// add collection
</pre>


#### **Methods**

* **list.size();**
* **list.contains(e);** //returns bool
* **list.indexOf(e);**
* **list.lastIndexOf(e);**
* **list.get(i);**
* **list.set(i,e);**
* **list.add(e);** // Add element
* **list.add(i,e);**
* **list.addAll(c)** // Add Collections
* **list.addAll(i, c)**
* **list.remove(i);** //returns bool : return at index

eg : arr.remove(3) -> this will remove element at index 3

* **list.remove(e) or list.remove(object);** **//returns bool : This is tricky in case of integer list,pass Integer object**

**NOTE: It will only remove first occurence of the object**

* **list.removeRange(int fromIndex, int toIndex)**
* **list.removeAll(Collection<?> c) // remove all of the elements that are contained in the specified collection.**
* **list.toArray();**  // convert list to array
* **Collections.sort(list);** //sorts in Ascending Order
* **Collections.sort(list, Collections.reverseOrder());** // Descending order
* **list.clear();**  //remove all element from the list
* **list.replaceAll(UnaryOperator `<E>` operator)**

e.g: list.replaceAll((element) -> element.toUpperCase());

### **copyOnWriteArrayList** — thread-safe version of list

<pre class="nj nk nl nm nn no np nq nr ax ns bj"><br class="Apple-interchange-newline"/>
List<String> list = new CopyOnWriteArrayList<>();
</pre>


***QUICK FACTS:***

1. List indexes start from ‘0’, just like array index.
2. List allows “null”
3. List supports Generics and we should use it whenever possible. Using Generics with List will avoid ClassCastException at runtime.




# HashSet `<Integer>` set= new HashSet<>();

###### Methods

* set.add(e);

If the element is not already present, then this method puts the element and returns `true`. If the element is already present, then it returns `false`.

* set.contains(e);
* set.remove(e);
* set.clear(); // remove all elements in set
* set.isEmpty();

###### **NOTE: SORTING NOT POSSIBLE IN HASHSET** //HashSet stores the elements in random order



***Then how to sort***

#### Creating an ArrayList from existing set.

```
List<Integer> list = new ArrayList<>(set);
```

#### Sorting the list.

```
Collections.sort(list);
```


***QUICK FACTS:***

1. HashSet does not allow duplicate elements.
2. HashSet allows only one null element.
3. The elements are inserted in random order in a  HashSet .
4. A HashSet is internally backed by a  HashMap .
5. initial capacity of 16 and a load factor of 0.75



# TreeSet`<Integer>` set= new TreeSet<>();

<pre class="nj nk nl nm nn no np nq nr ax ns bj"><br class="Apple-interchange-newline"/>
TreeSet<Integer> set = new TreeSet<>();
TreeSet<Integer> reverseSet =  new TreeSet<(Comparator.reverseOrder()); 

// with comparator as arguments
TreeSet<Integer> set = new TreeSet<>(list); // pass collection
</pre>


**S**ince all the elements are stored in sorted order in a  **TreeSet** , storing elements should either implement the **Comparable** interface or a custom **Comparator** while creating the  **TreeSet** .

#### Methods

* set.add(e)
* set.addAll(Collection c);
* set.first() //Fetching the first element in TreeSet
* set.last(); // Fetching the last element in TreeSet
* set.headSet(40) // Fetching all the elements less than 40 | 40 is not inclusive.
* set.tailSet(40) // Fetching all the elements greater than 40 | 40 is not inclusive.
* set.remove(e);
* set.isEmpty();
* set.size();
* set.conatins(e);


***QUICK FACTS:***

1. TreeSet does not allow duplicate elements.
2. TreeSet class doesn’t allow null elements.
3. Since elements are stored in a tree, the access and retrieval times are quite fast in a  TreeSet .
4. The elements are stored in ascending order in a  TreeSet .


# Difference between a HashSet and TreeSet

1. The HashSet allows one null element, whereas a TreeSet does not allow a null element.
2. The elements are stored in random order in a HashSet, whereas it is stored in sorted order in TreeSet.
3. HashSet is faster than Treeset for the operations like add, remove, contains, size, etc.




# HashMap<String, Integer> map= new HashMap<>();

##### *k = key, v = value*


#### Methods

* map.put(k,v);
* map.putIfAbsent(k,v);
* map.putAll(anotherMap);
* map.get(k) //returns v mapped to k
* map.getOrDefault(key , defaultValue); // If the `key` is not present in the `map`, it returns the default value `0` instead of `null`.

e.g: map.put(key, map.getOrDefault(key,0)+1); // very common to maintain frequency of the elements. . .

* map.remove(k) //returns v and removes it.
* map.size();
* map.containsKey(k);
* map.containsValue(v);

```
Map<String, Integer> stockPrice = new HashMap<>();
stockPrice.put("Oracle", 56);
stockPrice.put("Fiserv", 117);
stockPrice.put("BMW", 73);
stockPrice.put("Microsoft", 213);System.out.println(stockPrice.containsKey(“Oracle”));System.out.println(stockPrice.containsValue(73));
```

#### **Looping through a HashMap:**

* **map.entrySet();**

<pre class="nj nk nl nm nn no np nq nr ax ns bj"><br class="Apple-interchange-newline"/>
for(Map.Entry<String, Integer> element : map.entrySet()){
    element.getKey(); // use getKey() for key
    element.getValue(); //use getValue() for values.
}

</pre>

* **map.keySet();**  // This method returns a **Set** containing all the keys present in the Map.
* **map.values();** This method returns a **Collection** containing all the values present in the Map.


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


* **map.replace(K key, V oldValue, V newValue);**  // replace value of the key k if value of the key is same as old value(bool))
* **map.replace(K key,V newValue);** // replace value of the key with new value
* **map.replaceAll( bifunction);**

<pre class="nj nk nl nm nn no np nq nr ax ns bj"><br class="Apple-interchange-newline"/>
stockPrice.replaceAll((k,v) -> v + 10);
</pre>


***QUICK FACTS:***

1. The keys should be unique.
2. HashMap allows only one `null` key.
3. The values can be null or duplicate.
4. The keys are stored in random order.
5. an initial capacity of 16 and **load factor** of 0.75


# TreeMap<String, Integer> treeMap = new TreeMap<>();

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

* put(k,v);
* putAll(map);
* get(k);
* remove(k)
* firstKey() // gives smallest key ( since **TreeMap** stores elements in sorted order)
* firstEntry() // give smallest Entry
* lastKey() // give largest key
* lastEntry() // giva largest entry
* replace(key,value);
* replace(key,oldValue,newValue);


***QUICK FACTS:***

1. The entries in **TreeMap** are sorted in the natural ordering of its keys.
2. It does not allow null keys, however there can be null values.
3. The TreeMap is not thread-safe, although it can be made thread-safe using the `synchronizedMap()` method of the **Collections** class.
4. Since a **TreeMap** stores the keys in sorted order, the objects that we are storing in the **TreeMap** should either implement the **Comparable** interface or we should pass a **Comparator** while creating the **TreeMap** object.


# PriorityQueue `<Integer>` pq = new PriorityQueue<>()



//(max elements on top/descending order)

#### PriorityQueue `<Integer>` maxHeap = new PriorityQueue `<Integer>`((a,b) -> b-a); **



Let’s say you want your own comparator, example, the pq has keys of a hashmap as it’s elements, and they need to be arranged according to their values in a hashmap.

pq = new PriorityQueue<>((a,b) -> map.get(a)-map.get(b));

You can define your own comparator separately( named MyComparator for example):

pq = new PriorityQueue<>(new MyComparator());


# String s = “hello”;

* s.toCharArray();
* s.indexOf(substring);
* s.chatAt(i);
* s.toUpperCase();
* s1.equals(s2); //Note to self: DON’T DO “==” AGAIN AND WONDER WHY THE ANSWER IS CONSTANTLY INCORRECT
* s1.equalsIgnoreCase(s2);
* s1.compareTo(s2); //returns s1-s2, in dictionary order so a-b returns -1
* s1.contains(s2);
* s.length();
* s.startsWith(“hell”); //s.endsWith(“ello”), returns boolean
* s.substring(incl,excl); // incl: inclusive index, included, excl: exclusive index, excluded
* str_array = s.split(“ “);//return string array separated by spaces. “Hello world” returns [“Hello”,”world”]



# Iterator itr = array_name.iterator(); //or list.iterator()

* itr.hasNext(); //returns bool
* itr.next();
* itr.remove(); //removes curr element



# Random r = new Random();

* r.nextInt(n); //return a random int from 0 to n

OR

* Math.random(); //returns a random double between 0.0 and 1.0



# Stack `<Integer>` s = new Stack<>();

* s.push();
* s.peek();
* s.pop();
* s.empty(); //returns bool
* s.size();


# Queue `<Integer>` q = new ArrayList<>();

* q.add(e);
* q.remove(); //throws exception if empty
* q.poll(); //same as remove but returns null if empty
* q.peek();
* q.size();


# **LINKED LIST :**


//CREATTION
List`<Integer>` list = new LinkedList`<Integer>`();
List`<Integer>` list = new LinkedList`<Integer>`(oldList);

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



# Other Useful Methods:

* Character.isDigit(c); //returns bool
* Character.isAlphabetic(c);
* Integer.parseInt(str); //if str = “1234”, it returns integer 1234.
* Float.parseFloat(str); //same as above for floats
* Integer.toBinaryString(num); //returns binary representation of num, input = 10 returns “1010”
* Arrays.asList(arr); //converts array to list
* Integer.MIN_VALUE //returns least possible int in Java
* object.hashCode(); //returns hashcode value for object
* IntegerList.get(i).intValue(); // to convert Integer to int;


# Comparator:

* Arrays.sort(arr, (a.b)->b-a); //sorts in descending order
* Defining MySort to use in other sorting methods (example sort arrays based on their first element)

```java
public class MySort implements Comparator<int[]>{
       public int compare(int[] a, int[] b){
             return a[0]-b[0];
       }
}
```

And then using it like:

* Arrays.sort(arr, MySort)
* For ArrayLists, Collections.sort(arraylist, MyArrListSort());


# **Comparable VS Comparator**

the `Collections.sort()` method sorts the given List in ascending order. But the question is, how does the `sort()` method decide which element is smaller and which one is larger?

Each wrapper class(Integer, Double, or Long), String class, and Date class implements an interface called  **Comparable** . This interface contains a `compareTo(T o)` method which is used by sorting methods to sort the Collection. This method returns a negative integer, zero, or a positive integer if **this** object is less than, equal to, or greater than the object passed as an argument.


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



If we use the `Collections.sort(List<T> list)` method to sort an  **ArrayList** , then the class whose objects are stored in the **ArrayList** must implement the Comparable interface. If the **ArrayList** stores an Integer, a Long, or a String, then we don’t need to worry as these classes already implement the Comparable interface. But if the **ArrayList** stores a custom class object, then that class must implement the Comparable interface.

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
