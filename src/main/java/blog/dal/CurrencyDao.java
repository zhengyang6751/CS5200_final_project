package blog.dal;

import blog.model.*;
import blog.model.Character;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CurrencyDao {
	protected ConnectionManager connectionManager;

	private static CurrencyDao instance = null;
	protected CurrencyDao() {
		connectionManager = new ConnectionManager();
	}
	public static CurrencyDao getInstance() {
		if(instance == null) {
			instance = new CurrencyDao();
		}
		return instance;
	}
	public Currency create(Currency currency) throws SQLException {
		String query = "INSERT INTO Currency (currencyName, weeklyCaps, totalCaps) " +
				"VALUES (?, ?, ?)";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = connectionManager.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, currency.getCurrencyName());
			statement.setInt(2, currency.getWeeklyCaps());
			statement.setInt(3, currency.getTotalCaps());
			statement.executeUpdate();
			return currency;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(statement != null) {
				statement.close();
			}
		}
	}

	public Currency getCurrencyByName(String name){
		String query = "SELECT * FROM Currency WHERE currencyName = ?;";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, name);
			results = statement.executeQuery();
			if(results.next()) {
				String currencyName = results.getString("currencyName");
				int weeklyCaps = results.getInt("weeklyCaps");
				int totalCaps = results.getInt("totalCaps");
				Currency currency = new Currency(currencyName, weeklyCaps, totalCaps);
				return currency;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Currency updateWeeklyCaps(Currency currency, int newWeeklyCaps) throws SQLException {
		String query = "UPDATE Currency SET weeklyCaps=? WHERE currencyName=?;";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = connectionManager.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, newWeeklyCaps);
			statement.setString(2, currency.getCurrencyName());
			statement.executeUpdate();
			currency.setWeeklyCaps(newWeeklyCaps);
			return currency;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(statement != null) {
				statement.close();
			}
		}
	}

	public Currency updateTotalCaps(Currency currency, int newTotalCaps) throws SQLException {
		String query = "UPDATE Currency SET totalCaps=? WHERE currencyName=?;";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = connectionManager.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, newTotalCaps);
			statement.setString(2, currency.getCurrencyName());
			statement.executeUpdate();
			currency.setTotalCaps(newTotalCaps);
			return currency;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(statement != null) {
				statement.close();
			}
		}
	}

	public Currency delete(Currency currency) throws SQLException {
		String query = "DELETE FROM Currency WHERE currencyName=?;";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = connectionManager.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, currency.getCurrencyName());
			statement.executeUpdate();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(statement != null) {
				statement.close();
			}
			}
		}
		
	public List<Currency> getCurrenciesByFullName(Character character) throws SQLException {
        String query = "SELECT * FROM CharacterCurrency A JOIN Currency B ON A.currencyName = B.currencyName WHERE firstName = ? AND lastName = ?;";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        List<Currency> currencies = new ArrayList<>();

        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, character.getFirstName());
            statement.setString(2, character.getLastName());
            
            results = statement.executeQuery();

            while (results.next()) {            	
                String currencyName = results.getString("currencyName");
                int weeklyCaps = results.getInt("weeklyCaps");
                int totalCaps = results.getInt("totalCaps");
                Currency currency = new Currency(currencyName, weeklyCaps, totalCaps);
                currencies.add(currency);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        System.out.println(currencies.size());
        return currencies;
    }
	
}
