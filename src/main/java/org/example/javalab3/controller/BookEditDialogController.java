package org.example.javalab3.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.javalab3.model.Author;
import org.example.javalab3.model.Book;

public class BookEditDialogController {

    @FXML
    private TextField titleField;

    @FXML
    private TextField bindingField;

    @FXML
    private TextField publisherField;

    @FXML
    private TextField yearField;

    @FXML
    private TextField genreField;

    @FXML
    private TextField authorNameField;

    @FXML
    private TextField authorPhoneField;

    @FXML
    private TextField authorEmailField;

    @FXML
    private TextField authorRatingField;

    private Stage dialogStage;

    private Book book;

    private boolean okClicked = false;

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setBook(Book book) {

        this.book = book;

        titleField.setText(book.getTitle());
        bindingField.setText(book.getBinding());
        publisherField.setText(book.getPublisher());
        yearField.setText(
                String.valueOf(book.getPublicationYear())
        );
        genreField.setText(book.getGenre());

        Author author = book.getAuthor();

        authorNameField.setText(
                author.getFullName()
        );

        authorPhoneField.setText(
                author.getPhone()
        );

        authorEmailField.setText(
                author.getEmail()
        );

        authorRatingField.setText(
                String.valueOf(author.getRating())
        );
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {

        if (!isInputValid()) {
            return;
        }

        book.setTitle(
                titleField.getText().trim()
        );

        book.setBinding(
                bindingField.getText().trim()
        );

        book.setPublisher(
                publisherField.getText().trim()
        );

        book.setPublicationYear(
                Integer.parseInt(
                        yearField.getText().trim()
                )
        );

        book.setGenre(
                genreField.getText().trim()
        );

        Author author = book.getAuthor();

        author.setFullName(
                authorNameField.getText().trim()
        );

        author.setPhone(
                authorPhoneField.getText().trim()
        );

        author.setEmail(
                authorEmailField.getText().trim()
        );

        author.setRating(
                Double.parseDouble(
                        authorRatingField.getText().trim()
                )
        );

        okClicked = true;

        dialogStage.close();
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {

        StringBuilder errorMessage =
                new StringBuilder();

        if (titleField.getText() == null ||
                titleField.getText().trim().isEmpty()) {

            errorMessage.append(
                    "Введите название книги.\n"
            );
        }

        if (bindingField.getText() == null ||
                bindingField.getText().trim().isEmpty()) {

            errorMessage.append(
                    "Введите тип переплёта.\n"
            );
        }

        if (publisherField.getText() == null ||
                publisherField.getText().trim().isEmpty()) {

            errorMessage.append(
                    "Введите издательство.\n"
            );
        }

        if (yearField.getText() == null ||
                yearField.getText().trim().isEmpty()) {

            errorMessage.append(
                    "Введите год издания.\n"

            );

        } else {

            try {

                int year = Integer.parseInt(
                        yearField.getText().trim()
                );

                if (year < 1000 || year > 2026) {
                    errorMessage.append(
                            "Год должен быть от 1000 до 2026.\n"
                    );
                }

            } catch (NumberFormatException e) {

                errorMessage.append(
                        "Год должен быть целым числом.\n"
                );
            }
        }

        if (genreField.getText() == null ||
                genreField.getText().trim().isEmpty()) {

            errorMessage.append(
                    "Введите жанр.\n"
            );
        }

        if (authorNameField.getText() == null ||
                authorNameField.getText().trim().isEmpty()) {

            errorMessage.append(
                    "Введите ФИО автора.\n"
            );
        }

        if (authorPhoneField.getText() == null ||
                authorPhoneField.getText().trim().isEmpty()) {

            errorMessage.append(
                    "Введите телефон автора.\n"
            );
        }

        if (authorEmailField.getText() == null ||
                authorEmailField.getText().trim().isEmpty()) {

            errorMessage.append(
                    "Введите E-mail автора.\n"

            );

        } else if (!authorEmailField.getText()
                .trim()
                .matches("^[A-Za-zА-Яа-я0-9._%+-]+@[A-Za-zА-Яа-я0-9.-]+\\.[A-Za-zА-Яа-я]{2,}$")) {

            errorMessage.append(
                    "Введите корректный E-mail.\n"
            );
        }

        if (authorRatingField.getText() == null ||
                authorRatingField.getText().trim().isEmpty()) {

            errorMessage.append(
                    "Введите рейтинг автора.\n"

            );

        } else {

            try {

                double rating = Double.parseDouble(
                        authorRatingField.getText()
                                .trim()
                );

                if (rating < 0 || rating > 5) {

                    errorMessage.append(
                            "Рейтинг должен быть от 0 до 5.\n"
                    );
                }

            } catch (NumberFormatException e) {

                errorMessage.append(
                        "Рейтинг должен быть числом.\n"
                );
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        }

        Alert alert = new Alert(
                Alert.AlertType.ERROR
        );

        alert.initOwner(dialogStage);

        alert.setTitle("Ошибка ввода");

        alert.setHeaderText(
                "Проверьте введённые данные"
        );

        alert.setContentText(
                errorMessage.toString()
        );

        alert.showAndWait();

        return false;
    }
}