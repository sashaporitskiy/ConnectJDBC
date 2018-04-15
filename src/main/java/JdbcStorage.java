import entity.Project;

import java.sql.*;

public class JdbcStorage {
    private String DB_DRIVER="com.mysql.cj.jdbc.Driver";
    private String SERVER_PATH = "localhost:3306";
    private String DB_NAME = "homework11";
    private String DB_LOGIN = "root";
    private String DB_PASSWORD = "root";

    private Connection connection;

    private Statement st;

    public JdbcStorage(){
        initDbDriver();
        initConnection();
    }

    private void initDbDriver(){
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void  initConnection(){
        String connectionUrl = "jdbc:mysql://"+SERVER_PATH+"/"+DB_NAME;
        connectionUrl+="  ?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        try {
            connection = DriverManager.getConnection(connectionUrl,DB_LOGIN,DB_PASSWORD);
            st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Project getProjectByID (long projID){
        String selectSQL =
                "SELECT projects_id, projects_Name, projects_Uroven, cost" +
                        " FROM projects" +
                        "WHERE projects_id="+projID;
        ResultSet rs = null;
        try {
            rs = st.executeQuery(selectSQL);
            if (rs.first()){
                Project pr = new Project();
                pr.setProjects_id(rs.getLong("Projects_id"));
                pr.setProjects_Name(rs.getString("projects_Name"));
                pr.setProjects_Uroven(rs.getInt("projects_Uroven"));
                pr.setCost(rs.getDouble("cost"));
                return pr;
            }else{
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            closeResultSet(rs);
        }
    }

    private void closeResultSet(ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        JdbcStorage storage = new JdbcStorage();
        Project pr = storage.getProjectByID(2);
        System.out.println(pr);
    }
}
