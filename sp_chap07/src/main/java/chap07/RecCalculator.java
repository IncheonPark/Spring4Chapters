package chap07;

public class RecCalculator implements Calculator {
	
	@Override
	public long factorial(long num) {
		
		//재귀호출을 이용한 팩토리얼
		if (num == 0)
			return 1;
		else
			return num * factorial(num -1);
	}

}
