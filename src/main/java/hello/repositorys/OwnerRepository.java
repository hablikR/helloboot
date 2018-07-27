package hello.repositorys;

import hello.Models.Owners;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository  extends JpaRepository<Owners,Long> {
}
