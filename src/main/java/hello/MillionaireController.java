package hello;

import java.util.HashMap;
import java.util.Optional;

import javax.validation.constraints.AssertTrue;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.training.domain.Game;
import com.accenture.training.domain.Question;
import com.accenture.training.main.MonsterEngine;

@RestController
public class MillionaireController {
	
	HashMap<Long, Game> currentGames = new HashMap<>();
	
	@Autowired
	MonsterEngine engine;
	
	@RequestMapping("/")
    @ResponseBody
	public String index(){
		return "Hello";
	}
	
	@PostMapping(path = "/game", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public Game startGame(@RequestParam Optional<String> playerName){
		Game game = engine.startGame(playerName.orElse("John Doe"));
		game.setId(System.currentTimeMillis()%10);
		currentGames.put(game.getId(), game);
		return game;
	}
	
	@PutMapping("/game")
	public Boolean saveGame(@RequestParam Game game){
		Assert.assertTrue("game cannot be empty", game != null);
		Assert.assertTrue("Game id cannot be empty", game.getId()!=null);
		if(game == null || game.getId() == null || !currentGames.containsKey(game.getId())){
			return false;
		}
		currentGames.put(game.getId(), game);
		return true;
	}
	
	@GetMapping(path = "/game/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Game getGame(@PathVariable Long id){
		return currentGames.get(id);
	}

	@GetMapping("/game/{id}/current_question")
	public Question getCurrentQuestion(@PathVariable Long id){
		return currentGames.get(id).getCurrentQuestion();
	}
	
//	@PostMapping("/game/{id}/action/{action}")
//	public Object action(@PathVariable Long id, @PathVariable String action){
//		System.out.println("action(id="+id+", action="+action+")");
//		if(action == "stop"){
//			
//		}
//		if(action == "continue"){
//			
//		}
//		return Boolean.TRUE;
//	}
//	@RequestParam(name = "groups") Integer[] groups
	
	
	@PostMapping("/game/{id}/action")     //?action={action}")
	public Boolean action(@PathVariable Long id, @RequestParam String action){
		System.out.println("action(id="+id+", action="+action+")");
		Game game = currentGames.get(id);
		if(action.equals("stop")){
			game.setCurrentQuestion(-1);
		}
		if(action == "continue"){
		}
		return Boolean.TRUE;
	}
	
	@PostMapping("/game/{id}/answer")  //?answer=my_number
	public Boolean checkAnswer(@PathVariable Long id, @RequestParam Long answer){
		Game game = currentGames.get(id);
		return engine.giveAnswer(game, answer.intValue());
	}

}
