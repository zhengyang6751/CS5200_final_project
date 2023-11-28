package blog.dal;
import blog.model.ConsumableItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ConsumableItemDao {
    protected ConnectionManager connectionManager;

	private static ConsumableItemDao instance = null;
	protected ConsumableItemDao() {
		connectionManager = new ConnectionManager();
	}
	public static ConsumableItemDao getInstance() {
		if(instance == null) {
			instance = new ConsumableItemDao();
		}
		return instance;
	}

    public ConsumableItem create(ConsumableItem consumableItem) throws SQLException {
        String query = "INSERT INTO ConsumableItem (itemName, itemLevel, description, strengthBonusMax, dexterityBonusMax, vitalityBonusMax, intelligenceBonusMax, mindBonusMax) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, consumableItem.getItemName());
            statement.setInt(2, consumableItem.getItemLevel());
            statement.setString(3, consumableItem.getDescription());
            statement.setInt(4, consumableItem.getStrengthBonusMax());
            statement.setInt(5, consumableItem.getDexterityBonusMax());
            statement.setInt(6, consumableItem.getVitalityBonusMax());
            statement.setInt(7, consumableItem.getIntelligenceBonusMax());
            statement.setInt(8, consumableItem.getMindBonusMax());
            statement.executeUpdate();
            return consumableItem;
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

    public ConsumableItem getConsumableItemByName(String itemName) throws SQLException{
        String query = "SELECT * FROM ConsumableItem WHERE itemName = ?;";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, itemName);
            results = statement.executeQuery();
            if(results.next()) {
                String resultItemName = results.getString("itemName");
                int itemLevel = results.getInt("itemLevel");
                String description = results.getString("description");
                int strengthBonusMax = results.getInt("strengthBonusMax");
                int dexterityBonusMax = results.getInt("dexterityBonusMax");
                int vitalityBonusMax = results.getInt("vitalityBonusMax");
                int intelligenceBonusMax = results.getInt("intelligenceBonusMax");
                int mindBonusMax = results.getInt("mindBonusMax");
                ConsumableItem consumableItem = new ConsumableItem(resultItemName, itemLevel, description, strengthBonusMax, dexterityBonusMax, vitalityBonusMax, intelligenceBonusMax, mindBonusMax);
                return consumableItem;
            }
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
        return null;
    }

    public ConsumableItem delete(ConsumableItem consumableItem) throws SQLException {
        String query = "DELETE FROM ConsumableItem WHERE itemName=?;";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, consumableItem.getItemName());
            statement.executeUpdate();
            return consumableItem;
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

