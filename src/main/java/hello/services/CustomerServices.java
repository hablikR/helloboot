package hello.services;

import hello.Models.Customer;
import hello.repositorys.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServices {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public Optional<Customer> findByID (Long PcustomerID){
        return  customerRepository.findById(PcustomerID);
    }
    public void save(Customer customer){
         customerRepository.save(customer);
    }

    public void delete(Customer customer){
        customerRepository.delete(customer);
    }

    public void deleteByID(Long PcustomerID){
        customerRepository.deleteById(PcustomerID);
    }

    public boolean isExist(Long PID){
       return customerRepository.existsById(PID);
    }

}
