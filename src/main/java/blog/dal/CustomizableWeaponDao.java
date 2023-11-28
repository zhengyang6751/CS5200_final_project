package blog.dal;
import blog.model.CustomizableWeapon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class CustomizableWeaponDao {
    protected ConnectionManager connectionManager;

	private static CustomizableWeaponDao instance = null;
	protected CustomizableWeaponDao() {
		connectionManager = new ConnectionManager();
	}
	public static CustomizableWeaponDao getInstance() {
		if(instance == null) {
			instance = new CustomizableWeaponDao();
		}
		return instance;
	}

    public CustomizableWeapon create(CustomizableWeapon customizableWeapon) throws SQLException{
        String query = "INSERT INTO CustomizableWeapon (itemName, dyeColor, quality, itemCondition, characterMadeTheItem)" +
            "VALUES (?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultKey = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query,
            Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, customizableWeapon.getItemName());
            statement.setString(2, customizableWeapon.getDyeColor());
            statement.setString(3, customizableWeapon.getQuality());
            statement.setString(4, customizableWeapon.getItemCondition());
            statement.setString(5, customizableWeapon.getCharacterMadeTheItem());
            statement.executeUpdate();
            resultKey = statement.getGeneratedKeys();
            int customizableWeaponId = -1;
            if(resultKey.next()) {
                customizableWeaponId = resultKey.getInt(1);
            } else {
                throw new SQLException("Unable to retrieve auto-generated key.");
            }
            customizableWeapon.setCustomizableWeaponId(customizableWeaponId);
            return customizableWeapon;
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

    public List<CustomizableWeapon> getCustomizableWeaponByName(String itemName) throws SQLException{
        String query = "SELECT * FROM CustomizableWeapon WHERE itemName = ?;";
        List<CustomizableWeapon> customizableWeapons = new ArrayList<CustomizableWeapon>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, itemName);
            results = statement.executeQuery();
            while(results.next()) {
                int customizableWeaponId = results.getInt("customizableWeaponId");
                String dyeColor = results.getString("dyeColor");
                String quality = results.getString("quality");
                String itemCondition = results.getString("itemCondition");
                String characterMadeTheItem = results.getString("characterMadeTheItem");
                CustomizableWeapon customizableWeapon = new CustomizableWeapon(itemName, customizableWeaponId, dyeColor, quality, itemCondition, characterMadeTheItem);
                customizableWeapons.add(customizableWeapon);
            }
            return customizableWeapons;
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
    public CustomizableWeapon getCustomizableWeaponById(int customizableWeaponId) throws SQLException{
        String query = "SELECT * FROM CustomizableWeapon WHERE customizableWeaponId = ?;";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, customizableWeaponId);
            results = statement.executeQuery();
            if(results.next()) {
                String resultItemName = results.getString("itemName");
                String dyeColor = results.getString("dyeColor");
                String quality = results.getString("quality");
                String itemCondition = results.getString("itemCondition");
                String characterMadeTheItem = results.getString("characterMadeTheItem");
                CustomizableWeapon customizableWeapon = new CustomizableWeapon(resultItemName, customizableWeaponId, dyeColor, quality, itemCondition, characterMadeTheItem);
                return customizableWeapon;
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
    public List<CustomizableWeapon> getCustomizableWeaponByCharacter(String characterMadeTheItem) throws SQLException{
        String query = "SELECT * FROM CustomizableWeapon WHERE characterMadeTheItem = ?;";
        List<CustomizableWeapon> customizableWeapons = new ArrayList<CustomizableWeapon>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, characterMadeTheItem);
            results = statement.executeQuery();
            while(results.next()) {
                String resultItemName = results.getString("itemName");
                int customizableWeaponId = results.getInt("customizableWeaponId");
                String dyeColor = results.getString("dyeColor");
                String quality = results.getString("quality");
                String itemCondition = results.getString("itemCondition");
                CustomizableWeapon customizableWeapon = new CustomizableWeapon(resultItemName, customizableWeaponId, dyeColor, quality, itemCondition, characterMadeTheItem);
                customizableWeapons.add(customizableWeapon);
            }
            return customizableWeapons;
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
    public CustomizableWeapon deleteById(int id) throws SQLException {
        String query = "DELETE FROM CustomizableWeapon WHERE customizableWeaponId=?;";
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
}
