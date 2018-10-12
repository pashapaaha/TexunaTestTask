import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataRow {
    List<DataColumn> columns;

    DataRow(){
        columns = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("[ ");
        for(DataColumn dr: columns){
            string.append(dr.getSetting().getTitle() + " -> " + dr.getValue() + ", ");
        }
        string.delete(string.length()-2, string.length()-1);
        string.append("]");
        return string.toString();
    }
}
