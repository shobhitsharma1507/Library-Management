package modelDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelTO.BooksTO;

public class BooksDAO extends DAO {

    public boolean insertRecord(BooksTO record) {
        try {
            String query = "insert into Books";
            query += "(bookName,bookType,author,publisher,quantity) ";
            query += "values(?,?,?,?,?)";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getBookName());
            stmt.setString(2, record.getBookType());
            stmt.setString(3, record.getAuthor());
            stmt.setString(4, record.getPublisher());
            stmt.setInt(5, record.getQuantity());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            this.error = ex.getMessage();
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean updateRecord(BooksTO record) {
        try {
            String query = "update Books";
            query += " set bookName= ?,bookType=?,author=?,publisher=?,quantity=? ";
            query += " where bookId = ?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getBookName());
            stmt.setString(2, record.getBookType());
            stmt.setString(3, record.getAuthor());
            stmt.setString(4, record.getPublisher());
            stmt.setInt(5, record.getQuantity());
            stmt.setInt(6, record.getBookId());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            this.error = ex.getMessage();
            ex.printStackTrace();
            return false;
        }
    }

    public List<BooksTO> getAllRecord() {
        try {
            String query = "select * from Books";
            PreparedStatement stmt = DataConnection.getStatement(query);
            List<BooksTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    BooksTO record = new BooksTO();
                    record.setAuthor(rs.getString("author"));
                    record.setBookName(rs.getString("bookName"));
                    record.setBookType(rs.getString("bookType"));
                    record.setPublisher(rs.getString("publisher"));
                    record.setBookId(rs.getInt("bookId"));
                    record.setQuantity(rs.getInt("Quantity"));
                    result.add(record);
                } while (rs.next());
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            this.error = ex.getMessage();
            ex.printStackTrace();
            return null;
        }
    }

    public boolean deleteRecord(int bookId) {
        try {
            String query = "delete from Books ";
            query += "where bookId = ?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, bookId);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            this.error = ex.getMessage();
            return false;
        }
    }

    public BooksTO getBook(int bookId) {
        try {
            String query = "select * from Books where Books.bookId = ?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, bookId);
            ResultSet rs = stmt.executeQuery();
            BooksTO record = new BooksTO();
            if (rs.next()) {
                record.setAuthor(rs.getString("author"));
                record.setBookName(rs.getString("bookName"));
                record.setBookType(rs.getString("bookType"));
                record.setPublisher(rs.getString("publisher"));
                record.setBookId(rs.getInt("bookId"));
                record.setQuantity(rs.getInt("Quantity"));
            }
            return record;
        } catch (Exception ex) {
            this.error = ex.getMessage();
            ex.printStackTrace();
            return null;
        }
    }

}
