package hello.repositorys;

import hello.Models.Devices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Devices,Long> {
}
