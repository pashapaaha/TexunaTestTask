import java.io.File;

public class ReportGenerator {

    public static void main(String[] args) {
        if(args.length < 3){
            System.out.println("Указаны не все параметры");
            return;
        }
        String xmlFileName;
        String tsvFileName;
        String outFileName;
        if (!checkFile(args[0])){
            System.out.println(args[0] + " : Не существует");
            return;
        }
        if(!validExpansion(args[0], "xml")){
            System.out.println(args[0] + " : Неверный формат");
        }
        if (!checkFile(args[1])){
            System.out.println(args[1] + " : Не существует");
            return;
        }
        if(!validExpansion(args[1], "tsv")){
            System.out.println(args[1] + " : Неверный формат");
        }

        xmlFileName = args[0];
        tsvFileName = args[1];
        outFileName = args[2];

        BaseStruct baseStruct = new BaseStruct(xmlFileName);
        Rows rows = new Rows(tsvFileName, baseStruct);
        InputToFile input = new InputToFile(baseStruct, rows);
        input.generateReport();
        input.input(outFileName);
    }

    private static boolean checkFile(String fileName){
        File file = new File(fileName);
        return file.exists();
    }

    private static boolean validExpansion(String filename, String expansion){
        return filename.split("\\.")[1].equals(expansion);
    }
}
