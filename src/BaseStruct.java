import javax.xml.stream.XMLStreamException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class BaseStruct {

    private int width;
    private int height;

    private Map<String, Integer> columns;
    private List<String> keyArray;

    BaseStruct(String xmlFileName) {
        columns = new HashMap<>();
        keyArray = new ArrayList<>();
        try (StaxStreamProcessor processor = new StaxStreamProcessor(Files.newInputStream(Paths.get(xmlFileName)))) {
            initSize(processor);
            initColumns(processor);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }

        for(Map.Entry<String, Integer> entry: columns.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

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

    public List<String> getKeysArray(){
        return keyArray;
    }


    private void initSize(StaxStreamProcessor processor) throws XMLStreamException {
        if(processor.startElement("width", "page")){
            width = Integer.parseInt(processor.getText());
        }
        if(processor.startElement("height", "page")){
            height = Integer.parseInt(processor.getText());
        }
    }

    private void initColumns(StaxStreamProcessor processor) throws XMLStreamException {

        while (processor.startElement("column", "columns")) {
            String title = null;
            int width = -1;
            if(processor.startElement("title", "column"))
                title = processor.getText();
            keyArray.add(title);
            if(processor.startElement("width", "column"))
                width = Integer.parseInt(processor.getText());
            if(title != null && width != -1){
                columns.put(title, width);
            }
        }
    }
}
