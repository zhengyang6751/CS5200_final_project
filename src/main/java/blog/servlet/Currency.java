package blog.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.dal.CurrencyDao;
import blog.dal.CharacterDao;
import blog.model.Character;

@WebServlet("/currency")
public class Currency extends HttpServlet {
    private CurrencyDao currencyDao;
    private CharacterDao characterDao;

    @Override
    public void init() throws ServletException {
        currencyDao = CurrencyDao.getInstance();
        characterDao = CharacterDao.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> messages = new HashMap<>();
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        List<blog.model.Currency> currencies = new ArrayList<>();

        if (firstName == null || firstName.trim().isEmpty() || lastName == null || lastName.trim().isEmpty()) {
            messages.put("error", "First Name or Last Name is invalid");
        } else {
            try {
                Character character = characterDao.getCharacterByFirstNameAndLastName(firstName, lastName);
                if (character != null) {
                    System.out.println("Character found: " + character.getFirstName() + " " + character.getLastName());
                    currencies = currencyDao.getCurrenciesByCharacterName(character.getFirstName() + " " + character.getLastName());
                    System.out.println("Currencies found: " + currencies.size());
                } else {
                    messages.put("error", "Character not found with the given First Name and Last Name");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                messages.put("error", "SQL error: " + e.getMessage());
            }
        }

        req.setAttribute("currencies", currencies);
        req.setAttribute("messages", messages);
        req.getRequestDispatcher("/Currency.jsp").forward(req, resp);
    }
}