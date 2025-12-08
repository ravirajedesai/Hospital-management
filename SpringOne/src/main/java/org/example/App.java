package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context= new ClassPathXmlApplicationContext();
        Alien alien= (Alien) context.getBean("Alien");
        System.out.println( "Hello World!" );

        alien.show();
    }
}
