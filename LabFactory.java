public class LabFactory extends AssessmentFactory {
    public Assessment createAssessment(Vector2D position) {
        Assessment assm = new Lab();
        assm.position = position;
        assm.x = position.x;
        assm.y = position.y;
        return assm;
    }
}
