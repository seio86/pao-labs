# pao-labs Aplicatie banking


Aplicatia gestioneaza un sistem bancar al unei banci, de exemplu interactiunea dintre clienti si banca, folosind produse.



Entitatile (clase pojo) au implementate constructorii, getterii si setterii.

1. Account
2. AccountType
3. Admin
4. Beneficiary
5. Client
6. Role : Admin sau Client
7. SavingsAccount
8. TermAccount
9. Transaction
10. User

		
###### Services
Mai degraba interfete mai jos
1. ClientService
		addCustomer(Client customer);
		updateCustomer(Client customer);
		deleteCustomer(long customerId);
		findCustomerById(long customerId);
		
2. AccountService
		addAccount(Account saving);
        addSavingsAccount(SavingsAccount saving);
        addTermAccount(TermAccount term);
        deleteSavingId(long accountId);
        deleteTermId(long accountId);
		getAccountByID(long accountId);
		deposit(double amount, long accountId);
        transferMoney(long senderAccountId, long receiverAccountId, double amount, long customerId, String password);
		
3. AdminService
		addAdmin(Admin admin);
		updateAdmin(Admin admin);
		deleteAdmin(long adminId);
		findAdminById(long adminId);
		listAllAdmin();
		
4.BeneficiaryService
		addBeneficiary(Beneficiary beneficiary);
		updateBeneficiary(Beneficiary beneficiary);
		deleteBeneficiary(long beneficiaryId);
		findBeneficiaryById(long beneficiaryId);
		listAllBeneficiaries(long accountId);

5. TransactionService
		createTransaction(Transaction transaction);
		viewTransaction(long transactionId);
		findTransactionById(long transactionId);
		getAllMyAccTransactions(long accountId);
		
6. UserService
		addNewUser(User user);
		updateUserInfo(User user);
		
clasa serviciu UserServiceImpl ce porneste de la interfata
1. UserServiceImpl
