package com.react.book.service;

import com.react.book.domain.Book;
import com.react.book.domain.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //기능을 정의할 수 있고, 트랜잭션을 관리할 수 있음.
@RequiredArgsConstructor //final이 붙어있는 생성자 만듦
public class BookService {

    private final BookRepository bookRepository;

    @Transactional //서비스 함수가 종료될 때 commit 할 지 rollback할 지 트랜잭션 관리하겠다.
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Transactional(readOnly = true) // Jpa 변경감지라는 내부기능 활성화 X, update시의 정합성을 유지해줌, insert와 유령데이터현상 못막음
    public Book select(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Id를 확안해주세요."));
    }

    @Transactional(readOnly = true)
    public List<Book> selectAll() {
        return bookRepository.findAll();
    }

    @Transactional
    public Book update(Long id, Book book) {
        //더티체킹
        Book bookEntity = bookRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Id를 확안해주세요.")); // Book 오브젝트 영속화 ->  영속성 컨텍스트에 보관
        bookEntity.setTitle(book.getTitle());
        bookEntity.setAuthor(book.getAuthor());
        return bookEntity;
    } //함수 종료 => 트랜잭션 종료 => 영속화 되어있는 데이터를 DB로 생신(flush) => 이때 commit (더티체킹)

    public String delete(Long id) {
        bookRepository.deleteById(id);
        return "ok";
    }

}
