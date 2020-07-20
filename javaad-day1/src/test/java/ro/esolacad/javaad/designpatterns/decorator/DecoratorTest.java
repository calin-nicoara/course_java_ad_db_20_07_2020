package ro.esolacad.javaad.designpatterns.decorator;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.InputStreamReader;

public class DecoratorTest {

    @Test
    public void testDecorator() throws Exception{
//        new BufferedReader(new InputStreamReader(new FileInputStream("file")));

//        new TitlePrompter(new UpperCasePrompter(new HappyPrompter()));

        Prompter prompter = new TitlePrompter(new UpperCasePrompter(new HappyPrompter()));

        System.out.println(prompter.giveMeALine());
    }
}
