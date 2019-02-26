package basics.test;

import basics.model.Kalamata;
import basics.model.Olive;
import basics.model.OliveColor;
import basics.model.OliveName;

import java.util.*;

public class DataStructures {
    public static void basics() {
        // Bracket empty signifying dynamic size. No declaration of datatype in ArrayList
        // List ordered data
        List<String> list = new ArrayList<>();
        list.add("NewValue");
        list.add("NewValue2");
        list.add("NewValue3");
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        System.out.println(list.indexOf("NewValue3"));
        Iterator<String> iterator = list.iterator();

        // hasNext() whether data is availale in the list.
        // next() moves to the next available object and outputs it
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        list.forEach(System.out::println);

        // HashMap unordered data
        Map<String, String> map = new HashMap<>();
        // Data is put in any random order. This can be seen in the way it has been printed
        map.put("New", "Abc");
        map.put("New1","Def");
        map.put("New2","Ghi");
        // HashMap also supports only single value per key
        map.put("New2","Hij");
        System.out.println("Checking for duplicate: " + map.get("New2"));

        // Making set of Key values and iterating
        Set<String> set = map.keySet();
        Iterator<String> iterator1 = set.iterator();
        while(iterator1.hasNext()) {
            System.out.println(map.get(iterator1.next()));
        }

        // HashSet: Collection of data where each object in a set can appear only once
        Set<String> set1 =  new HashSet<>();
        set1.add("Data1");
        set1.add("Data2");
        set1.add("Data3");
        System.out.println("Size of HashSet is " + set1.size());

        set1.add(null);
        set1.add("Data2");
        System.out.println("Size of HashSet is " + set1.size());
        set1.remove("Data2");
        System.out.println("Size of HashSet is " + set1.size());
        System.out.println(set1);

        // TreeSet implements everything that a HashSet does and apart from that, you can control the order using
        // an interface called Comparable in the class that is used to store
        // Does not add same value to list twice (Remember during sorting questions)
        TreeSet<Olive> olives1 = new TreeSet<>();
        // Will throw exception as set needs to implement an interface by the name of Comparable
        olives1.add(new Olive(OliveName.LIGURIAN, OliveColor.GREEN, 2));
        olives1.add(new Kalamata());
        olives1.add(new Olive(OliveName.NEWTEST, OliveColor.BLACK, 2));
        olives1.add(new Kalamata());
        olives1.add(new Olive(OliveName.LIGURIAN, OliveColor.GOLDEN, 2));
        System.out.println(olives1.size());
        System.out.println(olives1);
        display(olives1);

        TreeSet<String> str1 = new TreeSet<>();
        str1.add("bASDF");
        str1.add("aASDF");
        str1.add("vASDF");
        str1.add("cASDF");
        System.out.println(str1);

        // In ArrayList, you can add data to the end of any list, but you cannot arbitrarily add data anywhere in list
        // This is why we use Linked Lists
        LinkedList<Olive> llist = new LinkedList<>();
        llist.add(new Olive(OliveName.LIGURIAN, OliveColor.GREEN, 2));
        llist.add(new Olive(OliveName.NEWTEST, OliveColor.BLACK, 2));
        llist.add(1, new Olive(OliveName.KALAMATA, OliveColor.BLACK, 2));
        System.out.println("Linked List with order: ");
        display(llist);
        Olive ot = llist.peek();
        System.out.println("First object of Linked List: "+ llist.peek());
        Olive op = llist.pollLast();
        System.out.println("Last object of Linked List: "+ op);
        display(llist);

        // Set: Union, Intersection, Difference
        Set<Integer> a = new HashSet<>();
        a.addAll(Arrays.asList(new Integer[] {1, 3, 2, 4, 8, 9, 0}));
        Set<Integer> b = new HashSet<>();
        b.addAll(Arrays.asList(new Integer[] {1, 3, 7, 5, 4, 0, 7, 5}));

        // To find union
        Set<Integer> union = new HashSet<>(a);
        union.addAll(b);
        System.out.print("Union of the two Set");
        System.out.println(union);

        // To find intersection
        Set<Integer> intersection = new HashSet<>(a);
        intersection.retainAll(b);
        System.out.print("Intersection of the two Set");
        System.out.println(intersection);

        // To find the symmetric difference
        Set<Integer> difference = new HashSet<>(a);
        difference.removeAll(b);
        System.out.print("Difference of the two Set");
        System.out.println(difference);
    }

    public static void display(Collection<Olive> col) {
        System.out.println("List order: ");
        Iterator<Olive> iter = col.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next().getName());
        }
    }
}
