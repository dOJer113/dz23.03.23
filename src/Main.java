import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] products = {"Хлеб","Яблоко","Молоко"};
        int[] prices ={40,10,60};
        Scanner scanner = new Scanner(System.in);
        int[] quantity = new int[products.length];
        int total = 0;
        Basket basket = new Basket(products,prices);
        File textFile = new File("./src/basket.txt");

        if (textFile.length()!=0){
            basket.loadFromTxtFile(textFile);
        }
        else {
            textFile.createNewFile();
        }
        basket.getFile(textFile);


        for(int i=0;i< products.length;i++){
            System.out.println(i+1+". " + products[i]+" "+ prices[i]+" руб/шт");
        }
        while (true){
            System.out.println("Введите товар и количество или введите 'end'");
            String input  = scanner.nextLine();
            if (input.equals("end")){
                basket.printCart();
                break;
            }
            String[] parts = input.split(" ");
            basket.addToCart(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]));
            basket.saveTxt(textFile);
        }
    }
}