package at.ac.testing.pbnj;

public class SubClassTest {

	public void simpleTest() {
		SuperClass superClass = new SuperClass();

		// Do the init
		superClass.init();
		System.out.println("\nSubClassTest.simpleTest() INIT: " + superClass);

		// This does not work !
		// Do the resize - modifies the objects inside SuperClass/SubClass
		superClass.resize(10);
		System.out.println("\nSubClassTest.simpleTest() RESIZE: " + superClass);
		
		superClass.resize(3);
		System.out.println("\nSubClassTest.simpleTest() RESIZE 3: " + superClass);


		// this fails when the class must modify an array of objects
		SubClass subClass = new SubClass();
		subClass.init();
		System.out.println("\nSubClassTest.simpleTest() INIT: " + subClass);

		subClass.resize(10);
		System.out.println("\nSubClassTest.simpleTest() RESIZE:" + subClass);

		
		subClass.resize(3);
		System.out.println("\nSubClassTest.simpleTest() RESIZE 3:" + subClass);
		/*
		*/
	}

	public static void main(String[] args) {
		SubClassTest test = new SubClassTest();
		test.simpleTest();
	}
}
