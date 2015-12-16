package mentee;

import java.util.*;

/**
 * Created by TheFa on 16.12.15.
 */
public class ListBean {

    public String name = "Bridge implement GUI, presents list at ListBox and Table";

    protected static List<String> listDataValue;
    static{
        listDataValue = new ArrayList<>();
        listDataValue.add("2000");
        listDataValue.add("2010");
        listDataValue.add("2020");
    }

    public String getName() {
        return name;
    }
}
