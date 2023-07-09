import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        List<Product> products = new ArrayList<>();
        System.out.println("Enter the number of products:");
        Integer numProd = sc.nextInt();

        sc.nextLine();

        for(int i=0; i<numProd; i++){
            System.out.println("Product #" + (i+1) + " data:" );
            System.out.print("Common, used or imported (c/u/i?");
            char ch = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name:");
            String nameProd = sc.next();
            System.out.print("Price:");
            Double priceProd = sc.nextDouble();

            if(ch == 'u'){
                System.out.println("Manufacture date(dd/MM/yyyy):");
               String manufactureDateString = sc.next();
               sc.nextLine();

               try{
                   Date manufactureDate = dateFormat.parse(manufactureDateString);
                   Product product = new UsedProduct(nameProd,priceProd,manufactureDate);
                   products.add(product);

               }catch (ParseException e){
                   System.out.println("Invalid Format!");
               }


                }else if(ch == 'i'){
                System.out.println("Customs fee:");
                Double customsFee = sc.nextDouble();
                Product product = new ImportedProduct(nameProd,priceProd,customsFee);
                products.add(product);
            }
            else if(ch == 'c'){
                Product product = new Product(nameProd,priceProd);
                products.add(product);
            }
        }

        for (Product product : products) {
            System.out.println(product.getName());
            System.out.printf( product.priceTag());
            System.out.println();

            if (product instanceof ImportedProduct) {
                ImportedProduct importedProduct = (ImportedProduct) product;
                System.out.println("Custom Fee: " + ImportedProduct.getCustomsFee());
            } else if (product instanceof UsedProduct) {
                UsedProduct usedProduct = (UsedProduct) product;
                System.out.println("Manufacture Date: " + usedProduct.getManufactureDate());
            }

            System.out.println(); // Add a line break for better readability
        }
        sc.close();
    }
}