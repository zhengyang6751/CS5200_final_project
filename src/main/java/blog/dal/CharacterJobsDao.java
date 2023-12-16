package blog.dal;

import blog.model.*;
import blog.model.Character;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Data access object (DAO) class to interact with the underlying BlogUsers table in your
 * MySQL instance. This is used to store {@link BlogUsers} into your MySQL instance and 
 * retrieve {@link BlogUsers} from MySQL instance.
 */
public class CharacterJobsDao{
	// Single pattern: instantiation is limited to one object.
	protected ConnectionManager connectionManager;
	private static CharacterJobsDao instance = null;
	protected CharacterJobsDao() {
		connectionManager = new ConnectionManager();
	}
	public static CharacterJobsDao getInstance() {
		if(instance == null) {
			instance = new CharacterJobsDao();
		}
		return instance;
	}

	public Character create(Jobs jobs, Character character) throws SQLException{
		String query = "INSERT INTO CharacterJobs (firstName, lastName, jobName, currentExp, jobLevel, requiredExp, isCurrentJob) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?)";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = connectionManager.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, character.getFirstName());
			statement.setString(2, character.getLastName());
			statement.setString(3, jobs.getJobName());
			statement.setInt(4, 0);
			statement.setInt(5, 1);
			statement.setInt(6, 100);
			statement.setBoolean(7, true);
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

	public List<CharacterJobs> getCharacterJobsByCharacter(Character character) throws SQLException{
		String query = "SELECT * FROM CharacterJobs WHERE firstName = ? AND lastName = ?;";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		List<CharacterJobs> characterJobs = new ArrayList<CharacterJobs>();
		try {
			connection = connectionManager.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, character.getFirstName());
			statement.setString(2, character.getLastName());
			results = statement.executeQuery();
			while(results.next()) {
				String firstName = results.getString("firstName");
				String lastName = results.getString("lastName");
				String jobName = results.getString("jobName");
				int currentExp = results.getInt("currentExp");
				int jobLevel = results.getInt("jobLevel");
				int requiredExp = results.getInt("requiredExp");
				boolean isCurrentJob = results.getBoolean("isCurrentJob");
				CharacterJobs characterJob = new CharacterJobs(firstName, lastName, jobName, currentExp, jobLevel, requiredExp, isCurrentJob);
				characterJobs.add(characterJob);
			}
			return characterJobs;
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
			if(results != null) {
				results.close();
			}
		}
	}
	public int getCurrentExp(Character character, Jobs job) throws SQLException{
		String query = "SELECT currentExp FROM CharacterJobs WHERE firstName = ? AND lastName = ? AND jobName = ?;";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		int currentExp = 0;
		try {
			connection = connectionManager.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, character.getFirstName());
			statement.setString(2, character.getLastName());
			statement.setString(3, job.getJobName());
			results = statement.executeQuery();
			if(results.next()) {
				currentExp = results.getInt("currentExp");
			}
			return currentExp;
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
			if(results != null) {
				results.close();
			}
		}
	}
	public CharacterJobs getCharacterJob(Character character, Jobs job){
		String query = "SELECT * FROM CharacterJobs WHERE firstName = ? AND lastName = ? AND jobName = ?;";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, character.getFirstName());
			statement.setString(2, character.getLastName());
			statement.setString(3, job.getJobName());
			results = statement.executeQuery();
			if(results.next()) {
				String firstName = results.getString("firstName");
				String lastName = results.getString("lastName");
				String jobName = results.getString("jobName");
				int currentExp = results.getInt("currentExp");
				int jobLevel = results.getInt("jobLevel");
				int requiredExp = results.getInt("requiredExp");
				boolean isCurrentJob = results.getBoolean("isCurrentJob");
				CharacterJobs characterJob = new CharacterJobs(firstName, lastName, jobName, currentExp, jobLevel, requiredExp, isCurrentJob);
				return characterJob;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public CharacterJobs updateExpAndJobLevel(Character character, Jobs job, int exp) throws SQLException{
		String query = "UPDATE CharacterJobs SET currentExp=?, jobLevel=? WHERE firstName=? AND lastName=? AND jobName=?;";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = connectionManager.getConnection();
			statement = connection.prepareStatement(query);
			int currentExp = exp + getCurrentExp(character, job);
			int jobLevel = 1;
			int requiredExp = 100;
			while(currentExp >= requiredExp) {
				currentExp -= requiredExp;
				jobLevel++;
				requiredExp = (int) (requiredExp * 1.5);
			}
			statement.setInt(1, currentExp);
			statement.setInt(2, jobLevel);
			statement.setString(3, character.getFirstName());
			statement.setString(4, character.getLastName());
			statement.setString(5, job.getJobName());
			statement.executeUpdate();
			CharacterJobs characterJob = new CharacterJobs(character.getFirstName(), character.getLastName(), job.getJobName(), currentExp, jobLevel, requiredExp, true);
			return characterJob;
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
}