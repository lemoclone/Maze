
public class Maze {
	int room;
	int door;
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public int getDoor() {
		return door;
	}
	public void setDoor(int door) {
		this.door = door;
	}
	@Override
	public String toString() {
		return "Maze [room=" + room + ", door=" + door + "]";
	}
	
}
