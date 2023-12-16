package blog.dal;

import blog.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import blog.model.Character;

/**
 * Data access object (DAO) class to interact with the underlying Persons table in your MySQL
 * instance. This is used to store {@link Persons} into your MySQL instance and retrieve 
 * {@link Persons} from MySQL instance.
 */
public class CharacterCurrencyDao {
	protected ConnectionManager connectionManager;
	
	// Single pattern: instantiation is limited to one object.
	private static CharacterCurrencyDao instance = null;
	protected CharacterCurrencyDao() {
		connectionManager = new ConnectionManager();
	}
	public static CharacterCurrencyDao getInstance() {
		if(instance == null) {
			instance = new CharacterCurrencyDao();
		}
		return instance;
	}

	public Character create(Currency currency, Character character, int weekAmount, int totalAmount) throws SQLException {
		String query = "INSERT INTO CharacterCurrency (firstName, lastName, currencyName, amountTotal, amountWeek) " +
				"VALUES (?, ?, ?, ?, ?)";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = connectionManager.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, character.getFirstName());
			statement.setString(2, character.getLastName());
			statement.setString(3, currency.getCurrencyName());
			statement.setInt(4, totalAmount);
			statement.setInt(5, weekAmount);
			statement.executeUpdate();
			return character;
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

	public Character updateTotal(Character character, Currency currency, int newTotal) throws SQLException {
		String query = "UPDATE CharacterCurrency SET amountTotal=? WHERE firstName=? AND lastName=? AND currencyName=?";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = connectionManager.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, newTotal);
			statement.setString(2, character.getFirstName());
			statement.setString(3, character.getLastName());
			statement.setString(4, currency.getCurrencyName());
			statement.executeUpdate();
			return character;
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

	public Character updateWeek(Character character, Currency currency, int newWeek) throws SQLException {
		String query = "UPDATE CharacterCurrency SET amountWeek=? WHERE firstName=? AND lastName=? AND currencyName=?";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = connectionManager.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, newWeek);
			statement.setString(2, character.getFirstName());
			statement.setString(3, character.getLastName());
			statement.setString(4, currency.getCurrencyName());
			statement.executeUpdate();
			return character;
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
		public Character delete(Character character, Currency currency) throws SQLException {
			String query = "DELETE FROM CharacterCurrency WHERE firstName=? AND lastName=? AND currencyName=?";
			Connection connection = null;
			PreparedStatement statement = null;
			try {
				connection = connectionManager.getConnection();
				statement = connection.prepareStatement(query);
				statement.setString(1, character.getFirstName());
				statement.setString(2, character.getLastName());
				statement.setString(3, currency.getCurrencyName());
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

		public List<CharacterCurrency> getCurrencyByCharacter(Character cha) throws SQLException {
			String query = "SELECT * FROM CharacterCurrency WHERE firstName=? AND lastName=?";
			List<CharacterCurrency> characterCurrencies = new ArrayList<CharacterCurrency>();
			Connection connection = null;
			PreparedStatement statement = null;
			ResultSet results = null;
			try {
				connection = connectionManager.getConnection();
				statement = connection.prepareStatement(query);
				statement.setString(1, cha.getFirstName());
				statement.setString(2, cha.getLastName());
				results = statement.executeQuery();
				while(results.next()) {
					String firstName = results.getString("firstName");
					String lastName = results.getString("lastName");
					String currencyName = results.getString("currencyName");
					int amountTotal = results.getInt("amountTotal");
					int amountWeek = results.getInt("amountWeek");
					CharacterCurrency characterCurrency = new CharacterCurrency(firstName, lastName, currencyName, amountTotal, amountWeek);
					characterCurrencies.add(characterCurrency);
				}
				return characterCurrencies;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(statement != null) {
					try {
						statement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(results != null) {
					try {
						results.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return null;
		}
}
