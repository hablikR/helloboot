package hello.services;

import hello.Models.Customer;
import hello.Models.Owners;
import hello.repositorys.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServices {

    @Autowired
    private OwnerRepository ownerRepository;

    public List<Owners> findAll(){
        return ownerRepository.findAll();
    }

    public Optional<Owners> findByID (Long POwnerID){
        return ownerRepository.findById(POwnerID);
    }

    public void save(Owners Powner){
        ownerRepository.save(Powner);
    }

    public void delete (Owners Powner){
        ownerRepository.delete(Powner);
    }

    public void  deleteByID(Long PownerID){
        ownerRepository.deleteById(PownerID);
    }

    public boolean isExist(Long PID) {
        return ownerRepository.existsById(PID);
    }

}
