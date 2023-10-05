package com.company;

import java.util.Calendar;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int actualYear = Calendar.getInstance().get(Calendar.YEAR);
        long time = System.currentTimeMillis();
        Date actualTime = new Date(time);
        boolean firstStart = true;

        while (true) {
            if (!firstStart) {
                System.out.println("Pro ukonceni programu 'exit' a pro pokracovani zmackni enter");
            } else {
                System.out.println("Pro pokracovani zmackni enter");
                firstStart = false;
            }

            String loop = sc.nextLine();

            if (loop.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Zadej rok: ");
            int year = sc.nextInt();

            if (isLeapYear(year)) {
                System.out.println(year + " je přestupný rok.");
                System.out.println();
            } else {
                System.out.println(year + " není přestupný rok.");
                System.out.println();
            }

            if (isLeapYear(actualYear)) {
                System.out.println("Aktuální rok " + actualYear + " je přestupný.");
                System.out.println();
            } else {
                System.out.println("Aktuální rok " + actualYear + " není přestupný.");
                int nextLeapYear = findNextLeapYear(actualYear);
                System.out.println("Další přestupný rok bude: " + nextLeapYear);
                System.out.println();
            }

            SimpleDateFormat timeFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            String formatedTime = timeFormat.format(actualTime);

            System.out.println("Aktuální čas: " + formatedTime);

            System.out.print("Zadej rok (např. 2023): ");
            int year2 = sc.nextInt();
            System.out.print("Enter the month (1-12): ");
            int month = sc.nextInt();
            System.out.print("Enter the day (1-31): ");
            int day = sc.nextInt();

            String inputDate = day + "." + month + "." + year2;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

            try {
                Date date = dateFormat.parse(inputDate);
                long millisUntilDate = date.getTime() - System.currentTimeMillis();

                if (millisUntilDate < 0) {
                    System.out.println("Zadané datum již uplynulo.");
                } else {
                    long seconds = millisUntilDate / 1000;
                    long minutes = seconds / 60;
                    long hours = minutes / 60;
                    long days = hours / 24;
                    long months = days / 30;
                    long years = months / 12;

                    long remainingSeconds = seconds % 60;
                    long remainingMinutes = minutes % 60;
                    long remainingHours = hours % 24;
                    long remainingDays = days % 30;
                    long remainingMonths = months % 12;

                    System.out.println("Do zadaného data zbývá:");
                    System.out.println(remainingSeconds + " sekund");
                    System.out.println(remainingMinutes + " minut");
                    System.out.println(remainingHours + " hodin");
                    System.out.println(remainingDays + " dní");
                    System.out.println(remainingMonths + " měsíců");
                    System.out.println(years + " roků");
                    System.out.println();
                }
            } catch (ParseException e) {
                System.out.println("Error");
            } finally {
                sc.nextLine();
            }
        }
    }


        public static boolean isLeapYear ( int rok){
            return (rok % 4 == 0 && rok % 100 != 0) || (rok % 400 == 0);
        }

        public static int findNextLeapYear ( int year){
            while (true) {
                year++;
                if (isLeapYear(year)) {
                    return year;
                }
            }
        }
    }

