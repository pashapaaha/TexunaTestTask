import java.util.ArrayList;
import java.util.List;

public class Rows {

    private List<DataRow> dataBase;

    public Rows() {
        dataBase = new ArrayList<>();
    }

    public DataRow getItem(int index){
        return dataBase.get(index);
    }
}
