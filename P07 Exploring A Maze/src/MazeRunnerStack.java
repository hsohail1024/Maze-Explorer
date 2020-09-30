
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
//
import java.util.EmptyStackException;

public class MazeRunnerStack implements StackADT<Position> {

	private int size;
	private Position[] stack;

	/**
	 * constructor for MazeRunnerStack initializes the stack array and sets size to
	 * 0
	 */
	public MazeRunnerStack() {
		stack = new Position[50];
		size = 0;
	}

	/**
	 * This method pushes the item into the stack and increments the stack size if
	 * size of stack is equal to the array, call extendArray and then put the item
	 * onto the stack
	 */

	@Override
	public void push(Position item) throws IllegalArgumentException {
		if (item == null) { // if item that is being pushed is null, then throw exception
			throw new IllegalArgumentException();
		}
		if (size == stack.length) { // if stack is the same size as the size field, call extendArray
			extendArray();
		}

		stack[size] = item; // pushes item onto the stack at current size
		size++; // increments size

	}

	/**
	 * This method checks to see if the stack is empty or not
	 */

	@Override
	public boolean isEmpty() {
		return size == 0;

	}

	@Override
	public Position pop() throws EmptyStackException {
		if (size == 0) { // if size of stack is equal to 0, throw exception
			throw new EmptyStackException();
		}
		Position popVar = stack[size - 1]; // pops the top of the stack and assigns it to popVar
		size--; // decrements size since the top position is removed from stack 

		return popVar;

	}

	/**
	 * Looks and sees what is at the top of the stack but does not remove it
	 */
	@Override
	public Position peek() throws EmptyStackException {
		if (isEmpty()) { // if size of stack is equal to 0, throw exception
			throw new EmptyStackException();
		}
		return stack[size - 1]; // checks the top of the stack and assigns that to
		// peekVar

	}

	/**
	 * Checks whether the Position p can be found within the stack
	 * 
	 * @param p
	 * @return
	 */

	public boolean contains(Position p) {

		for (int i = 0; i < size; i++) {
			if (stack[i].equals(p)) {
				return true;

			}
		}
		return false;
	}

	/**
	 * Creates a new array when size of current stack is approached Doubles the size
	 * of array
	 */
	private void extendArray() {
		Position[] newArray = new Position[size * 2];

		for (int i = 0; i < stack.length; i++) { // copies the current array into the new array
			newArray[i] = stack[i];
		}

		stack = newArray; // sets new array to stack array

	}

	/**
	 * gets size of stack
	 * 
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * sets the size of stack
	 * 
	 * @param size
	 */
	public void setSize(int size) {
		this.size = size;
	}
}

class Position {
	int col;
	int row;

	Position(int row, int col) {
		this.col = col;
		this.row = row;
	}

	/**
	 * checks if current stack position is equal to the position massed into method
	 * 
	 * @param other
	 * @return
	 */
	boolean equals(Position other) {
		return this.col == other.col && this.row == other.row;
	}

}