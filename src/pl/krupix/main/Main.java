package pl.krupix.main;


import org.apache.log4j.PropertyConfigurator;

public class Main {

    public static void main(String[] args) {

        String log4jConfPath = "log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);


        Controller controller = new Controller();
        controller.control();
    }
}
