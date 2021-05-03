package com.parser.parser;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebClientOptions;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.parser.converter.ConverterToWorldInfo;
import com.parser.entity.word.WordInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CambridgeDictionaryWorldInformationGetter implements WorldInformationGetter {

    private static final String URL = "https://dictionary.cambridge.org/dictionary/english/";
    private static final String XPATH_ALL = "//h2[@class='c_hh']|//span[@class='deg']|//span[@class='def-info ddef-info']|//div[@class='def ddef_d db']|//span[@class='w dw']|//div[@class='examp dexamp']";

    private String world;

    public CambridgeDictionaryWorldInformationGetter(final String world) {
        this.world = world;
    }

    public String getWorld() {
        return world;
    }

    public void setWorld(final String world) {
        this.world = world;
    }

    @Override
    public List<WordInfo> getWorldInfo() {
        try (WebClient webClient = new WebClient()) {
            WebClientOptions options = webClient.getOptions();
            options.setCssEnabled(false);
            options.setJavaScriptEnabled(false);

            HtmlPage htmlPage = webClient.getPage(CambridgeDictionaryWorldInformationGetter.URL + world);

            List<HtmlElement> htmlElements = htmlPage.getByXPath(CambridgeDictionaryWorldInformationGetter.XPATH_ALL);

            return ConverterToWorldInfo.convertToWorld(htmlElements.stream()
                    .filter(htmlElement -> !htmlElement.getTextContent().isBlank())
                    .collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
