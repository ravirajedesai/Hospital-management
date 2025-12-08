import java.util.Scanner;

public class QuestionService {

    Questions[] question= new Questions[5];
    String[] selection= new String[5];

    public QuestionService(){
        question[0]= new Questions(1,"size of Int","2","4","6","8","4");
        question[1]= new Questions(2,"size of Double","2","4","6","8","8");
        question[2]= new Questions(3,"size of Char","2","4","6","8","2");
        question[3]= new Questions(4,"size of Long","2","4","6","8","8");
        question[4]= new Questions(5,"size of Boolean","2","4","6","8","1");
    }
    public void PlayQuiz(){
        int i=0;
        for(Questions q:question){
            System.out.println("Question No: "+q.getId());
            System.out.println(q.getQuestion());
            System.out.println(q.getOpt1());
            System.out.println(q.getOpt2());
            System.out.println(q.getOpt3());
            System.out.println(q.getOpt4());
            System.out.println(q.getAnswer());

            Scanner sc = new Scanner(System.in);
            selection[i]= sc.nextLine();
            i++;

        }
        for(String s:selection){
            System.out.println(s);
        }
    }
    public void PrintScore(){
        int score=0;
        for(int i=0;i< question.length;i++){
            Questions que=question[i];
            String answer= que.getAnswer();
            String UserAnswer= selection[i];
            if(answer.equals(UserAnswer)){
                score++;
            }
        }
        System.out.println("Your Score is: "+score);
    }
}
