package db;

public class SQL {
    public static String getCreateMemberSQL() {
        return "INSERT INTO info (name, phone, email, group_name, birth_date, registration_date) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
    }

    public static String getReadMembersSQL() {
        return "SELECT * FROM info";
    }

    public static String getDeleteMemberSQL() {
        return "DELETE FROM info WHERE id = ?";
    }

    public static String getUpdateMemberSQL() {
        return "UPDATE info SET name = ?, phone = ?, email = ?, group_name = ?, birth_date = ? WHERE id = ?";
    }
}
