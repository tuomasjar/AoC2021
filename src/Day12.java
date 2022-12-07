import java.util.ArrayList;

public class Day12 extends Day{
	
	ArrayList<Cave> caves = new ArrayList<>();
	ArrayList<String> routes = new ArrayList<>();
	public Day12(){
		super(12);
	}
	
	

	public void runA(){
		Cave endCave = new Cave("end");
		caves.add(endCave);
		while(true) {
			String input = readNextLine();
			if(input==null)break;
			String[]inputParse = input.split("\\-");
			boolean found=false;
			for(Cave cave:caves) {
				if(cave.nameEquals(inputParse[0])) {
					cave.addDestination(inputParse[1]);
					found=true;
					break;
				}
			}
			if(!found) {
				Cave cave = new Cave(inputParse[0]);
				cave.addDestination(inputParse[1]);
				if(inputParse[0].equals("start")) {
					caves.add(0, cave);
				}
				else caves.add(cave);
			}
			found=false;
			for(Cave cave:caves) {
				if(cave.nameEquals(inputParse[1])) {
					cave.addDestination(inputParse[0]);
					found=true;
					break;
				}
			}
			if(!found) {
				Cave cave = new Cave(inputParse[1]);
				cave.addDestination(inputParse[0]);
				if(inputParse[1].equals("start")) {
					caves.add(0, cave);
				}
				else caves.add(cave);
			}
		}
		StringBuilder route = new StringBuilder();
		getRoute(caves.get(0),route);
		System.out.println(routes.size());
	}
	
	
	public void runB(){
		routes.clear();
		StringBuilder route = new StringBuilder();
		getBRoute(caves.get(0),route,null);
		System.out.println(routes.size());
	}
	
	public void getBRoute(Cave cave, StringBuilder currentRoute,String twice) {
		String twice2=twice;
		if(!cave.isBigCave() && cave.nameEquals(twice2) && getVisits(cave.getName(),currentRoute)==2)return;
		if(!cave.isBigCave() && !cave.nameEquals(twice2) && !cave.isStart() && !cave.isEnd() && getVisits(cave.getName(), currentRoute)==1) {
			if(twice2==null)twice2=cave.getName();
			else return;
		}
		if(cave.isEnd()) {
			currentRoute.append(",end");
			routes.add(currentRoute.toString());
			return;
		}
		if(cave.isStart() && getVisits("start",currentRoute)>0)return;
		if(cave.isStart())currentRoute.append("start");
		else currentRoute.append(","+cave.getName());
		for(String destination:cave.getDestinations()) {
			Cave destinationCave = findCave(destination);
			if(destinationCave==null)continue;
			StringBuilder nextRoute = new StringBuilder(currentRoute);
			getBRoute(destinationCave, nextRoute,twice2);
		}
	}
	
	public void getRoute(Cave cave, StringBuilder currentRoute) {
		if(!cave.isBigCave() && currentRoute.toString().contains(cave.getName()+","))return;
		if(cave.isEnd()) {
			currentRoute.append(",end");
			routes.add(currentRoute.toString());
			return;
		}
		if(cave.nameEquals("start"))currentRoute.append("start");
		else currentRoute.append(","+cave.getName());
		for(String destination:cave.getDestinations()) {
			Cave destinationCave = findCave(destination);
			if(destinationCave==null)continue;
			StringBuilder nextRoute = new StringBuilder(currentRoute);
			getRoute(destinationCave, nextRoute);
		}
	}
	
	public Cave findCave(String name) {
		for(Cave cave:caves) {
			if(cave.nameEquals(name))return cave;
		}
		return null;
	}
	
	public int getVisits(String name,StringBuilder route) {
		int amount=0;
		String input = route.toString();
		String[] inputParse = input.split(",");
		for(String s:inputParse) {
			if(s.equals(name))amount++;
		}
		return amount;
	}
	
	private class Cave {
		private String name;
		private ArrayList<String> destination;
		private boolean bigCave;
		
		public Cave(String name) {
			this.name=name;
			if(name.charAt(0)>='a' && name.charAt(0)<='z')bigCave=false;
			else bigCave=true;
			destination = new ArrayList<>();
		}
		
		public void addDestination(String destination) {
			this.destination.add(destination);
		}
		
		public boolean isBigCave() {
			return bigCave;
		}
		
		public String getName() {
			return name;
		}
		
		public ArrayList<String> getDestinations(){
			return destination;
		}
		
		public boolean isStart() {
			return name.contains("start");
		}
		
		public boolean isEnd() {
			return name.contains("end");
		}

		public boolean nameEquals(String checkName) {
			if(checkName==null)return false;
			return this.name.equals(checkName);
		}
	}
	
}
