package com.company.service;
import com.company.entities.Beneficiary;
import java.util.List;
import java.util.Set;

public interface BeneficiaryService {
    List<Beneficiary> addBeneficiary(Beneficiary beneficiary);
    List<Beneficiary> updateBeneficiary(Beneficiary beneficiary);
    List<Beneficiary> deleteBeneficiary(long beneficiaryId);
    Beneficiary findBeneficiaryById(long beneficiaryId);
    Set<Beneficiary> listAllBeneficiaries(long accountId);
}
