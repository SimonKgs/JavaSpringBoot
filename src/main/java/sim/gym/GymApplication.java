package sim.gym;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sim.gym.model.Client;
import sim.gym.service.IClientService;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class GymApplication implements CommandLineRunner {

	// Injecting the service
	@Autowired
	private IClientService clientService;
	// logger of the app
	private static final Logger logger = LoggerFactory.getLogger(GymApplication.class);

	public static void main(String[] args) {
		logger.info("Init the application");
		// on the logs I can see the spring factory
		SpringApplication.run(GymApplication.class, args);
		logger.info("application ends");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("***** GYM *****");
		gymApp();
	}

	private void gymApp() {
		boolean exit = false;
		Scanner scanner = new Scanner(System.in);
		while (!exit) {
			int action = showMenu(scanner);
			exit = executeAction(action, scanner);

		}

	}

	private int showMenu(Scanner scanner) {
		logger.info("""
				1. List clients
				2. Search client
				3. Create client
				4. Delete client
				5. exit
				""");
		return Integer.parseInt(scanner.nextLine());
	}
	
	private boolean executeAction(int action, Scanner scanner){
		boolean exit = false;
		switch (action){
			case 1 -> listClients();
			case 2 -> searchUserById(scanner);
			case 3 -> createUser(scanner);
			case 4 -> deleteUser(scanner);
			case 5 -> {
				logger.info("***** CLOSING GYM *****");
				exit = true;
			}
		}
		return exit;
	}

	private void listClients() {
		List<Client> clients = clientService.listOfClients();
		clients.forEach(client -> logger.info(client.toString()));
	}

	private void searchUserById(Scanner scanner) {
		logger.info("===== Searching client ===== ");
		logger.info("Insert client id: ");
		Integer clientId = Integer.parseInt(scanner.nextLine());
		Client client = clientService.searchClientById(clientId);
		logger.info("client found = {}", client);
	}

	private void createUser(Scanner scanner) {
		logger.info("===== Creating new client ===== ");
		logger.info("Insert client name: ");
		String name = scanner.nextLine();
		logger.info("Insert client lastname: ");
		String lastname = scanner.nextLine();
		logger.info("Insert client membership: ");
		int membership = Integer.parseInt(scanner.nextLine());
		clientService.createClient(new Client(name, lastname, membership));
	}

	private void deleteUser(Scanner scanner) {
		logger.info("===== Deleting client ===== ");
		logger.info("Insert client id to delete it: ");
		Integer clientId = Integer.parseInt(scanner.nextLine());
		Client client = clientService.searchClientById(clientId);
		clientService.deleteClient(client);
		logger.info("client deleted = {}", client);
	}
}
