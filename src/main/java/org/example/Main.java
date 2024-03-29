package org.example;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext
                ("spring/app-context.xml");

        MessageRender mr =
                ctx.getBean("renderer", MessageRender.class);
        mr.render();
    }
}