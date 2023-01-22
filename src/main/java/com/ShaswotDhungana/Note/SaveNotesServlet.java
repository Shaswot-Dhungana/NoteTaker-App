package com.ShaswotDhungana.Note;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


import org.hibernate.Session;
import org.hibernate.Transaction;


import com.ShaswotDhungana.FactoryProvider.FactoryProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@SuppressWarnings("serial")
@WebServlet("/SaveNotes")
public class SaveNotesServlet extends HttpServlet {

	@SuppressWarnings("deprecation")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");

		Note note = new Note(title,content,new Date());
		
		PrintWriter pw = resp.getWriter();
//		
//		pw.print(note.getId());
		
		// opening hibernate session 
		Session session = FactoryProvider.getFactory().openSession();
		
		
		
		// opening transaction.
		
		Transaction tx = session.beginTransaction();
		
	
		// saving to db
		session.save(note);
		
		// comitting transaction
		tx.commit();
		
	
		
		// closing session.
		session.close();
		
		resp.setContentType("text/html");
		pw.print("<h1> Note is added to DB. </h1>");
		pw.print("<h1> <a href='all_notes.jsp'>View All Notes. </a> </h1>");
		
	} catch(Exception e) {
		e.printStackTrace();
		
	}

	
	
	}		
}
