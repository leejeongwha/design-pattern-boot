package com.example.pattern.book.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BookCompositeTest {
    @Test
    void 리스트_출력_테스트() {
        BookShelf shelf1 = new BookShelf("1");
        BookShelf shelf11 = new BookShelf("1-1");
        BookShelf shelf12 = new BookShelf("1-2");
        Book book1 = new Book("마음의온도");
        Book book2 = new Book("헤드퍼스트디자인패턴");
        Book book3 = new Book("이펙티브자바");
        Book book4 = new Book("나의라임오렌지나무");

        shelf1.add(book1);

        shelf11.add(book2);
        shelf11.add(book3);

        shelf12.add(book4);

        shelf1.add(shelf11);
        shelf1.add(shelf12);

        shelf1.printList("");

        Assertions.assertTrue(true);
    }
}