package db;

public interface ODBC_CRUD {

    void select();

    void insert(String bookName, String bookAuthor, String bookPublisher, String bookImageUrl);

    void update(String targetBookName, String bookName, String bookAuthor, String bookPublisher, String bookImageUrl);

    void delete(String targetBookName);
}
