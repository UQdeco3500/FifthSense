# Team Fifth Sense
***
## Promotional Poster and StoryBoard

Poster: https://github.com/UQdeco3500/FifthSense/wiki/Poster  

StoryBoard: https://github.com/UQdeco3500/FifthSense/wiki/Storyboard

## Project Proposal

https://github.com/UQdeco3500/FifthSense/wiki

## Prototype

https://github.com/UQdeco3500/FifthSense/wiki/About-our-Prototype

## Prototype Instructions

- For interactive prototype, we use Figma, you can click the link to review them directly:- 

Figma Link: https://www.figma.com/file/dN5YNL2Y2ILccOFwlKSSky/Fifth-Sense?type=design&node-id=0-1&mode=design&t=atIaorfp0ai211re-0

- For functional prototype, we use IntelliJ and AndroidStudio, you can complete the review according to the following instructions:- 

Requirements:

HighEnd PC with atleast 16GB RAM (MacBook(Ensure that AndroidStudio and IntelliJ is installed) or Windows laptop(Ensure that AndroidStudio and IntelliJ is installed and GitBash is present)).

Android phone(API 30+, Android version 6+)

Process:

Step 1: Clone the repository code to your local machine.

Step 2: Open IntelliJ with Chat-Feature folder as the source code, and simultaneously open AndroidStudio with AndroidApp folder as source code.

Step 3: Click “Trust and Open” on both files.

Step 4: In IntelliJ, set up SDK and gradle build as IntelliJ suggests.

Step 5: In IntelliJ, also install the necessary extensions and plugins which IntelliJ suggests(Mainly springboot and websocket).

Step 6: When IntelliJ is set up and the SpringBootWebsocketApplication is ready to run, first we go to android studio set up.

Step 7: Before opening AndroidStudio, open either Terminal on MacBook or GitBash on Windows laptop.

Step 8: In Terminal or GitBash, Run the command "ifconfig | grep "inet " | grep -v 127.0.0.1". This may download new files on your PC and you will also get an output.

Step 9: You will get an output like this, "inet 'A.A.A.A' netmask 'B' broadcast 'C.C.C.C'", where A, B, C represent numbers.

Step 10: Copy just the 'A.A.A.A' segment.

Step 11: Now open AndroidStudio, set up SDK and API as AndroidStudio suggests.

Step 12: Now run the emulator for pixel 7 pro API 34 which is the normally the default emulator for AndroidStudio.

Step 13: When you open the file AndroidApp/app/src/main/java/com/example/myapplication/UI/Activities/DashboardActivity.kt in AndroidStudio, you should see an address like this on line 41, "http://A.A.A.A:8080". 

Step 14: Now replace the 'A.A.A.A' segment on line 41 with the one you copied earlier.

Step 14: Now go back to IntelliJ, and run the SpringBootWebsocketApplication.

Step 15: While that's running, go to AndroidStudio and run the application as well while the emulator is also running.

Step 16: This process will take some time to run as these are very heavy applications but once they run, you can enter the login information which is "samarth" for the username and "test1234" for the password.

- Note:

You can also connect your local android phone as an emulator on AndroidStudio by using the same wi-fi network. Now, when you click run for the application, the app will run on your local device. 


