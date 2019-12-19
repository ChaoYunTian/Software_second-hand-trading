package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}
