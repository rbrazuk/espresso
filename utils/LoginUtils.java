import java.util.Random;

public class LoginUtils {
    public static String randomEmail(int length) {

        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String atExample = "@example.com";
        String emailFirstHalf = "";


        for (int i = 0; i < length; i++) {
            Random random = new Random();
            Integer randomNumber = random.nextInt(alpha.length());

            String randomLetter = Character.toString(alpha.charAt(randomNumber));

            emailFirstHalf = emailFirstHalf + randomLetter;
        }

        String email = emailFirstHalf + atExample;

        return email;
    }

    public static String validRandomEmail(String email,int length) {

        String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
        String parts[] = email.split("@");
        String firstHalf = parts[0];
        String secondHalf = parts[1];
        String randoms = "";

        Random random = new Random();

        for (int i = 0; i < length; i++) {
            char randomChar = chars.charAt(random.nextInt(chars.length()));
            randoms = randoms + randomChar;
        }

        String validEmail = firstHalf + "+" + randoms + "@" + secondHalf;

        return validEmail;
    }

    public static String randomPassword(int characters, int numbers, boolean caps) {

        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String password = "";

        for(int i = 0; i < characters; i++) {
            Random random = new Random();
            Integer randomNumber = random.nextInt(alpha.length());

            String randomLetter = Character.toString(alpha.charAt(randomNumber));

            password = password + randomLetter;

        }

        for(int i = 0; i < numbers; i++) {
            Random random = new Random();
            int digits = random.nextInt(10);
            password = password + digits;
        }

        if(caps) {
            password = password.substring(0,1).toUpperCase() + password.substring(1);
        }

        return password;
    }
}
