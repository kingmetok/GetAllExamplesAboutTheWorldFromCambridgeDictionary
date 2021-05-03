package com.parser.entity.word;

import java.util.List;

public class Theme {

    private String name;
    private List<String> examples;

    public Theme() {
    }

    public Theme(final String name, final List<String> examples) {
        this.name = name;
        this.examples = examples;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<String> getExamples() {
        return examples;
    }

    public void setExamples(final List<String> examples) {
        this.examples = examples;
    }

    @Override
    public String toString() {
        return "\n\t\tTheme{\n" +
                "\t\t\ttheme\t\t\t=\t'" + name + '\'' +
                ",\n\t\t\tdescriptions\t=\t" + examples +
                "}\n";
    }
}
