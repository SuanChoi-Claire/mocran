package MokRanSplitProgram;

import java.util.ArrayList; 
import java.util.List;
import java.util.AbstractMap;
import java.util.Map;

public class Data {

	// 식사 /////////////////////////////////////////////////////////////////////
	// 식사 데이터 map으로 요리 각각에 이름과 메뉴 넣었다.

	public List<Map.Entry<String, Integer>> menuListMap;

	public List<Map.Entry<String, Integer>> getMenuListMap() {

		if (menuListMap == null) {
			menuListMap = new ArrayList<>();
			menuListMap.add(new AbstractMap.SimpleEntry<>("짜장면", 10000));
			menuListMap.add(new AbstractMap.SimpleEntry<>("짬뽕", 15000));
			menuListMap.add(new AbstractMap.SimpleEntry<>("긴스면", 11000));
			menuListMap.add(new AbstractMap.SimpleEntry<>("울면", 13000));
		}
		return menuListMap;

	}

	public void printmenulist() { // 메뉴 리스트 뽑은 메서드
		getMenuListMap();
		String menuList = "";
		System.out.println("*****식사 메뉴 리스트*****");

		int index = 0;
		for (Map.Entry<String, Integer> entry : menuListMap) {
			menuList = (index + 1) + "." + entry.getKey() + " - 가격: " + entry.getValue() + "원";
			System.out.println(menuList); // 각 항목을 출력한다.
			index++;
		}
		System.out.println("**********************");
	}

	// 코스 ////////////////////////////////////////////////////////////////////////

	// 새로운 메뉴 데이터를 저장할 리스트
	public List<String> courseNameList;
	public List<String> courseMealList;
	public List<Integer> coursePriceList;

	// 새로운 메뉴 데이터를 초기화하는 메서드
	public void courseList() {
		courseNameList = new ArrayList<>();
		courseMealList = new ArrayList<>();
		coursePriceList = new ArrayList<>();

		courseNameList.add("A코스");
		courseNameList.add("B코스");
		courseNameList.add("C코스");
		courseNameList.add("D코스");

		courseMealList.add("\n짜장면\n짬뽕\n탕수육\n");
		courseMealList.add("\n짜장면\n짬뽕\n탕수육\n");
		courseMealList.add("\n짜장면\n짬뽕\n탕수육\n");
		courseMealList.add("\n짜장면\n짬뽕\n탕수육\n");

		coursePriceList.add(30000);
		coursePriceList.add(35000);
		coursePriceList.add(40000);
		coursePriceList.add(55000);
	}

	// course List 를 출력하는 메서드
	public void printCourseList() {
		if (courseNameList == null) {  // ✅ courseList() 자동 호출
	        courseList();
	    }
		System.out.println("*****코스 메뉴 리스트*****");
		int index = 0;

		for (int i = 0; i < courseNameList.size(); i++) {
			String courseList = String.valueOf(index + 1) + "." + courseNameList.get(i) + "-" + coursePriceList.get(i)
					+ "원" + courseMealList.get(i) + "------------------";
			System.out.println(courseList); // 각 코스 메뉴 항목을 출력 String.valueOf >숫자를 문자열로 바꿔서 순서 유지에 도움
			index++;
		}
		System.out.println("**********************");
	}

	
	
	//요리//////////////////////////////////////////////////////////////////////////
	
	public List<Map.Entry<String, Integer>> dishListMap;

	public List<Map.Entry<String, Integer>> getDishListMap() {

		if (dishListMap == null) {
			dishListMap = new ArrayList<>();
			dishListMap.add(new AbstractMap.SimpleEntry<>("동파육", 50000));
			dishListMap.add(new AbstractMap.SimpleEntry<>("멘보샤", 45000));
			dishListMap.add(new AbstractMap.SimpleEntry<>("어향가지", 31000));
			dishListMap.add(new AbstractMap.SimpleEntry<>("또뭐잇찌", 33000));
		}
		return dishListMap;

	}
	
	

	public void printdishlist() { // 메뉴 리스트 뽑은 메서드
		getDishListMap();
		String dishList = "";
		System.out.println("*****요리 메뉴 리스트*****");

		int index = 0;
		for (Map.Entry<String, Integer> entry : dishListMap) {
			dishList = (index + 1) + "." + entry.getKey() + " - 가격: " + entry.getValue() + "원";
			System.out.println(dishList); // 각 항목을 출력한다.
			index++;
		}
		System.out.println("**********************");
	}
}
