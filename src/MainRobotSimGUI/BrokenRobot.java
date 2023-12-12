package MainRobotSimGUI;

/**
 *
 * @author Jumar Quinio Mesicias
 *
 * BRokenRobot is a subclass of Robot that acts as a static obstacle in the arena.
 * It provides navigational challenges for other robots.
 *
 *
 */


public class BrokenRobot extends Robot {


	// public BrokenRobot() {
	// 	// TODO Auto-generated constructor stub
	// }

	/**
	 * @param ix
	 * @param iy
	 * @param ir
	 */
    public BrokenRobot(double ix, double iy, double ir, double ia, double is) {
         super(ix, iy, ir, ia, is);
         col = 'k';
         rAngle = ia;
         rSpeed = is;
	}


	@Override
	protected void checkRobot(RobotArena b) {
		// nowt to do

	}

	@Override
	protected void adjustRobot() {
		// nowt to do

	}
	protected String getStrType() {
		return "Brokenrobot";
	}
}
