public class QuitCommand implements Command{
    @Override
    public void Execute(String parameter) {
        if (parameter == null) {
            System.exit(0);
        }
        else{
            System.out.println(QuitCommandHelp());
        }
    }

    private String QuitCommandHelp() {
        return "this command terminates the program";
    }

    @Override
    public String GetName() {
        return "quit";
    }
}
