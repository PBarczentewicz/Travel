package org.example.drivermenager;

public class DriverManagerFactory {
    public static ChromeDriverManager getManager(DriverType type) {

        ChromeDriverManager driverManager;

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            default:
                driverManager = new ChromeDriverManager();
        }
        return driverManager;
    }
}


