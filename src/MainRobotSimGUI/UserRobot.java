package MainRobotSimGUI;

public class UserRobot extends Robot{

double cAngle; // current angle of UserRobot
double cSpeed; // current speed of userRobot

    /**
	 * Set up the paddle controlled by the user
	 */
	public UserRobot() {
		// TODO Auto-generated constructor stub
	}

     /**
      * Set paddle ball size ir at ix,iy
      *
      * @param ix
      * @param iy
      * @param ir
      */
     public UserRobot(double ix, double iy, double ir, double ia, double is) {
          super(ix, iy, ir, ia, is);
          col = 'd';
          cAngle = ia;
          cSpeed = is;
          // TODO Auto-generated constructor stub
     }


     @Override
     protected void checkRobot(RobotArena b) {
          cAngle = b.CheckRobotAngle(x, y, rad, cAngle, RobotID);
          
     }

     @Override
     protected void adjustRobot() {
          double radAngle = cAngle * Math.PI / 180; // put angle in radians
          x += cSpeed * Math.cos(radAngle); // new X position
          y += cSpeed * Math.sin(radAngle); // new Y position

     }

     /**
      * return string description as paddle
      */
     protected String getStrType() {
          return "UserMouseRobot";
     }
}
