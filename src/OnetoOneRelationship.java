class PassPort{
    private String passportNo;
    private String issueDate;
    PassPort(String passportNo, String issueDate){
        this.passportNo=passportNo;
        this.issueDate=issueDate;
    }
    public String getPassportNo(){
        return passportNo;
    }
}
class Person{
    private String name;
    private int age;
    PassPort passport;
    Person(String name, int age, PassPort passport){
        this.name=name;
        this.age=age;
        this.passport=passport;
    }
    public String getName(){
        return name;
    }
    public PassPort getPassport(){
        return passport;
    }

}
class OnetoOneRelationship{
    public static void main(String[] args) {
    PassPort p=new PassPort("ABC","123");
    Person p1=new Person("Harshita",21,p);
        System.out.println("Name:"+p1.getName());
        System.out.println("PassPortNo:"+p1.getPassport().getPassportNo());
    }
}
