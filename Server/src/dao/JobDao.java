package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Books;
import model.Job;
import util.DBUtil;

public class JobDao {
	  public int insert(Job job) throws Exception{
	        Connection connection = DBUtil.getConnection();
	        String sql = "insert into job (jobname, jobdescribe, jobway, jobsalary, jobplace, jobtime, jobrequire) " +
	                     "values (?, ?, ?, ?, ?, ?, ?);";
	        PreparedStatement pst = connection.prepareStatement(sql);
	        pst.setString(1, job.getJobname());
	        pst.setString(2, job.getJobdescribe());
	        pst.setString(3, job.getJobway());
	        pst.setString(4, job.getJobsalary());
	        pst.setString(5, job.getJobplace());
	        pst.setString(6, job.getJobtime());
            pst.setString(7, job.getJobrequire());
	        int result = pst.executeUpdate();
	        
	        return result;
	    }
	   public ArrayList<Job> showAll() throws Exception{
	        Connection connection = DBUtil.getConnection();
	        String sql = "select * from job ";
	        PreparedStatement pst = connection.prepareStatement(sql);
	        ResultSet rst = pst.executeQuery();
	        ArrayList<Job> list=new ArrayList<Job>();
	        if (rst.next()) {
	            Job job = new Job();
	            job.setJobname(rst.getString(1));
               job.setJobdescribe(rst.getString(2));
               job.setJobway(rst.getString(3));
               job.setJobsalary(rst.getString(4));
               job.setJobplace(rst.getString(5));
               job.setJobtime(rst.getString(6));
               job.setJobrequire(rst.getString(7));
	            list.add(job);
	        }
	        
	        return list;
	    }
}
