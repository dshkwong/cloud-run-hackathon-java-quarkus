 

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;
import java.util.Random;


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
    }

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
	
	

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String index(ArenaUpdate arenaUpdate) {
		PlayerState myself = arenaUpdate.arena.state.get(arenaUpdate._links.href);
		
		int playerx[];
		int playery[];
        System.out.println(arenaUpdate);
        String[] commands = new String[]{"F", "R", "L", "T"};
		if (target()>0)
			return "T";
		else if (target()<0)
			return "F";
        int i = new Random().nextInt(4);
        return commands[i];
    }

}
