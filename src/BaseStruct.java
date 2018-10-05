import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class BaseStruct {

    private int width;
    private int height;

    private Map<String, Integer> colums;

    public BaseStruct(String xmlFileName) {

        try (StaxStreamProcessor processor = new StaxStreamProcessor(Files.newInputStream(Paths.get("payload.xml")))) {
            XMLStreamReader reader = processor.getReader();
            if(processor.startElement("height", "page")){
                height = Integer.parseInt(processor.getText());
            }
            if(processor.startElement("widht", "page")){
                width = Integer.parseInt(processor.getText());
            }
            while (processor.startElement("column", "columns")) {
                System.out.println(processor.getAttribute("id") +":" + processor.getText());
            }
        }
        catch (Exception e){

        }
        colums = new HashMap<>();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
