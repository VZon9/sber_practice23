package util;

public class ParserUtil {
    static public int getIndexSkipSpace(int spacePos, String text){
        int pos = spacePos;
        while(pos < text.length() && (text.charAt(pos) == ' ' || text.charAt(pos) == '\t')){
            pos++;
        }
        return pos;
    }

}
