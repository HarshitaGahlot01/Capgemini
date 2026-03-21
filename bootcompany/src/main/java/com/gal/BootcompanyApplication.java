package com.gal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.gal.model.Department;
import com.gal.service.DepartmentService;

@SpringBootApplication
public class BootcompanyApplication {
	private static final Logger log= LoggerFactory.getLogger(BootcompanyApplication.class);

    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                SpringApplication.run(BootcompanyApplication.class, args);
        log.info("Application started successfully!");

		 DepartmentService depService = context.getBean(DepartmentService.class);

//        DepartmentService depService = context.getBean(DepartmentService.class);
//        Department d = new Department();
//        d.setDepartmentId(60);
//        d.setDepartmentName("AI");
//        d.setManagerId(200);
//
//        depService.add(d);
//
//        // UPDATE
//        d.setDepartmentName("Artificial Intelligence");
//        depService.update(d);
//
//        // DELETE
//         depService.delete(50);

        // PRINT ALL
        depService.findAll().forEach(System.out::println);
    }
}

      