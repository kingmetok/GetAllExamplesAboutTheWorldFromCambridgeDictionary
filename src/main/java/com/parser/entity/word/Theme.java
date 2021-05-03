package com.parser.entity.word;

import java.util.List;

public class Theme {

    private String theme;
    private List<String> descriptions;

    public Theme() {
    }

    public Theme(final String theme, final List<String> descriptions) {
        this.theme = theme;
        this.descriptions = descriptions;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(final String theme) {
        this.theme = theme;
    }

    public List<String> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(final List<String> descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public String toString() {
        return "\n\t\tTheme{\n" +
                "\t\t\ttheme\t\t\t=\t'" + theme + '\'' +
                ",\n\t\t\tdescriptions\t=\t" + descriptions +
                "}\n";
    }
}
