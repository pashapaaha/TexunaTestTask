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
//        return stringBuilder.substring(0, endIndex).lastIndexOf(" "); // Нужны регулярки
    }

    protected boolean listIsEmpty(List<StringBuilder> values){
        boolean result = true;
        for(StringBuilder item : values){
            result &= item.toString().isEmpty();
        }
        return result;
    }

    protected void addSpaces(StringBuilder sb, int spaceCount){
        for (int i = 0; i < spaceCount; i++)  //???
            sb.append(' ');
    }
}
