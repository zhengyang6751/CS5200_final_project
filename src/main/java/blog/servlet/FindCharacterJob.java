package blog.servlet;

import blog.dal.*;
import blog.model.*;
import blog.model.CharacterJobs;
import blog.model.Character;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * FindUsers is the primary entry point into the application.
 * 
 * Note the logic for doGet() and doPost() are almost identical. However, there is a difference:
 * doGet() handles the http GET request. This method is called when you put in the /findusers
 * URL in the browser.
 * doPost() handles the http POST request. This method is called after you click the submit button.
 * 
 * To run:
 * 1. Run the SQL script to recreate your database schema: http://goo.gl/86a11H.
 * 2. Insert test data. You can do this by running blog.tools.Inserter (right click,
 *    Run As > JavaApplication.
 *    Notice that this is similar to Runner.java in our JDBC example.
 * 3. Run the Tomcat server at localhost.
 * 4. Point your browser to http://localhost:8080/BlogApplication/findusers.
 */
@WebServlet("/jobs")
public class FindCharacterJob extends HttpServlet {
	
	protected CharacterJobsDao characterJobsDao;
	protected CharacterDao characterDao;
	
	@Override
	public void init() throws ServletException {
		characterJobsDao = CharacterJobsDao.getInstance();
		characterDao = CharacterDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);
		List<CharacterJobs> characterJobs = new ArrayList<CharacterJobs>();
		String accountId = req.getParameter("accountId");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");;
		if (firstName == null || lastName == null || firstName.trim().isEmpty() || lastName.trim().isEmpty()) {
			messages.put("success", "Please enter a valid character.");
		} else {
			try {
				Character character = characterDao.getCharacterByFirstNameAndLastName(firstName, lastName);
				characterJobs = characterJobsDao.getCharacterJobsByCharacter(character);
				messages.put("success", "Displaying results for " + character.getFirstName() + character.getLastName());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
		}
		req.setAttribute("characterJobs", characterJobs);
		req.getRequestDispatcher("/FindCharacterJob.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);
		List<CharacterJobs> characterJobs = new ArrayList<CharacterJobs>();
		String accountId = req.getParameter("accountId");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");;
		if (firstName == null || lastName == null || firstName.trim().isEmpty() || lastName.trim().isEmpty()) {
			messages.put("success", "Please enter a valid character.");
		} else {
			try {
				Character character = characterDao.getCharacterByFirstNameAndLastName(firstName, lastName);
				characterJobs = characterJobsDao.getCharacterJobsByCharacter(character);
				messages.put("success", "Displaying results for " + character.getFirstName() + character.getLastName());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
		}
		req.setAttribute("characterJobs", characterJobs);
		req.getRequestDispatcher("/FindCharacterJob.jsp").forward(req, resp);
    }
}