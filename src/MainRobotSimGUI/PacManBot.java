package MainRobotSimGUI;

/**
 *
 */


import java.util.Iterator;


/**
 * @author Jumar Quinio Mesicias
 * The Target Robot which you are aiming at
 */
public class PacManBot extends Robot {
	private static final long serialVersionUID = 1L;
	private double rAngle; // angle and speed of travel
	private double rSpeed; // angle and speed of travel
	private boolean isEating; //new attribute to track if the PacManBot is eating a GameRobot



	/**
	 *
	 */
	// public BeamBot() {
	// 	this(100, 100, 16, 0, 2); // TODO Auto-generated constructor stub
	// }

	/**
	 * @param ix // x position
	 * @param iy // y position
	 * @param ir // radius
	 * @param ia // angle
	 * @param is // speed
	 */
	public PacManBot(double ix, double iy, double ir, double ia, double is) {
		super(ix, iy, ir, ia, is);
		col = 'n';
		rAngle = ia;
		rSpeed = is;
		isEating = false;

	}


	// public void followGameRobot(GameRobot gameRobot) {
	// 	if (!isEating) {
	// 		double dx = gameRobot.getX() - this.getX();
	// 		double dy = gameRobot.getY() - this.getY();
	// 		rAngle = Math.atan2(dy, dx);
	// 		this.setX(this.getX() + rSpeed * Math.cos(rAngle));
	// 		this.setY(this.getY() + rSpeed * Math.sin(rAngle));
	// 	}
	// }

	public boolean isEating() {
		return isEating;
	}

	public void startEating() {
		isEating = true;
	}

	public void stopEating() {
		isEating = false;
	}





	/**
	 * checkRobot for collision in arena
	 * @param b RobotArena
	 */
	@Override

	protected void checkRobot(RobotArena arena) {
		rAngle = arena.CheckRobotAngle(x, y, rad, rAngle, RobotID); // check for collision with wall or Robot
		//if the angle change, it means it hit something

	}


	/**
	 * draw Robot and display score
	 */

	public void drawRobot(MyCanvas mc) {
		double ang = rAngle * Math.PI / 180; // put angle in radians
		mc.showCircle(x, y, rad, col); // draw Robot body
		drawWheels(mc, ang); // draw Robot wheels
	}

	private void drawWheels(MyCanvas mc, double ang) {
		double x1 = x + (rad * Math.cos(ang + Math.PI / 4)); // calculate corners of Robot
		double y1 = y + (rad * Math.sin(ang + Math.PI / 4));
		double x2 = x + (rad * Math.cos(ang + 3 * Math.PI / 4)); // calculate corners of Robot
		double y2 = y + (rad * Math.sin(ang + 3 * Math.PI / 4));
		double x3 = x + (rad * Math.cos(ang - Math.PI / 4));
		double y3 = y + (rad * Math.sin(ang - Math.PI / 4));
		double x4 = x + (rad * Math.cos(ang - 3 * Math.PI / 4));
		double y4 = y + (rad * Math.sin(ang - 3 * Math.PI / 4));

		// adjust the angle of the lines to the Robot angle of travel
		// adjust the angle of the lines to the Robot angle of travel
		mc.showLineWheels(x1, y1, x2, y2); // draw Robot wheels
		mc.showLineWheels(x3, y3, x4, y4); // draw Robot Wheels
	}


	public void eatGameRobots(RobotArena arena) {
		Iterator<Robot> iterator = arena.getAllRobots().iterator();
		while (iterator.hasNext()) {
			Robot robot = iterator.next();
			if (robot instanceof GameRobot && isWithinEatingRange(robot)) {
				// You can perform actions like updating score or any other behavior here
				iterator.remove(); // Remove the GameRobot from the arena
			}
		}
	}

	// Add this method to check if a GameRobot is within eating range
	private boolean isWithinEatingRange(Robot robot) {
		double distance = Math.sqrt(Math.pow(x - robot.getX(), 2) + Math.pow(y - robot.getY(), 2));
		return distance < rad + robot.getRad() + EATING_RANGE;
	}

	// Add a constant for the eating range (you can adjust this value)
	private static final double EATING_RANGE = 0; // 0 means the PacManBot must be touching the GameRobot to eat it


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
		return "Bbot";
	}
}