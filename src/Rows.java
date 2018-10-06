import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Rows {

    private List<DataRow> dataBase;

    Rows() {
        dataBase = new ArrayList<>();
        TsvParserSettings settings = new TsvParserSettings();
        settings.getFormat().setLineSeparator("\n");

        TsvParser parser = new TsvParser(settings);

        try {
            List<String[]> allRows = parser.parseAll(new FileInputStream("source-data.tsv"));
            for(String[] arr : allRows){
                for(String str: arr){
                    System.out.print(str+", ");
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public DataRow getItem(int index){
        return dataBase.get(index);
    }
}
