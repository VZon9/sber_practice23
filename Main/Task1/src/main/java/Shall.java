import java.util.HashMap;
import java.util.Scanner;

public class Shall {
    public static HashMap<String, Command> CommandManager = new HashMap<>();

    public static void PrintErrorUnknownCommand(){
        System.out.println("unknown command");
        System.out.println("list of all commands:");
        for(String command: CommandManager.keySet()){
            System.out.println(command);
        }
        System.out.println("each of these commands has a parameter -h");
        System.out.println("example: \"command\" -h");
    }

    public static void main(String[] args) {
        Command time = new TimeCommand();
        CommandManager.put(time.GetName(), time);
        Scanner in = new Scanner(System.in);

        String currCommand;
        String[] SplitCommand;

        while (true){
            System.out.print(">");
            currCommand = in.nextLine().trim();
            SplitCommand = currCommand.split(" ");
            if(CommandManager.containsKey(SplitCommand[0])){
                if(SplitCommand.length == 1) {
                    CommandManager.get(SplitCommand[0]).Execute(null);
                }
                else if (SplitCommand[1].equals("-h")){
                    CommandManager.get(SplitCommand[0]).Execute(SplitCommand[1]);
                }
                else {
                    PrintErrorUnknownCommand();
                }
            }
            else{
                PrintErrorUnknownCommand();
            }
        }

    }
}
