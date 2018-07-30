package DoctorProblem;

public class Employee {
    private String name;
    private Date hireDate;
    public Employee(){
        name = "No name";
        hireDate = new Date("Jan",1,2014);
    }

    public Employee(String theName, Date theDate){
        if(theName == null || theDate == null){
            System.out.println("Fatal Error cresting employee.");
            System.exit(0);
        }
        name = theName;
        hireDate = theDate;
    }

    public Employee(Employee originalObject){
        name = originalObject.name;
        hireDate = originalObject.hireDate;
    }

    public String getName() {
        return name;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setName(String newName) {
        if(newName == null){
            System.out.println("Fatal Error setting employee name.");
            System.exit(0);
        }else{
            name = newName;
        }
    }

    public void setHireDate(Date newDate) {
        if(newDate == null){
            System.out.println("Fatal Error setting employee hire"+"date.");
            System.exit(0);
        }else{
            hireDate = newDate;
        }
    }

    public String toString(){
        return (name+" "+ hireDate.toString());
    }

    public boolean equals(Employee otherEmployee){
        return (name.equals(otherEmployee.name)
                &&hireDate.equals(otherEmployee.hireDate));
    }
}
