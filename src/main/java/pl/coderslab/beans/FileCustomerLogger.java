package pl.coderslab.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.coderslab.CustomerLogger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//zad 4.1 Utwórz implementację interfejsu CustomerLogger o nazwie FileCustomerLogger.

@Component
public class FileCustomerLogger implements CustomerLogger {

    //Klasa ma logować zmiany na klientach do pliku.
    //Dodaj w klasie właściwość String o nazwie filename,
    //zmodyfikuj ziarno tak aby wstrzyknąć właściwość prostą z nazwą pliku logu.

    private String filename;

    //konstruktor - wstrzyknięcie właściwości prostej z nazwą pliku logu
    public FileCustomerLogger(String filename) {
        this.filename = filename;
    }



    @Override
    public void log() {
        File file = new File(filename);
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter writer = new PrintWriter(fileWriter);

            //perform write operation:
            writer.println("jak zapisać operacje loga???");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
