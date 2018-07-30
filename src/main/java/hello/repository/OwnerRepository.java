package hello.repository;

import hello.model.Owners;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository  extends JpaRepository<Owners,Long> {
}
