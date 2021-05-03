package com.parser;

public class Main {
    public static void main(String[] args) {
        WorldInformationGetter worldInformation = new CambridgeDictionaryWorldInformationGetter("anxiety");

        worldInformation.getWorldInfo();
    }
}
