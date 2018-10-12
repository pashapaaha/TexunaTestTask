import java.util.ArrayList;
import java.util.List;

public class ReportRow extends ReportLine{

    void generateLine(DataRow row, BaseStruct bs){

        StringBuilder lineBuilder = new StringBuilder();
        List<StringBuilder> values = new ArrayList<>();
        List<Integer> widths = new ArrayList<>();

        for (DataColumn dc: row.columns) {
            values.add(new StringBuilder(dc.getValue()));
        }
        for(DataColumn item: row.columns){
            widths.add(item.getSetting().getWidth());
        }

        addRepeatedChar(lineBuilder, '-',bs.getWidth());
        lineBuilder.append("\n");
        height++;
        whileNotEmpty(lineBuilder, values, widths);

        line = lineBuilder.toString();
    }




}
