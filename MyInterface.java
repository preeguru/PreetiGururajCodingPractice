
public interface MyInterface {
	
	static int add(int a, int b) {
		return a+b;
	}
	
	int getPersonAge(String name);

	default void defaultMethod() {
		System.out.println("This is a default method");
	}
	
	int myAdd(int a,int b);
}

