package CafeApp;

/*
 * This is the main core of program this is the place everything happens
 * All the listeners from frame GUI call methods in Exec class
 */
class Food {
    double price;
    String name;
    int quantity = 1;

    public Food() {
    }

    /*
     * Just a constructor have to pass a string and int to create a food obj
     */
    public Food(String a, int p) {
        name = a;
        price = p;

    }

    /*
     * toString method to get the String form of an object adjusted the spaces in it according to output in a txt file
     */
    @Override
    public String toString() {
        return name + spacer(45 - (name.length())) + quantity + spacer(10) + price + spacer(8) + quantity * price;
    }


    /*
     * This is just returns n no. of spaces appended together
     * I have used it many times in program
     */
    public static StringBuffer spacer(int n) {
        StringBuffer space = new StringBuffer();
        for (int i = 0; i < n; i++) {
            space.append(" ");
        }
        return space;
    }
//End of Food
}
