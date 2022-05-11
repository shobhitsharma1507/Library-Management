package modelDAO;

import java.sql.PreparedStatement;
import modelTO.BookStockTO;

public class BookStockDAO extends DAO{
    public boolean insertRecord(BookStockTO record){
        try {
            String query = "insert into BookStock";
            query += " (bookId,entryType,quantity)";
            query += " values(?,?,?)";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, record.getBookId());
            stmt.setString(2, record.getEntryType());
            stmt.setInt(3, record.getQuantity());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            this.error = ex.getMessage();
            ex.printStackTrace();
            return false;
        }
    }
}
