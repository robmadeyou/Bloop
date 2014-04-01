###Intro Screen
1.1. Screen waits to seconds before fading in<br>
1.2. Screen fades in<br>
1.3. Screen waits before going to Main Menu<br>

###Main screen
2.1. Screen fades in when main menu is loaded<br>
2.2. When mouse is over the buttons the border is made visible<br>
2.3. When mouse is not over the buttons the border fades out<br>
2.4. Each button leads to the apropriate location
  * Game screen
  * High Scores
  * Options<br>

2.5. Background changes color<br>
2.6. All objects are loaded and visible
  * All labels
    * Bloop text
    * Play text
    * High Scores text
    * Options text
  * All borders
    * Play border
    * High Scores border
    * Options border<br>

2.7. Sound is playing and audible<br>

###Options

3.1. Back button leads back to Main menu<br>
3.2. Back button border activates on mouse highlighting<br>
3.3. Back button border hides when mouse is away from the button<br>
3.4. Changing options actually changes the options<br>
  * Volume changes
  * Level difficulty changes
  * Game speed changes<br>
3.5. Options label is clearly visible<br>


###High Scores

4.1. Back button leads back to Main menu<br>
4.2. Back button border activates on mouse highlighting<br>
4.3. Back button border hides when mouse is away from the button<br>
4.4. High scores are displayed in order (Highest to lowest)<br>
4.5. High scores have an identifier to recognize who is the author of the high score<br>
4.6. High scores update after a game has been played<br>
4.7. High score label is visible and not hidden<br>


###Game Screen
####Wall
5.1. Wall waits 3 seconds before starting<br>
5.2. Wall moves forward<br>
5.3. Wall increases in speed with the current level<br>
5.4. If player is stuck in wall, game ends<br>
####GUI
5.5. Score label is updated as the player runs to the right <br>
5.6. Score increments apropriately, meaning the algorithm "current level * current location" is apropriately calculated<br>
5.7. The "Map" GUI updates, with the wall and the player being appropriately located on the line of path<br>
####Player
5.8. The player is able to move right, but not left<br>
5.9. The player is able to jump<br>
5.10. Player speed increases every level<br>
5.11. Player jump height increases every level<br>
