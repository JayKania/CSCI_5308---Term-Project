package com.project.Group1.Dao;

import com.project.Group1.CommandFactory.Command;
import com.project.Group1.Database.IDatabase;
import org.springframework.core.env.Environment;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateICRItems extends Command {
    public UpdateICRItems(IDatabase receiver, String[] args, Environment env) {
        super(receiver, args, env);
    }

    @Override
    public Object execute() {
        IDatabase db = receiver;
        try {
            Connection con = db.getConnection(env.getProperty("CONNECTION_URL"), env.getProperty("DEVINT_USERNAME"), env.getProperty("DEVINT_PASSWORD"));
            PreparedStatement stmt = con.prepareStatement("call insert_ICRItems(?,?,?,?,?)");
            stmt.setInt(1, Integer.parseInt(args[0]));
            stmt.setInt(2, Integer.parseInt(args[1]));
            stmt.setString(3, args[2]);
            stmt.setInt(4, Integer.parseInt(args[3]));
            stmt.setInt(5, Integer.parseInt(args[4]));

            int result = stmt.executeUpdate();
            con.commit();
            con.close();

            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
