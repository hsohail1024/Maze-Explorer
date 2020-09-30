//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Exploring a Maze
// Files:           MazeRunnerStack.java, TestStack.java, Maze.java, StackADT.java
// Course:          CS 300, Spring, 2018
//
// Author:          Huzaifa Sohail
// Email:           hsohail@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    	
// Partner Email:   
// Lecturer's Name: 
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates 
// strangers, etc do.  If you received no outside help from either type of 
// source, then please explicitly indicate NONE.
//
// Persons:         NONE
// Online Sources:  NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.EmptyStackException;

public class TestStack {

	public static void main(String[] args) {
		boolean passAllTests = runTests();

		if (passAllTests) {
			System.out.println();
			System.out.println("All TESTS PASSED");
		} else {
			System.out.println("Test failed");
		}

	}

	public static boolean runTests() {
		boolean passAllTests = false;

		boolean testPush1 = pushTest(null);
		if (!testPush1) { // if test failed
			System.out.println("Failed: push from NULL value. Expected IllegalArgumentException.");
			passAllTests = false;
		} else {
			System.out.println("Test #1 push NULL value passed.");
			passAllTests = true;
		}

		//////////////////////////////////////////////////////////////////////////

		boolean testPush2 = pushTest(new Position(10, 50));
		if (!testPush2) { // if test passed
			System.out.println("Test #2 push(passing value in to push) passed.");
			passAllTests = true;
		} else {
			System.out.println("Test failed");
			passAllTests = false;
		}
		///////////////////////////////////////////////////////////////////////////

		boolean testPop1 = popTest();

		if (!testPop1) { // if test passed
			System.out.println("Pop Test #1 failed. Did not catch EmptyStackException");
			passAllTests = false;
		} else {
			System.out.println("Test #1 pop(no values in stack) passed.");
			passAllTests = true;
		}

		///////////////////////////////////////////////////////////////////////////

		boolean testPop2 = popTest();
		if (testPop2) {
			System.out.println("Test #2 pop passed (value in stack popped)");
			passAllTests = true;
		} else {
			System.out.println("Pop Test #2 failed.");
		}
		///////////////////////////////////////////////////////////////////////////

		boolean testPeek1 = peekTestEmptyStack();
		if (!testPeek1) {
			System.out.println("Peek Test #1 Empty Stack Test passed");
			passAllTests = true;
		}

		///////////////////////////////////////////////////////////////////////////

		Position testPeek2 = peekTestNonEmptyStack();
		if (testPeek2 != null) {
			System.out.println("Peek Test #2 non-empty stack passed");
			passAllTests = true;
		}

		///////////////////////////////////////////////////////////////////////////

		boolean testEmpty1 = emptyTest();
		if (!testEmpty1) {
			System.out.println("Empty Test #1 failed. Stack was not empty when items were popped");
		} else {
			System.out.println("Empty Test #1 Passed.");
			passAllTests = true;
		}

		////////////////////////////////////////////////////////////////////////////

		boolean testEmpty2 = emptyTestNotEmpty();

		if (!testEmpty2) {
			System.out.println("Empty Test #2 failed. Stack is empty");
		} else {
			System.out.println("Empty Test #2 passed. Stack has contents in it.");
			passAllTests = true;
		}

		////////////////////////////////////////////////////////////////////////////

		boolean testContains1 = containsTest(new Position(6, 50));
		if (!testContains1) {
			System.out.println(
					"Test #1 for test contains failed. Expeced true. Got: " + testContains1);
		} else {
			System.out.println("Test #1 for test contains passed.");
			passAllTests = true;
		}

		boolean testContains2 = notContainsTest(new Position(7, 100));
		if (!testContains2) {
			System.out.println("Test #2 for test contains passed.");
			passAllTests = true;
		} else {
			System.out.println(
					"Test #2 for test contains failed. Expeced false. Got: " + testContains2);
		}
		
		/////////////////////////////////////////////////////////////////////////////
		boolean testConstructor = constructorTest();
		if(testConstructor) {
			System.out.println("Test for testing constructor passed.");
		}else {
			System.out.println("Test for testing constructor failed.");
		}

		return passAllTests;

	}

	private static boolean pushTest(Position value) {
		MazeRunnerStack testPush = new MazeRunnerStack();

		try {
			testPush.push(value);
		} catch (IllegalArgumentException e) {
			return true;
		}

		return false;

	}

	private static boolean popTest() {
		
		MazeRunnerStack testPop = new MazeRunnerStack();
		Position popVar = new Position(12, 14);
		testPop.push(new Position(12, 14));

		try {
			popVar = testPop.pop();

		} catch (EmptyStackException e) {
			return false;
		}

		return true;
	}

	private static boolean peekTestEmptyStack() {
		MazeRunnerStack testPeek = new MazeRunnerStack();

		try {
			testPeek.peek();
		} catch (EmptyStackException e) {
			return false;
		}

		return true;

	}

	private static Position peekTestNonEmptyStack() {
		MazeRunnerStack testPeek = new MazeRunnerStack();
		testPeek.push(new Position(15, 20));
		testPeek.push(new Position(40, 50));
		testPeek.push(new Position(1, 10));

		Position peekVar = testPeek.pop();

		return peekVar;
	}

	private static boolean emptyTest() {
		MazeRunnerStack testEmpty = new MazeRunnerStack();
		testEmpty.push(new Position(5, 19));
		testEmpty.push(new Position(2, 40));
		testEmpty.push(new Position(12, 20));

		for (int i = 0; i < 3; i++) {
			testEmpty.pop();
		}

		if (testEmpty.isEmpty()) {
			return true;
		}

		return false;

	}

	private static boolean emptyTestNotEmpty() {

		MazeRunnerStack testEmpty = new MazeRunnerStack();
		testEmpty.push(new Position(5, 19));
		testEmpty.push(new Position(2, 40));
		testEmpty.push(new Position(12, 20));

		if (testEmpty.isEmpty()) {
			return false;
		}

		return true;

	}

	private static boolean containsTest(Position p) {
		MazeRunnerStack testContains = new MazeRunnerStack();

		testContains.push(new Position(5, 19));
		testContains.push(new Position(6, 50));

		boolean testResult = testContains.contains(p);

		return testResult;

	}

	private static boolean notContainsTest(Position p) {
		MazeRunnerStack testContains = new MazeRunnerStack();

		testContains.push(new Position(5, 19));
		testContains.push(new Position(6, 50));

		boolean testResult = testContains.contains(p);

		return testResult;

	}
	
	private static boolean constructorTest() {
		MazeRunnerStack constructorTest = new MazeRunnerStack();
		if(constructorTest.getSize() == 0) {
			return true;
		}
		return false;
	}
}
