//declare the mod package
package org.volcano.wurmunlimited.mods.extendedcommands;

//import other classes for implementation / calls
import org.gotti.wurmunlimited.modloader.interfaces.PlayerMessageListener;
import org.gotti.wurmunlimited.modloader.interfaces.WurmServerMod;
import com.wurmonline.server.creatures.Communicator;
import com.wurmonline.server.creatures.Creatures;

//Make my first class, naming it the same as my file name
//This class implements other classes, so we have to implement WurmServerMod to figure out what creature is talking and
//the PlayerMessageListener is being called from the modloader.jar, where we can trigger this mod when any player types something.
//Notice:  Look at the code below.  If you do not add a return true; at the end of the /wildlife IF statement, nobody in the server
//will be able to type anything...no chat, no commands, nothing except the /wildlife.  Very important to add the return true; and the return false; where required
public class extendedcommands implements WurmServerMod, PlayerMessageListener {

	//---------------------------------------------------------------------------------------------------
	//so the server told us that some player sent a message in ANY chat window
	@Override
	public boolean onPlayerMessage(Communicator communicator, String message) {
		//communicator is the player (their ID / link / reference) so we know who sent the message
		//message is the actual message that is typed.
		
		//-----------
		if(message != null && message.startsWith("/wildlife")) {
			//player typed the /wildlife command, now execute this code
			
			//I declared an integer and named it numCreatures, now I need to assign a value to it.
			//I found under server.jar, under com.wurmonline.server.creatures.Creatures, a method called getNumberOfCreatures, and it returned an integer.  
			//look for that yourself to see how to find it.  Expand the class name to find green solid circles representing potential methods you can call
			int numCreatures = Creatures.getInstance().getNumberOfCreatures();
			//now output the info to the Event tab.  You can send to other places too, this is just most convienent
			communicator.sendSafeServerMessage("Total Creatures: " + numCreatures);
			
			int numKingdomCreatures = Creatures.getInstance().getNumberOfKingdomCreatures();
			communicator.sendSafeServerMessage("Total Kingdom Creatures: " + numKingdomCreatures);
			
			int numNiceCreatures = Creatures.getInstance().getNumberOfNice();
			communicator.sendSafeServerMessage("Total Nice Creatures: " + numNiceCreatures);
	
			int numAggressiveCreatures = Creatures.getInstance().getNumberOfAgg();
			communicator.sendSafeServerMessage("Total Aggressive Creatures: " + numAggressiveCreatures);
			
			int numSeaCreatures = Creatures.getInstance().getNumberOfSeaMonsters();
			communicator.sendSafeServerMessage("Total Sea Monsters: " + numSeaCreatures);
			
			int numRedDragons = Creatures.getInstance().getNumberOfCreaturesWithTemplate(16);
			int numRedDragonHatchlings = Creatures.getInstance().getNumberOfCreaturesWithTemplate(103);
			communicator.sendSafeServerMessage("Total Red Dragons: " + numRedDragons + " and " + numRedDragonHatchlings + " red dragon hatchlings.");
	
			int numBlackDragons = Creatures.getInstance().getNumberOfCreaturesWithTemplate(89);
			int numBlackDragonHatchlings = Creatures.getInstance().getNumberOfCreaturesWithTemplate(18);
			communicator.sendSafeServerMessage("Total Black Dragon: " + numBlackDragons + " and " + numBlackDragonHatchlings + " black dragon hatchlings.");
	
			int numGreenDragons = Creatures.getInstance().getNumberOfCreaturesWithTemplate(90);
			int numGreenDragonHatchlings = Creatures.getInstance().getNumberOfCreaturesWithTemplate(17);
			communicator.sendSafeServerMessage("Total Green Dragon: " + numGreenDragons + " and " + numGreenDragonHatchlings + " green dragon hatchlings.");
	
			int numBlueDragons = Creatures.getInstance().getNumberOfCreaturesWithTemplate(91);
			int numBlueDragonHatchlings = Creatures.getInstance().getNumberOfCreaturesWithTemplate(104);
			communicator.sendSafeServerMessage("Total Blue Dragons: " + numBlueDragons + " and " + numBlueDragonHatchlings + " blue dragon hatchlings.");
	
			int numWhiteDragons = Creatures.getInstance().getNumberOfCreaturesWithTemplate(92);
			int numWhiteDragonHatchlings = Creatures.getInstance().getNumberOfCreaturesWithTemplate(19);
			communicator.sendSafeServerMessage("Total White Dragons: " + numWhiteDragons + " and " + numWhiteDragonHatchlings + " white dragon hatchlings.");
	
			int numTrollKing = Creatures.getInstance().getNumberOfCreaturesWithTemplate(27);
			communicator.sendSafeServerMessage("Total Troll Kings: " + numTrollKing);
	
			int numGoblinLeader = Creatures.getInstance().getNumberOfCreaturesWithTemplate(26);
			communicator.sendSafeServerMessage("Total Goblin Leaders: " + numGoblinLeader);
			
			int numForestGiant = Creatures.getInstance().getNumberOfCreaturesWithTemplate(20);
			communicator.sendSafeServerMessage("Total Forest Giant: " + numForestGiant);
			
			int numCyclops = Creatures.getInstance().getNumberOfCreaturesWithTemplate(22);
			communicator.sendSafeServerMessage("Total Kyklops: " + numCyclops);
			
			//very important to return true;  to say the function executed successfully
			return true;
		}
		//-----------
		//The player message did not contain a starting string of "/wildlife", return false, do nothing
		//very important to return false; or players will not be able to type in any window
		return false;
	}
	//---------------------------------------------------------------------------------------------------
	//this public function is very important.  This is what tells players what version your mod is.  This call is
	//named getVersion, and I believe the modloader calls it, and your mod needs to respond with something.  So you
	//will use return which sends info back to the requestor, and we are returning a string which is in "quotes".  You could
	//type anything in here really, but it is important to version a bigger mod so players know what version they have
	//in case there is a newer / better one.  You can optionally delete the method below too and the code will run, but that is poor coding
	public String getVersion() {
		return "v1.0";
	}
	//---------------------------------------------------------------------------------------------------
	public void onServerStarted() {
		//do nothing
    }
}