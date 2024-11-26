import java.util.HashMap;

public class Package {
  private String customer_name;
  private double weight;
  private int shipping_method;

  private double shipping_cost;

  /*      Air, Truck, Mail
   *  1~8
   *  9~16
   *  >17
   */
  final private double[][] shipping_cost_table = {
    {2.00, 1.50, 0.50},
    {3.00, 2.35, 1.50},
    {4.00, 3.25, 2.15}
  };

  // Constructor for package must contain attributes as parameters
  Package(String customer_name, Double weight, Integer shipping_method) {
    this.customer_name = customer_name;
    this.weight = weight;
    this.shipping_method = shipping_method;
    System.out.printf("%s,%f,%d\n",this.customer_name,this.weight,this.shipping_method);
    this.shipping_cost =  calculateCost();
  }

  // Call `calculateCost()` during constructor to assign rest of class memebrs
  double calculateCost() {
    int weight_category = 0;
    if(this.weight > 1 && this.weight <= 8) {
      weight_category = 0;
    }else if(this.weight > 8 && this.weight <= 16) {
      weight_category = 1;
    }else if(this.weight > 17) {
      weight_category = 2;
    }

    // get cost from table
    return shipping_cost_table[weight_category][this.shipping_method];
  }

  // since this class should not be responsible of displaying anything, return
  // the member information of this object as a table
  HashMap<String,String> display() {
    // Store all information as string as it is used to be displayed
    HashMap<String,String> info_table = new HashMap<>();

    info_table.put("customer_name",this.customer_name);
    // Safe to call toString without exception handling at is it checked on assignment by UI class
    info_table.put("weight",Double.toString(this.weight));
    info_table.put("shipping_method",Integer.toString(this.shipping_method));
    info_table.put("shipping_cost", Double.toString(this.shipping_cost));

    return info_table;
  }

}
