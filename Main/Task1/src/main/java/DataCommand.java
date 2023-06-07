import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataCommand implements Command{

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Override
    public void Execute(String parameter) {
        if (parameter == null) {
            System.out.println("current data: " + dtf.format(LocalDate.now()));
        }
        else if (parameter.equals("-h")){
            System.out.println(DataCommandHelp());
        }
        else{
            Shall.PrintErrorUnknownCommand();
        }
    }

    private String DataCommandHelp() {
        return "this command outputs the current data in the system";
    }

    @Override
    public String GetName() {
        return "data";
    }
}
