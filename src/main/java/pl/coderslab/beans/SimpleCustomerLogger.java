package pl.coderslab.beans;

import org.springframework.stereotype.Component;
import pl.coderslab.CustomerLogger;

import java.time.LocalDateTime;


@Component
public class SimpleCustomerLogger implements CustomerLogger {

    @Override
    public void log() {
        System.out.println("<Aktualna data i godzina>: " + LocalDateTime.now() + " Customer operation;");
    }
}
