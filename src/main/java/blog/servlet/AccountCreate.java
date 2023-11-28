package blog.servlet;

import blog.dal.*;
import blog.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/accountcreate")
public class AccountCreate extends HttpServlet {
	
	protected AccountDao accountDao;
	
	@Override
	public void init() throws ServletException {
		accountDao = accountDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        //Just render the JSP.   
        req.getRequestDispatcher("/AccountCreate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.
        String name = req.getParameter("name");
        String email = req.getParameter("emailAddress");
        if (name == null || name.trim().isEmpty() || email == null || email.trim().isEmpty()) {
            messages.put("success", "Invalid UserName or Email");
        } else {
	        try {
	        	// Exercise: parse the input for StatusLevel.
	        	Account account = new Account(name, email);
	        	account = accountDao.create(account);
	        	messages.put("success", "Successfully created " + name);
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/AccountCreate.jsp").forward(req, resp);
    }
}
