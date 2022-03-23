import React, { useEffect, useState } from 'react';
import BookItem from '../../components/BookItem';

const Home = () => {

    const [books, setbooks] = useState([])

//함수 실행시 최초 한 번 실행되는 것
    useEffect(()=> {
        fetch("http://localhost:8080/book")
        .then(res=>res.json())
        .then((res)=> {
            console.log(1,res);
            setbooks(res);
        }); //비동기 함수
    },[])

    return (
        <div>
            {books.map((book) => (
            <BookItem key={book.id} book={book}/>
            ))}
        </div>
    );
};

export default Home;