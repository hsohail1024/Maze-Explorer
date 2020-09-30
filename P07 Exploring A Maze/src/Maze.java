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
public class Maze {
	private MazeRunnerStack path; // stack for coordinates of solved maze
	private Boolean solved;
	private char[][] myMaze;
	private static Position startCoord; // starting place of maze
	private static Position finishCoord; // finishing plaze of maze
	private int maxStepCount; // counts the number of times of steps taken so no infinite loop
								// occurs

	public static void main(String[] args) {

		char[][] myMaze = new char[][] { { 'L', '.', '|', '.' }, { 'L', '|', '|','|' }, { 'L', '_', '_','|' } };
		Maze myMaze1 = new Maze(myMaze);
		myMaze1.setStart(0, 0);
		myMaze1.setFinish(1, 0);
		myMaze1.solveMaze();
		myMaze1.displayMaze();

	}

	/**
	 * constructor for Maze. This method assigns the fields solved and path to null
	 * initially and assigns mazeInfor to the private char[][] filed myMaze
	 * 
	 * @param mazeInfo
	 */
	public Maze(char[][] mazeInfo) {
		this.solved = null; // boolean solved is set as null when constructor is called
		this.myMaze = mazeInfo; // assigns mazeInfo to myMaze field
		this.path = null; // path is set as null when constructor is called

	}

	/**
	 * sets the starting coordinates
	 * 
	 * @param row
	 * @param col
	 */
	public void setStart(int row, int col) {
		Maze.startCoord = new Position(row, col); // sets Maze startCoord as new Position
		Maze.startCoord.row = row; // assigns row to startCoord Row
		Maze.startCoord.col = col; // assigns col to startCoord col

	}

	/**
	 * Sets the finish coordinate
	 * 
	 * @param row
	 * @param col
	 */
	public void setFinish(int row, int col) {

		Maze.finishCoord = new Position(row, col); // sets Maze finishCoord as new Position
		Maze.finishCoord.row = row; // assigns Row to finishCoord Row
		Maze.finishCoord.col = col; // assigns Col to finishCoord Col
	}

	/**
	 * This method will display the maze. The maze will be printed according to the
	 * the characters that are passed into the array and will be determined just by
	 * the left and bottom of the wall L - wall on left and bottom | - wall on left
	 * only . - no wall to left or bottom _ - wall on the bottom
	 * 
	 * This method will print out the solved maze (if solved is true) and use the
	 * field path to set asterisks (*) on the maze where it leads to solving the
	 * maze.
	 * 
	 */
	public void displayMaze() {
		boolean flag = false;

		if (this.solved) {
			System.out.println("Solution is:"); // if solved print out the message then the maze
		}
		if (maxStepCount >= myMaze.length * myMaze[0].length * 4) {
			System.out.println("No solution could be found."); // if maxStepCount is greater than or
																// equal to row times col * 4 print
																// not solved message
		}

		for (int row = 0; row < myMaze[0].length; row++) { // prints out the top row of the maze
			if (row == myMaze[0].length - 1) {
				System.out.println("+---+");
			} else {
				System.out.print("+---");
			}
		}

		for (int row = 0; row < myMaze.length; row++) {

			if (!flag) {
				for (int col = 0; col < myMaze[0].length; col++) {
					Position currentP = new Position(row, col);
					String x = " ";
					if (row == startCoord.row && col == startCoord.col) {
						x = "S";
					} else if (row == finishCoord.row && col == finishCoord.col) {
						x = "F";
					} else if (path.contains(currentP))
						x = "*";
					else {
						x = " ";
					}

					/**
					 * Prints out the wall when col is 0 according to the characters within the
					 * array
					 */
					if (col == 0) {
						System.out.print("| " + x + " ");
					} else if (myMaze[row][col] == 'L') {
						System.out.print("| " + x + " ");
					} else if (myMaze[row][col] == '|') {
						System.out.print("| " + x + " ");
					} else if (myMaze[row][col] == '_') {
						System.out.print("  " + x + " ");
					} else if (myMaze[row][col] == '.') {
						System.out.print("  " + x + " ");
					}

					if (col == myMaze[0].length - 1) { // last col print out |
						System.out.print("|");
					}
				}
				flag = true;
				row--;

				/**
				 * Prints out the inner parts of the maze
				 */
			} else if (flag) {
				for (int col = 0; col < myMaze[0].length; col++) {

					if (row == myMaze.length - 1) { // if last row
						if (col == myMaze[0].length - 1) { // if last col
							System.out.print("+---+");
						} else {
							System.out.print("+---");
						}
						continue;
					}
					if (col == myMaze[0].length - 1) {
						if (myMaze[row][col] == 'L') {
							System.out.print("+---+");
						} else if (myMaze[row][col] == '|') {
							System.out.print("+   +");
						} else if (myMaze[row][col] == '_') {
							System.out.print("+---+");
						} else if (myMaze[row][col] == '.') {
							System.out.print("+   +");
						}
					} else if (myMaze[row][col] == 'L') {
						System.out.print("+---");
					} else if (myMaze[row][col] == '|') {
						System.out.print("+   ");
					} else if (myMaze[row][col] == '_') {
						System.out.print("+---");
					} else if (myMaze[row][col] == '.') {
						System.out.print("+   ");
					}
				}
				flag = false;
			}
			System.out.println();
		}

		if (!path.isEmpty()) { // if stackPath is not empty
			String str = "";
			int size = path.getSize(); // get size of path
			for (int i = 0; i < size; i++) {
				Position stackInfo = path.pop(); // pops each Position off of stack and stores it in
													// local variable
				str = " --> " + "[" + stackInfo.row + "," + stackInfo.col + "]" + str;
			}
			System.out.print("Path is:" + str.substring(4)); // prints ot the path to solved maze
		}
	}

	/**
	 * This method checks for any backk tracked position on the stack and removes
	 * them until the current position is met If a previous stack element is the
	 * same as the current stack item, then all items are popped until the top item
	 * is equal to the current
	 * 
	 * @param item
	 */
	public void backTrackPos(Position item) {
		if (this.path.contains(item)) { // checks if the path already contains the Position item
			for (int i = 0; i < this.path.getSize(); i++) {
				if (this.path.peek() != item) { // pops the items off the stack until the top
												// element is equal to the current item
					this.path.pop();
					i++;
				}
			}
		}
	}

	/**
	 * This method uses the RIGHT HAND RULE to solve the maze First you have to
	 * consider which way you are facing in each cell (using a orientation
	 * viariable) The right hand rule is as follows if you can turn right, turn
	 * right if you cant try going straight if you cant go straight, try going left
	 * if you cant go left either, turn around and go back The orientation variable
	 * should be updated in each cell
	 * 
	 * At each position, you should check if the current position which you are at
	 * is not on the stack if that is true, you should remove the positions until
	 * you reach the curent position.
	 * 
	 */
	public void solveMaze() {
		this.path = new MazeRunnerStack();
		this.path.push(Maze.startCoord); // pushes the first coordinate onto the path (stack)
		String face = "E"; // we start facing East
		maxStepCount = 0;
		this.solved = false; // solved is assigned to false to begin with
		Position curPos = new Position(startCoord.row, startCoord.col); // current position is
																		// assigned with starting
																		// position
		while (!this.solved) {
			if (curPos.equals(finishCoord)) { // checks if current position is the same as finish
												// position
				this.solved = true;
				path.push(curPos); // pushes current position onto the stack
				break; // breaks out of while loop
			}

			if (maxStepCount >= (myMaze.length) * (myMaze[0].length) * 4) { // if the maxStepCount
																			// has been reached
				// set the size of Path to 0 and break out out of loop
				path.setSize(0);
				break;
			}

			if (face == "N") { // if orientation is facing North
				if (myMaze[0].length > curPos.col + 1) { // check if maze width is greater than the
															// current column + 1
					if (myMaze[curPos.row][curPos.col + 1] != 'L'
							&& myMaze[curPos.row][curPos.col + 1] != '|') { // if the cell
																			// underneath current is
																			// not a L or |
						backTrackPos(curPos); // call backTrack method to make sure curPos is not on
												// the stack already
						path.push(curPos); // push the current position onto the stack
						curPos = new Position(curPos.row, curPos.col + 1); // assign current
																			// position to new
																			// position
						face = "E"; // then turn east
						maxStepCount++; // increment maxStepCount
						continue;
					}
				}
				face = "W"; // if if statement is false, assign faceOrientation to West
				maxStepCount++; // increment maxStepCount
				continue;
			} else if (face == "E") { // if orientation is facing East
				if (myMaze.length > curPos.row + 1) { // checks to see if row + 1 is within the
														// height of maze
					if (myMaze[curPos.row][curPos.col] != 'L'
							&& myMaze[curPos.row][curPos.col] != '_') { // if current cell is not an
																		// L or _ (no bottom wall)
						backTrackPos(curPos); // call backTrack method to make sure curPos is not on
												// the stack already
						path.push(curPos); // push current position onto stack
						curPos = new Position(curPos.row + 1, curPos.col); // assign new cell with
																			// new position (one
																			// down) to current
																			// position
						face = "S"; // change orientation to South
						maxStepCount++; // increment maxStepCount
						continue;
					}
				}
				face = "N"; // if if statement is false, assign faceOrientation to North
				maxStepCount++; // increment maxStepCount
				continue;
			} else if (face == "S") { // if orientation is facing South
				if (curPos.row != 0) { // checks if the current row is not 0th index
					if (myMaze[curPos.row][curPos.col] != 'L'
							&& myMaze[curPos.row][curPos.col] != '|') { // if current cell is not an
																		// L or | (no wall to the
																		// left)
						backTrackPos(curPos); // call backTrack method to make sure curPos is not on
												// the stack already
						path.push(curPos); // push current position onto stack
						curPos = new Position(curPos.row, curPos.col - 1); // assign new cell with
																			// new position (col to
																			// the left) to current
																			// position
						face = "W"; // change orientation to West
						maxStepCount++; // increment maxStepCount
						continue;
					}
				}
				face = "E"; // if if statement is false, assign faceOrientation to East
				maxStepCount++; // increment maxStepCount
				continue;

			} else if (face == "W") { // if orientation is facing West
				if (curPos.row != 0) { // checks if the current row is not 0th index
					if (myMaze[curPos.row - 1][curPos.col] != 'L'
							&& myMaze[curPos.row - 1][curPos.col] != '_') { // if current cell is
																			// not an L or | (no
																			// wall on bottom of the
																			// row above current
																			// row)
						backTrackPos(curPos); // call backTrack method to make sure curPos is not on
												// the stack already
						path.push(curPos); // push current position onto stack
						curPos = new Position(curPos.row - 1, curPos.col); // assign new cell with
																			// new position (one row
																			// back) to current
																			// position
						face = "N"; // change orientation to North
						maxStepCount++; // increment maxStepCount
						continue;
					}
				}
				face = "S"; // if if statement is false, assign faceOrientation to South
				maxStepCount++; // increment maxStepCount
				continue;

			}

		}

	}

}