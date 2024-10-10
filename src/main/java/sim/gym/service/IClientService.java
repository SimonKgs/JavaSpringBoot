package sim.gym.service;

import sim.gym.model.Client;

import java.util.List;

public interface IClientService {
    // The interface to the service
    public List<Client> listOfClients();

    public Client searchClientById(Integer id);

    public void createClient(Client client);

    public void deleteClient(Client client);
}
