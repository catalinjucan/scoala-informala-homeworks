package tema11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JDBCSelectTest {

	private static final String DB_CONNECTION = "jdbc:postgresql://[::1]:5432/booking";
	private static final String DB_PASSWORD = "Banana1";
	private Connection dbConnection;
	private PreparedStatement preparedStatement;

	@Before
	public void setup() {
		Properties props = new Properties();
		props.setProperty("user", "postgres");
		props.setProperty("password", DB_PASSWORD);

		try {

			dbConnection = DriverManager.getConnection(DB_CONNECTION, props);

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

	}

	@After
	public void cleanUp() throws SQLException {

		if (preparedStatement != null) {
			preparedStatement.close();
		}

		if (dbConnection != null) {
			dbConnection.close();
		}
	}

	@Test
	public void selectColumnFromTable() throws SQLException {
		final String selectColumnFromTableSQL = "SELECT a.*, r.value, r.season "
				+ "FROM accomodation a "
				+ "INNER JOIN accomodation_fair_relation rel ON rel.id_accomodation = a.id "
				+ "INNER JOIN room_fair r ON rel.id_room_fair = r.id "
				+ "order by a.id, r.id";
		this.preparedStatement = dbConnection
				.prepareStatement(selectColumnFromTableSQL);

		ResultSet resultSet = preparedStatement.executeQuery();
		this.showResult(resultSet);

	}

	public void showResult(ResultSet rs) throws SQLException {
		while (rs != null && rs.next()) {
			System.out.println(rs.getLong("id") + ", "
					+ rs.getString("bed_type") + ", "
					+ rs.getLong("max_guests") + ", "
					+ rs.getString("description") + ", " + rs.getLong("value")
					+ ", " + rs.getString("season"));
		}

	}
}
