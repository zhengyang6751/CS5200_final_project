package blog.servlet;

import blog.dal.*;
import blog.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/accountdelete")
public class AccountDelete extends HttpServlet {
	
	protected AccountDao accountDao;
	
	@Override
	public void init() throws ServletException {
		accountDao = AccountDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        // Provide a title and render the JSP.
        messages.put("title", "Delete BlogUser");        
        req.getRequestDispatcher("/AccountDelete.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.
        int id = Integer.valueOf(req.getParameter("accountId"));
        System.out.println("id : " + id);
        if (id <= 0) {
			messages.put("title", "Invalid AccountId");
			messages.put("disableSubmit", "true");
        }
	        try {
	        	// Exercise: parse the input for StatusLevel.
	        	Account account = accountDao.getAccountById(id);
	        	account = accountDao.delete(account);
	        	// Update the message.
		        if (account == null) {
		            messages.put("title", "Successfully deleted " + id);
		            messages.put("disableSubmit", "true");
		        } else {
		        	messages.put("title", "Failed to delete " + id);
		        	messages.put("disableSubmit", "false");
		        }
	        } catch (SQLException e) {
        }
        
        req.getRequestDispatcher("/AccountDelete.jsp").forward(req, resp);
		}
}
