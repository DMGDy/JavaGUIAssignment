# Some Java Assignment 

Creates some application using [JOptionPane](https://docs.oracle.com/javase/8/docs/api/javax/swing/JOptionPane.html)
for dialog boxes to provide basic I/O. 

This is supposed to mimic a program to enter in **package information** and outputs **final shipping costs**.

**Package** object class contains 
   - weight *(float)*
   - shipping method *(char/String)*
        - **A** for air
        - **T** for truck
        - **M** for mail
   - shipping cost *(float)*


**Package** must be created by having its constructor have parameters for each Class member. 
This means data **must** be validated before calling constructor. 

the **calculateCost()** method is called by the constructor and determines the shipping cost based on 
the following 

| Weight (oz) | Air (\$) | Truck (\$) | Mail (\$)|
|-------------|----------|------------|----------|
| 1 ~ 8       | 2.0      | 1.5        | 0.5      |
| 9 ~ 16      | 3.0      | 2.35       | 1.5      |
| 17 and over | 4.0      | 3.25       | 2.15     |

The **Package** class has method **display()** that displays all four members of the class with the name of the customer.

Create a subclass **Insured Package** thats adds an insurance cost to the shipping cost

| Shipping Cost before Insuracnce (\$) | Additional Cost (\$) | 
|--------------------------------------|----------------------|
| 0 ~ 1.00                             | 2.45                 |
| 1.01 ~ 3.00                          | 3.95                 | 
| 3.01 and over                        | 5.55                 |


Application class **UsePackage** that instantiates objects based on user's choice.



