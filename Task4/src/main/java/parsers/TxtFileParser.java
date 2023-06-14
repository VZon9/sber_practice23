package parsers;

import util.ParserUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TxtFileParser implements Parser{
    private int pos = 0;
    private String text = "";

    public TxtFileParser(String filePath) {
        File file = new File(filePath);
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                text += scanner.nextLine() + " ";
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
