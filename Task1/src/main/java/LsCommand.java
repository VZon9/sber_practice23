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
            System.out.println(GetHelp());
        }
        else{
            Shell.PrintErrorUnknownCommand();
        }
    }


    @Override
    public String GetName() {
        return "ls";
    }

    @Override
    public String GetHelp() {
        return "this command outputs all files of the current directory";
    }
}
