package Singleton;

import java.util.logging.Logger;

public class Main {

    // Logger instance
    private static final Logger logger =
            Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        logger.info("Application Started");

        SingletonWithFunction obj =
                SingletonWithFunction.getInstance();

        obj.showMessage();
    }
}
