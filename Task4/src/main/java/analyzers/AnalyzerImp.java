package analyzers;

import parsers.Parser;
import java.util.HashMap;
import java.util.Map;

public class AnalyzerImp implements Analyzer{

    private final Parser parser;

    public AnalyzerImp(Parser parser) {
        this.parser = parser;
    }

    @Override
    public Map<String, Integer> getTokenMap() {
        Map<String, Integer> tokenMap = new HashMap<>();
        while (parser.HasNext()){
            String currToken = parser.getNext();
            if (tokenMap.containsKey(currToken)){
                tokenMap.replace(currToken, tokenMap.get(currToken) + 1);
            }
            else{
                tokenMap.put(currToken, 1);
            }
        }
        return tokenMap;
    }
}
