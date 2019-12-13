package pl.coderslab.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.coderslab.beans.*;
import pl.coderslab.beans.SimpleCustomerLogger;



@Configuration
public class AppConfig {

    //SimpleCustomerLogger - powinno być ziarnem zarządzanym przez Springa
    //Dodając adnotację @Bean określamy, że element zwracany przez metodę staje się ziarnem Springa.
    @Bean
    public SimpleCustomerLogger simpleCustomerLogger() {
        return new SimpleCustomerLogger();
    }

    //Zad. 3
//    @Bean
//    public MemoryCustomerRepository memoryCustomerRepository() {
//        return new MemoryCustomerRepository(simpleCustomerLogger());
//    }

    //Zad 4.3.
    @Bean
    public FileCustomerLogger fileCustomerLogger() {
        return new FileCustomerLogger("/Users/monikamisiewicz/Desktop/code/repositories/spring/Homework_01/src/main/resources/customers.txt");
    }

    //Zad 4.4. Zmodyfikuj definicje wstrzykiwania tak aby repozytorium korzystało z nowego loggera.
    @Bean
    public MemoryCustomerRepository memoryCustomerRepository() {
        return new MemoryCustomerRepository(fileCustomerLogger());
    }

    //Zad 5.3 Utwórz ziarno zajmujące się zapisem do bazy.
    //Zad 5.6 Wstrzyknij ziarno odpowiedzialne za połączenie do nowego loggera.
    @Bean
    public DBCustomerLogger dbCustomerLogger() {
        return new DBCustomerLogger("jdbc:mysql://localhost:3306/customer_logs?useSSL=false", "root", "coderslab");
    }


}
