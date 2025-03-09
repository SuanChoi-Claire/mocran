package MokRanSplitProgram;

public class Calculate {
	
	private Pocket pocket;  //Pocket객체를 저장할 필드선언
	public Calculate(Pocket pocket) { //생성자를 통해 Pocket 객체를 받음.
		this.pocket = pocket;
	}
	
	
	void printOderMenuOrCourse() {
		System.out.println(pocket.name + "님의 주문내역");
		if(pocket.menu_name != null) {
			System.out.println("------------------------");
			 System.out.println("식사: " + pocket.menu_name + " - " + pocket.menu_price + "원");
			 System.out.println("------------------------");
		}
			
		if (pocket.course_name != null) {
			System.out.println("------------------------");
            System.out.println("코스: " + pocket.course_name + " - " + pocket.course_price + "원");
            System.out.println("------------------------");
        }		
	}
	
	void printOderDish() { //for문 돌려야 할것 같은디
		if(pocket.dish_name !=null) {
			 System.out.println(pocket.dish_name + " - " + pocket.dish_price + "원");
		}
	}
	
	public long printOderMenuOrCourseTotal() {
		
		 return pocket.menu_price + pocket.course_price;
	}
	
	public long printOderDishTotal() {
		
		return pocket.dish_price;
		
	}	
	
	

}
