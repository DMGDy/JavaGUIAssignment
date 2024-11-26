import java.util.ArrayList;
import java.util.HashMap;

public class Packages {
  // Dynamic array for storing more than one package
  ArrayList<Package> packages;

  Packages() {
    this.packages = new ArrayList<>();
  }

  void addPackage(Package p) {
    packages.add(p);
  }

  // return an ArrayList of every package member value
  ArrayList<HashMap<String,String>> getMemberTables(){
    ArrayList<HashMap<String,String>> member_tables = new ArrayList<>();

    for(Package p: packages) {
      member_tables.add(p.display());
    }
    return member_tables;
  }

  
}
