package com.company.service;
import com.company.entities.Client;
import java.util.List;


public interface ClientService {
    List<Client> addCustomer(Client customer);
    List<Client> updateCustomer(Client customer);
    List<Client> deleteCustomer(long customerId);
    Client findCustomerById(long customerId);
}