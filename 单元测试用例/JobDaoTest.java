package test;

import java.sql.SQLException;

import org.junit.Test;

import dao.JobDao;
import model.Goods;
import model.Job;

public class JobDaoTest {
	JobDao jobDao=new JobDao();
	 @Test
	    public void insertTest() throws Exception{
		 Job job=new Job();
	   	 job.setJobname("图书馆助管");
	   	 job.setJobdescribe("整理图书");
	   	 job.setJobway("17860711820");
	   	 job.setJobsalary("100");
	   	 job.setJobplace("图书馆");
	   	 job.setJobtime("周六");
	   	 job.setJobrequire("不限");
	        try {
	            if(jobDao.insert(job) == 1){
	                System.out.println("insert successful");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
