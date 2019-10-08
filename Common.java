import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.lang.*;
import java.util.List;

public class Common {
    Set<Student> hash_Set;
    public int windowWidth;
    public int windowHeight;
    public UniversityMap map;
    public List<Academician> academicians;
    public List<Speaker> speakers;
    public List<Student> students;
    public List<Assessment> assessments;
    public Timer myTimer1;
	public Timer myTimer2;
	public Timer myTimer3;



	public Common() {
        hash_Set = new HashSet<Student>();
        assessments = new ArrayList<>();
        windowWidth = 800;
        windowHeight = 400;
        map = new UniversityMap();
        academicians = Arrays.asList( new Academician( "SelimTemizer" ), new Academician( "ShigeoKatsu" ), new Academician( "HansDeNivelle" ), new Academician( "VassiliosTourassis" ) );
        students = Arrays.asList( new Student( "Abay" ), new Student( "Abilda" ), new Student( "Abilkhaiyr" ), new Student( "Ablan" ), new Student( "Abylaikhan" ), new Student( "Adil" ), new Student( "Adilzhan" ), new Student( "Adlet" ), new Student( "Aidana" ), new Student( "Aidyn" ) );
        speakers = Arrays.asList( new Speaker( "Nazarbayev" ), new Speaker( "Tokayev" ) );
    }


    public void stepAllEntities() {

    }

    public void drawAllEntities(Graphics2D g2d, JPanel jp) {
        double b = 430;
        double c = 470;
        map.draw( g2d, jp );
        //hash_Set.size()
        if (hash_Set.size() == 10) {
            for (Student s : students) {
                s.draw( g2d, jp );
            }
            for (Academician s : academicians) {
                s.position.x = b;
                s.position.y = 270;
                b += 80;
                s.state = new Stationary();
                s.state.s = s.name;
                s.draw( g2d, jp );
            }
            for (Speaker s : speakers) {
                s.position.x = c;
                s.draw( g2d, jp );
                c += 140;
            }
            return;
        }
        for (Student s : students) {
            if (s.grade >= 100) {
                hash_Set.add( s );
                s.position.x = 550;
                s.position.y = 330;
                s.state = new Stationary();
                s.draw( g2d, jp );
            }
            if (assessments.size() != 0) {
                for (int i = 0; i < assessments.size(); i++) {
                    if (Math.abs( s.position.x - assessments.get( i ).x ) <= 15 && Math.abs( s.position.y - assessments.get( i ).y ) <= 15) {
                        s.grade += assessments.get( i ).points;
                        assessments.remove( i );
                    }
                }
            }
            s.draw( g2d, jp );
            s.position.x += s.state.x1;
            s.position.y += s.state.y1;
            if (s.state.s.equals( "Closest" )) {
                int min = Integer.MAX_VALUE;
                if (assessments.size() != 0) {
                    for (Assessment a : assessments) {
                        Vector2D pos = new Vector2D();
                        pos.x = a.x;
                        pos.y = a.y;
                        if (s.position.distanceTo( pos ) < min) {
                            s.state.x2 = pos.x;
                            s.state.y2 = pos.y;
                            min = s.position.distanceTo( pos );
                        }
                    }
                }
                s.state.step( s );
            } else {
                s.state.step( s );
            }
            s.draw( g2d, jp );
        }
        for (Academician a : academicians) {
            a.draw( g2d, jp );
            a.position.x += a.state.x1;
            a.position.y += a.state.y1;
            a.state.step( a );
            if (assessments.size() != 0) {
                for (Assessment assm : assessments) {
                    if (assm.name.equals( "Lab" )) {
                        g2d.setPaint( Color.RED );
                        g2d.fillOval( (int) assm.x, (int) assm.y, 20, 20 );
                        g2d.setPaint( Color.BLACK );
                        g2d.drawString( Integer.toString( assm.points ), (int) assm.x + 5, (int) assm.y + 18 );
                    } else if (assm.name.equals( "Homework" )) {
                        g2d.setPaint( Color.GREEN );
                        g2d.fillRect( (int) assm.x, (int) assm.y, 20, 20 );
                        g2d.setPaint( Color.BLACK );
                        g2d.drawString( Integer.toString( assm.points ), (int) assm.x + 5, (int) assm.y + 18 );
                    } else {
                        g2d.setPaint( Color.BLUE );
                        g2d.fillPolygon( new int[]{(int) assm.x, (int) assm.x + 10, (int) assm.x + 20}, new int[]{(int) assm.y + 20, (int) assm.y, (int) assm.y + 20}, 3 );
                        g2d.setPaint( Color.BLACK );
                        g2d.drawString( Integer.toString( assm.points ), (int) assm.x + 5, (int) assm.y + 18 );
                    }
                }
            }

        }
    }

    public void startAnimating(JPanel jp) {
    	if(hash_Set.size() == 10) {
    		return;
		}
		ActionListener myListener1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jp.repaint();
			}
		};

		ActionListener myListener2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (Academician a : academicians) {
					a.generateRandomState();
				}
				for (Student s : students) {
					s.generateRandomState();
				}
			}
		};

		ActionListener myListener3 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (Academician a : academicians) {
					if (a.state.s.equals( "GotoXY" ) || a.state.s.equals( "Zigzag" )) {
						assessments.add( a.createAssessment() );
					}
				}
			}
		};


		 myTimer1 = new Timer( 1, myListener1 );
		 myTimer2 = new Timer( 5000, myListener2 );
		 myTimer3 = new Timer( 800, myListener3 );
		myTimer1.start();
		myTimer2.start();
		myTimer3.start();
	}

}