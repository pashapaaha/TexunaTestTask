import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Rows {

    private List<DataRow> dataBase;

    Rows(String fileName, BaseStruct struct) {
        try {
            dataBase = new ArrayList<>();
            List<String[]> allRows = getDataFromFile(fileName);

            for(String[] strings: allRows) {
                DataRow dr = new DataRow();
                int i = 0;
                for (SettingsColumn item: struct.columns) {
                    dr.columns.add(new DataColumn(item, strings[i]));
                    i++;
                }
                dataBase.add(dr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

    }

    public DataRow getItem(int index){
        return dataBase.get(index);
    }

    void print(){
        for (DataRow dr: dataBase)
            System.out.println(dr);
    }

    private List<String[]> getDataFromFile(String fileName) throws IOException {
        TsvParserSettings settings = new TsvParserSettings();
        settings.getFormat().setLineSeparator("\n");
        TsvParser parser = new TsvParser(settings);
        return parser.parseAll(new FileInputStream(fileName));
    }
}
