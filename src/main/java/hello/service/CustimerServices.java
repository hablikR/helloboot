package hello.service;

import hello.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustimerServices {

    List<Customer> findAll();

    Optional<Customer> findByID (Long PcustomerID);
    void save(Customer customer);
    void delete(Customer customer);
    void delete(Long PcustomerID);
    boolean isExist(Long PID);
}
