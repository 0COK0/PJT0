package com.ohgiraffers.test.view;


import com.ohgiraffers.test.controller.BookManager;
import com.ohgiraffers.test.model.dto.BookDTO;

import java.util.ArrayList;
import java.util.Scanner;

public class BookMenu {
    private Scanner sc;
    private BookManager bm;

    public BookMenu() {
        this.sc = new Scanner(System.in);
        this.bm = new BookManager();
    }

    public void menu() {
        while (true) {
            System.out.println("1. 도서 추가");
            System.out.println("2. 도서 삭제");
            System.out.println("3. 도서 검색");
            System.out.println("4. 도서 출력");
            System.out.println("5. 전체 도서 출력");
            System.out.println("6. 도서 정렬");
            System.out.println("0. 종료");

            System.out.print("메뉴를 선택하세요: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Enter 키 처리

            switch (choice) {
                case 1:
                    BookDTO newBook = inputBook();
                    bm.addBook(newBook);
                    break;
                case 2:
                    System.out.print("삭제할 도서 번호를 입력하세요: ");
                    int deleteIndex = sc.nextInt();
                    bm.deleteBook(deleteIndex);
                    break;
                case 3:
                    System.out.print("검색할 도서 제목을 입력하세요: ");
                    String searchTitle = sc.nextLine();
                    int searchIndex = bm.searchBook(searchTitle);
                    if (searchIndex != -1) {
                        System.out.println("검색 결과: ");
                        bm.printBook(searchIndex);
                    } else {
                        System.out.println("해당 도서를 찾을 수 없습니다.");
                    }
                    break;
                case 4:
                    System.out.print("출력할 도서 번호를 입력하세요: ");
                    int printIndex = sc.nextInt();
                    bm.printBook(printIndex);
                    break;
                case 5:
                    System.out.println("전체 도서 목록을 출력합니다.");
                    bm.displayAll();
                    break;
                case 6:
                    System.out.println("도서를 정렬합니다.");
                    System.out.println("1. 카테고리 오름차순 정렬");
                    System.out.println("2. 카테고리 내림차순 정렬");
                    int sortChoice = sc.nextInt();
                    ArrayList<BookDTO> sortedList = bm.sortedBookList(sortChoice);
                    bm.printBookList(sortedList);
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("유효하지 않은 메뉴입니다. 다시 선택하세요.");
            }
        }
    }

    public BookDTO inputBook() {
        System.out.print("도서 번호를 입력하세요: ");
        int bNo = sc.nextInt();

        System.out.print("도서 카테고리를 입력하세요(1:인문, 2:자연과학, 3:의료, 4:기타): ");
        int category = sc.nextInt();

        sc.nextLine(); // Enter 키 처리

        System.out.print("도서 제목을 입력하세요: ");
        String title = sc.nextLine();

        System.out.print("도서 저자를 입력하세요: ");
        String author = sc.nextLine();

        return new BookDTO(bNo, category, title, author);
    }
}
