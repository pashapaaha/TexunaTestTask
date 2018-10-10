public class ReportLine {

    private int height = 1;
    private String line;

    public ReportLine(BaseStruct baseStruct) {

    }

//    private String[] splitValue(String value){
//        return value.split("\\W");
//    }

    void generateLine(BaseStruct baseStruct, DataRow row){
        StringBuilder lineBuilder = new StringBuilder("");

        lineBuilder.append('|');
        for(int i = 0; i < row.columns.size(); i++){
            int j = 0;
            //while(j < row.columns.get(i).getValue())
        }
    }
}
