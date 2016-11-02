package hibernatejpa.service;

import hibernatejpa.entity.ContactSummary;

import java.util.List;

public interface ContactSummaryService {
    List<ContactSummary> findAll();
}
