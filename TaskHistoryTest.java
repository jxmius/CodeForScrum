public class TaskHistoryTest {

    public static void main(String[] args) {
        testConstructor();
        testSetActionDate();
        testSetActionTime();
        testSetActionDescription();
    }

    private static void testConstructor() {
        TaskHistory history = new TaskHistory("2023-11-08", "12:00", "Task created");
        assert "2023-11-08".equals(history.getActionDate()) : "Constructor test failed - actionDate";
        assert "12:00".equals(history.getActionTime()) : "Constructor test failed - actionTime";
        assert "Task created".equals(history.getActionDescription()) : "Constructor test failed - actionDescription";
    }

    private static void testSetActionDate() {
        TaskHistory history = new TaskHistory("2023-11-08", "12:00", "Task created");
        history.setActionDate("2023-11-09");
        assert "2023-11-09".equals(history.getActionDate()) : "setActionDate test failed";
    }

    private static void testSetActionTime() {
        TaskHistory history = new TaskHistory("2023-11-08", "12:00", "Task created");
        history.setActionTime("13:00");
        assert "13:00".equals(history.getActionTime()) : "setActionTime test failed";
    }

    private static void testSetActionDescription() {
        TaskHistory history = new TaskHistory("2023-11-08", "12:00", "Task created");
        history.setActionDescription("Task updated");
        assert "Task updated".equals(history.getActionDescription()) : "setActionDescription test failed";
    }
}