package MokRanSplitProgram;

public class Pocket {
	
	//Scanner 로 받아서 저장할 애들 
	//주머니 만들기
	
	String name; 
	
	String menu;
	String menu_name;
	long menu_price;
	
	String course;
	String course_name;
	long course_price;
	
	String dish;
	String dish_name;
	long dish_price;
	
	
	Pocket(String name){ // 표 행 첫번째 칸 만들기 생성자.
		this.name = name ;
	}
	//매서드 
	public void menu(String menu_name , long menu_price){ //표 열 두번쨰 칸에 들어갈 애들  
		this.menu_name = menu_name;
		this.menu_price = menu_price;
	}
	
	public void course(String course_name, long course_price) {
		this.course_name = course_name;
		this.course_price = course_price;
	}
	
	public void dish(String dish_name, long dish_price) {
		this.dish_name = dish_name;
		this.dish_price = dish_price;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
