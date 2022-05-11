package modelDAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelTO.MemberTO;

public class MemberDAO extends DAO {

    public boolean insertRecord(MemberTO record) {
        try {
            Date date = new Date(System.currentTimeMillis());
            String query = "insert into Members ";
            query += "(member_id,member_name,member_dob,member_join_date,member_add,issued_books,returned_books )";
            query += "values(?,?,?,?,?,?,?)";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getMemberId());
            stmt.setString(2, record.getMemberName());
            stmt.setDate(3, record.getDob());
            stmt.setDate(4, date);
            stmt.setString(5, record.getAddress());
            stmt.setInt(6, record.getIssuedBooks());
            stmt.setInt(7, record.getIssuedBooks());
            boolean result = stmt.executeUpdate() > 0;
            return result;
        } catch (Exception ex) {
            this.error = ex.getMessage();
            return false;
        }
    }

    public boolean deleteRecord(String memId) {
        try {
            String query = "delete from Members ";
            query += "where member_id = ?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, memId);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            this.error = ex.getMessage();
            return false;
        }
    }

    public List<MemberTO> getAllRecord() {
        try {
            String query = "select * from Members";
            List<MemberTO> rec = null;
            PreparedStatement stmt = DataConnection.getStatement(query);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                rec = new ArrayList<>();
                do {
                    MemberTO result = new MemberTO();
                    result.setAddress(rs.getString("member_add"));
                    result.setMemberName(rs.getString("member_name"));
                    result.setDob(rs.getDate("member_dob"));
                    result.setJoindate(rs.getDate("member_join_date"));
                    result.setMemberId(rs.getString("member_id"));
                    result.setIssuedBooks(rs.getInt("issued_books"));
                    result.setIssuedBooks(rs.getInt("returned_books"));
                    rec.add(result);
                } while (rs.next());
            }
            return rec;
        } catch (Exception ex) {
            this.error = ex.getMessage();
            return null;
        }

    }
}
