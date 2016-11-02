package spring4ch16.servicelevel;

import org.springframework.data.repository.PagingAndSortingRepository;
import spring4ch16.entity.Contact;

public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {
}
