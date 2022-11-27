package gloomhavenPrototype;

import java.util.HashMap;
import java.util.Map;

/*Ex.
//doDamage exists in monster class
public void doDamage(player ply, DmgInfo dmg){
	Events.Call( "OnPlayerTakeDamage",  new Entity[]{ply, this, dmg} )
	//do other stuff here
}

//Somewhere else in code
Events.Add("OnPlayerTakeDamage", "UniqueName", (Entity[] ents) -> {
	Player ply = (Player) ents[0];
	Monster monster = (Monster) ents[1];
	Monster dmg = (DmgInfo) ents[2];
	
	System.println(ply.getName() + " : " + monster.getName());
}
*/
public final class Events {
	//Hashmap holds the event names as key and their Event object as value
	private static HashMap<String, Event> events = new HashMap<String, Event>();

	//Call an Event to be created if it doesn't exist or run all associated callbacks.
	public static void Call(String name, Entity[] ents) {
		Event event = events.get(name);
		//Create the Event if it doesn't exist.
		if (event == null) {
			event = new Event();
			events.put(name, event);
		}
		//Run callback(s) for event.
       for (Map.Entry<String, EventCallbacks> set : event.getCallbacks().entrySet()) {
    	   set.getValue().call(ents);
       }
	}
	
	//Create a Callback. 'name' is the name of the Event. 'id' parameter must be a unique name. 'e' is lambda expression
	public static void Add(String name, String id, EventCallbacks e) {
		Event mainEvent = events.get(name);
		if (mainEvent == null) {
			mainEvent = new Event();
			events.put(name, mainEvent);
		}
		mainEvent.addCallback(id, e);
	}
	//Remove an Event Callback based on their given id
	public static void Remove(String name, String id) {
		Event mainEvent = events.get(name);
		if (mainEvent == null) {
			
			return;
		}
		mainEvent.remove(id);
	}
}
