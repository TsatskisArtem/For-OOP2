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
        // Создание окна
        bookList = new JFrame("Информация о книгах");
        bookList.setSize(600, 400);
        bookList.setLocation(100, 100);
        bookList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создание таблицы с данными
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
        books.setAutoCreateRowSorter(true); // Добавление сортировки
        scroll = new JScrollPane(books);

        // Размещение таблицы с данными
        bookList.getContentPane().add(scroll, BorderLayout.CENTER);

        // Добавление компонентов на панель
        JPanel filterPanel = new JPanel(new GridLayout(1, 4));

        // Размещение панели поиска вверху окна
        bookList.getContentPane().add(filterPanel, BorderLayout.NORTH);

        // Создание кнопок
        save = new JButton("Сохранить");
        add = new JButton("Добавить");
        edit = new JButton("Редактировать");
        delete = new JButton("Удалить");

        // Добавление кнопок на панель
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(save);
        buttonPanel.add(add);
        buttonPanel.add(edit);
        buttonPanel.add(delete);

        // Размещение панели кнопок внизу окна
        bookList.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Визуализация экранной формы
        bookList.setVisible(true);
    }

    public static void main(String[] args) {
        // Создание и отображение экранной формы
        new okno().show();
    }
}
