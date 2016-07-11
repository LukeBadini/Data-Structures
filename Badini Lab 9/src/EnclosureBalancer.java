public class EnclosureBalancer
{
    /**
     * Determines if the given string has balanced enclosures 
     * (i.e. parentheses, brackets, curly braces, angle brackets).  
     * @param input
     * @return true if and only if the enclosures are balanced.
     */
    public boolean isBalanced(String input)
    {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < input.length(); i++) {
            Character currentChar = new Character(input.charAt(i));
            if (isOpeningEnclosure(currentChar)) 
            {
                processOpeningEnclosure(stack, currentChar);
            } 
            else if (isClosingEnclosure(currentChar)) 
            {
                if (closingMatchesOpening(stack, currentChar)) 
                {
                    processClosingEnclosure(stack, currentChar);
                } 
                else 
                {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
	
    private boolean isOpeningEnclosure(Character c)
    {
        return c.equals('(') 
                || c.equals('{') 
                || c.equals('<') 
                || c.equals('['); 
    }
	
    private boolean isClosingEnclosure(Character c)
    {
        return c.equals(')') 
                || c.equals('}') 
                || c.equals('>') 
                || c.equals(']'); 
    }
	
    private void processOpeningEnclosure(Stack<Character> stack, Character c)
    {
        stack.push(c);
    }
	
    private void processClosingEnclosure(Stack<Character> stack, Character c)
    {
        stack.pop();
    }
	
    private boolean closingMatchesOpening(Stack<Character> stack, Character c)
    {
        Character topChar = stack.top();
        if (topChar == null) {
            return false;
        }
        return (c.equals(')') && topChar.equals('(')) 
                || (c.equals('}') && topChar.equals('{')) 
                || (c.equals('>') && topChar.equals('<')) 
                || (c.equals(']') && topChar.equals('[')); 
    }
}
