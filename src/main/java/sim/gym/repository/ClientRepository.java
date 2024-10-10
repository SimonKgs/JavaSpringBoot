package sim.gym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sim.gym.model.Client;

// to use Jpa,it needs to extend from this interface
// passing as params the class and the type of the primary key
public interface ClientRepository extends JpaRepository<Client, Integer>{}
