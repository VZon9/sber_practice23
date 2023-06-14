package reportbuilders;

import analyzers.Analyzer;
import java.io.FileWriter;
import java.util.Map;

public class TxtReportBuilder implements ReportBuilder{

    private final Analyzer analyzer;

    public TxtReportBuilder(Analyzer analyzer) {
        this.analyzer = analyzer;
    }

    @Override
    public void makeReport() {
        try{
            FileWriter fileWriter = new FileWriter(System.getProperty("user.dir") + "/Task4/report.txt", false);
            Map<String, Integer> tokenMap = analyzer.getTokenMap();
            int numOfToken = 0;
            for(String token: tokenMap.keySet()){
                numOfToken += tokenMap.get(token);
            }
            fileWriter.write("Number of tokens: " + numOfToken + '\n');
            for(String token: tokenMap.keySet()){
                fileWriter.write(token + " - " + tokenMap.get(token) + '\n');
            }
            fileWriter.flush();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
