package pl.coderslab.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.coderslab.beans.*;
import pl.coderslab.configuration.AppConfig;

//klasa startowa aplikacji Spring
public class SpringDiApplication {

    //DI - Dependecy injections = wstrzykiwanie zależności

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        //obiekt kontekstu na podstawie konfiguracji
        SimpleCustomerLogger simpleCustomerLogger = context.getBean("simpleCustomerLogger", SimpleCustomerLogger.class);
        //Pobierz od kontekstu ziarno a następnie wywołaj na nim metodę log
        simpleCustomerLogger.log();


        //Zad 3.5
        //W metodzie main pobierz ziarno repozytorium,
        MemoryCustomerRepository memoryCustomerRepository = context.getBean("memoryCustomerRepository", MemoryCustomerRepository.class);
        // utwórz użytkownika a następnie zapisz go używając metody z repozytorium.
        Customer customer = new Customer(1, "Ala", "Antolak");
        Customer customer1 = new Customer(2, "Ula", "Dudziak");
        memoryCustomerRepository.addCustomer(customer); //zapisanie użytkownika do listy
        memoryCustomerRepository.addCustomer(customer1);
        memoryCustomerRepository.getCustomerList(); //pobranie listy
        memoryCustomerRepository.deleteCustomer(customer); //usunięcie użytkownika
        memoryCustomerRepository.getCustomerList();


        //Zad 4.4
        FileCustomerLogger fileCustomerLogger = context.getBean("fileCustomerLogger", FileCustomerLogger.class);
        fileCustomerLogger.log();

        //Zad 5.5
        DBCustomerLogger dbCustomerLogger = context.getBean("dbCustomerLogger", DBCustomerLogger.class);
        dbCustomerLogger.log();

        context.close();

    }
}
