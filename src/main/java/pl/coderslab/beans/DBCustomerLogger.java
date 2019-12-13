package pl.coderslab.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.coderslab.CustomerLogger;


//Zad 5.2 Klasa ma logować zmiany na klientach do bazy danych
//Zad 5.3 Dodaj sterownik bazy danych oraz utwórz ziarno zajmujące się zapisem do bazy.

@Component
public class DBCustomerLogger implements CustomerLogger {

    private CustomerLogger customerLogger;
    private String url;
    private String login;
    private String password;

    //Zad 5.5 Wstrzyknij za pomocą właściwości prostych dane wymagane do skonfigurowania połączenia.


    public DBCustomerLogger(String url, String login, String password) {
        this.url = url;
        this.login = login;
        this.password = password;
    }

    //Zad 6.1 Dla przykładu z poprzedniego zadania utwórz kwantyfikatory dla jednego z logerów.
    @Autowired
    public DBCustomerLogger(@Qualifier("fileCustomerLogger") CustomerLogger customerLogger) {
        this.customerLogger = customerLogger;
    }

    @Override
    public void log() {

    }
}
