package mentee;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TheFallen on 16.12.15.
 */
public class ListBoxBean extends ListBean {

    public String listData;

    public Map<String,Object> getMapDataValue() {
        Map<String, Object> mapDataValue = new LinkedHashMap<>();
        for (String dataValue: listDataValue) {
            mapDataValue.put(dataValue, dataValue);
        }
        return mapDataValue;
    }

    public String getListData() {
        return this.listData;
    }
}
