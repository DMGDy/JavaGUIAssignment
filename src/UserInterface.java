import java.util.HashMap;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Map;


// This class is responsible for handling input and displaying messages

public class UserInterface{
  // will interact with class for invoice controlling
  final private String title = "Package Shipment Application";
  final private String[] options = {"Air","Truck","Mail"};
  HashMap<String,Object> start() { 

    // call private methods to get user inputs 
    String name = getName();
    Double weight = getWeight();
    Integer shipping_method = getShippingMethod();
    boolean insured = getIfInsured();


    // table for returning for object initialization
    HashMap<String,Object> init_table = new HashMap<>();

    init_table.put("name",name);
    init_table.put("weight",weight);
    init_table.put("shipping_method",shipping_method);
    init_table.put("insured",insured);

    return init_table;
  }

  private String getName() {
    // enter name and make sure it is not empty
    String name = JOptionPane.showInputDialog(null,"Enter customer's Name: ",title,JOptionPane.PLAIN_MESSAGE);
    while(name.isBlank()) {
      name = JOptionPane.showInputDialog(null,"Name cannot be empty.\nEnter Customer Name: ",title,JOptionPane.PLAIN_MESSAGE);
    }

    return name;
  }

  private Double getWeight() {
    boolean valid_weight = false;
    Double weight = 0.0d;
    String weight_str = null;
    // try catch to only grab string that can be converted to float type
    
    while(!valid_weight){
      try {
        weight_str = JOptionPane.showInputDialog(null,"Enter Package weight:",title,JOptionPane.PLAIN_MESSAGE);
        weight = Double.parseDouble(weight_str);
        valid_weight = true;
      } catch(NumberFormatException e) {
        JOptionPane.showMessageDialog(null,"Enter a valid number!",title,JOptionPane.ERROR_MESSAGE);
      }
    }

    return weight;
  }

  private Integer getShippingMethod() {
    // Different options for shipping
    // Mail == 0, Truck == 1, Air == 2
    Integer option = JOptionPane.showOptionDialog(null,"Choose shipping method",title, 
        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
        options,options[0]);   

    return option;
  }

  private boolean getIfInsured() {
    boolean[] options = {true,false};
    int option = JOptionPane.showConfirmDialog(null,"Add insurance to package?",title,JOptionPane.YES_NO_OPTION);

    return options[option];
  }

  private String parseTable(HashMap<String,String> table) {
    String name = null;
    String weight = null;
    String shipping_method = null;
    String shipping_cost = null;
    boolean insured = false;
    String insured_cost = null;


    for(Map.Entry<String,String> entry: table.entrySet()) {
      String key = entry.getKey();
      switch(key) {
        case("customer_name"): {
          name = entry.getValue();
          break;
        }
        case("weight"): {
          weight = entry.getValue();
          break;
        }
        case("shipping_method"): {
          shipping_method = options[Integer.parseInt(entry.getValue())];
          break;
        }
        case("shipping_cost"): {
          shipping_cost = entry.getValue();
          break;
        }

        case("insured"): {
          insured = true;
          insured_cost = entry.getValue();
        }
      }
    }

    String formatted_info = new String();
    if(insured) {
      formatted_info = String.format("Customer Name: %s\nPackage Weight: %s\nShipping Method: %s\nShipping Cost: %s\n"+
          "Insurance Cost: %s\nTotal Cost with Insurance: %f\n"+
          "================================================\n",
          name,weight,shipping_method,shipping_cost,insured_cost,
          Double.parseDouble(shipping_cost) + Double.parseDouble(insured_cost));
    } else {
      formatted_info = String.format("Customer Name: %s\nPackage Weight: %s\nShipping Method: %s\nShipping Cost: %s\n"+
          "================================================\n",
          name,weight,shipping_method,shipping_cost);
    }
    return formatted_info;
  }

  public void display_package_info(ArrayList<HashMap<String,String>> member_tables) {
    StringBuilder formatted_info = new StringBuilder();
    formatted_info.append("================================================\n");

    for(HashMap<String,String> table: member_tables) {
      String info = parseTable(table);
      formatted_info.append(info);
    }
    
    formatted_info.toString();
    JOptionPane.showMessageDialog(null,formatted_info,title,JOptionPane.PLAIN_MESSAGE);
  }

  boolean createMorePackages() {
    boolean[] options = {true,false};
    int option = JOptionPane.showConfirmDialog(null,"Add another invoice for package?",title,JOptionPane.YES_NO_OPTION);
    return options[option];
  }

}
