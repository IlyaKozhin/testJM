import java.util.Scanner;

public class Calculator
{
   private static String inputString;
   
   public static void main(String[] args)
   {
      Scanner scanner = new Scanner( System. in);
	  inputString = scanner.nextLine();
          try{
            
            StringParser stringParser = new StringParser(inputString);
            calculate(stringParser);
          }
          catch(IllegalArgumentException iae)
          {
              System.out.println(iae);
              System.exit(0);
          }
          
   }
   private static void calculate(StringParser strP)
   {
	int result=0;
        if(strP.operator.equals("*"))result=strP.firstOperand * strP.secondOperand;
	else if(strP.operator.equals("/"))result=(strP.firstOperand / strP.secondOperand);
	else if(strP.operator.equals("-"))result=(strP.firstOperand - strP.secondOperand);
	else if(strP.operator.equals("+"))result=(strP.firstOperand + strP.secondOperand);
        
        if(strP.isArabicDigit)
        {
            System.out.println(result);
        }
        else
        {           
            String s = "";
            if(result<0)
            {
                result=result*(-1);
                s+="-";
            }
            
            while (result >= 100) {
            s += "C";
            result -= 100;
            }
            while (result >= 90) {
                s += "XC";
                result -= 90;
            }
            while (result >= 50) {
                s += "L";
                result -= 50;
            }
            while (result >= 40) {
                s += "XL";
                result -= 40;
            }
            while (result >= 10) {
                s += "X";
                result -= 10;
            }
            while (result >= 9) {
                s += "IX";
                result -= 9;
            }
            while (result >= 5) {
                s += "V";
                result -= 5;
            }
            while (result >= 4) {
                s += "IV";
                result -= 4;
            }
            while (result >= 1) {
                s += "I";
                result -= 1;
            }
            if(s.equals(""))s+="N";
    
            System.out.println(s);
        }
        
   }
    
}

