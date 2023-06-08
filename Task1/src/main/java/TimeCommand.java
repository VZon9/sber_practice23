import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class TimeCommand implements Command{

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override
    public void Execute(String parameter) {
        if (parameter == null) {
            System.out.println("current time: " + dtf.format(LocalTime.now()));
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
        return "time";
    }

    @Override
    public String GetHelp() {
        return "this command outputs the current time in the system";
    }


}
