import java.util.List;

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
        return stringBuilder.substring(0, endIndex).lastIndexOf(" "); // Нужны регулярки
    }

    protected boolean listIsEmpty(List<StringBuilder> values){
        boolean result = true;
        for(StringBuilder item : values){
            result &= item.toString().isEmpty();
        }
        return result;
    }
}
