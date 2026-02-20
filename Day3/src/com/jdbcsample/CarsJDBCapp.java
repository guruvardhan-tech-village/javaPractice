package com.jdbcsample;

public class CarsJDBCapp {

	public void insertCar(int id, String name) throws Exception {

        Connection con = JDBConnectionApp.getConnection();

        String q = "insert into cars values(?,?)";
        PreparedStatement ps = con.prepareStatement(q);

        ps.setInt(1, id);
        ps.setString(2, name);

        int rows = ps.executeUpdate();
        System.out.println(rows + " row inserted");

        ps.close();
        con.close();
    }

    public void deleteCar(int id) throws Exception {

        Connection con = JDBConnectionApp.getConnection();

        String q = "delete from cars where Id=?";
        PreparedStatement ps = con.prepareStatement(q);

        ps.setInt(1, id);

        int rows = ps.executeUpdate();
        System.out.println(rows + " row deleted");

        ps.close();
        con.close();
    }

    public void readCars() throws Exception {

        Connection con = JDBConnectionApp.getConnection();

        String q = "select * from cars";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(q);

        System.out.println("ID\tNAME");
        System.out.println("---------------");

        while (rs.next()) {
            System.out.println(
                    rs.getInt("Id") + "\t" +
                    rs.getString("name"));
        }

        rs.close();
        st.close();
        con.close();
    }

    public void updateName(int id, String newName) throws Exception {

        Connection con = JDBConnectionApp.getConnection();

        String q = "update cars set name=? where Id=?";
        PreparedStatement ps = con.prepareStatement(q);

        ps.setString(1, newName);
        ps.setInt(2, id);

        int rows = ps.executeUpdate();
        System.out.println(rows + " row updated");

        ps.close();
        con.close();
    }

}
