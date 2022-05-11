/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelTO;

/**
 *
 * @author Shobhit
 */
public class BookStockTO {

    int bookId;
    String entryType;
    int quantity;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getEntryType() {
        return entryType;
    }

    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BookStockTO{" + "bookId=" + bookId + ", entryType=" + entryType + ", quantity=" + quantity + '}';
    }


}
