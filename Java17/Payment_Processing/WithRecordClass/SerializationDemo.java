package Java17.Payment_Processing.WithRecordClass;

import java.io.*;

public class SerializationDemo {

    public static void main(String[] args) throws Exception {

        // Create an object that we want to serialize
        Payment payment = new UpiPayment("abc@ybl", 567);

        /*
         * FileOutputStream:
         * Creates (or opens) the file "payment.ser" and provides a
         * connection to write bytes into that file.
         *
         * ObjectOutputStream:
         * Wraps FileOutputStream and converts Java objects into a
         * stream of bytes (serialization) before writing them to the file.
         */
        ObjectOutputStream out =
                new ObjectOutputStream(
                        new FileOutputStream("payment.ser"));

        /*
         * Serialize the Payment object.
         *
         * Internally:
         * Payment Object
         *      ↓
         * ObjectOutputStream converts object into bytes
         *      ↓
         * FileOutputStream writes those bytes into payment.ser
         */
        out.writeObject(payment);

        // Release system resources and flush any remaining data to the file
        out.close();

        System.out.println("Payment serialized successfully");
    }
}
