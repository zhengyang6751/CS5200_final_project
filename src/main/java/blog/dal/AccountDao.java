package blog.dal;
import blog.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 * Data access object (DAO) class to interact with the underlying Administrators table in your
 * MySQL instance. This is used to store {@link Administrators} into your MySQL instance and 
 * retrieve {@link Administrators} from MySQL instance.
 */
public class AccountDao{
	// Single pattern: instantiation is limited to one object.
	protected ConnectionManager connectionManager;
	private static AccountDao instance = null;
	protected AccountDao() {
		connectionManager = new ConnectionManager();
	}
	public static AccountDao getInstance() {
		if(instance == null) {
			instance = new AccountDao();
		}
		return instance;
	}
	
	public Account create(Account account) throws SQLException {

		String insertAdministrator = "INSERT INTO Account(name,emailAddress) VALUES(?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		ResultSet resultKey = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertAdministrator,
					Statement.RETURN_GENERATED_KEYS);
			insertStmt.setString(1, account.getName());
			insertStmt.setString(2, account.getEmailAddress());
			insertStmt.executeUpdate();
			resultKey = insertStmt.getGeneratedKeys();
			int postId = -1;
			if(resultKey.next()) {
				postId = resultKey.getInt(1);
			} else {
				throw new SQLException("Unable to retrieve auto-generated key.");
			}
			account.setAccountId(postId);
			return account;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(insertStmt != null) {
				insertStmt.close();
			}
		}
	}

	/**
	 * Update the LastName of the Administrators instance.
	 * This runs a UPDATE statement.
	 */
	public Account updateName(Account account, String newName) throws SQLException {
		String updateAccount = "UPDATE Account SET name=? WHERE accountId=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateAccount);
			updateStmt.setString(1, newName);
			updateStmt.setInt(2, account.getAccountId());
			updateStmt.executeUpdate();
			
			// Update the person param before returning to the caller.
			account.setName(newName);
			return account;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(updateStmt != null) {
				updateStmt.close();
			}
		}
	}
	public Account updateEmailAddress(Account account, String newEmail) throws SQLException {
		String updateAccount = "UPDATE Account SET emailAddress=? WHERE accountId=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateAccount);
			updateStmt.setString(1, newEmail);
			updateStmt.setInt(2, account.getAccountId());
			updateStmt.executeUpdate();
			
			// Update the person param before returning to the caller.
			account.setEmailAddress(newEmail);
			return account;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(updateStmt != null) {
				updateStmt.close();
			}
		}
	}
	/**
	 * Delete the Administrators instance.
	 * This runs a DELETE statement.
	 */
	public Account delete(Account account) throws SQLException {
		String deleteAccount = "DELETE FROM Account WHERE accountId=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteAccount);
			deleteStmt.setInt(1, account.getAccountId());
			deleteStmt.executeUpdate();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(deleteStmt != null) {
				deleteStmt.close();
			}
		}
	}
	
	public Account getAccountById(int userId) throws SQLException {
		// To build an Administrator object, we need the Persons record, too.
		String selectAccount =
			"SELECT * " +
			"FROM Account " +
			"WHERE accountId=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectAccount);
			selectStmt.setInt(1, userId);
			results = selectStmt.executeQuery();
			if(results.next()) {
				int id = results.getInt("accountId");
				String name = results.getString("name");
				String email = results.getString("emailAddress");
				Account account = new Account(id, name, email);
				return account;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
			}
		}
		return null;
	}

	public List<Account> getAccountByName(String userName) throws SQLException {
		List<Account> accounts = new ArrayList<Account>();
		String selectAccount =
			"SELECT * " +
			"FROM Account " +
			"WHERE name=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectAccount);
			selectStmt.setString(1, userName);
			results = selectStmt.executeQuery();
			while(results.next()) {
				int id = results.getInt("accountId");
				String name = results.getString("name");
				String email = results.getString("emailAddress");
				Account account = new Account(id, name, email);
				accounts.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
	}
		}
		return accounts;
	}
}
