public class ReportGenerator {

    public static void main(String[] args) {
        String xmlFileName = "settings.xml";
        String tsvFileName = "source-data.tsv";
        BaseStruct bs = new BaseStruct(xmlFileName);

        Rows rows = new Rows(tsvFileName, bs);
        rows.print();
    }
}
