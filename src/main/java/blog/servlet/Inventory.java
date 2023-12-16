package blog.servlet;
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

import blog.dal.*;
import blog.model.Character;
import blog.model.InventoryItem;
import blog.model.Account;

@WebServlet("/inventory")
public class Inventory extends HttpServlet {
	protected InventoryItemDao inventoryItemDao;
	protected CharacterDao characterDao;
	
	@Override
	public void init()throws ServletException {
		inventoryItemDao = InventoryItemDao.getInstance();
		characterDao = CharacterDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Map<String, String> messages = new HashMap<String, String>();
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		
		List<InventoryItem> inventorys = new ArrayList<InventoryItem>();
		
		if (firstName == null || firstName.trim().isEmpty() || lastName == null || lastName.trim().isEmpty()) {
			messages.put("success", "FirstName or LastName is invald");
		} else {
			try {
				Character character = characterDao.getCharacterByFirstNameAndLastName(firstName, lastName);
				inventorys = inventoryItemDao.getItemByName(character);
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}			
		}
		
		req.setAttribute("inventorys", inventorys);
		req.getRequestDispatcher("/Inventory.jsp").forward(req, resp);
	}
	
}