//Create 2 Classes, Activity1 and Car in your activities package.
//The Car class will not have the main() method.
//In the Car class, add these variables:
//A String color
//A String transmission
//An int make
//An int tyres
//An int doors
//Make a constructor to initialize the class variables. Set the number of tyres to 4 and doors to 4.
//Create these methods:
//displayCharacteristics() - This displays the values of all the variables
//accelarate() - This prints "Car is moving forward."
//brake() - This prints "Car has stopped."

//In the class Activity1, create an Object of the Car class
//Initialize the values of
//make to 2014
//color to "Black"
//transmission to "Manual"
//Call the methods in the Car class to print the characteristics of the car, and what happens when you accelerate() and brake().

package activities;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Car car= new Car("Black" , "Manual" , 2014);
        
        car.displayCharacteristics();
        
        car.accelarate();
        
        car.brake();
        
	}

}
