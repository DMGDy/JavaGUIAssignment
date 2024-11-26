import java.util.HashMap;

public class InsuredPackage extends Package {
  private double insurance_cost;

  InsuredPackage(String name, Double weight, Integer shipping_method) {
    super(name,weight,shipping_method);

    this.insurance_cost = getInsuredCost();
  }

  private double getInsuredCost() {
    double shipping_cost = super.calculateCost();
    double insurance = 0.0d;
    if(shipping_cost > 0 && shipping_cost <= 1) { insurance = 2.45;}
    else if(shipping_cost > 1.01 && shipping_cost <= 3) {insurance = 3.95;}
    else if(shipping_cost > 3.01) {insurance = 5.55;}

    return insurance;
  }

  @Override
  HashMap<String,String> display() {
    HashMap<String,String> info_table = super.display();
    info_table.put("insured",String.format("%.2f",this.insurance_cost));

    return info_table;

  }
}
