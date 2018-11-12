package trying;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Graph {
	
	    public static void computePaths(Vertex source)
	    {
	        source.minDistance = 0.;
	        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
	    vertexQueue.add(source);

	    while (!vertexQueue.isEmpty()) {
	        Vertex u = vertexQueue.poll();

	            // Visit each edge exiting u
	            for (Edge e : u.adjacencies)
	            {
	                Vertex v = e.target;
	                double weight = e.weight;
	                double distanceThroughU = u.minDistance + weight;
	        if (distanceThroughU < v.minDistance) {
	            vertexQueue.remove(v);

	            v.minDistance = distanceThroughU ;
	            v.previous = u;
	            vertexQueue.add(v);
	        }
	            }
	        }
	    }

	    public static List<Vertex> getShortestPathTo(Vertex target)
	    {
	        List<Vertex> path = new ArrayList<Vertex>();
	        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
	            path.add(vertex);

	        Collections.reverse(path);
	        return path;
	    }

	    public static void main(String[] args)
	    {
	        // mark all the vertices
	        Vertex SFO = new Vertex("SFO");
	        Vertex NYC = new Vertex("NYC");
	        Vertex SEA = new Vertex("SEA");
	        Vertex GDL = new Vertex("GDL");
	        Vertex CUU = new Vertex("CUU");
	        Vertex MEX = new Vertex("MEX");
	        Vertex PAR = new Vertex("PAR");
	        Vertex MRS = new Vertex("MRS");
	        Vertex LYS = new Vertex("LYS");
	        Vertex PVG = new Vertex("PVG");
	        Vertex PEK = new Vertex("PEK");
	        Vertex CAN = new Vertex("CAN");
	        Vertex DEL = new Vertex("DEL");
	        Vertex BOM = new Vertex("BOM");
	        Vertex MAA = new Vertex("MAA");
	        Vertex MEL = new Vertex("MEL");
	        Vertex SYD = new Vertex("SYD");
	        Vertex PER = new Vertex("PER");
	        Vertex NBO = new Vertex("NBO");
	        Vertex MBA = new Vertex("MBA");
	        Vertex KIS = new Vertex("KIS");
	        Vertex CGK = new Vertex("CGK");
	        Vertex SUB = new Vertex("SUB");
	        Vertex BDO = new Vertex("BDO");
	        Vertex CGH = new Vertex("CGH");
	        Vertex GIG = new Vertex("GIG");
	        Vertex SSA = new Vertex("SSA");
	        Vertex MOW = new Vertex("MOW");
	        Vertex LED = new Vertex("LED");
	        Vertex KZN = new Vertex("KZN");

	        // set the edges and weight
	        SFO.adjacencies = new Edge[]{ new Edge(NYC, 232) };
	        SFO.adjacencies = new Edge[]{ new Edge(MEX, 226) };

	        NYC.adjacencies = new Edge[]{ new Edge(MEL, 942) };
	        NYC.adjacencies = new Edge[]{ new Edge(SYD, 930) };

	        SEA.adjacencies = new Edge[]{ new Edge(PEK, 667) };
	        SEA.adjacencies = new Edge[]{ new Edge(KIS, 4127) };


	        GDL.adjacencies = new Edge[]{ new Edge(KIS, 2294) };
	        GDL.adjacencies = new Edge[]{ new Edge(SUB, 1300) };

	        CUU.adjacencies = new Edge[]{ new Edge(SEA, 379) };
	        CUU.adjacencies = new Edge[]{ new Edge(GDL, 34) };

	        MEX.adjacencies = new Edge[]{ new Edge(PAR, 609) };
	        MEX.adjacencies = new Edge[]{ new Edge(KZN, 1302) };

	        PAR.adjacencies = new Edge[]{ new Edge(LYS, 65) };
	        PAR.adjacencies = new Edge[]{ new Edge(MBA, 462) };

	        MRS.adjacencies = new Edge[]{ new Edge(CUU, 1948) };
	        MRS.adjacencies = new Edge[]{ new Edge(PVG, 537) };

	        LYS.adjacencies = new Edge[]{ new Edge(SUB, 1073) };

	        PVG.adjacencies = new Edge[]{ new Edge(SEA, 373) };

	        PEK.adjacencies = new Edge[]{ new Edge(CAN, 254) };
	        PEK.adjacencies = new Edge[]{ new Edge(MAA, 345) };

	        CAN.adjacencies = new Edge[]{ new Edge(BOM, 363) };

	        DEL.adjacencies = new Edge[]{ new Edge(SEA, 667) };
	        DEL.adjacencies = new Edge[]{ new Edge(PEK, 263) };

	        BOM.adjacencies = new Edge[]{ new Edge(KZN, 539) };

	        MAA.adjacencies = new Edge[]{ new Edge(CAN, 201) };
	        MAA.adjacencies = new Edge[]{ new Edge(BOM, 29) };

	        MEL.adjacencies = new Edge[]{ new Edge(PER, 118) };
	        MEL.adjacencies = new Edge[]{ new Edge(LED, 810) };

	        SYD.adjacencies = new Edge[]{ new Edge(MEX, 1004) };

	        PER.adjacencies = new Edge[]{ new Edge(PAR, 729) };
	        PER.adjacencies = new Edge[]{ new Edge(NBO, 783) };

	        NBO.adjacencies = new Edge[]{ new Edge(CGH, 1140) };
	        NBO.adjacencies = new Edge[]{ new Edge(GIG, 899) };

	        MBA.adjacencies = new Edge[]{ new Edge(CGK, 611) };
	        MBA.adjacencies = new Edge[]{ new Edge(MOW, 786) };

	        KIS.adjacencies = new Edge[]{ new Edge(PEK, 809) };
	        KIS.adjacencies = new Edge[]{ new Edge(DEL, 972) };

	        CGK.adjacencies = new Edge[]{ new Edge(MRS, 651) };
	        CGK.adjacencies = new Edge[]{ new Edge(BDO, 85) };

	        SUB.adjacencies = new Edge[]{ new Edge(SEA, 1045) };
	        SUB.adjacencies = new Edge[]{ new Edge(PVG, 261) };

	        BDO.adjacencies = new Edge[]{ new Edge(NBO, 984) };
	        BDO.adjacencies = new Edge[]{ new Edge(SUB, 65) };

	        CGH.adjacencies = new Edge[]{ new Edge(LYS, 727) };
	        CGH.adjacencies = new Edge[]{ new Edge(CGK, 1794) };

	        GIG.adjacencies = new Edge[]{ new Edge(CUU, 595) };
	        GIG.adjacencies = new Edge[]{ new Edge(SSA, 90) };

	        SSA.adjacencies = new Edge[]{ new Edge(CGK, 1978) };
	        SSA.adjacencies = new Edge[]{ new Edge(BDO, 5634) };

	        MOW.adjacencies = new Edge[]{ new Edge(MAA, 381) };
	        MOW.adjacencies = new Edge[]{ new Edge(GIG, 759) };
	        MOW.adjacencies = new Edge[]{ new Edge(KZN, 52) };

	        LED.adjacencies = new Edge[]{ new Edge(PER, 825) };
	        LED.adjacencies = new Edge[]{ new Edge(MOW, 53) };

	        KZN.adjacencies = new Edge[]{ new Edge(MAA, 551) };
	        KZN.adjacencies = new Edge[]{ new Edge(LED, 96) };

	        computePaths(SFO); // run Dijkstra
	        System.out.println("Distance to " + MAA + ": " + MAA.minDistance);
	        List<Vertex> path = getShortestPathTo(MAA);
	        System.out.println("Path: " + path);
	    }
	
}
