import React, { useState } from 'react';
import { Button, Form } from 'react-bootstrap';
import {useNavigate} from 'react-router-dom'

const SaveForm = (props) => {

    const navigate = useNavigate();

    const[book, setBook] = useState({
        title:"",
        author:"",
    });

    const changeValue = (e) => {
        setBook({
            ...book,
            [e.target.name] : e.target.value
        })
    }

    const submitBook = (e) => {
        e.preventDefault(); //submit이 action을 안타고 자기 할 일을 그만함
        fetch("http://localhost:8080/book", {
            method : "POST",
            headers : {
                "Content-Type" : "application/json; charset=utf-8"
            },
            body : JSON.stringify(book),
        }).then((res) => {
            console.log(res);
            if(res.status === 200) {
                return res.json();
            } else {
                return null;
            }
        })
        .then((res) => {
            if(res !== null) {
                navigate("/");
            } else {
                alert("책 등록에 실패하였습니다")
            }
        });
    }

    return (
        <Form onSubmit={submitBook}>
  <Form.Group className="mb-3" controlId="formBasicEmail">
    <Form.Label>TITLE</Form.Label>
    <Form.Control type="text" placeholder="Enter Title" onChange={changeValue} name="title" />
    <Form.Text className="text-muted">
    </Form.Text>
  </Form.Group>

  <Form.Group className="mb-3" controlId="formBasicEmail">
    <Form.Label>AUTHOR</Form.Label>
    <Form.Control type="text" placeholder="Enter Author" onChange={changeValue} name="author" />
    <Form.Text className="text-muted">
    </Form.Text>
  </Form.Group>
  
  <Button variant="primary" type="submit">
    Submit
  </Button>
</Form>
    );
};

export default SaveForm;