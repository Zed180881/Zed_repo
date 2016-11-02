package springdatajpa.service;

import org.springframework.data.repository.CrudRepository;
import springdatajpa.entity.ContactAudit;

public interface ContactAuditRepository extends CrudRepository<ContactAudit, Long> {
}
