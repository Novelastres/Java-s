import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.stream.Stream;

public class FactorialTricks {

    //find the numbers whose sum of each digit's factorial is equal to the number itself
    //from 0 to the int a
    //return a list of those numbers
    public static int[] factorialSum(int a){
        int[] fin = new int[8];
        int verif = 0;

        int[] chiffre = new int[10];
        chiffre[0] = 1;
        for(int i = 1; i < 10; i++){
            chiffre[i] = chiffre[i-1] * i;
        }

        int digit;
        int sum;
        String number;
        for(int j = 0; j <= a; j++){
            sum = 0;
            number = "";
            number = Integer.toString(j);
            for(int k = 0; k < number.length(); k++){
                digit = Character.getNumericValue(number.charAt(k));
                sum += chiffre[digit];
            }

            if(sum==j){
                if(verif+1 >= fin.length){
                    fin = resize(fin);
                }
                fin[verif++]=j;
            }
        }
        int[] realfin = new int[verif];
        for(int l = 0; l < verif;l++){
            realfin[l] = fin[l];
        }
        return realfin;

    }

    //find the numbers whose product of each digit's factorial is equal to the number itself
    //from 0 to the int a
    //return a list of those numbers
    public static int[] factorialMult(int a){
        int[] fin = new int[8];
        int verif = 0;

        int[] chiffre = new int[10];
        chiffre[0] = 1;
        for(int i = 1; i < 10; i++){
            chiffre[i] = chiffre[i-1] * i;
        }

        int digit;
        int product;
        String number;
        for(int j = 0; j <= a; j++){
            product = 1;
            number = "";
            number = Integer.toString(j);
            for(int k = 0; k < number.length(); k++){
                digit = Character.getNumericValue(number.charAt(k));
                product *= chiffre[digit];
            }

            if(product==j){
                if(verif+1 >= fin.length){
                    fin = resize(fin);
                }
                fin[verif++]=j;
            }
        }
        int[] realfin = new int[verif];
        for(int l = 0; l < verif;l++){
            realfin[l] = fin[l];
        }
        return realfin;
    }
    // return a string to show the numbers found with factorialMult and factorialSum.
    public static String factorialStr(int a) {
        int[] sums = factorialSum(a);
        int[] mult = factorialMult(a);

        String fin = "The chosen numbers (less or equal to " + a + ") whose sum of each digit's factorial is equal to the number itself are: "+ sums[0];
        for(int i = 1; i < sums.length-1; i++){
            fin += ", "+ sums[i];
        }
        fin += " and " + sums[sums.length-1] + ".\n";


        fin += "The holy numbers (less or equal to " + a + ") whose product of each digits's factorial is equal the said number are: "+ mult[0];
        for(int i = 1; i < mult.length-1; i++) {
            fin += ", " + mult[i];
        }
        fin += " and " + mult[mult.length-1] + ".";

        return fin;

    }
    //resize a list by doubling its capacity
    public static int[] resize(int[] l){
        int[] fin = new int[l.length*2];
        for(int i= 0; i<l.length;i++){
            fin[i]= l[i];
        }
        return fin;
    }}





