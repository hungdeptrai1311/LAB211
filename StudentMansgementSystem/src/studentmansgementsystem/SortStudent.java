
package studentmansgementsystem;

import java.util.Comparator;

public class SortStudent implements Comparator{

    @Override
    public int compare(Object t, Object t1) {
        if(t instanceof Student && t1 instanceof Student){
            return ((Student)t).getAge() - ((Student)t1).getAge();
        }
        return 0;
    }
    
}
