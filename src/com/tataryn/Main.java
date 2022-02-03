package com.tataryn;

import java.util.Scanner;

public class Main {

    public static void Checkinginput(String input) throws IllegalArgumentException {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != 'H' && input.charAt(i) != 'O') {
                throw new IllegalArgumentException("Wrong input!!! Enter only 'H' and 'O' elements");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Input elements 'H' and 'O'");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Checkinginput(input);
        Water.releaseWater(input);
    }
}
