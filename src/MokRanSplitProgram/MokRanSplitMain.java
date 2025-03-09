package MokRanSplitProgram;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MokRanSplitMain {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println(" 안녕하세요 목란 더치페이 프로그램 입니다.");
        System.out.println(" 몇명이 방문예정이신가요? ");
        int howmany = input.nextInt();

        Pocket[] eachname = new Pocket[howmany];
        for (int i = 0; i < howmany; i++) {
            System.out.println("방문예정자 이름을 입력하세요.");
            String name = input.next();
            eachname[i] = new Pocket(name);
        }

        System.out.println("선택한 번호를 눌러주세요\n1.식사류(1인1메뉴)\n2.코스");
        int menuOrCourse = input.nextInt();
        Data data = new Data();  // Data 객체 한 번만 생성

        if (menuOrCourse == 1) {
            System.out.println("식사류 선택 1인1메뉴");
            data.printmenulist();
            List<Map.Entry<String, Integer>> menuListMa = data.getMenuListMap();

            if (menuListMa == null || menuListMa.isEmpty()) {
                System.out.println("⚠ 메뉴 리스트가 없습니다.");
            } else {
                for (int i = 0; i < howmany; i++) {
                    System.out.println(eachname[i].name + "님. 메뉴를 선택해주세요.");
                    int menuChoice = input.nextInt() - 1;

                    if (menuChoice >= 0 && menuChoice < menuListMa.size()) {
                        Map.Entry<String, Integer> selectedMenu = menuListMa.get(menuChoice);
                        eachname[i].menu(selectedMenu.getKey(), selectedMenu.getValue());
                        System.out.println("선택된 메뉴: " + selectedMenu.getKey() + " - " + selectedMenu.getValue() + "원");
                    } else {
                        System.out.println("잘못된 선택입니다. 다시 입력해주세요.");
                        i--; // 다시 선택하도록
                    }
                }
            }
        } else if (menuOrCourse == 2) {
            System.out.println("코스 선택 (1인 금액)");
            data.printCourseList();

            System.out.println("코스메뉴를 선택해주세요");
            int courseChoice = input.nextInt() - 1;

            if (data.courseNameList != null && data.coursePriceList != null &&
                courseChoice >= 0 && courseChoice < data.courseNameList.size()) {
                
                int selectedCoursePric = data.coursePriceList.get(courseChoice);
                String selectedCourseNam = data.courseNameList.get(courseChoice);

                for (int i = 0; i < howmany; i++) {
                    eachname[i].course(selectedCourseNam, selectedCoursePric);
                }
                System.out.println("선택된 코스: " + selectedCourseNam + " - " + selectedCoursePric + "원");
            } else {
                System.out.println("⚠ 잘못된 선택이거나 코스 데이터가 없습니다.");
            }
        } else {
            System.out.println("⚠ 잘못된 선택 입니다.");
        }

        System.out.println("요리를 선택할 경우 1 , 선택하지 않을경우 2 를 입력해주세요.");
        int dishOrNot = input.nextInt();
        Pocket[] eachdish = null; // `null`로 초기화

        if (dishOrNot == 1) {
            System.out.println("요리를 선택해주세요.");
            data.printdishlist();
            List<Map.Entry<String, Integer>> dishListMa = data.getDishListMap();

            if (dishListMa == null || dishListMa.isEmpty()) {
                System.out.println("⚠ 요리 리스트가 없습니다.");
            } else {
                System.out.println(" 몇개의 요리를 주문할 예정이신가요? ");
                int howmanydish = input.nextInt();
                eachdish = new Pocket[howmanydish];

                for (int i = 0; i < howmanydish; i++) {
                    System.out.println((i + 1) + "번째 요리를 선택해주세요.");
                    int dishChoice = input.nextInt() - 1;

                    if (dishChoice >= 0 && dishChoice < dishListMa.size()) {
                        Map.Entry<String, Integer> selectedDish = dishListMa.get(dishChoice);
                        eachdish[i] = new Pocket(selectedDish.getKey());
                        eachdish[i].dish(selectedDish.getKey(), selectedDish.getValue());
                        System.out.println("선택된 요리: " + selectedDish.getKey() + " - " + selectedDish.getValue() + "원");
                    } else {
                        System.out.println("잘못된 선택입니다. 다시 입력해주세요.");
                        i--;
                    }
                }
            }
        } else if (dishOrNot == 2) {
            System.out.println("요리를 선택하지 않았습니다.");
        } else {
            System.out.println("⚠ 잘못 입력하셨습니다.");
        }

        input.close();

        // 주문 내역 출력
        System.out.println("\n===== 📝 주문 내역 =====\n");
        for (int i = 0; i < howmany; i++) {
            Calculate calc = new Calculate(eachname[i]);
            calc.printOderMenuOrCourse();
        }

        // 요리 주문 내역 출력
        System.out.println("\n요리 주문내역");
        int totalDishPrice = 0;
        if (eachdish != null) {
            for (Pocket dish : eachdish) {
                if (dish != null) {
                    Calculate dishCalc = new Calculate(dish);
                    dishCalc.printOderDish();
                    totalDishPrice += dishCalc.printOderDishTotal();
                }
            }
        }

        // 더치페이 계산
        System.out.println("\n=========================");
        int dishSplit = (howmany > 0) ? totalDishPrice / howmany : 0;
        System.out.println("* 1인당 요리 더치페이 금액: " + dishSplit + "원\n");

        // 개별 지불 예상액 출력
        System.out.println("개별 지불 예상액");
        for (int i = 0; i < howmany; i++) {
            Calculate calc = new Calculate(eachname[i]);
            long totalAmount = calc.printOderMenuOrCourseTotal() + dishSplit;
            System.out.println(eachname[i].name + ": " + totalAmount + "원");
        }
    }
}
