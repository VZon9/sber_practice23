
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
            System.out.println(TimeCommandHelp());
        }
        else{
            Shall.PrintErrorUnknownCommand();
        }
    }

    private String TimeCommandHelp() {
        return "this command outputs the current time in the system";
    }

    @Override
    public String GetName() {
        return "time";
    }
}
