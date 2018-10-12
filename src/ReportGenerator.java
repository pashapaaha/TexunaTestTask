public class ReportGenerator {

    public static void main(String[] args) {
        String xmlFileName = args[0];
        String tsvFileName = args[1];
        String outFileName = args[2];
        BaseStruct baseStruct = new BaseStruct(xmlFileName);
        Rows rows = new Rows(tsvFileName, baseStruct);
        InputToFile input = new InputToFile(baseStruct, rows);
        input.generateReport();
        input.input(outFileName);
    }
}
