package com.nikijv.javahibernatehometask.service;

import com.nikijv.javahibernatehometask.model.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Book book) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(book);
    }

    @Transactional
    public void updateBook(Long id, Book updatedBook) {
        Session session = entityManager.unwrap(Session.class);
        Book existingBook = session.get(Book.class, id);
        if (existingBook != null) {
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setYear(updatedBook.getYear());
            existingBook.setGenre(updatedBook.getGenre());
            existingBook.setPages(updatedBook.getPages());
            existingBook.setDescription(updatedBook.getDescription());
            session.merge(existingBook);
        }
    }

    @Transactional
    public List<Book> getAllBooks() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("FROM Book", Book.class).getResultList();
    }

    @Transactional
    public Book getBookById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Book.class, id);
    }

    @Transactional
    public Book getBookByTitle(String title) {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("FROM Book WHERE title = :title", Book.class)
                .setParameter("title", title)
                .uniqueResult();
    }

    @Transactional
    public Book getBookByAuthor(String author) {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("FROM Book WHERE author = :author", Book.class)
                .setParameter("author", author)
                .uniqueResult();
    }

    @Transactional
    public Book getBookByYear(String year) {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("FROM Book WHERE year = :year", Book.class)
                .setParameter("year", year)
                .uniqueResult();
    }

    @Transactional
    public Book getBookByGenre(String genre) {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("FROM Book WHERE genre = :genre", Book.class)
                .setParameter("genre", genre)
                .uniqueResult();
    }

    @Transactional
    public Book getBookByPages(int pages) {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("FROM Book WHERE genre = :pages", Book.class)
                .setParameter("pages", pages)
                .uniqueResult();
    }

    @Transactional
    public Book getBookByDescriptionWord(String descriptionWord) {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("FROM Book WHERE description LIKE :description", Book.class)
                .setParameter("description", "%" + descriptionWord + "%")
                .uniqueResult();
    }

    @Transactional
    public void deleteBook(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Book book = session.get(Book.class, id);
        if (book != null) {
            session.remove(book);
        }
    }
}
