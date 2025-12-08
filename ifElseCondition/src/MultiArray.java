public class MultiArray {
    public static void main(String[] args) {
//        int [] arr= new int[6];
//        arr[0]=3;
//        arr[1]=3;
//        arr[2]=3;
//        arr[3]=3;
//        for(int i=0;i<arr.length;i++){
//            System.out.println(arr[i]);

            Student student=new Student();
            student.rollno=10;
            student.name="abc";
            student.age=21;

            Student stud=new Student();
            stud.rollno=11;
            stud.name="abcd";
            stud.age=22;

            Student stud2=new Student();
            stud2.rollno=12;
            stud2.name="xyz";
            stud2.age=23;

            Student student1[]=new Student[3];
            student1[0]=student;
            student1[1]=stud;
            student1[2]=stud2;
            for(Student st:student1){
                System.out.println(st.rollno+": "+st.name+": "+st.age+": ");

            }
        }
    }

