import java.sql.*;

public class SQLCommand {
    public ResultSet selectAll(Statement stmt, String table){
        ResultSet rset;
        try {
            String SQLString = "*";
            rset = stmt.executeQuery("Select " + SQLString + " from " +table + ";");
            return rset;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public ResultSet select(Statement stmt, String table, String... args){
        ResultSet rset;
        String SQLString = "Select ";
        for(String s:args){
            SQLString = SQLString + s + " ";
        }
        SQLString = SQLString +" "+ table+ ";";
        try{
            rset = stmt.executeQuery(SQLString +" from RailRoadDB");
            return rset;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public void update(Statement stmt, String table,String condition, String... values){
        String temp = values[0] + " ";
        for(int i =0; i < values.length - 1; i++){
            temp = values[i] + ", ";
        }
        temp = temp + values[values.length - 1] + " ";
        String SQLString = "update " + table + " set " + temp + " where " + condition + ";";
        try{
            stmt.execute(SQLString);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     *  Use only for a insert with all values
     *  Use insertPartial if the row doesnt have every data type
     * @param stmt
     * @param table String representing table name
     * @param values All values need to appear and needs to be in proper SQL format ex. (1,'sup',2)
     */
    public void insert(Statement stmt,String table, String values){
        try{
            stmt.execute("insert into " +table+ " values " + values + ";");
        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }

    /**
     * Used for only inserting a row with specific types of data
     * Use insert for inserting a complete row
     * @param category Which types of data will be entered into the table and need to be the same as column names
     * @param values Values for the specific data types
     */
    public void insertPartial(Statement stmt,String table, String category, String values){
        try{
            stmt.execute("insert into " +table+ " " +category+ " " + " values " + values + ";");
        }
        catch(SQLException f){
            f.printStackTrace();
        }
    }
    public void delete(Statement stmt, String table, String condition){
        try{
            stmt.execute("delete from " +table+ " where " +condition + ";");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}

