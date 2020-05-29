package collections;

interface Runnable {
	public void run();
}

class Car implements Runnable {
	@Override
	public void run() {
		System.out.println("자동차 달린다.");
	}
}

class Bus implements Runnable {
	@Override
	public void run() {
		System.out.println("버스가 달린다.");
	}
}

public class ImplementsClass {
	//메소드 구현.
	
	public static void callRun(Runnable runnable) {
		runnable.run();
	}
	
	
	public static void main(String[] args) {
		Runnable runnable = new Car();
		runnable.run();
		runnable = new Bus();
		runnable.run();
		runnable = () -> System.out.println("익명객체 달립니다."); //익명객체 람다식표현
		runnable.run();

//		runnable = new Runnable() { //익명객체 : 인터페이스명 쓰고 여기에 구현도 적어줌
//			@Override
//			public void run() {
//				System.out.println("익명객체 달립니다.");
//			}
//		};
//		runnable.run();
		
		
		callRun(new Car());
		callRun(() -> System.out.println("메소드 매개값 달립니다.")); //람다식 (익명객체)
//		callRun(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("메소드 매개값 달립니다.");
//			}
//		});
		
	}
}
