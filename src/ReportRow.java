import java.util.ArrayList;
import java.util.List;

public class ReportRow extends ReportLine{

    void generateLine(DataRow row, BaseStruct bs){

        StringBuilder lineBuilder = new StringBuilder();
        List<StringBuilder> values = new ArrayList<>();

        for (DataColumn dc: row.columns) {
            values.add(new StringBuilder(dc.getValue()));
        }
        int width = bs.getWidth();
        for(int i = 0; i < width; i++)
            lineBuilder.append("-");
        lineBuilder.append("\n");
        height++;
        while (!listIsEmpty(values)) {
            lineBuilder.append("| ");
            for (int i = 0; i < values.size(); i++) {

                int columnWidth = row.columns.get(i).getSetting().getWidth();
                if(values.get(i).toString().isEmpty()){
                    addSpaces(lineBuilder, columnWidth);
                    lineBuilder.append(" | ");
                    continue;
                }

                if (values.get(i).length() <= columnWidth) {
                    int diff = columnWidth - values.get(i).length();
                    lineBuilder.append(values.get(i));
                    addSpaces(lineBuilder, diff);
                    values.set(i, new StringBuilder());  //???
                } else {
                    int lastIndex = findDividerLastIndex(values.get(i), columnWidth);
                    if (lastIndex != -1 && lastIndex != 0) {
                        lastIndex++;
                        lineBuilder.append(values.get(i).substring(0, lastIndex));
                        int diff = columnWidth - lastIndex;
                        addSpaces(lineBuilder, diff);
                        values.get(i).delete(0, lastIndex);
                    } else {
                        lineBuilder.append(values.get(i).substring(0, columnWidth));
                        values.get(i).delete(0, columnWidth);
                    }
                }

                lineBuilder.append(" | ");
            }
            lineBuilder.append("\n");
            height++;
        }
        line = lineBuilder.toString();
    }



}
