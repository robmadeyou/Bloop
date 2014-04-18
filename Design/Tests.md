###Intro Screen
1.1. Screen waits to seconds before fading in
1.2. Screen fades in
1.3. Screen waits before going to Main Menu

###Main screen
2.1. Screen fades in when main menu is loaded
2.2. When mouse is over the buttons the border is made visible
2.3. When mouse is not over the buttons the border fades out
2.4. Each button leads to the apropriate location
  * Game screen
  * High Scores
  * Options

2.5. Background changes color
2.6. All objects are loaded and visible
  * All labels
    * Bloop text
    * Play text
    * High Scores text
    * Options text
  * All borders
    * Play border
    * High Scores border
    * Options border

2.7. Sound is playing and audible

###Options

3.1. Back button leads back to Main menu
3.2. Back button border activates on mouse highlighting
3.3. Back button border hides when mouse is away from the button
3.4. Changing options actually changes the options
  * Volume changes
  * Level difficulty changes
  * Game speed changes
3.5. Options label is clearly visible


###High Scores

4.1. Back button leads back to Main menu
4.2. Back button border activates on mouse highlighting
4.3. Back button border hides when mouse is away from the button
4.4. High scores are displayed in order (Highest to lowest)
4.5. High scores have an identifier to recognize who is the author of the high score
4.6. High scores update after a game has been played
4.7. High score label is visible and not hidden


###Game Screen
####Wall
5.1. Wall waits 3 seconds before starting
5.2. Wall moves forward
5.3. Wall increases in speed with the current level
5.4. If player is stuck in wall, game ends
####GUI
5.5. Score label is updated as the player runs to the right 
5.6. Score increments apropriately, meaning the algorithm "current level * current location" is apropriately calculated
5.7. The "Map" GUI updates, with the wall and the player being appropriately located on the line of path
####Player
5.8. The player is able to move right, but not left
5.9. The player is able to jump
5.10. Player speed increases every level
5.11. Player jump height increases every level
