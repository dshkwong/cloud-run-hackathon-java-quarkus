 

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.awt.geom.Point2D;
import java.lang.Object;


@Path("/{s:.*}")
public class App {

    static class Self {
        public String href;
    }

    static class Links {
        public Self self;
    }

    static class PlayerState {
        public Integer x;
        public Integer y;
        public String direction;
        public Boolean wasHit;
        public Integer score;
/*		public Coordinate getCoordinate() {
			return new Coordinate(x, y);
		}*/
    }

/*static class Coordinate {

    Integer x, y;
  }
*/
    static class Arena {
        public List<Integer> dims;
        public Map<String, PlayerState> state;
    }

    static class ArenaUpdate {
        public Links _links;
        public Arena arena;
    }


    @GET
    public String index() {
        return "Let the battle begin!";
    }
/*
	public int target() {
		int enemy =0;
		switch (direction) {
			case "N":
				for (int i=0;i< num_player; i++){
					if (playerx[i] == X) {
						int temp = Y-playery[i];
						if ((temp >0) && (temp<3))
							return 1;
						else if ((temp>0) && (temp>=3))
							enemy--;
				}
				break;
			case "S":
				for (int i=0;i< num_player; i++){
					if (playerx[i] == X) {
						int temp = playery[i]-Y;
						if ((temp >0) && (temp<3))
							return 1;
						else if ((temp>0) && (temp>=3))
							enemy--;
				}
				break;
			case "E":
				for (int i=0;i< num_player; i++){
					if (playery[i] == Y) {
						int temp = playerx[i]-X;
						if ((temp >0) && (temp<3))
							return 1;
						else if ((temp>0) && (temp>=3))
							enemy--;
				}
				break;
			case "W":
				for (int i=0;i< num_player; i++){
					if (playery[i] == Y) {
						int temp = X-playerx[i];
						if ((temp >0) && (temp<3))
							return 1;
						else if ((temp>0) && (temp>=3))
							enemy--;
				}
				break;
			default:
				break;
		}
		return enemy;
					
	}
	*/
	
	//Coordinate lastco;
	//String LastAction;
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String index(ArenaUpdate arenaUpdate) {
/*		PlayerState mystate = arenaUpdate.arena.state.get(arenaUpdate._links.self.href);
		//MAP<Coordinate, PlayerState> map = buildMap(arenaUpdate);
		PlayerState e1 = arenaUpdate.arena.state.get(new Coordinate(mystate.x+1, mystate.y));
		PlayerState e2 = arenaUpdate.arena.state.get(new Coordinate(mystate.x+2, mystate.y));
		PlayerState e3 = arenaUpdate.arena.state.get(new Coordinate(mystate.x+3, mystate.y));
		
		PlayerState w1 = arenaUpdate.arena.state.get(new Coordinate(mystate.x-1, mystate.y));
		PlayerState w2 = arenaUpdate.arena.state.get(new Coordinate(mystate.x-2, mystate.y));
		PlayerState w3 = arenaUpdate.arena.state.get(new Coordinate(mystate.x-3, mystate.y));
		
		PlayerState n1 = arenaUpdate.arena.state.get(new Coordinate(mystate.x, mystate.y-1));
		PlayerState n2 = arenaUpdate.arena.state.get(new Coordinate(mystate.x, mystate.y-2));
		PlayerState n3 = arenaUpdate.arena.state.get(new Coordinate(mystate.x, mystate.y-3));
		
		PlayerState s1 = arenaUpdate.arena.state.get(new Coordinate(mystate.x, mystate.y+1));
		PlayerState s2 = arenaUpdate.arena.state.get(new Coordinate(mystate.x, mystate.y+2));
		PlayerState s3 = arenaUpdate.arena.state.get(new Coordinate(mystate.x, mystate.y+3));
		
		if mystate.direction.equals("N") {
			if (n1==null)
		}
			
	*/
		boolean needRotate = false;
        boolean enemyInRange = false;
		
		
        System.out.println(arenaUpdate);
        String[] commands = new String[]{"R","R", "L", "L", "T","T","T", "T", "T", "T","F",};
		/*
		if (target()>0)
			return "T";
		else if (target()<0)
			return "F";
		*/
		
        int i = new Random().nextInt(10);
        return commands[i];
    }

}
