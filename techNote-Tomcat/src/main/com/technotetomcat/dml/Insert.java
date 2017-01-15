package com.technotetomcat.dml;

import com.technotetomcat.database.MySQLConnection;
import com.technotetomcat.dml.Select;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
  MySQLConnection con = new MySQLConnection();
  Select select = new Select();

  public void tagInsert(String tags) throws ClassNotFoundException {
		String sql = "INSERT INTO tag(tagname) VALUES(?)";

		try(Connection connection = con.getConnection();) {
      PreparedStatement preparedStatement = connection.prepareStatement(sql);

      for(String tag : tags.split("[ 　]+")) {

        if(!select.isTag(tag)) {
          preparedStatement.setString(1, tag);
          preparedStatement.executeUpdate();
        }
      }
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

  public void todoInsert(String title, String tags, String description) {
    String sql = "INSERT INTO todo(title,description) VALUES(?,?)";

    try(Connection connection = con.getConnection();) {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setString(1, title);
      preparedStatement.setString(2, description);
      preparedStatement.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		}
  }

  public void tagtodoInsert(String title, String tags) {
    String sql = "INSERT INTO tagtodo(title,tagID) VALUES(?,?)";

    try(Connection connection = con.getConnection();) {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

      for(String tag : tags.split("[ 　]+")) {
        preparedStatement.setString(1, title);
        preparedStatement.setInt(2, select.getTagId(tag));
        preparedStatement.executeUpdate();
      }
		} catch(SQLException e){
			e.printStackTrace();
		}
  }
}
