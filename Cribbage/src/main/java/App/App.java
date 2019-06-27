package App;

import controller.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author jackelder
 */
public class App {
    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
        Controller controller = ctx.getBean("controller", Controller.class);
        controller.run();
    }
}
