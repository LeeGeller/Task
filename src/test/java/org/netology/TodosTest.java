package org.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {

    @Test
    public void testSimpleTaskOfMatchesTrue() {
        SimpleTask simpleTask = new SimpleTask(5, "Оригинальное название");

        boolean actual = simpleTask.matches("Оригинальное");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testSimpleTaskOfMatchesFalse() {
        SimpleTask simpleTask = new SimpleTask(5, "Оригинальное название");

        boolean actual = simpleTask.matches("Не оригинальное");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testEpicMatchesTrue() {
        String[] subtasks = {"eat", "study", "work", "sleep"};
        Epic epic = new Epic(5, subtasks);

        boolean actual = epic.matches("work");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testEpicMatchesFalse() {
        String[] subtasks = {"eat", "study", "work", "sleep", "query"};
        Epic epic = new Epic(5, subtasks);

        boolean actual = epic.matches("drink");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testMeetingTrue() {
        Meeting meeting = new Meeting(10, "Study", "English", "Today");

        boolean actual = meeting.matches("English");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingFalse() {
        Meeting meeting = new Meeting(10, "Study", "English", "Today");

        boolean actual = meeting.matches("Java");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testOneTask() {
        Todos todos = new Todos();

        SimpleTask simpleTask = new SimpleTask(1, "English");

        todos.add(simpleTask);

        Task[] expected = {simpleTask};
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testOneSubtaskAndSimpleTask() {
        Todos todos = new Todos();

        String[] subtask = {"Exercise"};
        Epic epic = new Epic(1, subtask);

        SimpleTask simpleTask = new SimpleTask(2, "Cook");

        todos.add(epic);
        todos.add(simpleTask);

        Task[] expected = {epic, simpleTask};
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWithoutTasks() {
        Todos todos = new Todos();

        Task[] expected = {};
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testTwoSimpleTasks() {

        Todos todos = new Todos();

        SimpleTask simpleTask1 = new SimpleTask(1, "Play with cats");
        SimpleTask simpleTask2 = new SimpleTask(2, "Run");

        todos.add(simpleTask1);
        todos.add(simpleTask2);

        Task[] expected = {simpleTask1, simpleTask2};
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testTwoMeeting() {
        Todos todos = new Todos();

        Meeting meeting1 = new Meeting(1, "Shop", "For Cats", "Food");
        Meeting meeting2 = new Meeting(2, "Study", "English", "Verbs");
        SimpleTask simpleTask = new SimpleTask(3, "Clean room");

        todos.add(meeting1);
        todos.add(meeting2);
        todos.add(simpleTask);

        Task[] expected = {meeting1, meeting2, simpleTask};
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

}