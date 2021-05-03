package com.parser;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebClientOptions;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.util.List;

public class CambridgeDictionaryWorldInformationGetter implements WorldInformationGetter {

    private static final String URL = "https://dictionary.cambridge.org/dictionary/english/";
    private static final String XPATH_ALL = "//h2[@class='c_hh']|//span[@class='def-info ddef-info']|//div[@class='def ddef_d db']|//span[@class='w dw']|//div[@class='examp dexamp']";

    private String world;

    public CambridgeDictionaryWorldInformationGetter(final String world) {
        this.world = world;
    }

    @Override
    public String getWorldInfo() {
        try (WebClient webClient = new WebClient()) {
            WebClientOptions options = webClient.getOptions();
            options.setCssEnabled(false);
            options.setJavaScriptEnabled(false);

            HtmlPage htmlPage = webClient.getPage(CambridgeDictionaryWorldInformationGetter.URL + world);

            List<HtmlElement> htmlElements = htmlPage.getByXPath(CambridgeDictionaryWorldInformationGetter.XPATH_ALL);

            htmlElements.stream()
                    .filter(htmlElement -> !htmlElement.getTextContent().isBlank())
                    .forEach(htmlElement -> System.out.println(htmlElement + "\t->\t" + htmlElement.getTextContent().trim() + "\n"));

//            return htmlElements.stream()
//                    .filter(htmlElement -> !htmlElement.getTextContent().isBlank())
//                    .collect(Collectors.toList()).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Not Found";
    }
}
