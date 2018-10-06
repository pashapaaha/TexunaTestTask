import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Rows {

    private List<DataRow> dataBase;

    Rows() {
        String fileName = "source-data.tsv";
        dataBase = new ArrayList<>();
        List<String[]> allRows = getDataFromFile(fileName);
        for(String[] stringArray: allRows){

        }

    }

    public DataRow getItem(int index){
        return dataBase.get(index);
    }

    private List<String[]> getDataFromFile(String fileName) throws IOException {
        TsvParserSettings settings = new TsvParserSettings();
        settings.getFormat().setLineSeparator("\n");
        TsvParser parser = new TsvParser(settings);
        return parser.parseAll(new FileInputStream(fileName));
    }
}
