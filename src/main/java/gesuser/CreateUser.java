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
 * Servlet implementation class CreateUser
 */

@WebServlet("/create")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String VUE_CREATE_UTILISATEUR = "/WEB-INF/ajouterUtilisateur.jsp";

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		getServletContext().getRequestDispatcher(VUE_CREATE_UTILISATEUR).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String nom = request.getParameter("nom");
	        String prenom = request.getParameter("prenom");
	        String login = request.getParameter("login");
	        String password = request.getParameter("password");

	        // Créer un nouvel utilisateur
	        Utilisateur nouvelUtilisateur = new Utilisateur();
	        nouvelUtilisateur.setNom(nom);
	        nouvelUtilisateur.setPrenom(prenom);
	        nouvelUtilisateur.setLogin(login);
	        nouvelUtilisateur.setPassword(password);

	        // Ajouter l'utilisateur à la base de données
	        try {
				UtilisateurDao.add(nouvelUtilisateur);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        // Rediriger vers la servlet ListUser pour afficher la liste mise à jour des utilisateurs
	        response.sendRedirect(request.getContextPath() + "/list");
	}

}
