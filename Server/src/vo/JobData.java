package vo;

import dao.JobDao;
import model.Job;

public class JobData {
	JobDao dao=new JobDao();
	 public int insert(Job job) throws Exception {
	       return dao.insert(job);
	    }
}
