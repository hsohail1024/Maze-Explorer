	///////////////////////////////////////////////////////////
		
		 ///path = new MazeRunnerStack();
		
		/*
	        tempStack.push(this.startCoord);
	        String face = "E";
	        solved = false;
	        Position curPos = new Position(startCoord.row, startCoord.col);
	        while (!solved) {
	            if (curPos.equals(finishCoord)) {
	                solved = true;
	                break;
	            }
	            
	           if (face == "N") {
	               if (myMaze[0].length > curPos.col + 1) {
	                   if (myMaze[curPos.row][curPos.col + 1] != 'L' && myMaze[curPos.row][curPos.col + 1] != '|') {  
	                   tempStack.push(curPos);
	                   curPos = new Position(curPos.row, curPos.col + 1);
	                   face = "E";
	                   continue;
	               }    
	               }
	               face = "W";
	               continue;
	           } else if (face == "E") {
	               if (myMaze.length > curPos.row + 1) {
	                   if (myMaze[curPos.row][curPos.col] != 'L' && myMaze[curPos.row][curPos.col] != '_') {  
	                	   tempStack.push(curPos);
	                   curPos = new Position(curPos.row + 1, curPos.col);
	                   face = "S";
	                   continue;
	               }    
	               }
	               face = "N";
	               continue;
	           } else if (face == "S") {
	                if (curPos.row != 0) {
	                    if (myMaze[curPos.row][curPos.col] != 'L' && myMaze[curPos.row][curPos.col] != '|') { 
	                    	tempStack.push(curPos);
	                    curPos = new Position(curPos.row, curPos.col - 1);
	                    face = "W";
	                    continue;
	                }    
	                }
	                face = "E";
	                continue;
	              
	          } else if (face == "W") {
	              if (curPos.col != 0) {
	                  if (myMaze[curPos.row - 1][curPos.col] != 'L' && myMaze[curPos.row - 1][curPos.col] != '_') { 
	                	  tempStack.push(curPos);
	                  curPos = new Position(curPos.row - 1, curPos.col);
	                  face = "N";
	                  continue;
	              }   
	              }
	              face = "S";
	              continue;
	              
	          }
	          
	        }
		
		
		
		*/