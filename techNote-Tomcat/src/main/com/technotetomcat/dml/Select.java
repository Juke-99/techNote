package com.technotetomcat.dml;

import com.technotetomcat.database.MySQLConnection;
import com.technotetomcat.iterator.Todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Select {
  MySQLConnection con = new MySQLConnection();

  public boolean isTag(String tag) {
    String sql = "SELECT tagname FROM tag";
    String tagName = "";

    try(Connection connection = con.getConnection();) {

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{
				tagName = resultSet.getString("tagname");

        if(tagName.equals(tag)) {
          return true;
        }
			}
		} catch(SQLException e){
			e.printStackTrace();
		}

    return false;
  }

  public int getTagId(String tag) {
    String sql = "SELECT tagID FROM tag WHERE tagname=?";
    int tagID = 0;

    try(Connection connection = con.getConnection();) {

      PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, tag);
  		ResultSet resultSet = preparedStatement.executeQuery();

      while(resultSet.next())
			{
				tagID = resultSet.getInt("tagID");
			}
    } catch(SQLException e){
			e.printStackTrace();
		}

    return tagID;
  }

  public ArrayList<Todo> getTodoList() {
    String sql = "SELECT title,description,timestamp FROM todo ORDER BY timestamp DESC";
    String title, description, timestamp;
    ArrayList<Todo> todoList = new ArrayList<Todo>();

    try(Connection connection = con.getConnection();) {

      PreparedStatement preparedStatement = connection.prepareStatement(sql);
  		ResultSet resultSet = preparedStatement.executeQuery();

      while(resultSet.next())
			{
				title = resultSet.getString("title");
        description = resultSet.getString("description");
        timestamp = resultSet.getString("timestamp");

        todoList.add(new Todo(title, description, timestamp));
			}
    } catch(SQLException e){
			e.printStackTrace();
		}

    return todoList;
  }

  public ArrayList<Todo> getSearchTodo(String searchWord) {
    String sql = "SELECT title,description,timestamp FROM todo WHERE title LIKE ? OR description LIKE ?";
    String title, description, timestamp;
    String[] word = searchWord.split("[ 　]+");
    ArrayList<Todo> todoList = new ArrayList<Todo>();

    try(Connection connection = con.getConnection();) {
      if(word.length > 1) {
        for(int i = 1; i < word.length; i++) {
          if(i == word.length - 1) {
            sql += " OR title LIKE ? OR description LIKE ? ORDER BY timestamp DESC";
          } else {
            sql += " OR title LIKE ? OR description LIKE ?";
          }
				}
      }

      PreparedStatement preparedStatement = connection.prepareStatement(sql);

      for(int i = 0; i < word.length; i =+ 2) {
        preparedStatement.setString(i + 1, "%" + word[i] + "%");
				preparedStatement.setString(i + 2, "%" + word[i] + "%");
			}

  		ResultSet resultSet = preparedStatement.executeQuery();

      while(resultSet.next())
			{
				title = resultSet.getString("title");
        description = resultSet.getString("description");
        timestamp = resultSet.getString("timestamp");

        todoList.add(new Todo(title, description, timestamp));
			}
    } catch(SQLException e){
			e.printStackTrace();
		}

    return todoList;
  }

  public ArrayList<Todo> getTagOR(String searchWord) {
    String sql = "SELECT todo.title,description,timestamp FROM (todo INNER JOIN tagtodo ON todo.title=tagtodo.title) INNER JOIN tag ON tagtodo.tagID=tag.tagID WHERE tagname=?";
    String title, description, timestamp;
    String[] word = searchWord.split("[ 　]+");
    ArrayList<Todo> todoList = new ArrayList<Todo>();

    try(Connection connection = con.getConnection();) {
      if(word.length > 1) {
        for(int i = 1; i < word.length; i++) {

          if(i == word.length - 1) {
            sql += " OR tagname=? ORDER BY timestamp DESC";
          } else {
            sql += " OR tagname=?";
          }
				}
      }

      PreparedStatement preparedStatement = connection.prepareStatement(sql);

      for(int i = 0; i < word.length; i++) {
				preparedStatement.setString(i + 1, word[i]);
			}

  		ResultSet resultSet = preparedStatement.executeQuery();

      while(resultSet.next())
			{
				title = resultSet.getString("title");
        description = resultSet.getString("description");
        timestamp = resultSet.getString("timestamp");

        todoList.add(new Todo(title, description, timestamp));
			}
    } catch(SQLException e){
			e.printStackTrace();
		}

    return todoList;
  }

  public ArrayList<Todo> getTagAND(String searchWord) {
    String sql = "SELECT todo.title,description,timestamp FROM (todo INNER JOIN tagtodo ON todo.title=tagtodo.title) INNER JOIN tag ON tagtodo.tagID=tag.tagID WHERE tagname=?";
    String title, description, timestamp;
    String[] word = searchWord.split("[ 　]+");
    ArrayList<Todo> todoList = new ArrayList<Todo>();

    try(Connection connection = con.getConnection();) {
      if(word.length > 1) {
        for(int i = 1; i < word.length; i++) {
          if(i == word.length - 1) {
            sql += " AND tagname=? ORDER BY timestamp";
          } else {
            sql += " AND tagname=?";
          }
				}
      }

      PreparedStatement preparedStatement = connection.prepareStatement(sql);

      for(int i = 0; i < word.length; i++) {
				preparedStatement.setString(i + 1, word[i]);
			}

  		ResultSet resultSet = preparedStatement.executeQuery();

      while(resultSet.next())
			{
				title = resultSet.getString("title");
        description = resultSet.getString("description");
        timestamp = resultSet.getString("timestamp");

        todoList.add(new Todo(title, description, timestamp));
			}
    } catch(SQLException e){
			e.printStackTrace();
		}

    return todoList;
  }
}
