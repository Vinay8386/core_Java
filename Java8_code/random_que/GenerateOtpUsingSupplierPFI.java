package Java8;

import java.util.function.Supplier;

public class GenerateOtpUsingSupplierPFI {
    public static void main(String[] args) {
        generateOtp();
    }
    private static void generateOtp() {
        Supplier<String> s=()->{
            String otp=" ";
            for (int i = 0; i < 6; i++) {
                otp=otp+(int)(Math.random()*10);
            }
            return otp;
        };
        s.get();
        System.out.println(s.get());
    }
}
