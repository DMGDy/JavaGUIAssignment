import java.util.HashMap;
import java.util.Map;

public class PackageFactory {
  public Package createPackage(HashMap<String, Object> table) {
    String name = null;
    Double weight = 0.0d;
    Integer shipping_method = 0;
    boolean insured = false;
    // Boolean insured_shipping = false;

    for(Map.Entry<String,Object> entry: table.entrySet() ) {
      String member = entry.getKey();
      // assign different member fields depending on the key 
      switch(member) {
        case("name"): {
          name = entry.getValue().toString();
          break;
        }

        case("weight"): {
          weight = Double.parseDouble(entry.getValue().toString());
          break;
        }

        case("shipping_method"): {
          shipping_method = Integer.parseInt(entry.getValue().toString());
          break;
        }

        case("insured"): {
          insured = Boolean.valueOf(entry.getValue().toString());
          break;
        }
      }
    }
    Package p = null;
    if(insured) {
      p = new InsuredPackage(name,weight,shipping_method);
    } else {
      p = new Package(name,weight,shipping_method);
    }
    return p;
  }
}
