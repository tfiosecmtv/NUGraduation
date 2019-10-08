public class HomeworkFactory extends AssessmentFactory {
    public Assessment createAssessment(Vector2D position) {
        Assessment assm = new Homework();
        assm.x = position.x;
        assm.y = position.y;
        return assm;
    }
}