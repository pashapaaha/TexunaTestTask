import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReportLine {

    protected int height = 1;
    protected String line;

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return line;
    }

    protected int findDividerLastIndex(StringBuilder stringBuilder, int endIndex){
        String s = stringBuilder.substring(0, endIndex);
        Matcher m = Pattern.compile("[^a-zA-ZА-Яа-яёЁ\\d][a-zA-ZА-Яа-яёЁ\\d]*$").matcher(s);
        if(m.find())
            return m.start();
        return -1;
    }

    protected boolean listIsEmpty(List<StringBuilder> values){
        boolean result = true;
        for(StringBuilder item : values){
            result &= item.toString().isEmpty();
        }
        return result;
    }

    protected void addSpaces(StringBuilder sb, int spaceCount){
        addRepeatedChar(sb, ' ', spaceCount);
    }

    protected void addRepeatedChar(StringBuilder sb, char c, int spaceCount){
        for (int i = 0; i < spaceCount; i++)
            sb.append(c);
    }

    protected void addDataInCellLine(StringBuilder lineBuilder, List<StringBuilder> values, int columnWidth, int index){
        if (values.get(index).length() <= columnWidth) {
            addShortDataInCellLine(lineBuilder, values, columnWidth, index);
        } else {
            int lastIndex = findDividerLastIndex(values.get(index), columnWidth);
            if (lastIndex != -1 && lastIndex != 0) {
                addDataWithSymbol(lineBuilder, values.get(index), columnWidth, lastIndex);
            } else {
                lineBuilder.append(values.get(index).substring(0, columnWidth));
                values.get(index).delete(0, columnWidth);
            }
        }
    }

    private void addShortDataInCellLine(StringBuilder lineBuilder, List<StringBuilder> values, int columnWidth, int index){
        int diff = columnWidth - values.get(index).length();
        lineBuilder.append(values.get(index));
        addSpaces(lineBuilder, diff);
        values.set(index, new StringBuilder());
    }

    private void addDataWithSymbol(StringBuilder lineBuilder, StringBuilder values, int columnWidth, int lastIndex){
        lastIndex++;
        lineBuilder.append(values.substring(0, lastIndex));
        int diff = columnWidth - lastIndex;
        addSpaces(lineBuilder, diff);
        values.delete(0, lastIndex);
    }


    protected void whileNotEmpty(StringBuilder lineBuilder, List<StringBuilder> values, List<Integer> widths){
        while (!listIsEmpty(values)) {
            lineBuilder.append("| ");
            for (int i = 0; i < values.size(); i++) {
                int columnWidth = widths.get(i);
                if(values.get(i).toString().isEmpty()){
                    addSpaces(lineBuilder, columnWidth);
                    lineBuilder.append(" | ");
                    continue;
                }
                addDataInCellLine(lineBuilder, values, columnWidth, i);
                lineBuilder.append(" | ");
            }
            lineBuilder.append("\n");
            height++;
        }
    }
}
