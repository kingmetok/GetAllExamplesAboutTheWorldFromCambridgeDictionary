package com.parser.entity.word;

import java.util.List;

public class WordInfo {

    private String infoAboutBlock;
    private List<Theme> themes;

    public WordInfo() {
    }

    public WordInfo(final String infoAboutBlock, final List<Theme> themes) {
        this.infoAboutBlock = infoAboutBlock;
        this.themes = themes;
    }

    public String getInfoAboutBlock() {
        return infoAboutBlock;
    }

    public void setInfoAboutBlock(final String infoAboutBlock) {
        this.infoAboutBlock = infoAboutBlock;
    }

    public List<Theme> getThemes() {
        return themes;
    }

    public void setThemes(final List<Theme> themes) {
        this.themes = themes;
    }

    @Override
    public String toString() {
        return "\nWordInfo{\n\t" +
                "infoAboutBlock = '" + infoAboutBlock + '\'' +
                ", \n\tthemes=" + themes +
                '}';
    }
}
