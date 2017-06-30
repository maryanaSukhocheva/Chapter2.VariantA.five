/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package varianta.five.action;

import java.util.Scanner;

/**
 *
 * @author Sukhocheva Maryana
 */
public class Action {
    
    String pattern = "(\\s)+|($)";

    /**
     *
     * @return
     */
    public String[] Numbers() {
        boolean result;
        float number;
        String[] masNum = null;
        try (Scanner scan = new Scanner(System.in)) {
            result = false;
            String str = scan.nextLine();
            for (String retval : str.split(pattern)) {
                try {
                    if (!retval.isEmpty()) {
                        number = Float.valueOf(retval);
                        result = true;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Неверный формат чисел!");
                    result = false;
                    break;
                }
            }
            scan.close();
            if (result) {
                masNum = str.split(pattern);
            }
        }
        return masNum;
    }
    
    /**
     *
     * @param mas
     */
    public void CompareNumbers(String[] mas) {
        int countChetNumber=0;
        int countChet=0;
        int countNeChet=0;
        int countChetNechet=0;
        
        for (String str:mas) {
            
            if (Integer.valueOf(str)%2==0){
               
                countChetNumber++;
                countChet=0;
                countNeChet=0;
               char[] charArray=str.toCharArray();
               for (char simbol:charArray) {
                   if(Character.getNumericValue(simbol)%2==0){
                      countChet++; 
                   } else {
                       countNeChet++;
                   }
                   
                    }
               if (countChet==countNeChet) {
                       countChetNechet++;
                   }
            }
        }
        System.out.println("Количество четных чисел - "+String.valueOf(countChetNumber));
        System.out.println("Из них количество чисел с равным числом четных и нечетных цифр - "+String.valueOf(countChetNechet));
    }
}
