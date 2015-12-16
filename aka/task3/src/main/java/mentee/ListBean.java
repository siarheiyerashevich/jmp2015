package mentee;

import java.util.*;

/**
 * Created by TheFa on 16.12.15.
 */
public class ListBean {

    public String name = "Bridge implement GUI, presents list at ListBox and Table";

    public String listData;

    private static List<String> listDataValue;
    static{
        listDataValue = new ArrayList<>();
        listDataValue.add("2000");
        listDataValue.add("2010");
        listDataValue.add("2020");
    }

    public List<String> getListDataValue() {
        return this.listDataValue;
    }

    public Map<String,Object> getMapDataValue() {
        Map<String, Object> mapDataValue = new LinkedHashMap<>();
        for (String dataValue:listDataValue) {
            mapDataValue.put(dataValue, dataValue);
        }
        return mapDataValue;
    }

    public String getName() {
        return name;
    }

    public String getListData() {
        return this.listData;
    }
}
