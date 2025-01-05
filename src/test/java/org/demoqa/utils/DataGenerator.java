package org.demoqa.utils;

import nl.flotsam.xeger.Xeger;

public class DataGenerator {
    public static String generateEmail() {
        return "demo.qa" + generateRandomText(7) + "@yopmail.com";
    }

    public static String generateRandomText(int length) {
        String regex = "[A-Za-z]{" + length + "}";
        Xeger generator = new Xeger(regex);
        return generator.generate();
    }
}
