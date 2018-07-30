package hello.service;

import hello.model.Customer;
import hello.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServicesImpl implements  CustimerServices {

    private final CustomerRepository customerRepository;


    @Autowired
    public CustomerServicesImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = (List<Customer>) customerRepository.findAll();
        return customers;
    }

    @Override
    public Optional<Customer> findByID(Long PcustomerID) {
        return customerRepository.findById(PcustomerID);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public void delete(Long PcustomerID) {
        customerRepository.deleteById(PcustomerID);
    }

    @Override
    public boolean isExist(Long PID) {
        return customerRepository.existsById(PID);
    }


// Buisness Logic

    public List<Customer> getIDList(String pName) {
        ArrayList<Customer> newCustomerList = new ArrayList<>();
        for (Customer c : this.findAll()) {
            if (c.getName().equals(pName))
                newCustomerList.add(c);
        }
        return newCustomerList;

    }

    public Customer updateService(Long pID, String pName){
        Optional<Customer> optionalCustomerCustomer =  this.findByID(pID);
        Customer tCustomer = optionalCustomerCustomer.get();
        tCustomer.setName(pName);
        this.save(tCustomer);
        return tCustomer;
    }

    public Customer deleteService(Long pID){
        Optional<Customer> optionalCustomerCustomer =  findByID(pID);
        Customer tCustomer = optionalCustomerCustomer.get();
        delete(tCustomer);
        return tCustomer;
    }
}