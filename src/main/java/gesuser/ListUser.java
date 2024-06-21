	package gesuser;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Utilisateur;
import dao.UtilisateurDao;

/**
 * Servlet implementation class ListUser
 */@WebServlet("/list")
public class ListUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String VUE_LIST_UTILISATEUR = "/WEB-INF/listerUtilisateur.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		response.getWriter().append("Served at: ").append(request.getContextPath());
		ArrayList<Utilisateur> utilisateurs = null;
		try {
			utilisateurs = UtilisateurDao.lister();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("utilisateurs", utilisateurs);
		getServletContext().getRequestDispatcher(VUE_LIST_UTILISATEUR).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
	}
	
}
