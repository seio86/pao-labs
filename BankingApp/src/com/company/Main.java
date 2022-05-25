package com.company;

import com.company.config.DatabaseConfiguration;
import com.company.entities.*;
import com.company.csv.CsvReader;
import com.company.csv.CsvReaderImpl;
import com.company.csv.CsvWriter;
import com.company.csv.CsvWriterImpl;
import com.company.repository.AccountRepositoryUsingPreparedStatement;
import com.company.repository.BeneficiaryRepository;
import com.company.repository.ClientRepository;
import com.company.repository.TransactionRepository;
import com.company.service.MyLoggerService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Main {
    public static int uid = 0;
    //    public static Logger logger;
    private static Scanner scanner;
    public static List<Account> accountsList;
    public static List<Client> clientsList;
    public static List<Transaction> transactionsList;
    public static List<Beneficiary> beneficiariesList;
    public static MyLoggerService myLogger;


    public static void main(String[] args) throws IOException {
        initLogger();
//        stage1();  //function is deprecated
        readPersistedCollections();
        printCollections();

        Account testAccount = accountsList.get(0);
        try {
            restartTables();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        BeneficiaryRepository beneficiaryRepository = new BeneficiaryRepository();
        ClientRepository clientRepository = new ClientRepository();
        TransactionRepository transactionRepository = new TransactionRepository();

        // add 2 beneficiaries to db ( for acc 1)
        Beneficiary beneficiary1 = testAccount.getBeneficiaries().get(1);
        beneficiary1.setAccount(testAccount);
        Beneficiary beneficiary2 = testAccount.getBeneficiaries().get(1);
        beneficiary2.setAccount(testAccount);

        beneficiaryRepository.insert(beneficiary1);
        beneficiaryRepository.insert(beneficiary2);

        // add 2 clients to db ( for acc 1)
        Client client1 = testAccount.getClient().get(1);
        client1.setAccountNo(testAccount.getAccountId());
        clientRepository.insert(client1);

        Client client2 = testAccount.getClient().get(2);
        client2.setAccountNo(testAccount.getAccountId());
        clientRepository.insert(client2);

        // add 2 trans to db ( for acc 1)
        transactionRepository.insert(testAccount.getTransaction().get(1));
        transactionRepository.insert(testAccount.getTransaction().get(2));

        AccountRepositoryUsingPreparedStatement accountRepo = new AccountRepositoryUsingPreparedStatement(
                transactionRepository,clientRepository, beneficiaryRepository);

        accountRepo.insertAccount(testAccount);
        System.out.println( "I added " + testAccount);

        System.out.println("I took out " +  accountRepo.getAccountById(1));

        //    writeAndPopulateDataToCsv();// to comment this line once the CSV files are written and populated
        commandLine();

    }






    private static void commandLine() {
        scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            myLogger.info(command);
//            logger.info(command);
        }
    }
    private static void restartTables() throws SQLException {
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        Statement statement = connection.createStatement();
        statement.execute("DROP TABLE IF EXISTS `CLIENT`;");
        statement.execute(
                "CREATE TABLE `client` (\n" +
                        "  `id` int(6) UNSIGNED PRIMARY KEY AUTO_INCREMENT,\n" +
                        "  `name` varchar(20) DEFAULT NULL,\n" +
                        "  `phone_no` varchar(20) DEFAULT NULL,\n" +
                        "  `email` varchar(20) DEFAULT NULL,\n" +
                        "  `account_id` int(11) DEFAULT NULL\n" +
                        ")"
        );

        statement.execute("DROP TABLE IF EXISTS `BENEFICIARY`;");
        statement.execute("" +
                "CREATE TABLE `beneficiary` (\n" +
                "  `id` int(6) UNSIGNED PRIMARY KEY AUTO_INCREMENT,\n" +
                "  `beneficiaryId` int(11) DEFAULT NULL,\n" +
                "  `beneficiaryName` varchar(20) DEFAULT NULL,\n" +
                "  `beneficiaryAccNo` int(11) DEFAULT NULL,\n" +
                "  `accountType` varchar(20) DEFAULT NULL,\n" +
                "  `account_id` int(11) DEFAULT NULL\n" +
                ")"
        );

        statement.execute("DROP TABLE IF EXISTS `ACCOUNT`;");
        statement.execute("" +
                "CREATE TABLE `account` (\n" +
                "  `ID` int(11) PRIMARY KEY AUTO_INCREMENT,\n" +
                "  `account_id` int(11) NOT NULL,\n" +
                "  `INTEREST` float DEFAULT NULL,\n" +
                "  `BALANCE` float DEFAULT NULL,\n" +
                "  `TYPE` varchar(20) DEFAULT NULL\n" +
                ")"
        );

        statement.execute("DROP TABLE IF EXISTS `TRANSACTION` ;");
        statement.execute("" +
                "CREATE TABLE `transaction` (\n" +
                "  `id` int(6) UNSIGNED PRIMARY KEY AUTO_INCREMENT,\n" +
                "  `from` float DEFAULT NULL,\n" +
                "  `to` float DEFAULT NULL,\n" +
                "  `amount` varchar(20) DEFAULT NULL,\n" +
                "  `pin` varchar(20) DEFAULT NULL\n" +
                ")"
        );
    }
    private static void printCollections() {
        System.out.println("\nACCOUNTS");
        System.out.println("accountsList = " + accountsList);
        //   accountsList.sort(new Account()); //to be used only after CSV files with data are created
        //   accountsList.forEach(account -> System.out.println(account + "\n"));
        System.out.println("\nCLIENTS");
        System.out.println("clientsList = " + clientsList);
        System.out.println("\nTRANSACTIONS");
        System.out.println("transactionsList = " + transactionsList);
        System.out.println("\nBENEFICIARIES");
        System.out.println("beneficiariesList = " + beneficiariesList);
    }

    private static void writeAndPopulateDataToCsv() throws IOException {
        //creating beneficiaries
        Map<Integer, Beneficiary> beneficiaries = new HashMap<>();
        beneficiaries.put(1, new Beneficiary(1, "Name 1", 12, AccountType.CURRENT));
        beneficiaries.put(2, new Beneficiary(2, "Name 2", 23, AccountType.CURRENT));

        Map<Integer, Beneficiary> beneficiaries1 = new HashMap<>();
        beneficiaries1.put(3, new Beneficiary(3, "Name 3", 23, AccountType.CURRENT));
        beneficiaries1.put(4, new Beneficiary(4, "Name 4", 24, AccountType.CURRENT));

        // creating clients
        Map<Integer, Client> clientMap = new HashMap<>();
        clientMap.put(1, new Client(1, "Name Client 1", "0750708396", "ionela@gmail.com"));
        clientMap.put(2, new Client(2, "Name Client 2", "0740708396", "ionescu@gmail.com"));

        Map<Integer, Client> clientMap1 = new HashMap<>();
        clientMap1.put(3, new Client(3, "Name Client 3", "0752708396", "alexandra@gmail.com"));
        clientMap1.put(4, new Client(4, "Name Client 4", "0750728396", "sebastian@gmail.com"));

        // making transactions
        Map<Integer, Transaction> transactions = new HashMap<>();
        transactions.put(1, new Transaction(1, 1, 0, 10, 1234));
        transactions.put(2, new Transaction(2, 1, 0, 15, 1000));

        Map<Integer, Transaction> transactions1 = new HashMap<>();
        transactions1.put(3, new Transaction(3, 1, 0, 120, 1111));
        transactions1.put(4, new Transaction(4, 1, 0, 100, 2222));

        // make accounts and set it for beneficiary and client
        Account account = new Account(1, 2, 3300, AccountType.CURRENT, transactions, clientMap, beneficiaries);
        beneficiaries.get(1).setAccount(account);
        beneficiaries.get(2).setAccount(account);
        clientMap.get(1).addAccount(account);
        clientMap.get(2).addAccount(account);

        Account account1 = new Account(2, 3, 3300, AccountType.CURRENT, transactions1, clientMap1, beneficiaries1);
        beneficiaries1.get(3).setAccount(account1);
        beneficiaries1.get(4).setAccount(account1);
        clientMap1.get(3).addAccount(account1);
        clientMap1.get(4).addAccount(account1);

        Account account2 = new Account(3, 3, 100, AccountType.CURRENT, transactions1, clientMap1, beneficiaries1);
        beneficiaries.get(1).setAccount(account2);
        clientMap.get(1).addAccount(account2);


        // write to CSV
        CsvWriter<Account> accountCsvWriter = new CsvWriterImpl<>();
        CsvWriter<Beneficiary> beneficiaryCsvWriter = new CsvWriterImpl<>();
        CsvWriter<Client> clientCsvWriter = new CsvWriterImpl<>();
        CsvWriter<Transaction> transactionCsvWriter = new CsvWriterImpl<>();

        accountCsvWriter.writeToCsv(account);
        accountCsvWriter.writeToCsv(account1);
        accountCsvWriter.writeToCsv(account2);

        beneficiaryCsvWriter.writeToCsv(beneficiaries.get(1));
        beneficiaryCsvWriter.writeToCsv(beneficiaries.get(2));
        beneficiaryCsvWriter.writeToCsv(beneficiaries1.get(3));
        beneficiaryCsvWriter.writeToCsv(beneficiaries1.get(4));

        clientCsvWriter.writeToCsv(clientMap.get(1));
        clientCsvWriter.writeToCsv(clientMap.get(2));
        clientCsvWriter.writeToCsv(clientMap1.get(3));
        clientCsvWriter.writeToCsv(clientMap1.get(4));

        transactionCsvWriter.writeToCsv(transactions.get(1));
        transactionCsvWriter.writeToCsv(transactions.get(2));
        transactionCsvWriter.writeToCsv(transactions1.get(3));
        transactionCsvWriter.writeToCsv(transactions1.get(4));
    }

    private static void readPersistedCollections() {
        try {
            CsvReader<Account> accountCsvReader = new CsvReaderImpl<>();
            accountsList = accountCsvReader.readFromCsv(new Account());

            CsvReader<Client> clientCsvReader = new CsvReaderImpl<>();
            clientsList = clientCsvReader.readFromCsv(new Client());

            CsvReader<Transaction> transactionCsvReader = new CsvReaderImpl<>();
            transactionsList = transactionCsvReader.readFromCsv(new Transaction());

            CsvReader<Beneficiary> beneficiaryCsvReader = new CsvReaderImpl<>();
            beneficiariesList = beneficiaryCsvReader.readFromCsv(new Beneficiary());
        } catch (RuntimeException e) {
            myLogger.severe("Catched RuntimeException: There is NO csv data to read from, please run writeAndPopulateDataToCsv() first! ");
            //e.printStackTrace();
        }
    }

    private static void initLogger() throws IOException {
//        scanner = new Scanner(System.in);
//        logger = Logger.getLogger(Main.class.getName());
//        FileHandler fh = new FileHandler("MyLogFile.log", true);
//        logger.addHandler(fh);
//        SimpleFormatter formatter = new SimpleFormatter();
//        fh.setFormatter(formatter);
        myLogger = new MyLoggerService("MYLOGGER.LOG", true);
    }

    private static void stage1() {
        //        cream  obiecte
        Accounts_stage1 ionpope = new Accounts_stage1("Ion Popescu ", "A00001");
        Accounts_stage1 iriione = new Accounts_stage1("Irina Ionescu", "B00002");
        Accounts_stage1 davste = new Accounts_stage1("David Stefanescu ", "A00003");
        Accounts_stage1 adidum = new Accounts_stage1("Adina Dumitrescu", "B00004");
        Accounts_stage1 gabmal = new Accounts_stage1("Gabriel Malaimare ", "A00005");
        Accounts_stage1 marper = new Accounts_stage1("Maria Pericica", "B00006");
        Accounts_stage1 adrcot = new Accounts_stage1("Adrian Cotnarean ", "A00007");
        Accounts_stage1 erdene = new Accounts_stage1("Erdina Ene", "B00008");

        //presupunem ca au avut ceva bani depozitati la deschiderea de cont
        ionpope.depoziteaza(1000);
        iriione.depoziteaza(20000);
        davste.depoziteaza(3000);
        adidum.depoziteaza(40000);
        gabmal.depoziteaza(5000);
        marper.depoziteaza(60000);
        adrcot.depoziteaza(7000);
        erdene.depoziteaza(80000);
        erdene.depoziteaza(9000);
        marper.depoziteaza(100000);
        //apoi putem alege diferite meniuri pentru Irina Ionescu de exemplu
        iriione.arataMeniu();
    }
}
