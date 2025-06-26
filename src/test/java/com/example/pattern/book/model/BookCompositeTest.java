package com.example.pattern.book.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BookCompositeTest {
    
    @Test
    void 컴포지트패턴_기본_테스트() {
        // 1. 개별 책들 (Leaf)
        Book book1 = new Book("헤드퍼스트 디자인패턴");
        Book book2 = new Book("이펙티브 자바");
        Book book3 = new Book("클린 코드");
        
        // 2. 책장들 (Composite)
        BookShelf programmingShelf = new BookShelf("프로그래밍");
        BookShelf mainShelf = new BookShelf("메인 책장");
        
        // 3. 책을 책장에 추가
        programmingShelf.add(book1);
        programmingShelf.add(book2);
        programmingShelf.add(book3);
        
        // 4. 책장을 다른 책장에 추가 (중첩 구조)
        mainShelf.add(programmingShelf);
        
        // 5. 전체 구조 출력 (단일 인터페이스로 처리)
        mainShelf.printList("");
        
        Assertions.assertTrue(true);
    }
}