package desingPattern.structuralPattern;

public class BridgePattern {

    public interface Question {
        public void askQuestion();
    }

    public class JavaQuestion implements Question {

        @Override
        public void askQuestion() {
            System.out.println("hello");
        }
    }

    public class QuestionManager {
        Question q;
        public void askQuestion(){
            q.askQuestion();
        }
    }

}
