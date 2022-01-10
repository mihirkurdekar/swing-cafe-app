package src.CafeApp;

import java.util.Vector;

import javax.swing.JOptionPane;


/*
 * This is the main core of program this is the place everything happens
 * All the listeners from frame GUI call methods in Exec class
 */
class Food {
	double price;
	String name;
	int quantity=1;
	public Food(){}
	/*
	 * Just a constructor have to pass a string and int to create a food obj
	 */
	public Food(String a,int p)
	{
		name=a;
		price=p;
		
	}
	
	/*
	 * toString method to get the String form of an object adjusted the spaces in it according to output in a txt file
	 */
    @Override
	public String toString()
	{  	
    	return name+spacer(45-(name.length()))+quantity+spacer(10)+price+spacer(8)+quantity*price;	
	}	
    
    
    /*
     * This is just returns n no. of spaces appended together 
     * I have used it many times in program
     */
    public static StringBuffer spacer(int n){
    	StringBuffer space =  new StringBuffer();
    	for(int i= 0;i<n;i++){
    		space.append(" ");
    	}
    	return space;	
    }
//End of Food
}




/*
 * This is the main class
 * This is the place where all actions happen it has vector to store the objects created according to input
 * It has a string array cause I pass it to a jList in popup in which user can edit the bill
 * StringBuffer op is the string user sees in TextArea in main window
 */

class Exec{
    public static Vector<Food> v=new Vector<Food>(3,2);
    /*
     *If you will see a string from menu array you will understand that there are three components in a string
     *1st is the serial number after two spaces there is a name of restaurant dish and again after two spaces there is the price of that dish
     */
    public static String []menu ={"1  Garlic Bread  45","2  French Fries  50","3  Ch.Garlic Bread  55","4  Potato Wedges  55","5  Corn&Ch. Garlic Brd.  60","6  Veg Nuggets  60","7  Cheese Nuggets  70","8  Italian Pocha  75","9  Indian Harvest  75","10  Cheese Corn Nuggets  80","11  Chicken Nuggets  95","12  Margarita Pizza  100","13  Classic Special Pizza  105","14  Farm Treat  110","15  Baby Corn & Mushroom Pizza  120","16  Spicy Paneer Pizza  120","17  Barbeque Chicken Pizza  110","18  Spicy Chicken Pizza  120","19  Veg Pasta  80","20  Chicken Pasta  100","21  Veg Sandwich  30","22  Toast Masala Sandwich  40","23  Cheese Toast Sandwich  45","24  Cheese Grill Sandwich  60","25  Egg & Cheese Sandwich  65","26  Russian Sandwich  65","27  Veg Corn Grilled Sandwich  65","28  Veg Club Sandwich  70","29  Chicken Mayo Sandwich  75","30  Chilli Chicken Toast Sandwich  75","31  Grilled Chicken Sandwich  85","32  Chicken Jungle  90","33  County Chicken  100","34  Tea  25","35  Black Coffee  30","36  Hot Chocolate  50","37  Ice Tea (Peach/Lemon)  50","38  Cold Coffee  50","39  Cappuccino  50","40  Cold Chocó Coffee  60","41  Mexican Sunrise  50","42  Tango With Mango  50","43  Lemon Splash  50","44  Minty Orange  50","45  Go Green  60","46  Negro Cooler  60","47  Doctor Apple  60","48  Lichee Richee  60","49  Red Delight  60","50  Chinese Gooseberry  70","51  Wild Nemesis  70","52  Funny Bunny  75","53  Pink Paradise  80","54  Crunchy Kawah  80","55  Blue Scotch  80","56  Crazy Mango Punch  80","57  Black Thunder Storm  90","58  Chocó Twister  90","59  Chocó Oreo Crunch  95","60  Junglee Mowgli  100","61  Saffron Delight  100","62  Chocó-Coffee Blast  100","63  Chocó Volcano  120","64  Extra Scoop Ice-cream  15","65  Veg Spring Roll  75","66  Veg Fingers  75","67  Veg Manchurian Dry  75","68  Veg Chilli Dry  75","69  Veg Crispy  80","70  Paneer Manchurian Dry  85","71  Paneer Chilli  85","72  Mushroom Chilli Dry  85","73  Baby Corn Chilli Dry  85","74  Veg Cheese Corn Balls  90","75  Baby Corn Mushroom Chilli Dry  90","76  Paneer Schewan Dry  90","77  Paneer 65  90","78  Paneer Tikka  90","79  Vegetable Soup  60","80  Noodle Soup  60","81  Tomato Soup  60","82  Veg Hot & Sour Soup  60","83  Veg Sweet Corn Soup  60","84  Manchow Soup  65","85  Veg Mushroom Sweet Corn & Coriander  75","86  Veg Fried Rice  70","87  Lemon Rice  75","88  Veg Schezwan Fried Rice  80","89  Veg Hakka Noodles  80","90  Singapore Noodles  85","91  Veg Schezwan Noodles  90","92  Veg Triple Schezwan Fried Rice  110","93  Veg Manchurian  85","94  Veg Manchurian in Hot Garlic  90","95  Veg Balls in Burnt Garlic  90","96  Veg Shezwan Gravy  90","97  Sweet Corn Mushroom  100","98  Paneer Balls in Dark Soya Sauce  100","99  Paneer Balls in Hot Garlic  105","100  Paneer Sweet & Sour  110","101  Chicken Lollipop  90","102  Chicken Manchurian Dry  90","103  Chicken Chilli Dry  90","104  Crispy Chicken  105","105  Chicken Fingers  105","106  Chicken Crushed Red Pepper  105","107  Chicken Wings  110","108  Chicken Dragon  115","109  Chicken Threaded  115","110  Chicken Burnt Red Pepper  120","111  Shanghai Chicken  80","112  Chicken Hot & Sour Soup  80","113  Chicken Sweet Corn Soup  85","114  Minced Chicken Coriander Soup  90","115  Chicken Noodle Soup  90","116 Chicken Hakka Noodles  85","117  Chicken Schezwan Noodles  90","118  Chicken Garlic Rice  120","119  Chicken Fried Rice  95","120  Chicken Schezwan Fried Rice  105","121  Chicken Triple Schezwan Rice  120","122  Chicken American Chopsuey  125","123  Chicken Manchurian  95","124  Shredded Chicken Manchurian  100","125  Chicken Manchurian in Hot Garlic  100","126  Crispy Chicken Manchurian  110","127  Chicken Manchurian in Burnt Garlic  110","128  Pav Bhaji  65","129  Jain Pav Bhaji  70","130  Butter Pav Bhaji  70","131  Khada Pav Bhaji  75","132  Cheese Pav Bhaji  85","133  Cheese Khada Pav Bhaji  90","134  Tawa Pulav  85","135  Bhaji Pulav  90","136  Jain Bhaji Pulav  100","137  EXTRA BUTTER PAV(1ps.)  5","138  Veg Franky  25","139  Veg Corn Franky  25","140  Veg Salad Franky  25","141  Veg Manchurian Franky  25","142  Veg Mayonise Salad Franky  40","143  Veg Mayonise Franky  40","144  Veg Cheese Franky  40","145  Paneer Franky  40","146  Paneer Cheese Franky  50","147  Veg Mayonise Cheese Franky  50","148  Veg Mayonise Paneer Cheese Franky  60","149  Veg Mayonise Salad Paneer Franky  60","150  Egg Franky  40","151  Chicken Franky  50","152  Cheese Chicken Franky  60","153  Chicken Mayonise Franky  60","154  Chicken Paneer Franky  60","155  Chicken Sausage Franky  70","156  Chicken Tikka Franky  70","157  Chicken Tikka Mayonise Cheese Franky  80","158  Chicken Mayonise Paneer Cheese Franky  80","159  Chicken Mayonise Paneer Franky  80","160  Chicken Mayonise Paneer Cheese Tikka Franky  90"};
    public static String []billList;
    public static StringBuffer op=new StringBuffer();
    public static String []list=menu;
 
    
    public static void changeStringArray(int start,int end){
    	int n=0;
    	list=new String[end-start+1];
    	for(int i=start;i<=end;i++){
    		list[n]=menu[i];
    		//System.out.println(list[n]);
    		n++;
    	}
    	
    }
    
    /*
     *This method takes a number as input then take the string from menu array at index of input number
     *Splits the string into a string array
     *as explained before 1st part of string is serial number so just ignores it
     *takes the second part assigns to string
     *Checks if any object of same Name is present if yes the increses quantity
     *If no then creates a object and adds to the vector 
     */
    static public void Item(int inputNumber)
	{
		String []p=list[inputNumber].split("  ");
		Food temp;
    	boolean exists=false;
    	String itemName=p[1];
    	
    	for(int i=0;i<(v.size());i++){
    		temp=Exec.v.get(i);
    		if(temp.name.equalsIgnoreCase(itemName)){
    			temp.quantity++;
    			exists=true;
    		}
    	}
    	if(!exists){
        	Food A= new Food(itemName,Integer.parseInt(p[2]));
        	v.addElement(A);
    	}
	}
	
    static public void Item(int inputNumber,int howMany)
	{	
    	if (howMany>0){
    		String []p=list[inputNumber].split("  ");
    		Food temp;
    		boolean exists=false;
    		String itemName=p[1];
    	
    		for(int i=0;i<(v.size());i++){
    			temp=Exec.v.get(i);
    			if(temp.name.equalsIgnoreCase(itemName)){
    				temp.quantity+=howMany;
    				exists=true;
    			}
    		}
    		if(!exists){
       			Food A= new Food();
       			A.name=itemName;
       			A.price=Integer.parseInt(p[2]);
       			A.quantity=howMany;
       			v.addElement(A);
       			}
    	}
    	else{
    		error("Enter a number greater than zero");
    	}
	}
    /*
     * Removes all the elements in vector as well as array 
     */
    public static void empty(){
         v.removeAllElements();   
     }
    
    /*
     * Removes a particular element from a position from vector and array
     */
    public static void removeAt(int index){
        	v.removeElementAt(index);
        	//removeFromArray(index); //This method is defined below
     }
       
       /* This is the main which I defined to debug only this .java file
        * public static void main(String []args){
    		Scanner x=new Scanner (System.in);
    		System.out.println("Enter ur choice");
    		int input=x.nextInt();
    		StringBuffer asdsad= new StringBuffer(Exec.Item(input));
    		System.out.println(asdsad);
    	}*/
    
     
     /*
      * As op is the string which is seen in TextArea
      * This creates and or updates op when there is input from user  
      */
     public static StringBuffer display(){
       	double total=0;
       	op.setLength(0);
       	billList=new String[v.size()];
       	op.append(" Name"+Food.spacer(39)+"Qty."+Food.spacer(8)+"Rate"+Food.spacer(8)+"Amt."+"\n");
       	for(int i=0;i<v.size();i++){
    		op.append(v.get(i).toString()+"\n");
   			total+=v.get(i).price*v.get(i).quantity;
   			billList[i]=v.get(i).toString();
       	}
       	op.append(Food.spacer(62)+"Total="+total);
       	return op;
     }
     
     public static void reduceQuantity(int index){
    	 Food temp;
    	 temp=Exec.v.get(index);
    	 if(temp.quantity==1){
    		 removeAt(index); 
    	 }
    	 else{
    		 temp.quantity--;
    	 }
     }
    
     public static void error(String message)
     {
         //dialog box comes up with a message
         JOptionPane.showMessageDialog(null,message);
         //the JTextField is set to nothing
         
        	 //Frame.jTextArea1.setText(null);
        	 //Frame.jTextArea1.append(Exec.display()+"");
 
     }

	public static void increaseQuantity(int index) {
		Food temp;
   	 	temp=Exec.v.get(index);
   	 	temp.quantity++;
	}
	 //End of Exec class
}