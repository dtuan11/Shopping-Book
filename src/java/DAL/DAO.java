/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Models.Account;
import Models.Category;
import Models.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author tuan
 */
public class DAO {

    public static DAO INSTANTCE;
    private Connection con;
    private String status;
    private List<Product> pro;
    private List<Category> cat;
        private List<Account> acc;


    public DAO() {
        try {
            con = new DBContext().getConnection();
        } catch (Exception e) {
            status = "Error at Connection" + e.getMessage();
        }

    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Category> getCat() {
        return cat;
    }

    public void setCat(List<Category> cat) {
        this.cat = cat;
    }

    public List<Account> getAcc() {
        return acc;
    }

    public void setAcc(List<Account> acc) {
        this.acc = acc;
    }

    public List<Product> getPro() {
        return pro;
    }

    public void setPro(List<Product> pro) {
        this.pro = pro;
    }

    public List<Product> allproduct() {
        String sql = "select * from product";
        pro = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pro.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)
                ));
            }
        } catch (Exception e) {
            status = "Error at read product" + e.getMessage();
        }
        return pro;
    }
    public List<Account> allaccount() {
        String sql = "select * from Account";
        acc = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                acc.add(new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                        
                ));
            }
        } catch (Exception e) {
            status = "Error at read Account" + e.getMessage();
        }
        return acc;
    }

    public List<Category> allcategory() {
        String sql = "select * from category";
        cat = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cat.add(new Category(
                        rs.getInt(1),
                        rs.getString(2)
                ));
            }
        } catch (Exception e) {
            status = "Error at read category" + e.getMessage();
        }
        return cat;
    }

    public Product lastproduct() {
        String sql = "select top 1 * from product\n"
                + "order by id desc";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)
                );
            }
        } catch (Exception e) {
            status = "Error at read product" + e.getMessage();
        }
        return null;
    }

    public List<Product> getproductbycateid(String cid) {
        pro = new ArrayList<>();

        String sql = "select * from product\n"
                + "where cateID=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pro.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)
                ));
            }
        } catch (Exception e) {
            status = "Error at read product" + e.getMessage();
        }
        return pro;
    }

    public Product getproductbyid(String pid) {
        String sql = "select top 1 * from product\n"
                + "where id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)


                );
            }
        } catch (Exception e) {
            status = "Error at read product" + e.getMessage();
        }
        return null;
    }
    public Account getaccountbyid(int uID) {
        String sql = "select * from Account\n"
                + "where uID=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, uID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                );
            }
        } catch (Exception e) {
            status = "Error at read product" + e.getMessage();
        }
        return null;
    }

    public List<Product> searchproduct(String txt) {
        pro = new ArrayList<>();

        String sql = "select * from product where [name] like ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + txt + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pro.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)
                ));
            }
        } catch (Exception e) {
            status = "Error at read product" + e.getMessage();
        }
        return pro;
    }

    public Account login(String user, String pass) {
        String sql = "select * from Account where [user]=? and pass=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                );
            }
        } catch (Exception e) {
            status = "Error at read product" + e.getMessage();
        }
        return null;
    }
    public Account addaccount(String user, String pass, int isadmin) {
        String sql = "insert into Account values(?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setInt(3, isadmin);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                );
            }
        } catch (Exception e) {
            status = "Error at read product" + e.getMessage();
        }
        return null;
    }

    public Account CheckAcountExit(String user) {
        String sql = "select * from Account where [user]=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                );
            }
        } catch (Exception e) {
            status = "Error at read product" + e.getMessage();
        }
        return null;
    }

    public void signup(String user, String pass) {
        String sql = "insert into Account values(?,?,0)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();
        } catch (Exception e) {
            status = "Error at read product" + e.getMessage();
        }
    }

    public void deleteproduct(String pid) {
        String sql = "delete from product where id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
            status = "Error at read product" + e.getMessage();

        }
    }
public void deleteaccunt(int pid) {
        String sql = "delete from Account where uID=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
            status = "Error at read product" + e.getMessage();

        }
    }
    public void addproduct(String name, String image, String price, String title, String description, String category) {
        String sql = "INSERT INTO [dbo].[product]\n"
                + "           ([name]\n"
                + "           ,[image]\n"
                + "           ,[price]\n"
                + "           ,[title]\n"
                + "           ,[description]\n"
                + "           ,[cateID])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.executeUpdate();
        } catch (Exception e) {
            status = "Error at read product" + e.getMessage();

        }
    }

    public void editProduct(String name, String image, String price,
            String title, String description, String category, String pid) {
        String sql = "update product\n"
                + "set [name] = ?,\n"
                + "[image] = ?,\n"
                + "price = ?,\n"
                + "title = ?,\n"
                + "[description] = ?,\n"
                + "cateID = ?\n"
                + "where id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setString(7, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void editaccount(String user, String pass
           ,int isadmin, int id) {
        String sql = "update Account set [user] = ?, [pass] = ?, isAdmin = ? where uID = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setInt(3, isadmin);
            ps.setInt(4, id);
            
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        DAO d = new DAO();
        List<Account> list = d.allaccount();
        for (Account account : list) {
            System.out.println(account);
        }
    }

}
