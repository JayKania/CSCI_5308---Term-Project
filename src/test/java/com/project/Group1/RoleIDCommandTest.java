package com.project.Group1;

import com.project.Group1.CommandFactory.Command;
import com.project.Group1.CommandFactory.CommandFactory;
import com.project.Group1.CommandFactory.ICommandFactory;
import com.project.Group1.Database.Database;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("classpath:application-test.properties")
public class RoleIDCommandTest {

    @Autowired
    Environment env;

    @Test
    void testExecute() {
        ICommandFactory factory = new CommandFactory();
        String[] args = new String[1];
        args[0] = "Admin";
        Command getProjects=factory.getRoleIDCommand(Database.getInstance(), args, env);
        assertEquals(4,getProjects.execute());
    }

}


