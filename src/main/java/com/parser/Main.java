package com.parser;

import com.parser.parser.CambridgeDictionaryWorldInformationGetter;
import com.parser.parser.WorldInformationGetter;

public class Main {
    public static void main(String[] args) {
        WorldInformationGetter worldInformation = new CambridgeDictionaryWorldInformationGetter("anxiety");

        System.out.println(worldInformation.getWorldInfo());
    }
}
