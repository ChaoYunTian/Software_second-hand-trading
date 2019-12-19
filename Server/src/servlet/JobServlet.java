package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.JobDao;
import model.Job;

/**
 * Servlet implementation class JobServlet
 */
@WebServlet(name = "JobServlet", urlPatterns = "/job")
public class JobServlet extends HttpServlet {
	   JobDao jobDao=new JobDao();
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request,response);
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	String action = request.getParameter("action");
	    	 if(action.equals("insert")) {
	    		 try {
					this.insert(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	 }
	    	 
	    }
	    private void insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
	   	 String jobname = request.getParameter("jobname");
	   	 String jobdescribe=request.getParameter("jobdescribe");
	   	 String jobway=request.getParameter("jobway");
	   	 String jobsalary=request.getParameter("jobsalary");
	   	 String jobplace=request.getParameter("jobplace");
	   	 String jobtime=request.getParameter("jobtime");
	   	 String jobrequire=request.getParameter("jobrequire");
	   	 Job job=new Job();
	   	 job.setJobname(jobname);
	   	 job.setJobdescribe(jobdescribe);
	   	 job.setJobway(jobway);
	   	 job.setJobsalary(jobsalary);
	   	 job.setJobplace(jobplace);
	   	 job.setJobtime(jobtime);
	   	 job.setJobrequire(jobrequire);
	        int result = 0;
	        try {
	            result = jobDao.insert(job);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        PrintWriter out = response.getWriter();
	        out.write(new Gson().toJson(result));
	        out.flush();
	   }
	   
}
