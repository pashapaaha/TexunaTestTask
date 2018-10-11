class InputToFile {

    private BaseStruct struct;
    private Rows rows;
    private String filename;

    InputToFile(BaseStruct baseStruct, Rows rows, String fileName) {
        this.struct = baseStruct;
        this.rows = rows;
        this.filename = fileName;
    }

    void generateReport(){
        StringBuilder stringBuilder = new StringBuilder();
        int heightPosition = struct.getHeight();
        for (DataRow row: rows.dataBase) {

            ReportLine line = new ReportLine();
            line.generateLine(row, struct);
            if((heightPosition - line.getHeight()) > 0){

                stringBuilder.append(line);
                heightPosition -= line.getHeight();
            }
            else{
                stringBuilder.append("~\n");
                heightPosition = struct.getHeight();

                stringBuilder.append(line);
                heightPosition -= line.getHeight();
            }
            System.out.println(line.getHeight());
        }
        System.out.println(stringBuilder);
    }

}
