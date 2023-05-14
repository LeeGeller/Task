package org.netology;

public class Meeting extends Task {
    protected String topic;
    protected String project;
    protected String start;

    public Meeting(int id, String title, String project, String start) {
        super(id);
        this.topic = title;
        this.project = project;
        this.start = start;
    }

    public String getTopics() {

        return topic;
    }

    public String getProject() {

        return project;
    }

    public String getStart() {

        return start;
    }

    @Override
    public boolean matches(String query) {
        if (topic.contains(query)) {
            return true;
        }
        if (project.contains(query)) {
            return true;
        }
        return false;
    }
}
