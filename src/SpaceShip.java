public class SpaceShip extends SpaceShipControls {
  private String name;
  public SpaceShip(String name) { this.name = name; }
  public String toString() { return name; }
  public static void main(String[] args) {
	  Bart bart = new Bart();
	  bart.doh(1);
	  bart.doh('x');
	  bart.doh(1.0f);
	  bart.doh(new Milhouse());
}
}