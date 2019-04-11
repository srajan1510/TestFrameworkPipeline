package WebLibraries;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class MyComparatorClass implements Comparator, Collection {

    public int compare(Object o1, Object o2) {
        String a1=o1.toString();
        String a2= o2.toString();
        if (a1.length()==a2.length()){
            return a2.compareTo(a1);
        }
        else if (a1.length()<a2.length()){
            return 1;
        }
        else if(a1.length()>a2.length()){
            return -1;
        }
        else {
            return 0;
        }


    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
