public class StringParser
{
	public boolean isArabicDigit=true;
	public int firstOperand;
	public int secondOperand;
	public String operator="";
	
	private String inputStr;
	
	StringParser(String inputString) throws IllegalArgumentException
	{
		inputStr = inputString;
		inputStr=inputStr.replace(" ","");
                if(!((Character.isLetter(inputStr.charAt(0))&&Character.isLetter(inputStr.charAt(inputStr.length()-1)))
                  ||(Character.isDigit(inputStr.charAt(0))&&Character.isDigit(inputStr.charAt(inputStr.length()-1)))))
              throw new IllegalArgumentException("Invalid input...");
		if(!Character.isDigit(inputStr.charAt(0)))
		{
			romeToArabic();
                        isArabicDigit=false;
		}
                
		if(isOperator(Character.toString(inputStr.charAt(1))))
		{
			firstOperand=Integer.parseInt(inputStr.substring(0,1));
			secondOperand=Integer.parseInt(inputStr.substring(2));
                        if(!(isInRange(firstOperand)&&isInRange(secondOperand)))throw new IllegalArgumentException("Invalid input...");;
		}
		else if(isOperator(Character.toString(inputStr.charAt(2))))
		{
			firstOperand=Integer.parseInt(inputStr.substring(0,2));
			secondOperand=Integer.parseInt(inputStr.substring(3));
                        if(!(isInRange(firstOperand)&&isInRange(secondOperand)))throw new IllegalArgumentException("Invalid input...");
		}
                else throw new IllegalArgumentException("Invalid input...");
	}
	
	private void romeToArabic()
	{
		inputStr=inputStr.replace("IX","9");
		inputStr=inputStr.replace("VIII","8");
		inputStr=inputStr.replace("VII","7");
		inputStr=inputStr.replace("VI","6");
		inputStr=inputStr.replace("IV","4");
		inputStr=inputStr.replace("III","3");
		inputStr=inputStr.replace("II","2");
		inputStr=inputStr.replace("I","1");
		inputStr=inputStr.replace("V","5");
		inputStr=inputStr.replace("X","10");
	}
	private boolean isOperator(String findOperator)
	{
		if(findOperator.equals("*")||findOperator.equals("/")||
		findOperator.equals("+")||findOperator.equals("-"))
		{
			operator=findOperator;
                        return true;
		}
                return false;
		
	}
        private boolean isInRange(int oper)
        {
            return (oper>=1)&&(oper<=10);
        }
}