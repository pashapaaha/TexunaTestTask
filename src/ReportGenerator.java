public class ReportGenerator {

    public static void main(String[] args) {
        String xmlFileName = "settings.xml";
        String tsvFileName = "source-data.tsv";
        BaseStruct bs = new BaseStruct(xmlFileName);

        Rows rows = new Rows(tsvFileName, bs);
//        ReportRow line = new ReportRow();
//        line.generateLine(rows.getItem(4));
//        System.out.println(line);
//        rows.print();
        InputToFile input = new InputToFile(bs, rows, "hello");
        input.generateReport();
    }
}
