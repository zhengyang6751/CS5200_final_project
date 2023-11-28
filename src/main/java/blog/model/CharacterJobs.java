package blog.model;

public class CharacterJobs {
    private String firstName;
    private String lastName;
    private String jobName;
    private int currentExp;
    private int jobLevel;
    private int requiredExp;
    private boolean isCurrentJob;

    // Constructors, getters, and setters

    public CharacterJobs(String firstName, String lastName, String jobName, int currentExp, int jobLevel, int requiredExp, boolean isCurrentJob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobName = jobName;
        this.currentExp = currentExp;
        this.jobLevel = jobLevel;
        this.requiredExp = requiredExp;
        this.isCurrentJob = isCurrentJob;
    }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public int getCurrentExp() {
		return currentExp;
	}

	public void setCurrentExp(int currentExp) {
		this.currentExp = currentExp;
	}

	public int getJobLevel() {
		return jobLevel;
	}

	public void setJobLevel(int jobLevel) {
		this.jobLevel = jobLevel;
	}

	public int getRequiredExp() {
		return requiredExp;
	}

	public void setRequiredExp(int requiredExp) {
		this.requiredExp = requiredExp;
	}

	public boolean isCurrentJob() {
		return isCurrentJob;
	}

	public void setCurrentJob(boolean isCurrentJob) {
		this.isCurrentJob = isCurrentJob;
	}

	@Override
	public String toString() {
		return "CharacterJobs [firstName=" + firstName + ", lastName=" + lastName + ", jobName=" + jobName
				+ ", currentExp=" + currentExp + ", jobLevel=" + jobLevel + ", requiredExp=" + requiredExp
				+ ", isCurrentJob=" + isCurrentJob + "]";
	}
	
    // Getters and setters for other fields
    
    // Additional methods as needed
}
