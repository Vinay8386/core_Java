package Java8_code.random_que;

import java.util.function.Supplier;

public class GenerateOtpUsingSupplierPFI {
    public static void main(String[] args) {
        generateOtp();
    }
    
    private static void generateOtp() {

        Supplier<String> supplier = () -> {

            /*
            * Approach 1: Generate OTP digit by digit
            *
            * Math.random() returns a double value between:
            * 0.0 (inclusive) and 1.0 (exclusive)
            *
            * Multiplying by 10 gives:
            * 0.0 to 9.999...
            *
            * Casting to int gives:
            * 0 to 9
            *
            * Example:
            * Math.random() = 0.6543
            * 0.6543 * 10 = 6.543
            * (int)6.543 = 6
            *
            * Running the loop 6 times guarantees a 6-digit OTP.
            */

            String otp = "";

            for (int i = 0; i < 6; i++) {
                otp = otp + (int) (Math.random() * 10);
            }

            return otp;

            /*
            * Approach 2: Generate a random number directly
            *
            * Math.random() returns:
            * 0.0 <= value < 1.0
            *
            * Multiplying by 1,000,000 gives:
            * 0 to 999999
            *
            * Example:
            * Math.random() = 0.654321
            * 0.654321 * 1000000 = 654321
            *
            * Note:
            * This does NOT always generate a 6-digit OTP.
            * Possible outputs:
            * 123
            * 4567
            * 98765
            * 654321
            *
            * To guarantee a 6-digit OTP:
            *
            * return String.valueOf(
            *          (int)(Math.random() * 900000) + 100000
            * );
            */
        };

        System.out.println(supplier.get());
    }
}
/*
| Approach                             | Guaranteed 6 Digits? | Example Output            |
| ------------------------------------ | -------------------- | ------------------------- |
| `for` loop                           | ✅ Yes                | `034781`                  |
| `(int)(Math.random()*1000000)`       | ❌ No                 | `1234`, `98765`, `654321` |
| `(int)(Math.random()*900000)+100000` | ✅ Yes                | `123456`, `987654`        |

*/


