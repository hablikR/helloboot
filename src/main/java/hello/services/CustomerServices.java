package hello.services;

import hello.Customer;
import hello.repositorys.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServices {

    @Autowired
    private CustomerRepository customerRepository;

    public Iterable<Customer> findAll(){
        return customerRepository.findAll();
    }
    public void save(Customer customer){
         customerRepository.save(customer);
    }
}
