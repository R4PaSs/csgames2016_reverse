package org.csgames;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Java1 {

    public static void main(String[] args) {
        System.out.println("===============================================");
        System.out.println("#  WELCOME TO THE PSEUDO REVERSING CHALLENGE  #");
        System.out.println("===============================================");
        System.out.println();

        System.out.println("Just so you know, reversing Java isn't serious.");
        System.out.println("You're lucky there are some kind guys out there...");
        System.out.println("I'm not one of those so you still have some work to do.");
        System.out.println("Let see if you can find the password.");

        System.out.print("Enter the password : ");

        String pass = new Scanner(System.in).nextLine();


//        if (isValidPassword(pass)) {
//            System.out.println("You got it ! UQAM{FLAG}");
//        }
        if (shiftFuck("R3v3rs1ng_J4v4_1s_S0_Much_Fun".toCharArray())) {
            System.out.println("YOU WON!");
        }
        reverseShiftFuck("");


    }

    private static boolean isValidPassword(String pass) {
        long result = 97;
        String password = "R3v3rs1ng_J4v4_1s_S0_Much_Fun";
        char[] chars = password.toCharArray();
        byte[] test = new String(chars).getBytes(StandardCharsets.UTF_8);

        for (int i = 0; i < password.length(); i++) {
            //System.out.println("" + test[i]);
            result += test[i] * 607;
        }

        System.out.println(result);
        shiftFuck("R3v3rs1ng_J4v4_1s_S0_Much_Fun".toCharArray());
        //reverseShiftFuck("");
        return true;

    }

    private static boolean shiftFuck(char[] pass) {
        int[] bytes = {
                0x94, 0xd1, 0x9d, 0xd1, 0x95, 0xd5, 0xc1, 0x1f, 0x5d, 0xde, 0x16, 0x89, 0x9d, 0x89, 0xde, 0xc1,
                0xd5, 0xde, 0xd4, 0x81, 0xde, 0x4e, 0xcd, 0x55, 0x7, 0xde, 0x1c, 0xcd, 0x1f,
        };

        if (bytes.length != pass.length) {
            return false;
        }

        ArrayList<Integer> out = new ArrayList<>();

        //0x1, 0x2, 0x4, 0x8, 0x16, 0x32, 0x64
        for (int i = 0; i < pass.length; i++) {
            int result = 0;
            result += ((pass[i] & 0x1) << 6);   // pos 7
            result += ((pass[i] & 0x2) << 3); // pos 5
            result += ((pass[i] & 0x4) << 1); // pos 4
            result += ((pass[i] & 0x8) >> 2); // pos 2
            result += ((pass[i] & 0x10) << 3); // pos 8
            result += ((pass[i] & 0x20) >> 5); // pos 1
            result += ((pass[i] & 0x40) >> 4); // pos 3
            result += ((pass[i] & 0x80) >> 2); // pos 6

            if ((result & 0xff) != bytes[i]) {
                return false;
            }

            out.add(result & 0xff);
        }


        for (int i = 0; i < out.size(); i++) {
            System.out.print("0x" + Integer.toHexString(out.get(i)) + ", ");
        }

        System.out.println();
        return true;
    }

    private static boolean reverseShiftFuck(String pass) {
        int[] chars = {
                0x94, 0xd1, 0x9d, 0xd1, 0x95, 0xd5, 0xc1, 0x1f, 0x5d, 0xde, 0x16, 0x89, 0x9d, 0x89, 0xde, 0xc1,
                0xd5, 0xde, 0xd4, 0x81, 0xde, 0x4e, 0xcd, 0x55, 0x7, 0xde, 0x1c, 0xcd, 0x1f,
        };

        ArrayList<Character> out = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            int result = 0;
            result += ((chars[i] & 0x1) << 5);   // pos 6
            result += ((chars[i] & 0x2) << 2); // pos 4
            result += ((chars[i] & 0x4) << 4); // pos 7
            result += ((chars[i] & 0x8) >> 1); // pos 3
            result += ((chars[i] & 0x10) >> 3); // pos 2
            result += ((chars[i] & 0x20) << 2); // pos 8
            result += ((chars[i] & 0x40) >> 6); // pos 1
            result += ((chars[i] & 0x80) >> 3); // pos 5

            out.add((char) (result & 0xff));
        }

        System.out.println(out);

        return true;
    }
}
