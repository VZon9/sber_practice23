import java.io.File;

public class LsCommand implements Command{
    private final File currDir= new File(System.getProperty("user.dir"));

    @Override
    public void Execute(String parameter) {
        if (parameter == null){
            File[] fileArr = currDir.listFiles();
            assert fileArr != null;
            for(File file: fileArr){
                System.out.println(file.getName());
            }
        }
        else if (parameter.equals("-h")){
            System.out.println(LsCommandHelp());
        }
        else{
            Shall.PrintErrorUnknownCommand();
        }
    }

    private String LsCommandHelp() {
        return "this command outputs all files of the current directory";
    }

    @Override
    public String GetName() {
        return "ls";
    }
}
