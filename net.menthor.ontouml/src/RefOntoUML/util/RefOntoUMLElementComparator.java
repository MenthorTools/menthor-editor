package RefOntoUML.util;

import java.util.Comparator;

public class RefOntoUMLElementComparator implements Comparator<RefOntoUMLElement> {
    @Override
    public int compare(RefOntoUMLElement o1, RefOntoUMLElement o2) {
        return o1.toString().compareToIgnoreCase(o2.toString());
    }
}
