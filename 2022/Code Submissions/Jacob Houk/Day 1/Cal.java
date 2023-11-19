package Day1;


public class Cal {
	private int calorie;
	   
	   public Cal() {
	      this.calorie = 0;
	   }
	   
	   public Cal(int a) {
	      this.calorie = a;
	   }
	   
	   public void add(int a) {
	      this.calorie += a;
	   }
	   
	   public int getCalorie() {
	      return this.calorie;
	   }
	   
	   @Override
	   public String toString() {
	      return "" + this.calorie;
	   }
}
