package enums;

public enum Roles {
    DAD("dad"),
    MOM("mom"),
    BABY("baby"),
    OTHER("other");

    private final String role;
    Roles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
