public class QuizFactory extends AssessmentFactory {
    public Assessment createAssessment(Vector2D position) {
        Assessment assm = new Quiz();
        assm.x = position.x;
        assm.y = position.y;
        return assm;
    }
}


