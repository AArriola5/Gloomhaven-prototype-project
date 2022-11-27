package gloomhavenPrototype;

import java.util.HashMap;

//Used for Event Callback
interface EventCallbacks {
    void call(Entity[] args);
}

public class Event {
	//stores all EventCallbacks for the Event. Key is their unique id.
	private HashMap<String, EventCallbacks> callbacks;

	public Event() {
		callbacks = new HashMap<>();//Initalize the map
	}
	
	//Returns the map to callbacks
	public HashMap<String, EventCallbacks> getCallbacks(){
		return callbacks;
	}
	
	//Inserts a callback based on the id given
	public void addCallback(String id, EventCallbacks e){
		callbacks.put(id, e);
	}
	
	//Removes a callback
	public void remove(String id){
		callbacks.remove(id);
	}
}

