package spinnerUiJdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcOracleConnection {
	
	
	public void databaseAction() {
		 Connection conn2 = null;
		 
	        try {
	            
	            Class.forName("oracle.jdbc.OracleDriver");
	 
	            String dbURL2 = "jdbc:oracle:thin:@ipsurrounddb.ip.devcerner.net:1521:surd1";
	            
	            String username = "v500";
	            String password = "v500";
	            
	            conn2 = DriverManager.getConnection(dbURL2, username, password);
	            
	            
	            if (conn2 != null) {
	                System.out.println("Connected with connection #2");
	            }
	            
	            Statement stmt = conn2.createStatement();
	            
	            String query = "select SERVICE_RESOURCE_CD from SERVICE_RESOURCE sr where sr.activity_type_cd = 696";
	            
	            //select INSTR_NAME from SERVICE_RESOURCE sr where sr.activity_type_cd = 696
	            //select INSTR_NAME from LAB_INSTRUMENT where UPDT_TASK = 1234703
	            //select * from SERVICE_RESOURCE sr where sr.activity_type_cd = 696
	            
	            boolean status = stmt.execute(query);
	            if(status){
	                //query is a select query.
	                ResultSet rs = stmt.getResultSet();
	                while(rs.next()){
	                    System.out.println(rs.getString(1));
	                }
	                rs.close();
	            } else {
	                //query can be update or any query apart from select query
	            }
	 
	 
	        } catch (ClassNotFoundException ex) {
	            ex.printStackTrace();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally {
	            try {
	                if (conn2 != null && !conn2.isClosed()) {
	                    conn2.close();
	                }
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        }
	}
 
    public static void main(String[] args) {
    	
       System.out.println("called JdbcOracleConnection main()");
    }
}