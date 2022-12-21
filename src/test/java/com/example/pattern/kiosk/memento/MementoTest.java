package com.example.pattern.kiosk.memento;

import com.example.pattern.kiosk.memento.Memento;
import com.example.pattern.kiosk.memento.Originator;
import org.junit.jupiter.api.Test;

import java.util.Stack;

class MementoTest {
    @Test
    void 메멘토_테스트() {
        Originator originator = new Originator();
        //Stack 자료구조를 CareTaker클래스로 대체
        Stack<Memento> mementos = new Stack<>();

        originator.setState("A");
        mementos.push(originator.createMemento());
        originator.setState(originator.getState() + "B");
        mementos.push(originator.createMemento());
        originator.setState(originator.getState() + "C");
        mementos.push(originator.createMemento());
        originator.setState(originator.getState() + "D");
        mementos.push(originator.createMemento());

        while (!mementos.isEmpty()) {
            //이전 상태로 복구
            originator.restoreMemento(mementos.pop());
            System.out.println(originator.getState());
        }
    }
}