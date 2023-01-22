package com.ShaswotDhungana.Note;

import java.io.IOException;

import com.ShaswotDhungana.FactoryProvider.FactoryProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;



@WebServlet("/DeleteNote")
public class DeleteNoteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			int noteId = Integer.parseInt(req.getParameter("note_id").trim());
			
			Session s = FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();
			
			Note note = (Note)s.get(Note.class, noteId);
			s.delete(note);
			
			tx.commit();
			
			s.close();
		
			resp.sendRedirect("all_notes.jsp");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	
	
	
	
}
