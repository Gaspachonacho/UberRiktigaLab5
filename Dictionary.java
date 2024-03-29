package lab5;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

public class Dictionary {
	
	Map<Word,Set<Word>> map = new HashMap<Word,Set<Word>>();
	
	public void add(Word t, Word m) {
		if(map.containsKey(t)) {
			Set<Word> nyttM = map.get(t);
			nyttM.add(m);
		}
		else {
			Set<Word> newSet = new HashSet<>();
			newSet.add(m);
			map.put(t, newSet);
		}
		
	}
	
	public void add(String keys, String values) {
		add(new Word(keys), new Word(values));
	}
	
	
	 // Returnerar en icke-null mängd med ordlistans alla termer.
	 
	public Set<Word> terms() {
		return map.keySet();
	}
	
	
	 // Slår upp och returnerar en mängd av betydelser till t,
	 // eller null om t inte finns i ordlistan
	 
	
	public Set<Word> lookup(Word t) {
		return map.get(t);
	}
	 
	 // Skapar och returnerar en ny ordlista på det motsatta språket,
	 // dvs, alla betydelser blir termer och alla termer blir betydelser.
	 // T.ex en svensk-engelsk ordlist blir efter invertering engels-svensk.
	
	public Dictionary inverse() {
		Dictionary inverseDictionary = new Dictionary();
		
		for(Word key : map.keySet()) {
			for (Word value : lookup(key)) {
			inverseDictionary.add(value, key);
			}
		}
		return inverseDictionary;
		
	}
	
	 
	//  Läser in orden från den givna strömmen och lägger dessa i ordlistan.
	 
	
	public void load(InputStream is) {
		
	}
	
	
	 // Lagrar ordlistan på den givna strömmen.
	 
	
	public void save(OutputStream os) {
		
	}
	
	
}