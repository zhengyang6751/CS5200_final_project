package blog.servlet;

import blog.dal.CurrencyDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/currency")
public class Currency extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CurrencyDao currencyDao;

    public void init() throws ServletException {
        currencyDao = CurrencyDao.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<blog.model.Currency> currencyList = currencyDao.getAllCurrencies();
            request.setAttribute("currencyList", currencyList);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Error retrieving currency list");
        }

        request.getRequestDispatcher("/Currency.jsp").forward(request, response);
    }
}

