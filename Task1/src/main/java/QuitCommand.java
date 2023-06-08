public class QuitCommand implements Command{
    @Override
    public void Execute(String parameter) {
        if (parameter == null) {
            System.exit(0);
        }
        else{
            System.out.println(GetHelp());
        }
    }

    @Override
    public String GetName() {
        return "quit";
    }

    @Override
    public String GetHelp() {
        return "this command terminates the program";
    }
}
