package com.amdocs.dio;

import javax.swing.*;
import java.awt.*;

public class FizzBuzz implements Renderer {

    public String render(int number){
        // return null; AssertionError: expected:<2> but was:<null>

        if (number % 3 == 0 && number % 5 == 0)
            return "FizzBuzz";
        if (number % 3 == 0)
            return "Fizz";
        if (number % 5 == 0)
            return "Buzz";

        return String.valueOf(number);
    }

}
