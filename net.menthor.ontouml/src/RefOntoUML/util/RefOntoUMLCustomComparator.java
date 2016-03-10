package RefOntoUML.util;

import java.util.Comparator;

public class RefOntoUMLCustomComparator implements Comparator<RefOntoUMLElementCustom>{
    @Override
    public int compare(RefOntoUMLElementCustom o1, RefOntoUMLElementCustom o2) {
        return o1.toString().compareToIgnoreCase(o2.toString());
    }
}
