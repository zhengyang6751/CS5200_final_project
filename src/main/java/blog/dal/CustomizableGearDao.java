package blog.dal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import blog.model.CustomizableGear;
public class CustomizableGearDao {
    protected ConnectionManager connectionManager;

	private static CustomizableGearDao instance = null;
	protected CustomizableGearDao() {
		connectionManager = new ConnectionManager();
	}
	public static CustomizableGearDao getInstance() {
		if(instance == null) {
			instance = new CustomizableGearDao();
		}
		return instance;
	}

    public CustomizableGear create(CustomizableGear customizableGear) throws SQLException{
        String query = "INSERT INTO CustomizableGear (itemName, dyeColor, quality, itemCondition, characterMadeTheItem) " +
                "VALUES (?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultKey = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query,
            PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, customizableGear.getItemName());
            statement.setString(2, customizableGear.getDyeColor());
            statement.setString(3, customizableGear.getQuality());
            statement.setString(4, customizableGear.getItemCondition());
            statement.setString(5, customizableGear.getCharacterMadeTheItem());
            statement.executeUpdate();
            resultKey = statement.getGeneratedKeys();
            int customizableGearId = -1;
            if(resultKey.next()) {
                customizableGearId = resultKey.getInt(1);
            } else {
                throw new SQLException("Unable to retrieve auto-generated key.");
            }
            customizableGear.setCustomizableGearId(customizableGearId);
            return customizableGear;
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
            if(resultKey != null) {
                resultKey.close();
            }
        }
    }

    public CustomizableGear deleteById(int id) throws SQLException{
        String query = "DELETE FROM CustomizableGear WHERE customizableGearId = ?;";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
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
    public CustomizableGear getCustomizableGearById(int id) throws SQLException{
        String query = "SELECT * FROM CustomizableGear WHERE customizableGearId = ?;";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            results = statement.executeQuery();
            if(results.next()) {
                int customizableGearId = results.getInt("customizableGearId");
                String itemName = results.getString("itemName");
                String dyeColor = results.getString("dyeColor");
                String quality = results.getString("quality");
                String itemCondition = results.getString("itemCondition");
                String characterMadeTheItem = results.getString("characterMadeTheItem");
                CustomizableGear customizableGear = new CustomizableGear(itemName, dyeColor, quality, itemCondition, characterMadeTheItem);
                customizableGear.setCustomizableGearId(customizableGearId);
                return customizableGear;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(connection != null) {
                connection.close();
            }
        }
        return null;
    }
    public List<CustomizableGear> getCustomizableGearByCharacter(String name) throws SQLException{
        String query = "SELECT * FROM CustomizableGear WHERE characterMadeTheItem = ?;";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        List<CustomizableGear> customizableGears = new ArrayList<CustomizableGear>();
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, name);
            results = statement.executeQuery();
            while(results.next()) {
                int customizableGearId = results.getInt("customizableGearId");
                String itemName = results.getString("itemName");
                String dyeColor = results.getString("dyeColor");
                String quality = results.getString("quality");
                String itemCondition = results.getString("itemCondition");
                String characterMadeTheItem = results.getString("characterMadeTheItem");
                CustomizableGear customizableGear = new CustomizableGear(itemName, dyeColor, quality, itemCondition, characterMadeTheItem);
                customizableGear.setCustomizableGearId(customizableGearId);
                customizableGears.add(customizableGear);
            }
            return customizableGears;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(connection != null) {
                connection.close();
            }
        }
    }
    public List<CustomizableGear> getCustomizableGearsByName(String name) throws SQLException{
        String query = "SELECT * FROM CustomizableGear WHERE itemName = ?;";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        List<CustomizableGear> customizableGears = new ArrayList<CustomizableGear>();
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, name);
            results = statement.executeQuery();
            while(results.next()) {
                int customizableGearId = results.getInt("customizableGearId");
                String dyeColor = results.getString("dyeColor");
                String quality = results.getString("quality");
                String itemCondition = results.getString("itemCondition");
                String characterMadeTheItem = results.getString("characterMadeTheItem");
                CustomizableGear customizableGear = new CustomizableGear(name, dyeColor, quality, itemCondition, characterMadeTheItem);
                customizableGear.setCustomizableGearId(customizableGearId);
                customizableGears.add(customizableGear);
            }
            return customizableGears;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(connection != null) {
                connection.close();
            }
        }
    }
}
