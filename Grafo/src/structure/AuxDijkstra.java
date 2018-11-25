package structure;

public class AuxDijkstra<M, N> {

	public M distance;
	public N path;

		  public AuxDijkstra( M distance, N path) {
		    this.distance = distance;
		    this.path = path;
		  }

		  public M getDistance() {
			  return distance;
			  }
		  public N getPath() {
			  return path; 
			  }

		  @Override
		  public int hashCode() { 
			  return distance.hashCode() ^ path.hashCode(); 
			  }

		  @Override
		  public boolean equals(Object o) {
		    if (!(o instanceof AuxDijkstra)) return false;
		    AuxDijkstra pairo = (AuxDijkstra) o;
		    return this.distance.equals(pairo.getDistance()) &&
		           this.path.equals(pairo.getPath());
		  }

		
	
}
