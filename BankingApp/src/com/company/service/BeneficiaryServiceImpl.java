package com.company.service;

import com.company.entities.Beneficiary;

import java.util.List;
import java.util.Set;

public class BeneficiaryServiceImpl implements BeneficiaryService {
    private static BeneficiaryService INSTANCE;

    private BeneficiaryServiceImpl() {
    }

    private static BeneficiaryService getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new BeneficiaryServiceImpl();
        }
        return INSTANCE;
    }


    @Override
    public List<Beneficiary> addBeneficiary(Beneficiary beneficiary) {
        return null;
    }

    @Override
    public List<Beneficiary> updateBeneficiary(Beneficiary beneficiary) {
        return null;
    }

    @Override
    public List<Beneficiary> deleteBeneficiary(long beneficiaryId) {
        return null;
    }

    @Override
    public Beneficiary findBeneficiaryById(long beneficiaryId) {
        return null;
    }

    @Override
    public Set<Beneficiary> listAllBeneficiaries(long accountId) {
        return null;
    }
}
