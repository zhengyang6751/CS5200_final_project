package blog.model;

public class Jobs {
    private String jobName;
    private String category;
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Jobs(String jobName, String category) {
		this.jobName = jobName;
		this.category = category;
	}
	@Override
	public String toString() {
		return "Jobs [jobName=" + jobName + ", category=" + category + "]";
	}

    // Constructors, getters, and setters
    
    // Additional methods as needed
}
