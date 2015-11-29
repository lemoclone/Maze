
public class StandardMazeBuilder extends MazeBuilder {
	private Maze maze;
	public StandardMazeBuilder(){
		super();
		System.out.println("StandardMazeBuilder init");
		maze = new Maze();
	}

	@Override
	public void buildMaze() {
		super.buildMaze();
	}

	@Override
	public Maze buildRoom(int room) {
		super.buildRoom(room);
		maze.setRoom(room);
		return maze;
	}

	@Override
	public Maze buildDoor(int roomFrom, int roomTo) {
		super.buildDoor(roomFrom, roomTo);
		maze.setDoor(roomFrom);
		return maze;
	}
	
	@Override
	public Maze getMaze(){
		return maze;
	}
}
