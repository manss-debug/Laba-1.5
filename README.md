# Лабораторная работа 1.4

## Работа с классом-моделью, ObservableList и TableView

### Цель работы

Создать класс-модель предметной области, использовать его в коллекции `ObservableList` и реализовать отображение данных в компоненте `TableView` с помощью контроллера.

---

## Задание

1. Создать класс-модель.
2. Использовать класс-модель в коллекции `ObservableList`.
3. Отобразить данные в компоненте `TableView` с помощью контроллера.

---

## Предметная область

В работе используется предметная область **«Электронный каталог книг»**.

### Книга

- Название
- Переплёт
- Издательство
- Год издания
- Жанр
- Автор

### Автор

- ФИО
- Телефон
- E-mail
- Рейтинг

---

## Используемые технологии

- Java
- JavaFX
- FXML
- Maven
- IntelliJ IDEA
- Scene Builder
- ObservableList
- TableView
- MVC

---

## Структура проекта

```text
JavaLab3
│
├── src
│   └── main
│       ├── java
│       │   └── org.example.javalab3
│       │       ├── controller
│       │       │   └── BookOverviewController.java
│       │       │
│       │       ├── model
│       │       │   ├── Book.java
│       │       │   └── Author.java
│       │       │
│       │       └── Launcher.java
│       │
│       └── resources
│           └── org.example.javalab3
│               └── BookOverview.fxml
│
├── module-info.java
├── pom.xml
└── README.md
