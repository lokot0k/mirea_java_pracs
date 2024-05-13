package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) {
        if (args.length < 1) {
            System.out.println("Please enter the bean name as an argument");
            return;
        }

        String beanName = args[0];
        Programmer programmer = (Programmer) context.getBean(beanName);

        if (programmer != null) {
            programmer.doCoding();
        } else {
            System.out.println("Bean with name " + beanName + " not found");
        }
    }
}
