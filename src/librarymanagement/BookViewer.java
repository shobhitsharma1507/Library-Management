/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import javax.swing.Action;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import modelDAO.BooksDAO;
import modelTO.BooksTO;

/**
 *
 * @author Shobhit
 */
public class BookViewer extends javax.swing.JInternalFrame {

    /**
     * Creates new form BookViewer
     */
    private List<BooksTO> books;
    private JPopupMenu jpm;
    private int selectedrow;

    public BookViewer() {
        initComponents();
        bindTableDetails();
        jpm = new JPopupMenu();
        JMenuItem deleteBook = new JMenuItem("Delete This Record?");
        jpm.add(deleteBook);
        deleteBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBookRecord();
            }
        });
    }

    public void deleteBookRecord() {
        if (selectedrow != -1 && books.size() > 0 && books != null && selectedrow < books.size()) {
            String message = "";
            BooksTO record = books.get(selectedrow);
            if (record != null) {
                int option = JOptionPane.showConfirmDialog(this, "Are You Sure To Remove This Record?", "Important Message", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    BooksDAO dao = new BooksDAO();
                    if (dao.deleteRecord(selectedrow)) {
                        message += "Record is deleted";
                        bindTableDetails();
                    } else {
                        message += "Deletion Failure due to" + dao.getEror();
                    }
                }
            }
            JOptionPane.showMessageDialog(this, message);
        }
    }

    public void bindTableDetails() {
        String colnames[] = {"Book ID", "Book Name", "Book Type", "Author", "Publisher", "Quantity"};
        books = new BooksDAO().getAllRecord();
        Object[][] records = null;
        if (books != null && books.size() > 0) {
            records = new Object[books.size()][colnames.length];
            int index = 0;
            for (BooksTO bt : books) {
                records[index] = new Object[]{bt.getBookId(), bt.getBookName(), bt.getBookType(), bt.getAuthor(), bt.getPublisher(), bt.getQuantity()};
                index++;
            }
        } else {
            records = new Object[1][colnames.length];
            records[0] = new Object[]{"No Records", "No Records", "No Records", "No Records", "No Records", "No Records"};
        }
        DefaultTableModel model = new DefaultTableModel(records, colnames);
        booksTable.setModel(model);
        booksTable.getTableHeader().setReorderingAllowed(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        booksTable = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("BOOKS");

        booksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        booksTable.setAutoscrolls(false);
        booksTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booksTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(booksTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void booksTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksTableMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            int rowpoint = booksTable.rowAtPoint(evt.getPoint());
            booksTable.getSelectionModel().setSelectionInterval(rowpoint, rowpoint);
            jpm.show(booksTable, evt.getX(), evt.getY());
            selectedrow = booksTable.getSelectedRow();
        }
    }//GEN-LAST:event_booksTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable booksTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
