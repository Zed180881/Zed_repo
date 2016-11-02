package servicelevel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Long> {
    List<Contact> findByFirstName(String firstName);

    @Query("SELECT c FROM Contact c WHERE c.firstName=:firstName AND c.lastName=:lastName")
    Contact findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
