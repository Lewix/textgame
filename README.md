John's mountain biking adventure
================================

Game
----

The Game class will have one of each of the I/O system's classes (except Command). It will probably also need a handle on the Player class.

I/O System
----------

Made up of four classes: Listener, Modifier, Printer and Command. Listener and Modifier pass around Commands generated from user input. Modifier then changes the game state. Printer takes care of all the output from the game.

To-do
-----


* TODO: implement Character.talk 

* TODO: implement Character.getItem 

* TODO: implement Character.giveItem 

* TODO: decide on the state a command should have 

* TODO: write Command constructor 

* TODO: Implement ConversationState.getAcceptableItems(); 

* TODO: Implement ConversationState.getItem(); 

* TODO: Implement ConversationState.getGivableItems(); 

* TODO: Implement ConversationState.giveItem 

* TODO: Implement ConversationState.getSpeeches() 

* TODO: Implment ConversationState.talk 

* TODO: write game constructor 

* TODO: write main 

* TODO: write getCommand() 

* TODO: write decode public boolean issueCommand(Command command) { 

* TODO: decide on error handling 

* TODO: decide whether Modifier class is useful 

* TODO: write issueCommand 

* TODO: write printState (and others for different parts of state)

(don't write anything past this point)
