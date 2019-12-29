package vo;

import java.util.ArrayList;

import dao.JobDao;
import model.Job;

public class JobData {
	JobDao dao=new JobDao();
	 public int insert(Job job) throws Exception {
	       return dao.insert(job);
	    }
	 public ArrayList<Job> showAll() throws Exception {
	    	return dao.showAll();
	    }
}
