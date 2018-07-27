package hello.services;


import hello.Models.Devices;
import hello.Models.Owners;
import hello.repositorys.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceServices {

    @Autowired
    private DeviceRepository deviceRepository;

    public List<Devices> findAll(){
        return deviceRepository.findAll();
    }

    public Optional<Devices> findByID (Long POwnerID){
        return deviceRepository.findById(POwnerID);
    }

    public void save(Devices Pdev){
        deviceRepository.save(Pdev);
    }

    public void delete (Devices Pdev){
        deviceRepository.delete(Pdev);
    }

    public void  deleteByID(Long PdevID){
        deviceRepository.deleteById(PdevID);
    }

    public boolean isExist(Long PID) {
        return deviceRepository.existsById(PID);
    }
}
