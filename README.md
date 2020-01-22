# conversionOnTextFile
 This Program first find the data and convert them to either uppercase or  replace the text with some other text based on the user choice on COMMAND LINE INTERFACE

 Write a command line program that performs conversions on a text file.
 

 java Convert [-uc] [-oc word] text

 Example:

 Using the text, ”The mice will see you now” as an example, below is 
a description of parameters:

Parameter Description

-uc finds each lowercase letter c in the text file, and converts it to

uppercase

	-uo à The mice will see yOu nOw

-oc word

	finds each word in the file beginning with the character c (not case

	sensitive) and adds word after it separated by commas.

	-oM ouch à The mice, ouch, will see you now

Output:

case 1:java Convert [-uo] The mice will see you now

Display : The mice will see yOu nOw

Case 2:java Convert [-oM ouch] The mice will see you now

Display : The mice, ouch, will see you now
