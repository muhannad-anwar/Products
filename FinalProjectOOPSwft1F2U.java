package finalprojectoopswft1f2u;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FinalProjectOOPSwft1F2U {

    private static ArrayList<products> list;

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            int a = 0;
            list = SaveDataList();

            int n = 0;
            int z = 1;
            do {
                System.out.println("1- Show all Products.\n"
                        + "2- Add Product.\n"
                        + "3- Delete Product.\n"
                        + "4- Edit Product.\n"
                        + "5- Calculate Total Price.\n"
                        + "6- Save Data to File.\n"
                        + "7- Exit.\n"
                        + "Enter your choice: ");
                n = input.nextInt();

                switch (n) {
                    case 1:
                        System.out.println("<------------------------------------------------------->");
                        ShowallProducts();
                        break;
                    case 2:
                        System.out.println("<------------------------------------------------------->");

                        AddProduct();
                        break;
                    case 3:
                        System.out.println("<------------------------------------------------------->");

                        DeleteProduct();
                        break;
                    case 4:
                        System.out.println("<------------------------------------------------------->");

                        EditProduct();
                        break;
                    case 5:
                        System.out.println("<------------------------------------------------------->");

                        TotalPrice(/*list, z*/);
                        break;
                    case 6:
                        System.out.println("<------------------------------------------------------->");

                        SaveDatatoFile(/*list*/);
                        break;
                    case 7:
                        break;
                }
                System.out.println("<------------------------------------------------------->");

            } while (n != 7);

        } catch (Exception e) {
            System.out.println("Error......An error occurred restarting the program..........");
        }
    }

    //-----------------------------------------------------------------------------------------------------------
    public static void ShowallProducts() {

        System.out.println("ID, NAME, DESCRIPTION, PRICE, TYPE");

        for (int i = 0; i < list.size(); i++) {

            System.out.println(list.get(i).toString());

        }
        System.out.println("");

    }

    //------------------------------------------------------------------------------------------------------
    public static void AddProduct() {

        Scanner input = new Scanner(System.in);

        System.out.println("\nEnter id of priduct:");
        int b = input.nextInt();
        boolean gg = false;
        for (int z = 0; z < list.size(); z++) {
            products get = new products();
            get = (products) list.get(z);
            if (get.getID() == b) {
                gg = true;
            }
        }

        if (!gg) {
            System.out.println("What kind of product:\n"
                    + "1.Dimensional Products.\n2.Weighted Products.");
            int n = input.nextInt();
            System.out.println("Enter name of product:");
            String c = input.next();

            System.out.println("Enter Description's product:");
            String cc2 = input.next();

            System.out.println("Enter Price's product:");
            double d = input.nextDouble();

            if (n == 1) {
                System.out.println("Enter the width of products:");
                double dd = input.nextDouble();
                System.out.println("Enter the length od products:");
                double ddd = input.nextDouble();
                products p = new DimensionalProducts(b, c, cc2, d, dd, ddd);
                list.add(p);

            } else if (n == 2) {
                System.out.println("Enter the weight of products:");
                double dd = input.nextDouble();
                products p = new WeightedProducts(b, c, cc2, d, dd);
                list.add(p);

            }
            System.out.println("Product Added Successfully...");

        } else {
            System.out.println("This ID already exists. Please enter another ID:");
            AddProduct();
        }

    }
    //--------------------------------------------------------------------------------------------------------

    public static void DeleteProduct(/*ArrayList list, int */) {
        ShowallProducts();
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter the ID number you want to delete: ");
        int a = input.nextInt();
        boolean gg = false;
        for (int i = 0; i < list.size(); i++) {
            products get = new products();
            get = (products) list.get(i);
            if (get.getID() == a) {
                list.remove(i);
                gg = true;
                System.out.println("Deleted Successfully....");
            }
        }
        if (!gg) {
            System.out.println("This product does not exist. Please enter another ID:");
            DeleteProduct(/*list, z*/);
        }
        //return list;
    }

    //----------------------------------------------------------------------------------------------------
    public static void EditProduct() {
        Scanner input = new Scanner(System.in);
        ShowallProducts();
        System.out.println("\nEnter the ID number for the product you want to edit:");
        int a = input.nextInt();
        boolean gg = false;
        for (int ss = 0; ss < list.size(); ss++) {
            products get = new products();
            get = (products) list.get(ss);
            if (get.getID() == a) {
                int size = get.toString().length();
                String str = get.toString();
                if (str.charAt(size - 1) == 'D') {
                    //----------------------------------------------
                    products product = new DimensionalProducts();
                    product = (products) list.get(ss);
                    System.out.println("What do you want to edit ?");
                    product.toString();
                    System.out.println("1. Edit all.\n"
                            + "2. Edit ID only.\n"
                            + "3. Edit name.\n"
                            + "4. Edit Description.\n"
                            + "5. Edit Price.\n");
                    System.out.println("6.Edit length.\n"
                            + "7.Edit width.");
                    int s = input.nextInt();
                    if (s == 1) {
                        AllEdit(s);
                    } else {
                        product = AddProductEditD(product, s);
                    }

                    //------------------------------------------------
                } else {
                    //------------------------------------------------
                    products product = new WeightedProducts();
                    product = (products) list.get(ss);
                    System.out.println("What do you want to edit ?");
                    product.toString();
                    System.out.println("1. Edit all.\n"
                            + "2. Edit ID only.\n"
                            + "3. Edit name.\n"
                            + "4. Edit Description.\n"
                            + "5. Edit Price.\n");
                    System.out.println("6.Edit weight.");
                    int s = input.nextInt();
                    if (s == 1) {
                        AllEdit(s);
                    } else {
                        product = AddProductEditW(product, s, list);
                    }
                }
                System.out.println("Updated Successfully.....");
                gg = true;
            }
        }
        if (!gg) {
            System.out.println("This product does not exist. Please enter another ID:");
            EditProduct();
        }

    }
    //--------------------------------------------------------------------------------------------------------

    public static void AllEdit(int a) {
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter the new id of priduct:");
        int b = input.nextInt();
        System.out.println("");
        boolean gg = true;
        for (int z = 0; z < list.size(); z++) {
            products get = new products();
            get = (products) list.get(z);
            if (get.getID() == b) {
                gg = false;
            }
        }
        if (gg) {
            System.out.println("What kind of new product:______\n"
                    + "1.Dimensional Products.\n\n2.Weighted Products.");
            int n = input.nextInt();

            System.out.println("Enter the new name of product:");
            String c = input.next();
            System.out.println("");

            System.out.println("Enter the new Description's product:");
            String cc2 = input.next();
            System.out.println("");

            System.out.println("Enter the new Price's product:");
            double d = input.nextDouble();
            System.out.println("");
            products p;
            if (n == 1) {
                System.out.println("Enter the new width of products:");
                double dd = input.nextDouble();
                System.out.println("Enter the new length od products:");
                double ddd = input.nextDouble();
                p = new DimensionalProducts(b, c, cc2, d, dd, ddd);

            } else {
                System.out.println("Enter the new weight of products:");
                double dd = input.nextDouble();
                p = new WeightedProducts(b, c, cc2, d, dd);

            }
            list.set(a, p);

        } else {
            System.out.println("This ID already exists. Please enter another ID:");
            AllEdit(a);
        }
     //   return list;
    }

    //--------------------------------------------------------------------------------------------------------
    public static products AddProductEditD(products product, int s) {
        Scanner input = new Scanner(System.in);

        switch (s) {
            case 2:
                System.out.println("Enter the new ID:");
                int d = input.nextInt();
                boolean gg = true;
                for (int z = 0; z < list.size(); z++) {
                    products get = new products();
                    get = (products) list.get(z);
                    if (get.getID() == d) {
                        gg = false;
                    }
                }
                if (gg) {
                    product.setID(d);
                } else {
                    System.out.println("The ID number you entered already exists, please enter another number:");
                    AddProductEditD(product, s);
                }
                break;
            case 3:
                System.out.println("Enter the new name:");
                String dd = input.nextLine();
                product.setName(dd);
                break;
            case 4:
                System.out.println("Enter the new Description:");
                String ddd = input.nextLine();
                product.setDescription(ddd);
                break;
            case 5:
                System.out.println("Enter the new Price:");
                double dddd = input.nextDouble();
                product.setPrice(dddd);
                break;
            case 6:
                System.out.println("Enter the new length:");
                double ddddd = input.nextInt();
                product.setLength(ddddd);
                break;
            case 7:
                System.out.println("Enter the new width:");
                double dddddd = input.nextInt();
                product.setWidth(dddddd);
                break;

        }
        return product;
    }

    public static products AddProductEditW(products product, int s, ArrayList list) {
        Scanner input = new Scanner(System.in);
        switch (s) {
            case 2:
                System.out.println("Enter the new ID:");
                int d = input.nextInt();
                boolean gg = true;
                for (int z = 0; z < list.size(); z++) {
                    products get = new products();
                    get = (products) list.get(z);
                    if (get.getID() == d) {
                        gg = false;
                    }
                }
                if (gg) {
                    product.setID(d);
                } else {
                    System.out.println("The ID number you entered already exists, please enter another number:");
                    AddProductEditW(product, s, list);
                }
                break;
            case 3:
                System.out.println("Enter the new name:");
                String dd = input.nextLine();
                product.setName(dd);
                break;
            case 4:
                System.out.println("Enter the new Description:");
                String ddd = input.nextLine();
                product.setDescription(ddd);
                break;
            case 5:
                System.out.println("Enter the new Price:");
                double dddd = input.nextDouble();
                product.setPrice(dddd);
                break;
            case 6:
                System.out.println("Enter the new weight:");
                double ddddd = input.nextInt();
                product.setWeight(ddddd);
                break;
        }
        return product;
    }
//-------------------------------------------------------------------------------------------------------------

    public static void TotalPrice(/*ArrayList list, int z*/) {
        System.out.println("--------------------------");
        ShowallProducts();
        double Total = 0;
        for (int t = 0; t < list.size(); t++) {
            products pp = new products();
            pp = (products) list.get(t);
            System.out.println(pp.CalculatePrice());
            Total += pp.CalculatePrice();
        }
        System.out.println("Total Price : " + Total + ".");
    }

    //-----------------------------------------------------------------------------------------------------------
    public static void SaveDatatoFile() {
        try {
            String directory = "E:\\FinalProjectOOPSwft1F2U";
            Path path;
            path = Paths.get(directory);

            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
            FileWriter fileWriter = new FileWriter("E:\\FinalProjectOOPSwft1F2U\\FileProducts.txt", false);
            PrintWriter printWriter = new PrintWriter(fileWriter, true);
            printWriter.println("ID,NAME,DESCRIPTION,PRICE,TYPE");
            for (int i = 0; i < list.size(); i++) {
                products pp;
                pp = (products) list.get(i);
                printWriter.println(pp.toString());
            }
            printWriter.close();

        } catch (IOException ex) {
            Logger.getLogger(FinalProjectOOPSwft1F2U.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("saved....");
    }
    //-----------------------------------------------------------------------------------------------

    public static ArrayList SaveDataList() throws IOException {
        ArrayList<products> list = new ArrayList<>();
        try {
            String directory = "E:\\FinalProjectOOPSwft1F2U";
            Path path = Paths.get(directory);
            
            if(!Files.exists(path)){
                Files.createDirectories(path);
            }else{
            File file = new File("E:\\FinalProjectOOPSwft1F2U\\FileProducts.txt");
            Scanner input1 = new Scanner(file);
            int a = 0;
            while (input1.hasNextLine()) {
                if (a != 0) {
                    String str = input1.nextLine();
                    String str2[] = str.split(",");
                    if (str2[str2.length - 1].equalsIgnoreCase("D")) {
                        int ID = Integer.parseInt(str2[0]);
                        String NAME = str2[1];
                        String DESCRIPTION = str2[2];
                        double PRICE = Double.parseDouble(str2[3]);
                        double length = Double.parseDouble(str2[4]);
                        double width = Double.parseDouble(str2[5]);
                        list.add(new DimensionalProducts(ID, NAME, DESCRIPTION, PRICE, length, width));
                    } else if (str2[str2.length - 1].equalsIgnoreCase("W")) {
                        int ID = Integer.parseInt(str2[0]);
                        String NAME = str2[1];
                        String DESCRIPTION = str2[2];
                        double PRICE = Double.parseDouble(str2[3]);
                        double weight = Double.parseDouble(str2[4]);
                        list.add(new WeightedProducts(ID, NAME, DESCRIPTION, PRICE, weight));
                    }
                }
                a++;
            }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FinalProjectOOPSwft1F2U.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
