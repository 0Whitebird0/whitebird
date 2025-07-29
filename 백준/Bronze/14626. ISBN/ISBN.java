import java.io.*;

public class Main {
    static char[] isbn = new char[13];
    static int star_index = -1;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        for (int i = 0; i < 13; i++) {
            isbn[i] = input.charAt(i);
        }

        if (isbn[12] == '*') {
            for (int i = 0; i <= 9; i++) {
                result = isbn1(i);
                if (result != -1) break;
            }
        } else {
            for (int i = 0; i <= 11; i++) {
                if (isbn[i] == '*') {
                    star_index = i;
                    break;
                }
            }
            result = isbn2(star_index);
        }
        System.out.print(result);
    }

    static int isbn1(int num) {
        isbn[12] = (char)(num + '0');

        int sum = 0;
        for (int i = 0; i < 12; i++) {
            if (isbn[i] < '0' || isbn[i] > '9') {
                return -1;
            }
            int digit = isbn[i] - '0';

            if (i % 2 == 0) sum += digit;
            else sum += digit * 3;
        }

        int checkDigit = (10 - (sum % 10)) % 10;

        if (checkDigit == num) return num;
        else return -1;
    }

    static int isbn2(int starIndex) {
        if (isbn[12] < '0' || isbn[12] > '9') return -1;

        int lastDigit = isbn[12] - '0';

        for (int candidate = 0; candidate <= 9; candidate++) {
            isbn[starIndex] = (char)(candidate + '0');

            int sum = 0;
            boolean validInput = true;

            for (int i = 0; i < 12; i++) {
                if (isbn[i] < '0' || isbn[i] > '9') {
                    validInput = false;
                    break;
                }
                int digit = isbn[i] - '0';

                if (i % 2 == 0) sum += digit;
                else sum += digit * 3;
            }
            if (!validInput) continue;

            int checkDigit = (10 - (sum % 10)) % 10;

            if (checkDigit == lastDigit) return candidate;
        }

        return -1;
    }
}
