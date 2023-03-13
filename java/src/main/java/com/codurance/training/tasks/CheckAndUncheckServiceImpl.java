package com.codurance.training.tasks;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class CheckAndUncheckServiceImpl implements CheckAndUncheckService{
    private final PrintWriter out;
    private final Map<String, List<Task>> tasks;

    public CheckAndUncheckServiceImpl(PrintWriter out, Map<String, List<Task>> tasks) {
        this.out = out;
        this.tasks = tasks;
    }

    private void setDone(String idString, boolean done) {
        int id = Integer.parseInt(idString);
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId() == id) {
                    task.setDone(done);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %d.", id);
        out.println();
    }

    @Override
    public void check(String idString) {
        this.setDone(idString, true);
    }

    @Override
    public void uncheck(String idString) {
        this.setDone(idString, false);
    }


}
