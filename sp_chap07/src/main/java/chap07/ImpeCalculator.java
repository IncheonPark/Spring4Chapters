package chap07;

public class ImpeCalculator implements Calculator {
	
	@Override
	public long factorial(long num) {
		long result = 1;
		
		//for문을 이용한 팩토리얼
		for (int i =1; i <= num; i++) {
			result *= i;
		}
		return result;
	}

}
