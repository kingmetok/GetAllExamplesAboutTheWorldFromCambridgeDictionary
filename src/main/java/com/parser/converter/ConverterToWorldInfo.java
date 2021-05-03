package com.parser.converter;

import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.parser.entity.word.Theme;
import com.parser.entity.word.WordInfo;

import java.util.ArrayList;
import java.util.List;

public class ConverterToWorldInfo {

    private static final List<String> HEADERS = List.of("HtmlSpan[<span class=\"def-info ddef-info\">]", "HtmlHeading2[<h2 class=\"c_hh\">]");
    private static final String THEME = "HtmlDivision[<div class=\"def ddef_d db\">]";

    private ConverterToWorldInfo() {
    }

    public static List<WordInfo> convertToWorld(List<HtmlElement> htmlElements) {
        List<WordInfo> wordInfos = new ArrayList<>();
        int counterWords = 0;

        List<Theme> themes = new ArrayList<>();
        Theme theme;
        List<String> descriptions = new ArrayList<>();

        for (HtmlElement htmlElement : htmlElements) {
            if (isHeader(htmlElement.toString())) {
                wordInfos.add(new WordInfo());
                themes = new ArrayList<>();
                wordInfos.get(counterWords).setThemes(themes);
                wordInfos.get(counterWords).setInfoAboutBlock(htmlElement.getTextContent().trim());
                counterWords++;
            } else {
                if (THEME.equals(htmlElement.toString())) {
                    theme = new Theme();
                    descriptions = new ArrayList<>();
                    theme.setName(htmlElement.getTextContent());
                    theme.setExamples(descriptions);
                    themes.add(theme);
                } else {
                    if (themes.isEmpty()) {
                        theme = new Theme();
                        descriptions = new ArrayList<>();
                        theme.setExamples(descriptions);
                        themes.add(theme);
                    }
                    descriptions.add(htmlElement.getTextContent().trim());
                }
            }
        }

        return wordInfos;
    }

    private static boolean isHeader(String string) {
        return HEADERS.contains(string);
    }
}
