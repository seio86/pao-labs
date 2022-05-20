package com.company.service;

import com.company.entities.Client;

import java.util.List;

public class ClientServiceImpl implements ClientService{
    private static ClientService INSTANCE;

    private ClientServiceImpl() {
    }

    private static ClientService getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new ClientServiceImpl();
        }
        return INSTANCE;
    }

    @Override
    public List<Client> addCustomer(Client customer) {
        return null;
    }

    @Override
    public List<Client> updateCustomer(Client customer) {
        return null;
    }

    @Override
    public List<Client> deleteCustomer(long customerId) {
        return null;
    }

    @Override
    public Client findCustomerById(long customerId) {
        return null;
    }
}
