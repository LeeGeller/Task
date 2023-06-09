package org.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Куропатка", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

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

        SimpleTask simpleTask1 = new SimpleTask(1, "Play with cat");
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

    @Test
    public void testSimpleTaskQuerry() {
        SimpleTask simpleTask = new SimpleTask(5, "Оригинальное название");
        Todos todos = new Todos();

        todos.add(simpleTask);

        Task[] actual = {simpleTask};
        Task[] expected = todos.search("Оригинальное название");

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testMeetingQuerry() {
        Todos todos = new Todos();
        Meeting meeting = new Meeting(10, "Study", "English", "Today");

        todos.add(meeting);

        Task[] expected = todos.search("English");
        Task[] actual = {meeting};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testEpicMatchesQuerry() {
        Todos todos = new Todos();
        String[] subtasks = {"eat", "study", "work", "sleep"};
        Epic epic = new Epic(5, subtasks);

        todos.add(epic);

        Task[] expected = todos.search("work");
        Task[] actual = {epic};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testSimpleTaskQuerryNotFind() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Оригинальное название");
        SimpleTask simpleTask2 = new SimpleTask(2, "Не оригинальное название");
        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);

        Task[] actual = {};
        Task[] expected = todos.search("Очень оригинальное название");

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testSimpleTaskQuerryWithTwoTasks() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Оригинальное название");
        SimpleTask simpleTask2 = new SimpleTask(2, "Не оригинальное название");
        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);

        Task[] actual = {simpleTask2};
        Task[] expected = todos.search("Не оригинальное название");

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testMeetingQuerryNotFind() {
        Todos todos = new Todos();
        Meeting meeting = new Meeting(10, "Study", "English", "Today");

        todos.add(meeting);

        Task[] expected = todos.search("Italy");
        Task[] actual = {};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testEpicMatchesQuerryNotFind() {
        Todos todos = new Todos();
        String[] subtasks = {"eat", "study", "work", "sleep"};
        Epic epic = new Epic(5, subtasks);

        todos.add(epic);

        Task[] expected = todos.search("cook");
        Task[] actual = {};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testWhenFindOneTask() {
        Todos todos = new Todos();

        String[] subtasks = {"eat", "study", "work", "sleep"};
        Epic epic = new Epic(5, subtasks);
        Meeting meeting = new Meeting(10, "Study", "English", "Today");
        SimpleTask simpleTask = new SimpleTask(2, "Не оригинальное название");

        todos.add(epic);
        todos.add(meeting);
        todos.add(simpleTask);

        Task[] expected = {epic};
        Task[] actual = todos.search("eat");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenFindSomeTask() {
        Todos todos = new Todos();

        String[] subtasks = {"eat", "Study", "work", "sleep"};
        Epic epic = new Epic(5, subtasks);
        Meeting meeting = new Meeting(10, "Study", "English", "Today");
        SimpleTask simpleTask = new SimpleTask(2, "Не оригинальное название");

        todos.add(epic);
        todos.add(meeting);
        todos.add(simpleTask);

        Task[] expected = {epic, meeting};
        Task[] actual = todos.search("Study");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenFindNothink() {
        Todos todos = new Todos();

        String[] subtasks = {"eat", "Study", "work", "sleep"};
        Epic epic = new Epic(5, subtasks);
        Meeting meeting = new Meeting(10, "Study", "English", "Today");
        SimpleTask simpleTask = new SimpleTask(2, "Не оригинальное название");

        todos.add(epic);
        todos.add(meeting);
        todos.add(simpleTask);

        Task[] expected = {};
        Task[] actual = todos.search("Watch YouTube");

        Assertions.assertArrayEquals(expected, actual);
    }

}