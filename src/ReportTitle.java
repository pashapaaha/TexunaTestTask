import java.util.ArrayList;
import java.util.List;

public class ReportTitle extends ReportLine{

    void generateLine(BaseStruct bs){
        StringBuilder lineBuilder = new StringBuilder();
        List<StringBuilder> values = new ArrayList<>();
        List<Integer> widths = new ArrayList<>();

        for (SettingsColumn sc: bs.columns) {
            values.add(new StringBuilder(sc.getTitle()));
        }
        for(SettingsColumn item: bs.columns){
            widths.add(item.getWidth());
        }

        whileNotEmpty(lineBuilder, values, widths);

        line = lineBuilder.toString();
    }
}
