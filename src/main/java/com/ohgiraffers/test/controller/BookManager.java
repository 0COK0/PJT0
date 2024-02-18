package com.ohgiraffers.test.controller;


import com.ohgiraffers.comparator.AscCategory;
import com.ohgiraffers.comparator.DescCategory;
import com.ohgiraffers.test.model.dto.BookDTO;

import java.util.ArrayList;
import java.util.Comparator;

public class BookManager {
    private ArrayList<BookDTO> bookList;

    public BookManager() {
        this.bookList = new ArrayList<>();
    }

    public void addBook(BookDTO book) {
        bookList.add(book);
    }

    public void deleteBook(int index) {
        if (index >= 0 && index < bookList.size()) {
            bookList.remove(index);
        } else {
            System.out.println("유효하지 않은 인덱스입니다.");
        }
    }

    public int searchBook(String bTitle) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getTitle().equals(bTitle)) {
                return i;
            }
        }
        return -1;
    }

    public void printBook(int index) {
        if (index >= 0 && index < bookList.size()) {
            System.out.println(bookList.get(index));
        } else {
            System.out.println("유효하지 않은 인덱스입니다.");
        }
    }

    public void displayAll() {
        for (BookDTO book : bookList) {
            System.out.println(book);
        }
    }

    public ArrayList<BookDTO> sortedBookList(int select) {
        ArrayList<BookDTO> sortedList = new ArrayList<>(bookList);

        if (select == 1) {
            sortedList.sort(new AscCategory());
        } else if (select == 2) {
            sortedList.sort((Comparator<? super BookDTO>) new DescCategory());
        }

        return sortedList;

}

    public void printBookList(ArrayList<BookDTO> list) {
        for (BookDTO book : list) {
            System.out.println(book);
        }
    }
}