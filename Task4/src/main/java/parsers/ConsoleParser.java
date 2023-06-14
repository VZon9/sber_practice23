package parsers;

import util.ParserUtil;
import java.util.Scanner;

public class ConsoleParser implements Parser {

    private int pos = 0;
    private String text = "";

    public ConsoleParser() {
        Scanner in = new Scanner(System.in);
        text += in.nextLine();
        in.close();
    }

    @Override
    public String getNext() {
        String token = "";
        pos = ParserUtil.getIndexSkipSpace(pos, text);
        while(pos < text.length() && text.charAt(pos) != ' ' && text.charAt(pos) != '\t'){
            token += text.charAt(pos);
            pos++;
        }
        pos = ParserUtil.getIndexSkipSpace(pos, text);
        return token;
    }

    @Override
    public boolean HasNext() {
        return pos < text.length();
    }
}
