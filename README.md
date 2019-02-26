#Java Docs

##Basics

###Architecture
Interpreted language. Converts to bytecode instead of machine language using JVM (Java Virtual Machine)
Runs in protected Virtual Machine envt. (JVM) and doesn't interact with low level functions
C++ directly compiles to Machine Language and has more access to low level functions. Java limited
to single inheritance. JS is interpreted at runtime and not compiled.

SE Standard, EE Enterprise for more power, ME Micro Edition for micro controllers sensors etc.
JDK: Development Kit
JRE: Runtime Environment Runs all Java Applications. Hackable without updates. People do not use
Oracle provided JRE

Unlike C, C++, memory management is automatic. Made possible by the JVM Garbage collector
Stack memory: Somewhat faster. All primitive data types and small declarations stay within block scope
Heap memory: More dynamic. Complex objects
Garbage collector runs on its own thread and user cannot control memory deallocation
Minimize object creation, find ways of recycling or reusing
-Xmx256m: m for Maximum Heap size customisation
Running jar file: java -jar jarName

###Basics
java: Runtime
javac: Compiler
javadoc: docs builder
jar: archive builder

instanceof: Tells us whether an object is instance of a class
eg. String s instanceof java.lang.String will be true
Best practice is to use .equals class instead of == as operator for comparison
?: Ternary (if then)
String s = condition ? truevalue : falsevalue

###OOPS
####Encapsulation: 
Grouping functions and data together, breaking functionality into small maintainable units
Packaging complex functionality for ease of programming
Access to individual functions can be restricted
Hide complex functionality
True nature or type of data may also be hidden (JSON maybe) 

####Abstraction:
private: class and nested class scope
protected: variables can be accessed outside of class scope by extending. Can be seen by subclasses 
or package member
public: usage anywhere. Ideally classes and variables should be private, methods public
static: in methods, they belong to entire class and not any particular object of class
final: Value can only be set once

####Inheritence
Only single inheritance in Java. Makes it easier to manage code.
Base/derived, Superclass/subclass
Any class that is not final can be inherited
Any private object or data cannot be inherited

####Polymorphism: 
Ability of data to be processed in more than one way, Supports method overloading
Increases code flexibility and reusability. Inheritance is also a demonstration of this.

###Datatype
byte 8 bits, short 16, int 32, long 64, float 32, double 64 -2^x to 2^x
Widening, shortening of data (Data type casting into another)

String is an object and recognised as an array of characters. No limit on size. String s = char[] type
char[] s1 = {'h','e','l','l','o'}; String s1 =  new String(s1); toCharArray(String) for reverse .toString()
Efficient use of String: StringBuilder sb = new StringBuilder('Hello').append('a').append(' World');
Strings are immutable. When we say s1 = 'Hello' and then s1 = 'Hello1', we will be dereferencing Obj 1
for garbage collection

On passing parameters to functions, in case of primitives, original primitive remains unchanged. But in 
case of objects or arrays, the original value is modified (String is immutable and is an exception).

###Taking input
Scanner s =  new Scanner(System.in);
System.out.print('Provide input\n ')
String s1 = s.nextline() 
Use NumberFormat num = NumberFormat.getNumberInstance(locale); to auto format variable by type

###Exception handling
Use Intellij to create project. Select Java and Command Palette to auto-generate class under src with package
Use try catch to catch exceptions. Can also specify exceptions by replacing Exception with exception name
Can also add multiple catch blocks
Custom error: if() { throw(new Exception("My Exception")) }

###Object
Object is an instance of class
Non primitive variables are references to objects (Every object can have multiple references)
Resetting of an object also creates a new object

List and Maps are interfaces, HashMaps and ArrayLists are implementations of these interfaces as they extend it
Interfaces define a contract that needs to be adhered by any member that extends it

###Data Strcutures

Set: Collection of data where each object in a set can appear only once. HashSet (Simple set), 
TreeSet (Comparable) (No index, add, remove, size, addAll(Collection) (Union), retainAll(Collection) intersection,
removeAll(Collection) difference)
List: Each object can appear more than once. ArrayList, LinkedList (peek, peekFirst (First object ref),
peekLast (Last Object), poll, pollFirst/ pollLast (Returns and then removes first/last element), size,
indexOf, push, set(index, replacement), addAll(index, collection)(Shifts all list by index if not empty))
Maps: Used for key value associations. Maps are NOT part of collections library. TreeMap, 
LinkedHashMap predictable orders, Hashmap no predictable order
Again, key should be unique, but key pair value can be repeated. HashMap (.keySet(), .put(key, value),
 .putAll(map, map), .get(key), .containsKey(key), .remove(key))
 
###Multithreading
Running multiple tasks at the same time by code. This is called concerrency, concurrent operations that can
execute simultaneously.

###Sorting Algorithms
####Insertion sort

In the best case, where the array was already sorted, no element will need to be moved, so the algorithm will 
just run through the array once and return the sorted array. The running time would be directly proportional to 
the size of the input, so we can say it will take N time.

However, we usually focus on the worst-case running time (computer scientists are pretty pessimistic). The worst 
case for Insertion Sort occurs when the array is in reverse order. To insert each number, the algorithm will have 
to shift over that number to the beginning of the array. Sorting the entire array of N numbers will therefore take 
1+2+..N-1 operations, which is N(N-1)/2 (almost N^2). Computer scientists just round that up (pick the dominant term) 
to N^2 and say that Insertion Sort is an " time" algorithm.
