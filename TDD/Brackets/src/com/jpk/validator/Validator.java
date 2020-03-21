package com.jpk.validator;

import java.util.Optional;
import java.util.Stack;

public class Validator implements sequenceValidation {
    @Override
    public boolean isClosedCorrectly(String sequence) {
        if (Optional.ofNullable(sequence).isEmpty()) {
            System.out.println("String is null!!");
            return false;
        }
        else {
            char[] charArray = sequence.toCharArray();
            if (charArray.length < 2) {
                return false;
            }
            else {
                Stack<Character> stack = new Stack();
                for(char ch : charArray){
                    switch (ch) {
                        case '{': stack.push('}'); break;
                        case '(': stack.push(')'); break;
                        default:
                            if (stack.isEmpty() || ch != stack.peek()) return false;
                            stack.pop();
                    }
                }
                return stack.isEmpty();
            }
        }
    }
}
