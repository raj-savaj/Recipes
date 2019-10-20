package com.recipes.srd.recipes.Api;

public class Globals {

    private static Globals instance = new Globals();

    public static Globals getInstance() {
        return instance;
    }

    public static void setInstance(Globals instance) {
        Globals.instance = instance;
    }

    private int lang;

    public int getValue() {
        return lang;
    }

    public void setValue(int lang) {
        this.lang = lang;
    }

}
