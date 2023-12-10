package MainRobotSimGUI;

/**
 *
 */


/**
 * @author Jumar Quinio Mesicias
 * The Target Robot which you are aiming at
 */
public class TargetRobot extends Robot {
	private static final long serialVersionUID = 1L;
	private int score;
	private double rAngle;
	private double rSpeed; // angle and speed of travel


	/**
	 *
	 */
	public TargetRobot() {
		this(100, 100, 10, 45, 1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param ix
	 * @param iy
	 * @param ir
	 */
	public TargetRobot(double ix, double iy, double ir, double ia, double is) {
	super(ix, iy, ir, ia, is);
	score = 0;
     col = 'o';
     rAngle = ia;
	rSpeed = is;

	}

	/**
	 * checkRobot in arena
	 * @param b RobotArena
	 */
	@Override
	protected void checkRobot(RobotArena b) {
		rAngle = b.CheckRobotAngle(x, y, rad, rAngle, RobotID); // check for collision with wall or Robot
		if (b.checkHit(this))
			score++; // if been hit, then increase score
	}


	/**
	 * draw Robot and display score
	 */

	public void drawRobot(MyCanvas mc) {

		// super.drawRobot(mc); // Commented out as this draws a circle and was duplicating the my robot
		double ang = rAngle * Math.PI / 180; // put angle in radians
		mc.showCircle(x, y, rad, col); // draw Robot body
		drawWheels(mc, ang); // draw Robot wheels
		mc.showInt(x, y, score); // display score
	}
private void drawWheels(MyCanvas mc, double ang) {
		// double x1 = x + (rad * Math.cos(ang + Math.PI / 4)); // calculate corners of Robot
		// double y1 = y + (rad * Math.sin(ang + Math.PI / 4));
		// double x2 = x + (rad * Math.cos(ang + 3 * Math.PI / 4)); // calculate corners of Robot
		// double y2 = y + (rad * Math.sin(ang + 3 * Math.PI / 4));
		// double x3 = x + (rad * Math.cos(ang - Math.PI / 4));
		// double y3 = y + (rad * Math.sin(ang - Math.PI / 4));
		// double x4 = x + (rad * Math.cos(ang - 3 * Math.PI / 4));
		// double y4 = y + (rad * Math.sin(ang - 3 * Math.PI / 4));


		// adjust the angle of the lines to the Robot angle of travel

		// mc.showCircle( x, y, rad, col); // draw Robot body
		// // adjust the angle of the lines to the Robot angle of travel
		// mc.showLineWheels(x1, y1, x2, y2); // draw Robot wheels
		// mc.showLineWheels(x3, y3, x4, y4); // draw Robot Wheels

		mc.showInt(x, y, score); // display score

	}

	/**
	 * adjustRobot
	 * for moving the Robot - not needed here
	 */
	@Override
	protected void adjustRobot() {
		double radAngle = rAngle * Math.PI / 180; // convert to radians
		x += rSpeed * Math.cos(radAngle); // move Robot
		y += rSpeed * Math.sin(radAngle);
	}

      // not needed here ..
		@Override
		public void setXY(double nx, double ny) {
			// TODO Auto-generated method stub

		}
	/**
	 * return string defining Robot ... here as target
	 */
	protected String getStrType() {
		return "Target";
	}
}
