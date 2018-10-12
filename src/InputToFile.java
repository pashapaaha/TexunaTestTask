import java.io.*;

class InputToFile {

    private BaseStruct struct;
    private Rows rows;
    private String report;

    InputToFile(BaseStruct baseStruct, Rows rows) {
        this.struct = baseStruct;
        this.rows = rows;
    }

    void generateReport(){
        StringBuilder stringBuilder = new StringBuilder();

        ReportTitle title = new ReportTitle();
        title.generateLine(struct);
        stringBuilder.append(title);

        int heightPosition = struct.getHeight();
        for (DataRow row: rows.dataBase) {

            ReportRow line = new ReportRow();
            line.generateLine(row, struct);
            if((heightPosition - line.getHeight()) > 0){

                stringBuilder.append(line);
                heightPosition -= line.getHeight();
            }
            else{
                stringBuilder.append("~\n");
                heightPosition = struct.getHeight();
                stringBuilder.append(title);
                heightPosition -= title.getHeight();

                stringBuilder.append(line);
                heightPosition -= line.getHeight();
            }
        }
        report = stringBuilder.toString();
    }

    void input(String fileName){
        try {
            try(BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF16"))){
                bufferedWriter.write(report);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
