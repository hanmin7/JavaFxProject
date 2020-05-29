package collections;

interface Runnablee<T> { //제너릭
	public void run(T t);
}

class Caar implements Runnablee<String> {
	@Override
	public void run(String str) {
		System.out.println("자동차 달린다.");
	}
}

class Buus implements Runnablee<String> {
	@Override
	public void run(String intVal) {
		System.out.println("버스가 달린다.");
	}
}

public class ImplementsClass2 {
	//메소드 구현.
	
	public static void callRun(Runnablee<String> runnable) {
		runnable.run("Hello");
	}
	
	
	public static void main(String[] args) {
		Runnablee<String> runnable = new Caar();
		runnable.run("Car");
		runnable = new Buus();
		runnable.run("Bus");
		runnable = (str) -> System.out.println("익명객체 달립니다."); //익명객체 람다식표현
		runnable.run("Run");

//		runnable = new Runnable() { //익명객체 : 인터페이스명 쓰고 여기에 구현도 적어줌
//			@Override
//			public void run() {
//				System.out.println("익명객체 달립니다.");
//			}
//		};
//		runnable.run();
		
		
		callRun(new Caar());
		callRun((str) -> System.out.println("메소드 매개값 달립니다.")); //람다식 (익명객체)
//		callRun(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("메소드 매개값 달립니다.");
//			}
//		});
		
	}
}
