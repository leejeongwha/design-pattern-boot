package com.example.pattern.book.model;

public abstract class BookComposite {
    private final String name;

    protected BookComposite(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void add(BookComposite composite);

    public abstract void printList(String path);
}
