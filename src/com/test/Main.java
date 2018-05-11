package com.test;

import tutorial.generics.BoxDemo;
import tutorial.generics.GenericsExamples;
import tutorial.inheritance.*;
import tutorial.general.*;
import daily.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        testPancake();
        testCipher();
    }

    private static void testCipher () {
        String encrypted = CipherBeta.encrypt("thepackagehasbeendelivered", "snitch");
        String decrypted = CipherBeta.decrypt(encrypted, "snitch");

        System.out.println(encrypted);
        System.out.println(decrypted);
    }


    private static void testPancake () {
//        Integer[] test = {8, 1, 3, 5, 2, 7, 4, 6};
//        ArrayList<Integer> testList = new ArrayList<Integer>(Arrays.asList(test));

        Pancake pancakes = new Pancake(8);
        pancakes.print();
        System.out.println("____________");
        System.out.println(pancakes.sort(true) + " flips");
        System.out.println("Done");
    }

    private static void changePancake(Pancake p) {
        p.sort(false);
        p = new Pancake(2);
        p.print();
    }


    private static void testSmallestPair() {
        long start = System.currentTimeMillis();
        for (int i=0;i<1001;i++) {
            SmallestPair.find(12L);
            SmallestPair.find(456L);
            SmallestPair.find(4567L);
            SmallestPair.find(12345L);
            SmallestPair.find(1234567891011L);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start + " miliseconds");
    }

    private static void testSub() {
        SubClass mySub = new SubClass();
        SuperClass mySup = new SuperClass();
        mySub.setIntOne(5);
        mySub.setIntTwo(4);
        mySub.print();
        mySub.modify(3,10);
        mySub.print();
        mySup = mySub;
        System.out.println(mySup.getIntOne() + " " + mySup.getIntTwo());
    }

    private static void testGenerics() {
        GenericsExamples.betterForCasting();
        GenericsExamples.boxesTest();
        GenericsExamples.pairTest();
        GenericsExamples.sumOfNumbers(Arrays.asList(1.2, 2.3, 3.5, 5.7, 7.11, 11.13));
        GenericsExamples.sumOfNumbers(Arrays.asList(1L, 2L, 3L, 5L, 7L, 11L, 13L));
        System.out.println(GenericsExamples.compareTest());
        GenericsExamples.extendsTest();
        GenericsExamples.classTest();
        GenericsExamples.printListTest();
        BoxDemo.start();
        Main.testSub();
        General.immutableTest();
    }

}
