package ProjectGUI;

//Below are the imports needed

	import java.awt.BorderLayout; //Border

	import java.awt.Color; // For Color

	import java.awt.FlowLayout; //For Layout

	import java.awt.Font;

	import java.awt.event.ActionEvent; //Action Listener Related

	import java.awt.event.ActionListener;

	import java.io.FileNotFoundException; //File Exception

	import java.io.PrintWriter; //File Method Related

	import javax.swing.JButton; //Imports JButton

	import javax.swing.JFrame;//Imports JFrame

	import javax.swing.JLabel; //Imports JLabel

	import javax.swing.JPanel; //Imports JPanel

	import javax.swing.JTextField; //Needed for Text field, where user import will be added

	//The Class projectGUI extends JFrame and implements ActionListener

public class ProjectGUI extends JFrame implements ActionListener

	{

	//Below are the variables that are created with in the class

	JFrame frame = new JFrame("Learning With Arrays Game");//Creates JFrame

	JPanel panel = new JPanel(); //Creates JPanel

	JLabel welcomeLabel; //The welcome label is created

	JLabel gameRulesLabel1;//The first rule of the Game is Explained

	JTextField intsArray;//Text field, where the user needs to enter integers separated by comma

	JLabel gameRulesLabel2; //The second rule of the Game is Explained

	JTextField favoriteNum; //Text field, where the user needs to enter a number, which will be needed for some methods

	JLabel buttonLabel; //This label explains the last step and asks the user to click any button on the steps can be performed

	//All the buttons below perform a function when clicked using array and favoriteNum value

	JButton button1;//multiply values (needs array and favoriteNum Value)

	JButton button2;//merge sort algorithm(needs only array)

	JButton button3;//bubble sort algorithm(needs only array)

	JButton button4;//linear search algorithm(needs array and favoriteNum Value)

	JButton button5;//Binary search algorithm (needs array and favoriteNum Value)

	//This the the label that is created for displaying results to the user after a button is clicked

	JLabel FinalResult; //Gives Final result

	JLabel ThankYou;

	//Below is the code for projectGUI(), which makes the GUI

	public ProjectGUI()

	{

	//Below is the Welcome label

	welcomeLabel = new JLabel("WELCOME TO THE GAME OF ARRAY ACTIONS");

	welcomeLabel.setFont(new Font("Algerian", Font.BOLD, 25));

	panel.add(welcomeLabel);

	//Below the first rule of the game is explained and user needs to enter integers of an array separated by a comma

	gameRulesLabel1 = new JLabel( "First: Enter the Integers in the Array Separated by a Comma: ");

	gameRulesLabel1.setFont(new Font("Algerian", Font.BOLD, 20));

	panel.add(gameRulesLabel1);

	intsArray = new JTextField("Enter Integers of The Array HERE ");

	panel.add(intsArray);

	//The second rule of the game is explained and user needs to enter their favorite number

	gameRulesLabel2 = new JLabel( "Second: Enter your Favorite Number: ");

	gameRulesLabel2.setFont(new Font("Algerian", Font.BOLD, 20));

	panel.add(gameRulesLabel2);

	favoriteNum = new JTextField("Enter Favorite Num HERE ");

	panel.add(favoriteNum);

	//When the user is done entering the ints for array and one fav num, then one button should be clicked so an algor. can be performed.

	buttonLabel = new JLabel("Last: Please Select A Button To Play With Your Array Numbers");

	buttonLabel.setFont(new Font("Algerian", Font.BOLD, 25)); //setting Font Size

	panel.add(buttonLabel);

	//Below are five JButtons that can do five things using the one array and one integer entered by the user

	//button1 when clicked multiplies each value in the array by the value in 2nd textfield

	button1 = new JButton();

	button1.setText("MultiplyValues");

	button1.setBackground(Color.PINK); //pink button

	panel.add(button1);

	button1.addActionListener(this);

	//button2 when clicked sorts using merge sort algo.

	button2 = new JButton();

	button2.setText("MergeSort");

	button2.setBackground(Color.RED);//Red button

	panel.add(button2);

	button2.addActionListener(this);

	//button3 when clicked sorts array using bubble sort algo.

	button3 = new JButton();

	button3.setText("BubbleSort");

	button3.setBackground(Color.GREEN);//Green button

	panel.add(button3);

	button3.addActionListener(this);

	//button4 when clicked will return the value of the location of where is the 2nd textfield value

	button4 = new JButton();

	button4.setText("LinearSearch");

	button4.setBackground(Color.ORANGE);//Orange button

	panel.add(button4);

	button4.addActionListener(this);

	//button5 will return the index of the location of where is the 2nd text field using binary search algo.

	button5 = new JButton();

	button5.setText("BinarySearch");

	button5.setBackground(Color.PINK);//Pink button

	panel.add(button5);

	button5.addActionListener(this);

	//This label is created to use when the buttons are clicked and display the final result

	FinalResult = new JLabel("\n\n\n The Results of the Game Are: ");

	panel.add(FinalResult);

	//Below is the design of the GUI

	panel.setBackground(Color.YELLOW);

	panel.setLayout(new FlowLayout());

	frame.add(panel);

	frame.setSize(1000,1000);

	frame.setLocation(200,300);

	frame.setVisible(true);

	}

	//ActionPerformed has a file exception and a general exception which prints a list of instructions on the screen if something goes wrong

	@Override

	public void actionPerformed(ActionEvent e)

	{

	try //try to do this, and if user input is correct, then the buttons clicked will give correct output

	{

	//In the Code Below, the string values are converted into integer values

	String intsByUser = intsArray.getText().trim();//store information of ints in a big string

	String [] intsByUserArrayString = intsByUser.split(","); //makes it into an array by split

	int lengthOfintsByUserArrayString = intsByUserArrayString.length; //place the length of array into a variable

	int[] intsByUserArrayInteger = new int[lengthOfintsByUserArrayString]; //makes an int[] with same length as string array above

	//Below the values are placed into int[] array that was already in the string[] but each index has an int value

	for(int i = 0; i<intsByUserArrayInteger.length;i++)

	{

	Integer.parseInt(intsByUserArrayString[i]);

	intsByUserArrayInteger[i] = Integer.parseInt(intsByUserArrayString[i]);

	}

	//the favoriteNum entered by the user is converted into an integer

	int favoriteNumByUser = Integer.parseInt(favoriteNum.getText().trim());

	String actionCommand = e.getActionCommand();

	//Below the code is a switch case occurs when buttons are clicked

	switch(actionCommand)

	{

	//Case 1 is multiplying Values

	case "MultiplyValues": //Below is a code that multiplies the values of the values in the index using the method mentioned between(1111111)

	String button1 = "The Array will have these values in it: "; //button1 created to help in display results

	//method is called that will multiple the values and added to button1 variable information

	button1 = button1 + mulipleValuesInArrayByAValue(intsByUserArrayInteger , favoriteNumByUser);

	FinalResult.setText(button1 + " **The Values that You Entered Are Multiplied By Your Favorite Number**");

	writeTextToNewFile("button1Results.txt", button1 + " **The Values that You Entered Are Multiplied By Your Favorite Number**");

	break;

	//Case 2 is using merge sort to sort array

	case "MergeSort"://Below is the code that sorts the array using merge sort methods used to perform that are between(2222222222222)

	String button2= "The Values in the Merge Sorted Array are "; //button2 created to help in display results

	//mergeSort method is called to perform the task of sorting

	mergeSort(intsByUserArrayInteger);

	for(int i = 0; i<intsByUserArrayInteger.length; i++)

	{

	button2=button2+intsByUserArrayInteger[i]+"__";

	}

	FinalResult.setText(button2 + " **The Values that You Entered Are Sorted By Merge Sort**");

	writeTextToNewFile("button2Results.txt", button2 + " **The Values that You Entered Are Sorted By Merge Sort**");

	break;

	//Case 3 is using bubble sort to sort array using

	case "BubbleSort"://Below is the code for bubble sort and methods used to perform bubble sort are between (333333333333)

	String button3 = "The Values in the Bubble Sorted Array are "; //button3 is used to display the results

	//bublleSort method is performed

	bubbleSort(intsByUserArrayInteger);

	for( int i = 0; i<intsByUserArrayInteger.length; i++)

	{

	button3= button3+ intsByUserArrayInteger[i]+"___";

	}

	FinalResult.setText(button3 + " **The Values that You Entered Are Sorted By Bubble Sort** ");

	writeTextToNewFile("button3Results.txt", button3 +" **The Values that You Entered Are Sorted By Bubble Sort**");

	break;

	//Case 4 is using Linear Search to find the value entered in 2nd textField

	case "LinearSearch"://Below is the code for linear search

	String button4= " The Value is found using Linear Search in location: ";

	//the linear search function is created in the program(4444444) is the divider

	//value of the location is stored in the variable locationOfValueLS

	int locationOfValueLS = linearSearch(intsByUserArrayInteger,favoriteNumByUser);

	button4=button4+locationOfValueLS;

	FinalResult.setText(button4+" **Your Favorite Number was Found Using Linear Search**");

	writeTextToNewFile("button4Results.txt", button4+" **Your Favorite Number was Found Using Linear Search**");

	break;

	//Case 5 is using Binary Search to find the value entered in 2nd textField

	case "BinarySearch"://Below is the code for binary search cord divided by (555555555555555555)

	String button5 = "The Value is Found using Binary Search in location: ";//button5 created to be used in display

	mergeSort(intsByUserArrayInteger); //the array is sorted first before the binary search

	int locationOfValueBS = binarySearch(intsByUserArrayInteger,favoriteNumByUser,0,intsByUserArrayInteger.length);

	button5 = button5 + locationOfValueBS;

	FinalResult.setText(button5 + " **Your Favorite Number was Found Using Linear Search**");

	writeTextToNewFile("button5Results.txt", button5+" **Your Favorite Number was Found Using Linear Search**");

	break;

	}//try statement is over, then the catch statement begins

	}

	catch(Exception general)//catch statement prints the label below

	{

	FinalResult.setText("THERE IS AN ERROR BECAUSE YOU DID NOT ENTER ONLY INTEGERS BUT LETTERS OR SYMBOLS IN ONE OR BOTH OF THE TEXTFIELD." +

	"Please Re-enter Only Integer Values In The TextFields Provided Above That Want Your Input");

	}

	}

	//1111111111111111111111111111111111111111111111111111111111111111111111111111

	//Method for button 1

	public static String mulipleValuesInArrayByAValue(int [] array, int a)

	{

	String returnValuesinArrayInAString = ""; //variable that will be returned

	for(int i = 0; i<array.length; i++)

	{

	int multipliedNum = array[i]*a;

	returnValuesinArrayInAString = returnValuesinArrayInAString + array[i]*a+ " -- ";

	}

	return returnValuesinArrayInAString;

	}

	//1111111111111111111111111111111111111111111111111111111111111111111111111111

	//2222222222222222222222222222222222222222222222222222222222222222222222222222

	//Method for button 2

	//Below are the methods used for merge sort

	//The split method is created, which will be used in the mergeSort method

	public static void split(int[] a, int[] b, int[] c) //a is the big array that will be broken into b and c which are small arrays

	{

	for(int i = 0; i<b.length; i++)

	{

	b[i] = a[i];

	}

	for(int i =0; i<c.length; i++)

	{

	c[i] = a[b.length + i];

	}

	}

	//the method merge is created which will be used in mergeSort method

	public static void merge (int[] bigArray, int[] firstHalf, int[]lastHalf)

	{

	int indexBA= 0; //3 index variables are created with value 0

	int indexFH = 0;

	int indexLH = 0;

	while((indexFH < firstHalf.length) && (indexLH < lastHalf.length))

	{

	if(firstHalf[indexFH]<lastHalf[indexLH]){

	bigArray[indexBA] = firstHalf[indexFH];

	indexFH ++;

	}else{

	bigArray[indexBA] = lastHalf[indexLH];

	indexLH ++;

	}

	indexBA ++;

	}

	while(indexFH<firstHalf.length){

	bigArray[indexBA] = firstHalf[indexFH];

	indexFH ++;

	indexBA ++;

	}

	while(indexLH < lastHalf.length){

	bigArray[indexBA] = lastHalf[indexLH];

	indexLH ++;

	indexBA ++;

	}

	}

	//THE METHOD MERGE HAS ENDED AND NOT THE CODE OF MERGE SORT WILL BE WRITTEN

	//THE MERGE METHOD WILL BE USED IN THE MERGESORT WHEN BUTTON 2 Will Be clicked

	//Now come the merge sort method, which is a recursive method because it calls it self

	//PLEASE NOTE: the method merge and split will be used in the mergeSort

	public static void mergeSort( int[] array)

	{

	if(array.length >= 2)

	{

	int halfLength = array.length/2;

	int[] firstHalf = new int[halfLength];

	int[] lastHalf = new int[array.length - halfLength];

	split(array, firstHalf, lastHalf);

	mergeSort(firstHalf);

	mergeSort(lastHalf);

	merge(array, firstHalf, lastHalf);

	}

	}

	//The mergeSort method will be called by button if button 2 is clicked

	//2222222222222222222222222222222222222222222222222222222222222222222222222222

	//3333333333333333333333333333333333333333333333333333333333333333333333333333

	//Methods for button 3

	//Below are the methods needed for bubble sort; They are used in the case button 3

	public static void swap(int[] arr, int a, int b)

	{

	int temp = arr[a];

	arr[a] = arr[b];

	arr[b] = temp;

	}

	public static void bubbleSort(int[] arr)

	{

	boolean notSorted = true;

	while(notSorted){

	notSorted = false;

	for(int i= 0; i<arr.length - 1; i++)

	{

	int j = i + 1;

	if((arr[i])> (arr[j]))

	{

	swap(arr,i,j);

	notSorted = true;

	}

	}

	}

	}

	//3333333333333333333333333333333333333333333333333333333333333333333333333333

	//4444444444444444444444444444444444444444444444444444444444444444444444444444

	//Method for Button 4

	public static int linearSearch (int [] array, int find)

	{

	for(int i = 0; i<array.length; i++)

	{

	if(find==array[i])

	{

	return i;

	}

	}

	return -1;

	}

	//4444444444444444444444444444444444444444444444444444444444444444444444444444

	//5555555555555555555555555555555555555555555555555555555555555555555555555555

	//Methods for button 5

	public static int binarySearch( int[] array, int find, int startIndex, int endIndex)

	{

	if(startIndex>endIndex)

	{

	return -1; //-1 means the value was not found

	}

	else{

	int midpoint=(startIndex + endIndex)/2;

	if(find == array[midpoint]){

	return midpoint;

	}

	else if(find > array[midpoint]){

	return binarySearch(array,find,(midpoint + 1), endIndex);

	}

	else{

	return binarySearch(array, find, startIndex, (midpoint-1));

	}

	}

	}

	//5555555555555555555555555555555555555555555555555555555555555555555555555555

	//****************************************************************************

	//The method for writing to a file the results of the button

	public static void writeTextToNewFile(String fileName, String lineOfText){

	PrintWriter outStr = null;

	try{

	outStr = new PrintWriter(fileName); //creates a file

	outStr.println(lineOfText);

	}catch(FileNotFoundException fnfe){

	System.out.println("Sorry: "+fnfe.getMessage());

	}finally{

	outStr.close();

	}

	}

	//****************************************************************************

	//____________________________________________________________________________

	//Below is the main Method that creates a gui

	public static void main(String[] args)

	{

	ProjectGUI gui = new ProjectGUI();

	}

	//____________________________________________________________________________

	}

