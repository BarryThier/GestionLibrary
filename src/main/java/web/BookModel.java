package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Books;

public class BookModel {
    private String keyWords;
    private List<Books> books = new ArrayList<>();
    
    public String getKeywords() {
        return keyWords;
    }
    
    public void setKeywords(String keywords) {
        this.keyWords = keywords;
    }
    
    public List<Books> getBooks() {
        return books;
    }
    
    public void setBooks(List<Books> books) {
        this.books = books;
    }
}
