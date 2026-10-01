package org.example.javalab3.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.example.javalab3.model.Author;
import org.example.javalab3.model.Book;

public class BookOverviewController {

    @FXML
    private TableView<Book> bookTable;

    @FXML
    private TableColumn<Book, String> titleColumn;

    @FXML
    private TableColumn<Book, String> bindingColumn;

    @FXML
    private TableColumn<Book, String> publisherColumn;

    @FXML
    private TableColumn<Book, Number> yearColumn;

    @FXML
    private TableColumn<Book, String> genreColumn;

    @FXML
    private Label titleLabel;

    @FXML
    private Label bindingLabel;

    @FXML
    private Label publisherLabel;

    @FXML
    private Label yearLabel;

    @FXML
    private Label genreLabel;

    @FXML
    private Label authorNameLabel;

    @FXML
    private Label authorPhoneLabel;

    @FXML
    private Label authorEmailLabel;

    @FXML
    private Label authorRatingLabel;

    private final ObservableList<Book> bookData =
            FXCollections.observableArrayList();

    @FXML
    private void initialize() {

        titleColumn.setCellValueFactory(
                cellData -> cellData.getValue().titleProperty()
        );

        bindingColumn.setCellValueFactory(
                cellData -> cellData.getValue().bindingProperty()
        );

        publisherColumn.setCellValueFactory(
                cellData -> cellData.getValue().publisherProperty()
        );

        yearColumn.setCellValueFactory(
                cellData -> cellData.getValue().publicationYearProperty()
        );

        genreColumn.setCellValueFactory(
                cellData -> cellData.getValue().genreProperty()
        );

        bookTable.setItems(bookData);

        bookTable.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (observable, oldValue, newValue) ->
                                showBookDetails(newValue)
                );

        createBooks();
    }

    private void createBooks() {

        Author dostoevsky = new Author(
                "Фёдор Михайлович Достоевский",
                "+7 (900) 111-11-11",
                "dostoevsky@mail.ru",
                4.9
        );

        Author tolstoy = new Author(
                "Лев Николаевич Толстой",
                "+7 (900) 222-22-22",
                "tolstoy@mail.ru",
                5.0
        );

        Author pushkin = new Author(
                "Александр Сергеевич Пушкин",
                "+7 (900) 333-33-33",
                "pushkin@mail.ru",
                4.9
        );

        Author bulgakov = new Author(
                "Михаил Афанасьевич Булгаков",
                "+7 (900) 444-44-44",
                "bulgakov@mail.ru",
                4.8
        );

        Author chekhov = new Author(
                "Антон Павлович Чехов",
                "+7 (900) 555-55-55",
                "chekhov@mail.ru",
                4.8
        );

        Author gogol = new Author(
                "Николай Васильевич Гоголь",
                "+7 (900) 666-66-66",
                "gogol@mail.ru",
                4.7
        );

        Author turgenev = new Author(
                "Иван Сергеевич Тургенев",
                "+7 (900) 777-77-77",
                "turgenev@mail.ru",
                4.7
        );

        Author remark = new Author(
                "Эрих Мария Ремарк",
                "+7 (900) 888-88-88",
                "remark@mail.ru",
                4.9
        );

        Author rowling = new Author(
                "Джоан Роулинг",
                "+7 (900) 999-99-99",
                "rowling@mail.ru",
                4.8
        );

        Author king = new Author(
                "Стивен Кинг",
                "+7 (901) 111-11-11",
                "king@mail.ru",
                4.9
        );

        Author hemingway = new Author(
                "Эрнест Хемингуэй",
                "+7 (901) 222-22-22",
                "hemingway@mail.ru",
                4.8
        );

        Author martin = new Author(
                "Джордж Мартин",
                "+7 (901) 333-33-33",
                "martin@mail.ru",
                4.7
        );

        bookData.addAll(

                new Book(
                        "Преступление и наказание",
                        "Твёрдый",
                        "Эксмо",
                        2020,
                        "Роман",
                        dostoevsky
                ),

                new Book(
                        "Идиот",
                        "Твёрдый",
                        "АСТ",
                        2019,
                        "Роман",
                        dostoevsky
                ),

                new Book(
                        "Война и мир",
                        "Твёрдый",
                        "Азбука",
                        2021,
                        "Роман",
                        tolstoy
                ),

                new Book(
                        "Анна Каренина",
                        "Мягкий",
                        "Эксмо",
                        2020,
                        "Роман",
                        tolstoy
                ),

                new Book(
                        "Евгений Онегин",
                        "Твёрдый",
                        "Азбука",
                        2018,
                        "Роман",
                        pushkin
                ),

                new Book(
                        "Мастер и Маргарита",
                        "Твёрдый",
                        "АСТ",
                        2022,
                        "Роман",
                        bulgakov
                ),

                new Book(
                        "Вишнёвый сад",
                        "Мягкий",
                        "Эксмо",
                        2017,
                        "Пьеса",
                        chekhov
                ),

                new Book(
                        "Мёртвые души",
                        "Твёрдый",
                        "Азбука",
                        2021,
                        "Сатира",
                        gogol
                ),

                new Book(
                        "Отцы и дети",
                        "Мягкий",
                        "АСТ",
                        2019,
                        "Роман",
                        turgenev
                ),

                new Book(
                        "Три товарища",
                        "Твёрдый",
                        "Эксмо",
                        2020,
                        "Роман",
                        remark
                ),

                new Book(
                        "Гарри Поттер и философский камень",
                        "Твёрдый",
                        "Махаон",
                        2021,
                        "Фэнтези",
                        rowling
                ),

                new Book(
                        "Зелёная миля",
                        "Твёрдый",
                        "АСТ",
                        2022,
                        "Фантастика",
                        king
                )
        );
    }

    private void showBookDetails(Book book) {

        if (book == null) {
            return;
        }

        titleLabel.setText(book.getTitle());
        bindingLabel.setText(book.getBinding());
        publisherLabel.setText(book.getPublisher());
        yearLabel.setText(String.valueOf(book.getPublicationYear()));
        genreLabel.setText(book.getGenre());

        Author author = book.getAuthor();

        authorNameLabel.setText(author.getFullName());
        authorPhoneLabel.setText(author.getPhone());
        authorEmailLabel.setText(author.getEmail());
        authorRatingLabel.setText(
                String.valueOf(author.getRating())
        );
    }
}