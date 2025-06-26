package com.example.pattern.book.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Book extends BookComposite {
    public Book(String name) {
        super(name);
    }

    public void add(BookComposite entry) {
        throw new IllegalArgumentException("책에는 하위 객체를 추가할 수 없습니다");
    }

    @Override
    public void printList(String path) {
        log.info(path + "/" + this.getName());
    }
}
