import java.util.HashMap;
import java.util.ArrayList;

public class UsePackage {
  public static void main(String args[]) {

    UserInterface ui = new UserInterface();
    PackageFactory factory = new PackageFactory();
    Packages packages = new Packages();

    // keep creating package invoices as long as customer wants
    do {
      HashMap<String,Object> table = ui.start();
      Package p = factory.createPackage(table);
      packages.addPackage(p);
    }while(ui.createMorePackages());

    // display all invoice information
    ArrayList<HashMap<String,String>> member_tables = packages.getMemberTables();
    ui.display_package_info(member_tables);
  }
}
