package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Utilisateur;


public class UtilisateurDao {
    
   
    public static ArrayList<Utilisateur> lister() throws SQLException {
        ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
        String sql = "SELECT id, nom, prenom, login, password FROM utilisateur";
        try (Connection conn = ConnexionMySQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String login = rs.getString("login");
                String password = rs.getString("password");
                Utilisateur utilisateur = new Utilisateur(id, nom, prenom, login, password);
                utilisateurs.add(utilisateur);
            }
        }
        return utilisateurs;
    }
    
    
    public static void add(Utilisateur utilisateur) throws SQLException {
        String sql = "INSERT INTO utilisateur (nom, prenom, login, password) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnexionMySQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getPrenom());
            stmt.setString(3, utilisateur.getLogin());
            stmt.setString(4, utilisateur.getPassword());
            stmt.executeUpdate();
        }
    }
    
  
    public static void delete(int id) throws SQLException {
        String sql = "DELETE FROM utilisateur WHERE id = ?";
        try (Connection conn = ConnexionMySQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
    
  
    public static Utilisateur getById(int id) throws SQLException {
        String sql = "SELECT nom, prenom, login, password FROM utilisateur WHERE id = ?";
        try (Connection conn = ConnexionMySQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nom = rs.getString("nom");
                    String prenom = rs.getString("prenom");
                    String login = rs.getString("login");
                    String password = rs.getString("password");
                    return new Utilisateur(id, nom, prenom, login, password);
                }
            }
        }
        return null; 
    }
    
   
    public static void update(Utilisateur utilisateurModifie) throws SQLException {
        String sql = "UPDATE utilisateur SET nom = ?, prenom = ?, login = ?, password = ? WHERE id = ?";
        try (Connection conn = ConnexionMySQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, utilisateurModifie.getNom());
            stmt.setString(2, utilisateurModifie.getPrenom());
            stmt.setString(3, utilisateurModifie.getLogin());
            stmt.setString(4, utilisateurModifie.getPassword());
            stmt.setInt(5, utilisateurModifie.getId());
            stmt.executeUpdate();
        }
    }
}
