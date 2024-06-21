package gesuser;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import beans.Utilisateur;
import dao.UtilisateurDao;

/**
 * Servlet implementation class Update
 */
@WebServlet("/update")
public class Update extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VUE_UPDATE_UTILISATEUR = "/WEB-INF/updateUtilisateur.jsp";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));

        // Récupérer les informations de l'utilisateur à partir de votre source de données
        Utilisateur utilisateur = null;
		try {
			utilisateur = UtilisateurDao.getById(userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Méthode à implémenter dans votre UtilisateurDao

        // Passer les informations de l'utilisateur à la page JSP de mise à jour comme attribut de la requête
        request.setAttribute("utilisateur", utilisateur);

        // Rediriger vers la page JSP de mise à jour
        getServletContext().getRequestDispatcher(VUE_UPDATE_UTILISATEUR).forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les paramètres de la requête contenant les nouvelles informations de l'utilisateur
        int userId =  (int) Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        // Créer un objet Utilisateur avec les nouvelles informations
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(userId);
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setLogin(login);
        utilisateur.setPassword(password);

        // Mettre à jour l'utilisateur dans la source de données
        try {
			UtilisateurDao.update(utilisateur);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Méthode à implémenter dans votre UtilisateurDao

        // Rediriger vers la servlet ListUser pour afficher la liste mise à jour des utilisateurs
        response.sendRedirect(request.getContextPath() + "/list");
    }
}
