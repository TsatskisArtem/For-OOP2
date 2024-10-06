package laba2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class okno {

    private JFrame bookList;
    private DefaultTableModel model;   
    private JButton save, add, edit, delete;
    private JScrollPane scroll;
    private JTable books;

    public void show() {
        bookList = new JFrame("Информация о книгах");
        bookList.setSize(600, 400);
        bookList.setLocation(100, 100);
        bookList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] columns = {"Название книги", "Автор", "Шрифт", "Закреплена?"};
        String[][] data = {
            {"Война и мир", "Лев Толстой", "Arial", "Нет"},
            {"1984", "Джордж Оруэлл", "Calibri", "Да"},
            {"Прощай оружие!", "Эрнест Хемингуэй", "Garamond", "Нет"},
            {"Убить пересмешника", "Харпер Ли", "Fraktur", "Да"},
            {"На дороге", "Джек Керуак", "Papyrus", "Нет"}
        };
        model = new DefaultTableModel(data, columns);
        books = new JTable(model);
        books.setAutoCreateRowSorter(true); 
        scroll = new JScrollPane(books);

        bookList.getContentPane().add(scroll, BorderLayout.CENTER);

        JPanel filterPanel = new JPanel(new GridLayout(1, 4));

        bookList.getContentPane().add(filterPanel, BorderLayout.NORTH);

        save = new JButton("Сохранить");
        add = new JButton("Добавить");
        edit = new JButton("Редактировать");
        delete = new JButton("Удалить");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(save);
        buttonPanel.add(add);
        buttonPanel.add(edit);
        buttonPanel.add(delete);

        bookList.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        bookList.setVisible(true);
    }

    public static void main(String[] args) {
        new okno().show();
    }
}
