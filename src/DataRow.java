import java.util.HashMap;
import java.util.Map;

public class DataRow {
    public Map<String, String> columns;

    public DataRow(){
        columns = new HashMap<>();
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("[ ");
        for(Map.Entry<String, String> entry: columns.entrySet()){
            string.append(entry.getKey() + " -> " + entry.getValue() + ", ");
        }
        string.delete(string.length()-2, string.length()-1);
        string.append("]");
        return string.toString();
    }
}
