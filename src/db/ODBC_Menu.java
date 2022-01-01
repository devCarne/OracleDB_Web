package db;

import java.util.Scanner;

public class ODBC_Menu {

    ODBC_Menu(){
        Scanner scanner = new Scanner(System.in);

        ODBC_DAO dao = new ODBC_DAO();

        while (true) {
            System.out.println("1: 조회, 2: 삽입, 3: 수정, 4: 삭제, 5: 종료");

            int toDo = Integer.parseInt(scanner.nextLine());

            String name, author, publisher, imgUrl, target;

            switch (toDo) {
                case 1:
                    dao.select();
                    break;
                case 2:
                    System.out.print("책 제목 : ");
                    name = scanner.nextLine();
                    System.out.print("책 작가 : ");
                    author = scanner.nextLine();
                    System.out.print("책 출판사 : ");
                    publisher = scanner.nextLine();
                    System.out.print("책 이미지 : ");
                    imgUrl = scanner.nextLine();

                    dao.insert(name, author, publisher, imgUrl);
                    break;
                case 3:
                    System.out.print("변경하고 싶은 책 제목 : ");
                    target = scanner.nextLine();
                    System.out.print("책 제목 : ");
                    name = scanner.nextLine();
                    System.out.print("책 작가 : ");
                    author = scanner.nextLine();
                    System.out.print("책 출판사 : ");
                    publisher = scanner.nextLine();
                    System.out.print("책 이미지 : ");
                    imgUrl = scanner.nextLine();

                    dao.update(target, name, author, publisher, imgUrl);
                    break;
                case 4:
                    System.out.print("삭제하고 싶은 책 제목 : ");
                    target = scanner.nextLine();

                    dao.delete(target);
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 명령입니다.");
                    break;
            }
        }
    }
}
