package structure;

import java.util.ArrayList;

public class AuxKruskal<T> {
	
	private ArrayList<T> nodes;
	
	
	public AuxKruskal(T firtNode)
	{
		nodes = new ArrayList<T>();
		nodes.add(firtNode);
	}
	
	public ArrayList<T> getNodes(){
		return nodes;
	}
	
	
	public boolean isNode(T node)
	{
		boolean found = false;
		for (int i = 0; i<nodes.size() && !found; i++)
		{
			if(nodes.get(i).equals(node))
			{
				found = true;
			}
		}
		
		return found;
	}
	
	public void getTogether(AuxKruskal<T> secondAux)
	{
		for(int i = 0; i<secondAux.getNodes().size();i++)
		{
			if(!isNode(secondAux.getNodes().get(i)))
			{
				nodes.add(secondAux.getNodes().get(i));
				
			}
		}
	}

}
