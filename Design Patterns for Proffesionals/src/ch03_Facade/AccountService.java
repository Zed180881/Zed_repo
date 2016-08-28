package ch03_Facade;

import javax.ejb.Stateless;

@Stateless
public class AccountService {
    boolean getLoan(double amount) {
        // check if bank vault has enough
        return true;
    }

    boolean setCustomerBalance(long id, double amount) {
        // set new customer balance
        return true;
    }
}
