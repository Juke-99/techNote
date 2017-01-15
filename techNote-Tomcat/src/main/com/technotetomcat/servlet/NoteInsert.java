package com.technotetomcat.servlet;

import com.technotetomcat.dml.Insert;
import com.technotetomcat.dml.Select;
import com.technotetomcat.iterator.Todo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/InsertData")
public class NoteInsert extends HttpServlet {

  private static final long serialVersionUID=1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      request.setCharacterEncoding("UTF-8");

      String title = request.getParameter("title");
      String tags = request.getParameter("tags");
      String description = request.getParameter("description");
      ArrayList<Todo> todoList = new ArrayList<Todo>();

      try {
        Insert insert = new Insert();
        Select select = new Select();

        insert.tagInsert(tags);
        insert.todoInsert(title, tags, description);
        insert.tagtodoInsert(title, tags);
        todoList = select.getTodoList();

        request.setAttribute("todo", todoList);
        request.getRequestDispatcher("./index.jsp").forward(request, response);
      } catch(ClassNotFoundException cnfe) {
        cnfe.printStackTrace();
      }
  }
}
