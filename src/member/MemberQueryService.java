package member;

import db.DBConnection;
import db.SQL;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberQueryService {
    private final DBConnection connection;

    public MemberQueryService() {
        connection = new DBConnection();
    }

    public void createMemberQuery(Member member) {
        try (PreparedStatement pstmt = connection.getConnection().prepareStatement(SQL.getCreateMemberSQL())) {

            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getPhone());
            pstmt.setString(3, member.getEmail());
            pstmt.setString(4, member.getGroupName());
            pstmt.setDate(5, new Date(member.getBirthDate().getTime()));
            pstmt.setDate(6, new Date(member.getRegistrationDate().getTime()));

            pstmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("멤버 생성 실패 : " + e.getMessage(), e);
        }
    }

    public List<Member> readMembersQuery() {
        List<Member> members = new ArrayList<>();

        try (PreparedStatement pstmt = connection.getConnection().prepareStatement(SQL.getReadMembersSQL());
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Member member = new Member();
                member.setId(rs.getInt(1));
                member.setName(rs.getString(2));
                member.setPhone(rs.getString(3));
                member.setEmail(rs.getString(4));
                member.setGroupName(rs.getString(5));
                member.setBirthDate(rs.getDate(6));
                member.setRegistrationDate(rs.getDate(7));
                members.add(member);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("멤버 리스트 읽기 실패" + e.getMessage(), e);
        }

        return members;
    }

    public void updateMemberQuery(Member member) {
        try (PreparedStatement pstmt = connection.getConnection().prepareStatement(SQL.getUpdateMemberSQL())) {

            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getPhone());
            pstmt.setString(3, member.getEmail());
            pstmt.setString(4, member.getGroupName());
            pstmt.setDate(5, new Date(member.getBirthDate().getTime()));
            pstmt.setInt(6, member.getId());

            pstmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("멤버 업데이트 실패 : " + e.getMessage(), e);
        }
    }


    public void deleteMemberQuery(int id) {
        try (PreparedStatement pstmt = connection.getConnection().prepareStatement(SQL.getDeleteMemberSQL())) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("멤버 삭제 실패 :  " + e.getMessage(), e);
        }
    }


}
