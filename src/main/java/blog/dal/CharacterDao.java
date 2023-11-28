package blog.dal;

import blog.model.*;
import blog.model.Character;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CharacterDao {
	protected ConnectionManager connectionManager;

	private static CharacterDao instance = null;
	protected CharacterDao() {
		connectionManager = new ConnectionManager();
	}
	public static CharacterDao getInstance() {
		if(instance == null) {
			instance = new CharacterDao();
		}
		return instance;
	}
	public Character create(Account account, Character character) throws SQLException {
		String query = "INSERT INTO CharacterTable (accountId, firstName, lastName, strength, dexterity, vitality, intelligence) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = connectionManager.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, character.getAccountId());
			statement.setString(2, character.getFirstName());
			statement.setString(3, character.getLastName());
			statement.setInt(4, character.getStrength());
			statement.setInt(5, character.getDexterity());
			statement.setInt(6, character.getVitality());
			statement.setInt(7, character.getIntelligence());
			statement.executeUpdate();
			character.setAccountId(account.getAccountId());
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
	/**
	 * Delete the Character instance.
	 * This runs a DELETE statement.
	 */
	public Character delete(Character character) throws SQLException {
		String deleteBlogComment = "DELETE FROM CharacterTable WHERE firstName=? AND lastName=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteBlogComment);
			deleteStmt.setString(1, character.getFirstName());
			deleteStmt.setString(2, character.getLastName());
			deleteStmt.executeUpdate();
			// Return null so the caller can no longer operate on the Character instance.
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

	/**
	 * Get the Character record by fetching it from your MySQL instance.
	 * This runs a SELECT statement and returns a single Character instance.
	 * Note that we use BlogPostsDao and BlogUsersDao to retrieve the referenced
	 * BlogPosts and BlogUsers instances.
	 * One alternative (possibly more efficient) is using a single SELECT statement
	 * to join the Character, BlogPosts, BlogUsers tables and then build each object.
	 */
	

	/**
	 * Get the all the Character for a user.
	 */
	public List<Character> getCharacterById(int Id) throws SQLException {
		List<Character> list = new ArrayList<Character>();
		String selectCharacter =
			"SELECT * " +
			"FROM CharacterTable " +
			"WHERE accountId=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectCharacter);
			selectStmt.setInt(1, Id);
			results = selectStmt.executeQuery();
			while(results.next()) {
				int strength = results.getInt("strength");
				int dexterity = results.getInt("dexterity");
				int vitality = results.getInt("vitality");
				int intelligence = results.getInt("intelligence");
				String firstName = results.getString("firstName");
				String lastName = results.getString("lastName");
				Character cha = new Character(Id, firstName, lastName, strength, dexterity, vitality, intelligence);
				list.add(cha);
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
		return list;
	}
	
	/**
	 * Get the all the Character for a post.
	 */
	public Character getCharacterByFirstNameAndLastName(String firstName, String lastName) throws SQLException {
		String selectCharacter =
			"SELECT * " +
			"FROM CharacterTable " +
			"WHERE firstName=? AND lastName=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectCharacter);
			selectStmt.setString(1, firstName);
			selectStmt.setString(2, lastName);
			results = selectStmt.executeQuery();
			if(results.next()) {
				int id = results.getInt("accountId");
				int strength = results.getInt("strength");
				int dexterity = results.getInt("dexterity");
				int vitality = results.getInt("vitality");
				int intelligence = results.getInt("intelligence");
				Character cha = new Character(id, firstName, lastName, strength, dexterity, vitality, intelligence);
				return cha;
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

	public Character updateStrength(Character character, int newStrength) throws SQLException {
		String updateCharacter = "UPDATE CharacterTable SET strength=? WHERE firstName=? AND lastName=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateCharacter);
			updateStmt.setInt(1, newStrength);
			updateStmt.setString(2, character.getFirstName());
			updateStmt.setString(3, character.getLastName());
			updateStmt.executeUpdate();
			character.setStrength(newStrength);
			return character;
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

	public Character updateDexterity(Character character, int newDexterity) throws SQLException {
		String updateCharacter = "UPDATE CharacterTable SET dexterity=? WHERE firstName=? AND lastName=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateCharacter);
			updateStmt.setInt(1, newDexterity);
			updateStmt.setString(2, character.getFirstName());
			updateStmt.setString(3, character.getLastName());
			updateStmt.executeUpdate();
			character.setDexterity(newDexterity);
			return character;
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

	public Character updateVitality(Character character, int newVitality) throws SQLException {
		String updateCharacter = "UPDATE CharacterTable SET vitality=? WHERE firstName=? AND lastName=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateCharacter);
			updateStmt.setInt(1, newVitality);
			updateStmt.setString(2, character.getFirstName());
			updateStmt.setString(3, character.getLastName());
			updateStmt.executeUpdate();
			character.setVitality(newVitality);
			return character;
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

	public Character updateIntelligence(Character character, int newIntelligence) throws SQLException {
		String updateCharacter = "UPDATE CharacterTable SET intelligence=? WHERE firstName=? AND lastName=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateCharacter);
			updateStmt.setInt(1, newIntelligence);
			updateStmt.setString(2, character.getFirstName());
			updateStmt.setString(3, character.getLastName());
			updateStmt.executeUpdate();
			character.setIntelligence(newIntelligence);
			return character;
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

}
