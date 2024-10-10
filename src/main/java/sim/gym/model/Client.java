package sim.gym.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data // creates getters and setters with lombok
@NoArgsConstructor // create the empty constructor
@AllArgsConstructor // create the constructor with all arguments
@ToString
@EqualsAndHashCode
public class Client {
    // This model contain the mapping of
    // the table Client on the db
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Integer is better for JPA(hibernate)
    private String name;
    private String lastname;
    private Integer membership;

    public Client(String name, String lastname, int membership) {
        this.name = name;
        this.lastname = lastname;
        this.membership = membership;
    }
}
