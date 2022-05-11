package modelDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelTO.BookTypeTO;

public class BookTypeDAO extends DAO {

    public boolean insertRecord(BookTypeTO record) {
        try {
            String query = "insert into Genre ";
            query += "(bookType) ";
            query += "values(?)";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getBookType());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            this.error = ex.getMessage();
            return false;
        }
    }

    public List<BookTypeTO> getAllRecord() {
        try {
            String query = "select * from Genre";
            List<BookTypeTO> record = null;
            PreparedStatement stmt = DataConnection.getStatement(query);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                record = new ArrayList<>();
                do {
                    BookTypeTO rec = new BookTypeTO();
                    rec.setBookType(rs.getString("bookType"));
                    record.add(rec);
                } while (rs.next());
            }
            return record;
        } catch (Exception ex) {
            this.error = ex.getMessage();
            return null;
        }
    }

    public boolean deleteRecord(String bType) {
        try {
            String query = "delete from Genre ";
            query += "where bookType = ?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, bType);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            this.error = ex.getMessage();
            return false;
        }
    }

    public boolean updateRecord(String bType, String oldType) {
        try {
            String query = "update Genre ";
            query += "set bookType = ?";
            query += "where bookType = ?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, bType);
            stmt.setString(2, oldType);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            this.error = ex.getMessage();
            return false;
        }
    }
}
