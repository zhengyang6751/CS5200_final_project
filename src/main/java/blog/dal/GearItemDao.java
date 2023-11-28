package blog.dal;
import blog.model.GearItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class GearItemDao {
    protected ConnectionManager connectionManager;

	private static GearItemDao instance = null;
	protected GearItemDao() {
		connectionManager = new ConnectionManager();
	}
	public static GearItemDao getInstance() {
		if(instance == null) {
			instance = new GearItemDao();
		}
		return instance;
	}

    public GearItem create(GearItem gearItem) throws SQLException {
        String query = "INSERT INTO GearItem (itemName, itemLevel, slotName, requiredLevel, requiredJob, defenseRating, magicDefenseRating) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, gearItem.getItemName());
            statement.setInt(2, gearItem.getItemLevel());
            statement.setString(3, gearItem.getSlotName());
            statement.setInt(4, gearItem.getRequiredLevel());
            statement.setString(5, gearItem.getRequiredJob());
            statement.setInt(6, gearItem.getDefenseRating());
            statement.setInt(7, gearItem.getMagicDefenseRating());
            statement.executeUpdate();
            return gearItem;
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

    public GearItem getGearItemByName(String itemName) throws SQLException{
        String query = "SELECT * FROM GearItem WHERE itemName = ?;";
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
                String slotName = results.getString("slotName");
                int requiredLevel = results.getInt("requiredLevel");
                String requiredJob = results.getString("requiredJob");
                int defenseRating = results.getInt("defenseRating");
                int magicDefenseRating = results.getInt("magicDefenseRating");
                GearItem gearItem = new GearItem(resultItemName, itemLevel, slotName, requiredLevel, requiredJob, defenseRating, magicDefenseRating);
                return gearItem;
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

    public GearItem updateDefenseRating(GearItem gearItem, int newDefenseRating) throws SQLException {
        String query = "UPDATE GearItem SET defenseRating=? WHERE itemName=?;";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, newDefenseRating);
            statement.setString(2, gearItem.getItemName());
            statement.executeUpdate();
            gearItem.setDefenseRating(newDefenseRating);
            return gearItem;
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

    public GearItem updateMagicDefenseRating(GearItem gearItem, int newMagicDefenseRating) throws SQLException {
        String query = "UPDATE GearItem SET magicDefenseRating=? WHERE itemName=?;";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, newMagicDefenseRating);
            statement.setString(2, gearItem.getItemName());
            statement.executeUpdate();
            gearItem.setMagicDefenseRating(newMagicDefenseRating);
            return gearItem;
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
