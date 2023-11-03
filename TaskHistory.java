public class TaskHistory {
    private String actionDate;
    private String actionTime;
    private String actionDescription;

    public TaskHistory(String actionDate, String actionTime, String actionDescription) {
        this.actionDate = actionDate;
        this.actionTime = actionTime;
        this.actionDescription = actionDescription;
    }

    public String getActionDate() {
        return actionDate;
    }

    public void setActionDate(String actionDate) {
        this.actionDate = actionDate;
    }

    public String getActionTime() {
        return actionTime;
    }

    public void setActionTime(String actionTime) {
        this.actionTime = actionTime;
    }

    public String getActionDescription() {
        return actionDescription;
    }

    public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
    }
}
