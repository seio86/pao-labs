# pao-labs Banking application

updates "etapa 2", with spacing:

creating csv files if not already in place
throws exception if csv files not created
reads the csv files
singletons in services
changed name to English for previous function and renamed to stage1() with the comment "deprecated"
logger MyLogFile.log which shows what actions were performed
streams and lambda
csv generated files will not be checked-in to github, they can be generated from the Banking app


list of requirements copied for reference below:

"0.5  - pull request corect (din main, pt etapa2, dupa ce etapa1 a fost mergeuita in main), commituri cu mesaje clare cu ce modificari ati facut in fiecare (nu cu 234876 de commituri diferite toate cu acelasi nume)
2p   - fisiere CSV pt minim 4 entitati (care vor contine date pe care le veti incarca la pornirea aplicatiei)
0.5p - structura fisier corecta pt csv-ul cu entitati (sa aiba header, sa fie formatat corect, sa aiba campurile corecte din entitati)
1p   - servicii singleton (fiecare serviciu pe care il aveti sa fie singleton, si facut corect)
2p   - folosire servicii generice pt scriere fisiere
2p   - folosire servicii generice pt citire fisiere
1p   - incarcare date din fisiere la pornirea aplicatiei in memorie la o colectie (dar si la CSV sincronizat)
1p   - persistare de entitati in csv in decursul rularii aplicatiei (ce voi salvati in colectii pana acum, o parte din ele vor trebui persistate in fisiere)
1p   - serviciu extra, de audit - scriere in fisier cand se executa actiunile - cu append, not override, cand se reporneste aplicatia, sa se adauge la logurile existente (nu trebuie sa faceti voi commit la fisierul vostru de audit, dar sa se creeze unul nou pt cei care ruleaza aplicatia)
0.5p - structura fisier corecta pt csv-ul pt audit
1p   - utilizare streams + lambda
1p   - utilizare exceptii (cu try catch pt fisiere)
0.5p - utilizare colectii in loc de array-uri, cu decuplare a implementarii de interfata (adica folosit interfete pt colectii)
1p   - corectare dupa code review"







-----------------------------------------------------------------------------

Readme de la etapa 1:
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
