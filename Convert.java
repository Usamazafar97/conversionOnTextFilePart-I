
import java.util.StringTokenizer;

public class Convert {

	static String createSentence(String[] args) {
		
		if(args[0].charAt(0)!= '[')
		{
			boolean forUpper = false;
			boolean forAppen = false;
			if(args[0].length() >= 2) 
			{
				forUpper = true;
				forAppen = true;
			}
			if((args[0].charAt(1)== 'u' || args[1].charAt(1)== 'u') && args[0].charAt(0) == '-' && forUpper == true)
			{
				args[0]="["+args[0]+"]";
			}
			 if((args[0].charAt(1)== 'o'|| args[1].charAt(1)== 'o')&& args[0].charAt(0) == '-' && forAppen == true)
			{
				args[0]="["+args[0];
				args[1]=args[1]+"]";
			}
			 if((args[1].charAt(1)== 'o'|| args[2].charAt(1)== 'o')&& args[1].charAt(0) == '-' && forAppen == true)
				{
					args[1]="["+args[1];
					args[2]=args[2]+"]";
				}
		}

		String concatString = "";

		for (int i = 0; i < args.length; i++) {
			concatString = concatString + args[i] + ' ';
			// System.out.println("Your argument is: " + concatString);
		}

		char[] customizedString = new char[concatString.length()];
		int indexForCustString = 0;

		for (int i = 0; i < concatString.length(); i++) {
			if (concatString.charAt(i) == ']') {
				customizedString[indexForCustString] = ']';
				indexForCustString++;
				customizedString[indexForCustString] = '+';// at the time of tokkenize
				indexForCustString++;
				i++;// again increment to avoid space
			} else {
				customizedString[indexForCustString] = concatString.charAt(i);
				indexForCustString++;
			}
		}
		// System.out.println("The customized sentence is: " + new
		// String(customizedString));
		return new String(customizedString);
	}

	static String uppercase(char character, String sentence) {

		char[] sentenceArr = sentence.toCharArray();

		for (int i = 0; i < sentenceArr.length; i++) {
			if (sentenceArr[i] == character) {
				sentenceArr[i] = Character.toUpperCase(sentenceArr[i]);
			}
		}

		return new String(sentenceArr);
	}

	static String append(char character, String Word, String sentence) {

		//System.out.println("charToSendForAppend = " + character + " and wordForAppend = " + Word + " and sentence = " + sentence);

		// char[] sentenceArr = sentence.toCharArray();
		char[] sentenceArr = new char[sentence.length() * 2];
		boolean chk = false;
		int indexForSentenceArr = 0;

		for (int i = 0; i < sentence.length(); i++) {
			if (sentence.charAt(i) ==((Character.toLowerCase(character))) || (sentence.charAt(i) == (Character.toUpperCase(character)))) {
				sentenceArr[indexForSentenceArr] = sentence.charAt(i);
				indexForSentenceArr++;
				chk = true;
			} else {
				if (sentence.charAt(i) == ' ') {
					if (chk) {
						sentenceArr[indexForSentenceArr] = sentence.charAt(i);
						indexForSentenceArr++;
						sentenceArr[indexForSentenceArr] = ',';
						indexForSentenceArr++;
						for (int j = 0; j < Word.length(); j++) {
							sentenceArr[indexForSentenceArr] = Word.charAt(j);
							indexForSentenceArr++;
						}
						chk = false;
					}
				}
				sentenceArr[indexForSentenceArr] = sentence.charAt(i);
				indexForSentenceArr++;
			}
		}
		return new String(sentenceArr);
	}

	static String toExtractSentence(String[] args) {
		if(args[0].charAt(0)!= '[')
		{
			boolean forUpper = false;
			boolean forAppen = false;
			if(args[0].length() >= 2) 
			{
				forUpper = true;
				forAppen = true;
			}
			if(args[0].charAt(1)== 'u' && args[0].charAt(0) == '-' && forUpper == true)
			{
				args[0]="["+args[0]+"]";
			}
			if(args[0].charAt(1)== 'o'&& args[0].charAt(0) == '-' && forAppen == true)
			{
				args[0]="["+args[0];
				args[1]=args[1]+"]";
			}
		}
		String extractedString = null;
		for (int i = 0; i < args.length; i++) {
			if (args[i].charAt(0) != '[') {
				extractedString = args[i];
				break;
			}
		}

		return extractedString;
	}

	public static void main(String[] args) {

		String incomingString = createSentence(args);
		//System.out.println(incomingString);
		String[] splitArr = incomingString.split("\\+");

		for (String string : splitArr) {
			//System.out.println(string);
		}

		String extractSentence = toExtractSentence(splitArr);

		boolean forUpper = false;
		boolean forAppendWord = false;
		boolean onlySentence = false;
		char charToSendForUpper = 0;
		char charToSendForAppend = 0;
		String wordForAppend = null;
		for (int i = 0; i < splitArr.length; i++) {
			// System.out.println(splitArr[i]);
			if (splitArr[i].charAt(1) == '-' && splitArr[i].charAt(2) == 'u') {
				forUpper = true;
				charToSendForUpper = splitArr[i].charAt(3);
			}
			if (splitArr[i].charAt(1) == '-' && splitArr[i].charAt(2) == 'o') {
				charToSendForAppend = splitArr[i].charAt(3);

				// now tokkenize on the bases of space to extract the word for which to replace

				String[] splitArrForAppend = splitArr[i].split(" ");

				for (String string : splitArrForAppend) {
					//System.out.println(string);
				}
				
				
				wordForAppend = splitArrForAppend[1];
				
				forAppendWord = true;
			}
			if(forUpper == false && forAppendWord == false)
			{
				onlySentence = true;
			}

		}

		if (forUpper) {
			System.out.println(uppercase(charToSendForUpper, extractSentence));
		}

		if (forAppendWord) {

			char[] tempWord = new char[wordForAppend.length()-1];
			for (int i = 0; i < wordForAppend.length()-1; i++) {
				tempWord[i] = wordForAppend.charAt(i);
			}
			System.out.println(append(charToSendForAppend, new String(tempWord), extractSentence));

		}
		if(onlySentence)
		{
			System.out.println(extractSentence);
		}

		// System.out.println(uppercase( 'c', "cccc"));
	}
}

