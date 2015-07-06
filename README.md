# game-of-life
A simple java console implementation of [Conway's Game of Life](https://en.wikipedia.org/wiki/Conway's_Game_of_Life)

# How to execute?
```java com.twimba.cgl.Game <width> <height> <seed alive cells in the format x,y>```

##Example:
20x40 world with the ["Gosper Glider Gun"](https://en.wikipedia.org/wiki/Gun_(cellular_automaton)) pattern

```java com.twimba.cgl.Game 20 40 1,5 1,6 2,5 2,6 11,5 11,6 11,7 12,4 12,8 13,3 13,9 14,3 14,9 15,6 16,4 16,8 17,5 17,6 17,7 18,6 21,3 21,4 21,5 22,3 22,4 22,5 23,2 23,6 25,1 25,2 25,6 25,7 35,3 35,4 36,3 36,4```

# Output example:
```
-: 0
   |  0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39
 0 |                                                                                                                         
 1 |                                                                             #                                           
 2 |                                                                       #     #                                           
 3 |                                         #  #                    #  #                                      #  #          
 4 |                                      #           #              #  #                                      #  #          
 5 |     #  #                          #                 #           #  #                                                    
 6 |     #  #                          #           #     #  #              #     #                                           
 7 |                                   #                 #                       #                                           
 8 |                                      #           #                                                                      
 9 |                                         #  #                                                                            
10 |                                                                                                                         
11 |                                                                                                                         
12 |                                                                                                                         
13 |                                                                                                                         
14 |                                                                                                                         
15 |                                                                                                                         
16 |                                                                                                                         
17 |                                                                                                                         
18 |                                                                                                                         
19 |                                                                                                                         
```
