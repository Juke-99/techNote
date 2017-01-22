package com.technotejarsey;

import com.technotejarsey.dml.Insert;
import com.technotejarsey.dml.Select;
import com.technotejarsey.iterator.Todo;

import java.util.ArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.mvc.Viewable;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("get")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    @FormParam("title")
    private String title;

    @FormParam("tags")
    private String tags;

    @FormParam("description")
    private String description;

    @POST
    @Path("post")
    @Produces(MediaType.TEXT_PLAIN)
    public Viewable getFormPramsAndView() {

      ArrayList<Todo> todoList = new ArrayList<Todo>();

      try {
        Insert insert = new Insert();
        Select select = new Select();

        insert.tagInsert(tags);
        insert.todoInsert(title, tags, description);
        insert.tagtodoInsert(title, tags);
        todoList = select.getTodoList();

        //request.setAttribute("todo", todoList);
        //request.getRequestDispatcher("./index.jsp").forward(request, response);
      } catch(ClassNotFoundException cnfe) {
        cnfe.printStackTrace();
      }

      return new Viewable("index", todoList);
    }
}
