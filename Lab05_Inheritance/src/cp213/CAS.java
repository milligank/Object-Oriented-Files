package cp213;


public class CAS extends Professor{
	private String term = null;
	
	public CAS(String lastName, String firstName, String department,  String term) {
		super(lastName, firstName, department);
		this.term = term;
	}
	public String getTerm() {
		return this.term;
		
	}
	
	public void print() {
		System.out.println(this.lastName + ", " + this.firstName);
		System.out.println("Department: " + this.department);
		System.out.println("Term: " + this.term);
	}
}


/**public class CAS extends Professor implements Comparable<Professor>{
	protected String firstName = null;
    protected String lastName = null;
    protected String term = null;
    protected String department = null;
    
    public CAS(String lastName, String firstName, String department,  String term) {
		this.term = term;
		this.lastName = lastName;
	    this.firstName = firstName;
	}
    
	@Override
	public int compareTo(Professor prof) {
		int flag = this.lastName.compareTo(prof.lastName);

        if (flag == 0) {
            // last names are the same - compare first names.
            flag = this.firstName.compareTo(prof.firstName);
        }
        return flag;
	}
        public String getTerm() {
    		return this.term;
    		
    	}
        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }
        
        public String getDepartment() {
            return this.department;
        }
    	public void print() {
    		System.out.println(this.lastName + ", " + this.firstName);
    		System.out.println("Department: " + this.department);
    		System.out.println("Term: " + this.term);
    	}
    
	}
**/