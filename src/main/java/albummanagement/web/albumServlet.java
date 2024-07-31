package albummanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import albummanagement.model.album;

import albummanagement.dao.*;
import albummanagement.model.*;



/**
 * Servlet implementation class albumServlet
 */
@WebServlet("/")
public class albumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private albumDAO albumDAO;
	
	public void init() {
		albumDAO = new albumDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertalbum(request, response);
				break;
			case "/delete":
				deletealbum(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updatealbum(request, response);
				break;
			default:
				listalbum(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listalbum(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<album> listalbum = albumDAO.selectAllalbums();
		request.setAttribute("listalbum", listalbum);
		RequestDispatcher dispatcher = request.getRequestDispatcher("album-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("album-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		album existingalbum = albumDAO.selectalbum(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("album-form.jsp");
		request.setAttribute("album", existingalbum);
		dispatcher.forward(request, response);

	}

	private void insertalbum(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String album = request.getParameter("album");
		String artist = request.getParameter("artist");
		String languages = request.getParameter("languages");
		album newalbum = new album(album, artist, languages);
		albumDAO.insertalbum(newalbum);
		response.sendRedirect("list");
	}

	private void updatealbum(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String album = request.getParameter("album");
		String artist = request.getParameter("artist");
		String languages = request.getParameter("languages");

		album book = new album(id, album, artist, languages);
		albumDAO.updateAlbum(book);
		response.sendRedirect("list");
	}

	private void deletealbum(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		albumDAO.deleteAlbum(id);
		response.sendRedirect("list");

	}

}