/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class Controller {

    ArrayList<Book> listBook = new ArrayList();
    Frame frm = new Frame();
    JList list = frm.getList();
    JButton btnSave = frm.getBtnSave();
    JButton btnRemove = frm.getBtnRemove();
    JButton btnExit = frm.getBtnExit();
    JPanel panel = frm.getPanel();

    public Controller() {
        frm.setVisible(true);
        frm.setResizable(false);
        list.setEnabled(true);
        for (int year = 2000; year <= Calendar.getInstance().get(Calendar.YEAR); year++) {
            frm.getCbo().addItem(year);
        }
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!listBook.isEmpty()) {
                    if (!list.isSelectionEmpty()) {
                        update();
                    } else {
                        addBook();
                        addBookList();
                    }
                }
                if (listBook.isEmpty()) {
                    addBook();
                    addBookList();
                }

            }
        });
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listBook.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "List book is empty");
                } else {
                    Remove();
                    JOptionPane.showMessageDialog(null, "Remove successfull");
                }
            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        click();
    }

    public void addBook() {
        String code = frm.getTxtCode().getText();
        String name = frm.getTxtName().getText();
        String author = frm.getTxtAuthor().getText();
        String publisher = frm.getTxtPublisher().getText();
        int year = frm.getCbo().getSelectedIndex();
        boolean rent;
        if (checkExist(code)) {
            if (frm.getCheckBox().isSelected()) {
                rent = true;
            } else {
                rent = false;
            }
            listBook.add(new Book(code, name, author, publisher, year, rent));
            JOptionPane.showMessageDialog(null, "Successfull");
            frm.getTxtCode().setText("");
            frm.getTxtName().setText("");
            frm.getTxtAuthor().setText("");
            frm.getTxtPublisher().setText("");
            frm.getCbo().setSelectedIndex(0);
            frm.getCheckBox().setSelected(true);
        } else {
            JOptionPane.showMessageDialog(null, "Existed");
        }
    }

    public void addBookList() {
        DefaultListModel mod = new DefaultListModel();
        for (int i = 0; i < listBook.size(); i++) {
            mod.addElement(listBook.get(i).getName());
        }

        list.setModel(mod);
    }

    public Book getBookByName(String bookSelecter) {
        for (Book book : listBook) {
            if (book.getName().equalsIgnoreCase(bookSelecter)) {
                return book;
            }
        }
        return null;
    }

    public void click() {
        list.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!listBook.isEmpty()) {
                    String bookSelected = (String) frm.getList().getSelectedValue();
                    int i = frm.getList().getSelectedIndex();
                    if (listBook.get(i).getName().equalsIgnoreCase(bookSelected)) {
                        frm.getTxtCode().setText(listBook.get(i).getCode());
                        frm.getTxtName().setText(listBook.get(i).getName());
                        frm.getTxtAuthor().setText(listBook.get(i).getAuthor());
                        frm.getTxtPublisher().setText(listBook.get(i).getPublisher());
                        frm.getCbo().setSelectedIndex(listBook.get(i).getYear());
                        frm.getCheckBox().setSelected(listBook.get(i).isRent());
                    }
                    panel();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public void panel() {
        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frm.getTxtCode().setText("");
                frm.getTxtName().setText("");
                frm.getTxtAuthor().setText("");
                frm.getTxtPublisher().setText("");
                frm.getCbo().setSelectedIndex(0);
                frm.getCheckBox().setSelected(true);
                list.clearSelection();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    public void displayBook(Book book) {
        frm.getTxtCode().setText(book.getCode());
        frm.getTxtName().setText(book.getName());
        frm.getTxtAuthor().setText(book.getAuthor());
        frm.getTxtPublisher().setText(book.getPublisher());
        frm.getCbo().setSelectedIndex(book.getYear());
        frm.getCheckBox().setSelected(book.isRent());
    }

    public void Remove() {
        String bookName = (String) list.getSelectedValue();
        listBook.remove(getBookByName(bookName));
        addBookList();
        if (!listBook.isEmpty()) {
            list.setSelectedIndex(0);
            String bookNameFirst = (String) list.getSelectedValue();
            for (Book book : listBook) {
                if (book.getName().equalsIgnoreCase(bookNameFirst)) {
                    displayBook(book);
                    return;
                }
            }

        } else {
            frm.getTxtCode().setText("");
            frm.getTxtName().setText("");
            frm.getTxtAuthor().setText("");
            frm.getTxtPublisher().setText("");
            frm.getCbo().setSelectedIndex(0);
            frm.getCheckBox().setSelected(true);
        }
    }

    public void update() {
        String code = frm.getTxtCode().getText().trim();
        String name = frm.getTxtName().getText().trim();
        String author = frm.getTxtAuthor().getText().trim();
        String publisher = frm.getTxtPublisher().getText().trim();
        int year = frm.getCbo().getSelectedIndex();
        boolean rent;
        if (frm.getCheckBox().isSelected()) {
            rent = true;
        } else {
            rent = false;
        }
        int i = frm.getList().getSelectedIndex();
        if (checkExistUpdate(code, name)) {
            listBook.get(i).setCode(code);
            listBook.get(i).setName(frm.getTxtName().getText().trim());
            listBook.get(i).setAuthor(author);
            listBook.get(i).setPublisher(publisher);
            listBook.get(i).setYear(year);
            listBook.get(i).setRent(rent);

            JOptionPane.showMessageDialog(null, "Update Successfull");
            addBookList();
        } else {
            JOptionPane.showMessageDialog(null, "Existed");
        }

    }

    public boolean checkExist(String code) {
        for (Book b : listBook) {
            if (code.equalsIgnoreCase(b.getCode())) {
                return false;
            }
        }
        return true;
    }

    public boolean checkExistUpdate(String code, String name) {
        int i = frm.getList().getSelectedIndex();
        for (Book b : listBook) {
            if (code.equalsIgnoreCase(listBook.get(i).getCode())) {
                return true;
            }
            if (code.equalsIgnoreCase(b.getCode())) {
                return false;
            }

        }
        return true;
    }
}
