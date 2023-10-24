public enum Updatetype {
    BUG("Bug"),
    UPDATE("Update"),
    PATCH("Patch"),
    REGULAR_MAINTENANCE("Regular Maintenance");

    private String type;

    Updateyype(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
