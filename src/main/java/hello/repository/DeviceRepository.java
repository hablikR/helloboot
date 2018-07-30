package hello.repository;

import hello.model.Devices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Devices,Long> {
}
