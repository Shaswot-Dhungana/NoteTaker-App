package com.ShaswotDhungana.Note;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ShaswotDhungana.FactoryProvider.FactoryProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/UpdateNote")
public class UpdateNoteServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
		try {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		int noteId = Integer.parseInt(req.getParameter("noteId").trim());
		
		Session s = FactoryProvider.getFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Note note = s.get(Note.class, noteId);
		
		note.setTitle(title);
		note.setAddedDate(new Date());
		note.setContent(content);
		
		
		
		
		s.save(note);
		
		
		tx.commit();
		
		s.close();
		
		resp.sendRedirect("all_notes.jsp");
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
	
}
