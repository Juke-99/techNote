package com.technotetomcat.servlet;

import com.technotetomcat.dml.Select;
import com.technotetomcat.iterator.Todo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Search")
public class Search extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      request.setCharacterEncoding("UTF-8");

      String searchWord = request.getParameter("search");
      Select select = new Select();
      ArrayList<Todo> todoList = new ArrayList<Todo>();

      if(searchWord.startsWith("#")) {
        searchWord.replaceAll("#", "");
        todoList = select.getTagOR(searchWord);
      } else if(searchWord.startsWith("&")) {
        searchWord.replaceAll("&", "");
        todoList = select.getTagAND(searchWord);
      } else {
        todoList = select.getSearchTodo(searchWord);
      }

      request.setAttribute("todo", todoList);
      request.getRequestDispatcher("./index.jsp").forward(request, response);
  }
}
