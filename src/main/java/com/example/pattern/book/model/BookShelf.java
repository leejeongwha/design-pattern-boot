package com.example.pattern.book.model;

import java.util.ArrayList;

public class BookShelf extends BookComposite {
    //책을 담기 위한 ArrayList
    ArrayList<BookComposite> compositeList = new ArrayList<>();

    public BookShelf(String name) {
        super(name);
    }

    //책장에 책 추가
    public void add(BookComposite entry) {
        compositeList.add(entry);
    }

    @Override
    public void printList(String path) {      //목록을 보여줍니다.
        path += "/" + this.getName();
        for (BookComposite bookComposite : compositeList) {
            bookComposite.printList(path);
        }
    }
}
