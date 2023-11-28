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


@WebServlet("/accountupdate")
public class AccountUpdate extends HttpServlet {
	
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

        // Retrieve user and validate.
        int id = Integer.valueOf(req.getParameter("accountId"));
        if (id <= 0) {
            messages.put("success", "Please enter a valid AccountId.");
        } else {
        	try {
        		Account account = accountDao.getAccountById(id);
        		if(account == null) {
        			messages.put("success", "AccountId does not exist.");
        		}
        		req.setAttribute("account", account);
        	} catch (SQLException e) {
                e.printStackTrace();
                throw new IOException(e);
            }
        
        req.getRequestDispatcher("/AccountUpdate.jsp").forward(req, resp);
	}
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        int id = Integer.valueOf(req.getParameter("accountId"));
        if (id <= 0) {
            messages.put("success", "Please enter a valid AccountId.");
        } else {
        	try {
        		Account account = accountDao.getAccountById(id);
        		if(account == null) {
        			messages.put("success", "AccountId does not exist. No update to perform.");
        		} else {
        			String newEmail = req.getParameter("newEmail");
                    String newName = req.getParameter("newName");
                    System.out.println(newName);
                    if (newName == null || newName.trim().isEmpty()) {
            	            messages.put("success", "Please enter a valid UserName.");      
                    } else {        
                            account = accountDao.updateName(account, newName);
                            messages.put("success", "Successfully updated " + id);
                    }
        			if (newEmail == null || newEmail.trim().isEmpty()) {
        	            messages.put("success", "Please enter a valid Email.");
        	        } else {
        	        	account = accountDao.updateEmailAddress(account, newEmail);
        	        	messages.put("success", "Successfully updated " + id);
        	        }
        		}
        		req.setAttribute("account", account);
        	} catch (SQLException e) {
                e.printStackTrace();
                throw new IOException(e);
            }
        }
        req.getRequestDispatcher("/AccountUpdate.jsp").forward(req, resp);

    }
}
