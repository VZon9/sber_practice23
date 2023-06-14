package reportbuilders;

import analyzers.Analyzer;
import java.util.Map;

public class ConsoleReportBuilder implements ReportBuilder{

    private final Analyzer analyzer;

    public ConsoleReportBuilder(Analyzer analyzer) {
        this.analyzer = analyzer;
    }

    @Override
    public void makeReport() {
        Map<String, Integer> tokenMap = analyzer.getTokenMap();
        int numOfToken = 0;
        for(String token: tokenMap.keySet()){
            numOfToken += tokenMap.get(token);
        }
        System.out.println("Number of tokens: " + numOfToken);
        for(String token: tokenMap.keySet()){
            System.out.println(token + " - " + tokenMap.get(token));
        }
    }
}
