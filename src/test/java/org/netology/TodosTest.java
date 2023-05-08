package org.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {

    @Test
    public void testSimpleTaskOfMatchesTrue() {
        SimpleTask simpleTask = new SimpleTask(5,"Оригинальное название");

        boolean actual = simpleTask.matches("Оригинальное");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testSimpleTaskOfMatchesFalse(){
        SimpleTask simpleTask = new SimpleTask(5,"Оригинальное название");

        boolean actual = simpleTask.matches("Не оригинальное");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testEpicMatchesTrue(){
        String[]subtasks ={"eat","study","work", "sleep"};
        Epic epic = new Epic(5,subtasks);

        boolean actual = epic.matches("work");

        Assertions.assertTrue(actual);
    }
    @Test
    public void testEpicMatchesFalse(){
        String[]subtasks ={"eat","study","work", "sleep", "query"};
        Epic epic = new Epic(5,subtasks);

        boolean actual = epic.matches("drink");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testMeetingTrue(){
        Meeting meeting = new Meeting(10,"Study","English","Today");

        boolean actual = meeting.matches("English");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingFalse(){
        Meeting meeting = new Meeting(10,"Study","English","Today");

        boolean actual = meeting.matches("Java");

        Assertions.assertFalse(actual);
    }

}