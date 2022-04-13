package me.egaetan.redblue;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RedBlueService {

	@Autowired
	RedBlueRepository repository;
	
	@Transactional
	public void increment(boolean isRed) {
		String idTeam;
		if (isRed)
			idTeam = "red";
		else
			idTeam = "blue";
		RedBlueEntity persisted = repository.findById(idTeam).orElseGet(() -> new RedBlueEntity(idTeam, 0));
		persisted.score++;
		repository.save(persisted);
	}

	public String score() {
		var scores = repository.findAll()
			.stream()
			.collect(Collectors.toMap(e -> e.getTeam(), e -> e.getScore()));
		int red = scores.getOrDefault("red", 0);
		int blue = scores.getOrDefault("blue", 0);
		return blue == red ? "TIE" : red + "/" + blue;
	}
	
	public void reset() {
		repository.deleteAll();
	}
}
