package app;

import configuration.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import reportbuilders.ReportBuilder;

public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        ReportBuilder reportBuilder = applicationContext.getBean(ReportBuilder.class);
        reportBuilder.makeReport();
    }
}
