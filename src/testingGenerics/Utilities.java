package testingGenerics;

import java.util.Collection;

public class Utilities <list extends Comparable<list>>{
    public list method(Collection<list> collection) {
        list result = null;
        for (list l : collection) {
            if (result == null || l.compareTo(result) < 0)
                result = l;
        }
        return result;
    }
}
