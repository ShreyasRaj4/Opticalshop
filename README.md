### Lab Task - 1
### Tic-Tae-Toe

## There are four ways to solve the Tic-Tae-Toe

# Solution 1: (Simple brute force approach)

# Data Structure:
- There we used a nine element vector to represent the board
- 0 for black, 1 for X and 2 for O

# Algorithm
- We will view the board the as a ternary number  
- Convert it into the decimal number
- Use the computed number as an index into the Movetable and access the vector
- Set the board according to the new vector

# Properties
- Very efficient in terms of time
-Theoretically, an optimal game of tic-tac-toe

# Solution 2:

# Data Structure
- Board: A nine element vector, but with 2 for blank, 3 for X and 5 for O 
- Turn: An integer indicating which move is about to be played
- 1 the first, 9 the last

# Algorithm
- Make2: Return if the center square is blank, otherwise return any non-blank square
- Posswin(p): Return 0 if the player p cannot win his next move, otherwise return the winning move
   - Can test entire row (column or diagonal) to see if it is possible to win by multiplying the values of its squares together
   -If the product is 18 (3x3x2), then X can win If the product is 50 (5x5x2), then O can win
   -If we find a winning row, return the number of the blank square
-Go(n): Make a move in square n

# Properties
- O Not as efficient as Solution-1
- Has to check several conditions before
- Lot more efficient in terms of space Lot easier to understand the strategy or to change it
- Any bugs will show up in play Still not generalizable to three dimensions

# Solution 3:

# Data Structure
- Identical to the solution 3 except that the nine element vector is numbered different
- Here two key insights are used 
   - Sum of 15
   - No player can have more than four squares at a time
 
 # Properties
 - Row scanning is easy 
 
 # Solution 4:
 
 # Data Struccture
 - Board Position: 
    - A structure containing:
    - A nine element vector representing the board A list of board positions that could result from the next move
    - A number representing an estimate of how likely the board position is to lead to ultimate
      win for the player to move
 # Algorithm
 - To decide the next move, look ahead at the board position that result from each possible
   move
 - Decide which position is best Make the move that leads to that position
 - Assign the rating of that best move to the current position
 # Properties
 - It has to search a tree representing all possible movd sequences to make the next move
 - Very good example of AI- Technique
 
