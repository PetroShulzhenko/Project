package main;

import dbService.DBService;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SetupObjects {
    private static DBService dbService;
    private static String fromEmail;
    private static String emailPassword;
    private static ExecutorService executorService;
    private static HashMap<Long, String> couchesLongToString;
    private static HashMap<String, Long> couchesStringToLong;

    private SetupObjects() {
    }

    public static void init(String from, String password, int numberOfThreads) {
        dbService = new DBService();
        fromEmail = from;
        emailPassword = password;
        executorService = Executors.newFixedThreadPool(numberOfThreads);
        couchesLongToString = new HashMap<Long, String>();
        couchesStringToLong = new HashMap<String, Long>();
    }

    public static DBService getDbService() {
        return dbService;
    }

    public static String getFromEmail() {
        return fromEmail;
    }

    public static String getEmailPassword() {
        return emailPassword;
    }

    public static ExecutorService getExecutorService() {
        return executorService;
    }

    public static HashMap<Long, String> getCouchesLongToString() { return couchesLongToString; }

    public static HashMap<String, Long> getCouchesStringToLong() { return couchesStringToLong; }
}
