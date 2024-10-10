package sim.gym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sim.gym.model.Client;
import sim.gym.repository.ClientRepository;

import java.util.List;

// these annotations are to make the files
// part of the spring architecture
// using it all code is part of the same structure
// and let me add dependency injections
@Service
public class ClientService implements IClientService{
    // autoInjection
    @Autowired
    private ClientRepository clientRepository; // this will create an object

    @Override
    public List<Client> listOfClients() {
        // like CLient respository
        // implements jpa repository
        // and comibined with autowired I have access to an object
        // I also have access to the methods on JpaRepository
        return clientRepository.findAll();
    }

    @Override
    public Client searchClientById(Integer id) {
        // using the jpa again method find by id
        // if there is no client else null
       return clientRepository.findById(id).orElse(null);
    }

    @Override
    public void createClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }
}
