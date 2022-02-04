package edu.wctc;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "edu.wctc")
public class SalesApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SalesApp.class);
        context.refresh();
        ((ReportProvider)context.getBean("reportProvider")).printReports();

    }

    @Bean
    public SalesInput reader() {
        return new SalesReader();
    }

    @Bean
    public SalesReport reporter() {
        return new SummaryReport();
    }
}
