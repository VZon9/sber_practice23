package configuration;

import analyzers.Analyzer;
import analyzers.AnalyzerImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import parsers.Parser;
import parsers.TxtFileParser;
import reportbuilders.ReportBuilder;
import reportbuilders.XMLReportBuilder;


@Configuration
public class AppConfig {

    @Bean
    public Parser parser(){
        return new TxtFileParser(System.getProperty("user.dir") + "/Task4/test.txt");
    }

    @Bean
    public Analyzer analyzer(){
        return new AnalyzerImp(parser());
    }

    @Bean
    public ReportBuilder reportBuilder(){
        return new XMLReportBuilder(analyzer());
    }
}
