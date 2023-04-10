package io.javabrains;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CurrentTasks {

    private Map<String, Task> currentTasks = new HashMap<>();

    public Map<String, Task> getCurrentTasks() {
        return currentTasks;
    }

    public void setCurrentTasks(Map<String, Task> currentTasks) {
        this.currentTasks = currentTasks;
    }

    public void startTask(Task task) {
        if(currentTasks.putIfAbsent(task.getTaskName(), task)!=null){
            Logger.log("Task already exists, skipping");
        }
    }

    public void completeTask(Task task) {
        Task existingTask = currentTasks.get(task.getTaskName());
        if (existingTask == null) {
            Logger.log("No tasks found");
        } else {
            existingTask.setEndTime(LocalDateTime.now());
            existingTask.setStatus(TaskStatus.COMPLETED);
        }

    }
}
