package model;

public class Job {
  private String jobname;
  private String jobdescribe;
  private String jobway;
  private String jobsalary;
  private String jobplace;
  private String jobtime;
  private String jobrequire;
@Override
public String toString() {
	return "Job [jobname=" + jobname + ", jobdescribe=" + jobdescribe + ", jobway=" + jobway + ", jobsaraly="
			+ jobsalary + ", jobplace=" + jobplace + ", jobtime=" + jobtime + ", jobrequire=" + jobrequire + "]";
}
public String getJobname() {
	return jobname;
}
public void setJobname(String jobname) {
	this.jobname = jobname;
}
public String getJobdescribe() {
	return jobdescribe;
}
public void setJobdescribe(String jobdescribe) {
	this.jobdescribe = jobdescribe;
}
public String getJobway() {
	return jobway;
}
public void setJobway(String jobway) {
	this.jobway = jobway;
}
public String getJobsalary() {
	return jobsalary;
}
public void setJobsalary(String jobsalary) {
	this.jobsalary = jobsalary;
}
public String getJobplace() {
	return jobplace;
}
public void setJobplace(String jobplace) {
	this.jobplace = jobplace;
}
public String getJobtime() {
	return jobtime;
}
public void setJobtime(String jobtime) {
	this.jobtime = jobtime;
}
public String getJobrequire() {
	return jobrequire;
}
public void setJobrequire(String jobrequire) {
	this.jobrequire = jobrequire;
}
}
