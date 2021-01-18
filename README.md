### Lab Task - 1
### Tic-Tae-Toe

Algorithm 1: (Simple brute force approach)
Concept: 
It consists of a dictionary in which all the possible 3^9 board positions and the next best possible move which can be made by the computer either to win or to stop the user from winning keeping in mind that particular board position is thought of. 
Here we view the board as a ternary number which is then converted to a decimal number. The computed decimal number is used as an index to navigate in the dictionary and the setting the board according to the new number. 
Functions in the code:
1) dec_to_ter : Convert decimal number to ternary required for verifying if a particular position is taken up or not and to show the board.
2) show : print the board at various intervals with the help of dec+to+ter function
We have 2 dictionaries present where the key is decimal representation of all possible 3^9 representations of the board and the values are:-
dict_num : the next best possible move for the computer
dict_won : character (C/O/X/T) determining the output in case of the corresponding ternary representation of the board.
My views: This approach is very efficient in terms of time but takes up a lot of storage as 3^9 cases need to be stored, that too it has to be done manually hence the chances of it being error free are less.

Algorithm 2: 
Concept: 
It consists of a boards which is a 9 element vector in which the states are represented in form of numbers : 2 for blank, 3 for X ( user’s move here) and 5 for O (computer’s move).
Now after user makes his move the computer finds the best move in the following manner: first of all it check in the centre block is empty for it to make a move and if it is then it returns 5. 0 is returned if the player cannot win on the next move. If the product of any row/column/diagonal is 18 then X wins and if it is 50 then O wins. If a winning row is found then the index of the blank square is returned.
Functions in the code:

1) is_winner : function to check in case the user or the computer is winner of the game by checking all possible winning situations possible in the board.
2) spaceIsFree : function to check if a particular position is empty that is not taken by anyone
3) isBoardFull : function to check if all the board positions have been occupied
4) move_computer : This is basically played by the computer in search of the best possible move to defend by first looking for the central box, then trying to occupy the corners and if these places are not available then going in pursuit of the edge blocks.
5) fill_pos : function to place the symbol on the board at the place chosen by the user
6) selectRandom : selects a random move out of equally feasible possible moves
7) show : function to print the board
8) posWinner : This checks if the user or the computer is winner of the match
9) move_player : function to process the move chosen by the user it just accepts the position where the user wants to make his next move and also check that the move is a valid move
10) main : This is the main function where first the user is asked to make a move then the computer accordingly makes the best move and checks if the game has ended or who is the winner of the match.

My Views: 
This has higher time complexity as compared to the 1st one and very less space complexity. Moreover it has easy to understand algorithm and code without much error.

Algorithm 3: 
Concept: 
This is much similar to 2nd algorithm except that the numbering is done as 8,3,4,1,5,9,6,7,2 such that is produces a magic square with sum 15. The process of checking for a winning possibility can be simplified by using the insights that no player will have more than 4 squares at a time plus the sum of 15. 
Functions in the code:
1) is_winner : function to check in case the user or the computer is winner of the game by checking all possible winning situations possible in the board.
2) spaceIsFree : function to check if a particular position is empty that is not taken by anyone
3) isBoardFull : function to check if all the board positions have been occupied
4) move_computer : This is basically played by the computer in search of the best possible move to defend by first looking for the central box, then trying to occupy the corners and if these places are not available then going in pursuit of the edge blocks.
5) fill_pos : function to place the symbol on the board at the place chosen by the user
6) selectRandom : selects a random move out of equally feasible possible moves
7) show : function to print the board
8) posWinner : This checks if the user or the computer is winner of the match
9) move_player : function to process the move chosen by the user it just accepts the position where the user wants to make his next move and also check that the move is a valid move
10) main : This is the main function where first the user is asked to make a move then the computer accordingly makes the best move and checks if the game has ended or who is the winner of the match.
My views:
This is also almost similar to algorithm 2 but we have simplified the posWinner function by using the magic square property as if a player is winning then the sum of values of the 3 cells which led to his win will be 15 (in this case). Also because a player individually can have a maximum of 4 cells we utilize this property to apply 2 for loops without any much effect in time complexity.

Algorithm 4: 
Concept:  
A nine element vector represents the board and here we deal with a number that represents an estimate of how likely the board positions can lead to the ultimate win. To decide the next move we need to look ahead the board position that results from each possible move. Then after selecting the best position, move is made which leads to that solution, assign the ratting of the best move to the current position. The best move for each position is decided as follows: 
If it is a winning move then assign it the highest possible ratting. If not then consider all possible moves that can be made by the user. Let us assume that the user will make the move that turns out to be the worst for us then assign the ratting of that to the move that we are considering. The node with the highest ratting will be the best. 
Functions:
1) is_winner : function to check in case the user or the computer is winner of the game by checking all possible winning situations possible in the board.
2) spaceIsFree : function to check if a particular position is empty that is not taken by anyone
3) isBoardFull : function to check if all the board positions have been occupied
4) move_computer : This function evaluates all the available moves using minimax() and then returns the best move the maximizer can make.
5) fill_pos : function to place the symbol on the board at the place chosen by the user
6) minimax: This function executes the minimax algorithm. This is used to check whether or not the 	current move is better than the best move which considers all the possible ways the game can go and returns the best value for that move, assuming the opponent also 	  	         plays optimally
7) show : function to print the board
8) move_player : function to process the move chosen by the user it just accepts the position where the user wants to make his next move and also check that the move is a valid move
9) main : This is the main function where first the user is asked to make a move then the computer accordingly makes the best move and checks if the game has ended or who is the winner of the match.
Views:
It is the best approach and can also be used for building more complex games than tic tac toe. This is though too inefficient for simple problems but highly efficient for complicated problems.
