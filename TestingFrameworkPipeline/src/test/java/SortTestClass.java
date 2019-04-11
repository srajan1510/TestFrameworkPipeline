import WebLibraries.MyComparatorClass;
import org.testng.annotations.Test;

import java.util.*;

public class SortTestClass {


    MyComparatorClass myComparatorClass= new MyComparatorClass();

    @Test
    public void sortLinkedList(){


       ArrayList<String> arrayList = new ArrayList<>();
       arrayList.add("Dee");
       arrayList.add("ADrrfdfdkfdq;");
       arrayList.add("Zzzzzfekepk");
       arrayList.add("Cccfeec");
       arrayList.add("Lee");
       arrayList.add("AA");
       arrayList.add("alalalwr");

        Collections.sort(arrayList);
        System.out.println(arrayList);
    }


    @Test
    public void validateHashMap_LinkedHaspMap_TreeMap_Order(){

        Map<Integer,String> m1= new HashMap<>();
        m1.put(2,"Modi");
        m1.put(1,"Rahul");
        m1.put(3,"Others");

        System.out.println(m1);

        Map<Integer,String> m2 = new LinkedHashMap<>();
        m2.put(3,"Modi");
        m2.put(2,"Rahul");
        m2.put(1,"Others");

        System.out.println(m2);

        Map<Integer,String> m3 = new TreeMap<>();
        m3.put(4,"Modi");
        m3.put(5,"Rahul");
        m3.put(1,"Others");

        System.out.println(m3);
    }

}
