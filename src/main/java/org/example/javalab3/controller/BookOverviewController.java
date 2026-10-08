package org.example.javalab3.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
                cellData -> cellData.getValue().titleProperty()
        );

        bindingColumn.setCellValueFactory(
                cellData -> cellData.getValue().bindingProperty()
        );

        publisherColumn.setCellValueFactory(
                cellData -> cellData.getValue().publisherProperty()
        );

        yearColumn.setCellValueFactory(
                cellData -> cellData.getValue()
                        .publicationYearProperty()
                        .asObject()
        );

        genreColumn.setCellValueFactory(
                cellData -> cellData.getValue().genreProperty()
        );

        showBookDetails(null);

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

        if (book != null) {

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

        } else {

            titleLabel.setText("");
            bindingLabel.setText("");
            publisherLabel.setText("");
            yearLabel.setText("");
            genreLabel.setText("");
            authorNameLabel.setText("");
            authorPhoneLabel.setText("");
            authorEmailLabel.setText("");
            authorRatingLabel.setText("");
        }
    }

    @FXML
    private void handleNewBook() {

        Book tempBook = new Book();

        boolean okClicked =
                mainApp.showBookEditDialog(tempBook);

        if (okClicked) {
            mainApp.getBookData().add(tempBook);

            bookTable.getSelectionModel()
                    .select(tempBook);
        }
    }

    @FXML
    private void handleEditBook() {

        Book selectedBook =
                bookTable.getSelectionModel()
                        .getSelectedItem();

        if (selectedBook != null) {

            boolean okClicked =
                    mainApp.showBookEditDialog(selectedBook);

            if (okClicked) {
                showBookDetails(selectedBook);
                bookTable.refresh();
            }

        } else {

            showNoSelectionAlert(
                    "Не выбрана книга",
                    "Выберите книгу в таблице."
            );
        }
    }

    @FXML
    private void handleDeleteBook() {

        int selectedIndex =
                bookTable.getSelectionModel()
                        .getSelectedIndex();

        if (selectedIndex >= 0) {

            Alert confirmation = new Alert(
                    Alert.AlertType.CONFIRMATION
            );

            confirmation.initOwner(
                    mainApp.getPrimaryStage()
            );

            confirmation.setTitle("Удаление книги");
            confirmation.setHeaderText(
                    "Удалить выбранную книгу?"
            );
            confirmation.setContentText(
                    "Книга будет удалена из каталога."
            );

            if (confirmation.showAndWait()
                    .orElse(ButtonType.CANCEL)
                    == ButtonType.OK) {

                bookTable.getItems()
                        .remove(selectedIndex);
            }

        } else {

            showNoSelectionAlert(
                    "Не выбрана книга",
                    "Выберите книгу в таблице."
            );
        }
    }

    private void showNoSelectionAlert(
            String title,
            String message
    ) {

        Alert alert = new Alert(
                Alert.AlertType.WARNING
        );

        alert.initOwner(
                mainApp.getPrimaryStage()
        );

        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }
}