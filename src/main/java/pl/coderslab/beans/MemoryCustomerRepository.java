package pl.coderslab.beans;

import pl.coderslab.CustomerLogger;
import pl.coderslab.CustomerRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Zad 3.2. Klasa powinna zapisywać dane do wewnętrznie zdefiniowanej listy obiektów Customer - skorzystaj z ArrayList.
//Zad 3.3. Klasa ma zawierać pole typu CustomerLogger, wstrzyknij odpowiednią zależność.
//Zad 3.4. Zmodyfikuj metody klasy MemoryCustomerRepository dodając logowanie w każdej z metod. (wywołaj metodę log()).


public class MemoryCustomerRepository implements CustomerRepository {


    //Zad.3.3. wstrzykiwanie zależności przez konstruktor
//    private CustomerLogger customerLogger;
//    private List<Customer> customers;
//
//
//    public MemoryCustomerRepository(CustomerLogger customerLogger) {
//        this.customerLogger = customerLogger;
//        this.customers = new ArrayList<>();
//    }

    //Zad.3.4
//    @Override
//    public void addCustomer(Customer customer) {
//        customerLogger.log();
//        customers.add(customer);
//        System.out.println("Added customer: " + customer.getFirstName() + " " + customer.getLastName() );
//    }
//
//    @Override
//    public void deleteCustomer(Customer customer) {
//        customerLogger.log();
//
//        Iterator<Customer> iterator = customers.iterator();
//        while (iterator.hasNext()) {
//            if(iterator.next()==customer) {
//                iterator.remove();
//            }
//        }
//        System.out.println("Customer deleted");
//    }
//
//    @Override
//    public void getCustomerList() {
//        customerLogger.log();
//
//        for (Customer c : customers) {
//            System.out.println(c);
//        }
//    }


    //Zad 4.4 Zmodyfikuj definicje wstrzykiwania tak aby repozytorium korzystało z nowego loggera.
    private FileCustomerLogger fileCustomerLogger;
    private List<Customer> customers;

    public MemoryCustomerRepository(FileCustomerLogger fileCustomerLogger) {
        this.fileCustomerLogger = fileCustomerLogger;
        this.customers = new ArrayList<>();
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Added customer: " + customer.getFirstName() + " " + customer.getLastName());
        fileCustomerLogger.log();
    }

    @Override
    public void deleteCustomer(Customer customer) {

        Iterator<Customer> iterator = customers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == customer) {
                iterator.remove();
            }
        }
        System.out.println("Customer deleted");

        fileCustomerLogger.log();
    }

    @Override
    public void getCustomerList() {
        for (Customer c : customers) {
            System.out.println(c);
        }
        fileCustomerLogger.log();
    }
}



