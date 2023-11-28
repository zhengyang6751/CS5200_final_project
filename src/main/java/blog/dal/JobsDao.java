package blog.dal;

import blog.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class JobsDao {
	protected ConnectionManager connectionManager;

	private static JobsDao instance = null;
	protected JobsDao() {
		connectionManager = new ConnectionManager();
	}
	public static JobsDao getInstance() {
		if(instance == null) {
			instance = new JobsDao();
		}
		return instance;
	}

	public Jobs create(Jobs job) throws SQLException {
		String query = "INSERT INTO Job (jobName, category) " +
				"VALUES (?, ?)";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = connectionManager.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, job.getJobName());
			statement.setString(2, job.getCategory());
			statement.executeUpdate();
			return job;
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

	public Jobs getJobByName(String name){
		String query = "SELECT * FROM Job WHERE jobName = ?;";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, name);
			results = statement.executeQuery();
			if(results.next()) {
				String jobName = results.getString("jobName");
				String category = results.getString("category");
				Jobs job = new Jobs(jobName, category);
				return job;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Jobs> getJobsByCategory(String category) throws SQLException {
		List<Jobs> list = new ArrayList<Jobs>();
		String selectJobs =
			"SELECT * " +
			"FROM Job " +
			"WHERE category=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectJobs);
			selectStmt.setString(1, category);
			results = selectStmt.executeQuery();
			while(results.next()) {
				String jobName = results.getString("jobName");
				String category1 = results.getString("category");
				Jobs job = new Jobs(jobName, category1);
				list.add(job);
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

	public Jobs updateCategory(Jobs job, String newCategory) throws SQLException {
		String query = "UPDATE Job SET category=? WHERE jobName=?;";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = connectionManager.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, newCategory);
			statement.setString(2, job.getJobName());
			statement.executeUpdate();
			job.setCategory(newCategory);
			return job;
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
	public Jobs delete(Jobs job) throws SQLException {
		String deleteJob = "DELETE FROM Job WHERE jobName=?;";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = connectionManager.getConnection();
			statement = connection.prepareStatement(deleteJob);
			statement.setString(1, job.getJobName());
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
}
