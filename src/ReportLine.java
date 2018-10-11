import java.util.ArrayList;
import java.util.List;

public class ReportLine {

    private int height = 1;
    private String line;

//    private String[] splitValue(String value){
//        return value.split("\\W");
//    }

    public int getHeight() {
        return height;
    }

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
                    for (int k = 0; k < columnWidth; k++)  //???
                        lineBuilder.append(' ');
                    lineBuilder.append(" | ");
                    continue;
                }

                if (values.get(i).length() < columnWidth) {
                    int diff = columnWidth - values.get(i).length();
                    lineBuilder.append(values.get(i));
                    for (int k = 0; k < diff; k++)  //???
                        lineBuilder.append(' ');
                    values.set(i, new StringBuilder());  //???
                } else {
                    int lastIndex = findDividerLastIndex(values.get(i), columnWidth);
                    if (lastIndex != -1 && lastIndex != 0) {
                        lastIndex++;
                        lineBuilder.append(values.get(i).substring(0, lastIndex));
                        int diff = columnWidth - lastIndex;
                        for (int k = 0; k < diff; k++)  //???
                            lineBuilder.append(' ');
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

    private int findDividerLastIndex(StringBuilder stringBuilder, int endIndex){
        return stringBuilder.substring(0, endIndex).lastIndexOf(" "); // Нужны регулярки
    }

    private boolean listIsEmpty(List<StringBuilder> values){
        boolean result = true;
        for(StringBuilder item : values){
            result &= item.toString().isEmpty();
        }
        return result;
    }

    @Override
    public String toString() {
        return line;
    }
}
