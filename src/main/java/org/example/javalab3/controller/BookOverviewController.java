package org.example.javalab3.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.example.javalab3.Launcher;
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
    private TableColumn<Book, Integer> yearColumn;

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

    private Launcher mainApp;

    @FXML
    private void initialize() {

        titleColumn.setCellValueFactory(
                cellData ->
                        cellData.getValue().titleProperty()
        );

        bindingColumn.setCellValueFactory(
                cellData ->
                        cellData.getValue().bindingProperty()
        );

        publisherColumn.setCellValueFactory(
                cellData ->
                        cellData.getValue().publisherProperty()
        );

        yearColumn.setCellValueFactory(
                cellData ->
                        cellData.getValue()
                                .publicationYearProperty()
                                .asObject()
        );

        genreColumn.setCellValueFactory(
                cellData ->
                        cellData.getValue().genreProperty()
        );

        bookTable.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (observable, oldValue, newValue) ->
                                showBookDetails(newValue)
                );
    }

    public void setMainApp(Launcher mainApp) {
        this.mainApp = mainApp;
        bookTable.setItems(mainApp.getBookData());
    }

    private void showBookDetails(Book book) {

        if (book == null) {
            return;
        }

        titleLabel.setText(book.getTitle());
        bindingLabel.setText(book.getBinding());
        publisherLabel.setText(book.getPublisher());
        yearLabel.setText(
                String.valueOf(book.getPublicationYear())
        );
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