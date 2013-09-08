package nl.thijsmolendijk.PGMXMLValidator.validatorstorage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.w3c.dom.Element;

public class ParentChildValidators {
	public static HashMap<String, List<String>> parentChildren = new HashMap<String, List<String>>();
	
	static {
		parentChildren.put("authors", Arrays.asList("author"));
		parentChildren.put("contributors", Arrays.asList("contributor"));
		parentChildren.put("rules", Arrays.asList("rule"));

		//Regions
		parentChildren.put("union", Arrays.asList("block", "union", "negative", "complement", "intersect", "point", "region", "rectangle", "cuboid", "cylinder", "sphere", "circle"));
		parentChildren.put("negative", Arrays.asList("block", "union", "negative", "complement", "intersect", "point", "region", "rectangle", "cuboid", "cylinder", "sphere", "circle"));
		parentChildren.put("complement", Arrays.asList("block", "union", "negative", "complement", "intersect", "point", "region", "rectangle", "cuboid", "cylinder", "sphere", "circle"));
		parentChildren.put("intersect", Arrays.asList("block", "union", "negative", "complement", "intersect", "point", "region", "rectangle", "cuboid", "cylinder", "sphere", "circle"));
		
		//Objectives and Gamemodes
		parentChildren.put("wool", Arrays.asList("block"));
		parentChildren.put("destroyables", Arrays.asList("destroyable"));
		parentChildren.put("destroyable", Arrays.asList("block", "union", "negative", "complement", "intersect", "point", "region", "rectangle", "cuboid", "cylinder", "sphere", "circle"));
		parentChildren.put("blitz", Arrays.asList("time", "lives", "broadcastLives", "title"));
		parentChildren.put("cores", Arrays.asList("core", "cores"));
		parentChildren.put("core", Arrays.asList("block", "union", "negative", "complement", "intersect", "point", "region", "rectangle", "cuboid", "cylinder", "sphere", "circle"));
		parentChildren.put("score", Arrays.asList("time", "limit", "box"));
		
		//Teams
		parentChildren.put("teams", Arrays.asList("team"));

		//Kits
		parentChildren.put("kits", Arrays.asList("kit"));
		parentChildren.put("kit", Arrays.asList("item", "potion", "helmet", "chestplate", "leggings", "boots", "head"));
		parentChildren.put("classes", Arrays.asList("class"));
		
		//Other modules
		parentChildren.put("toolrepair", Arrays.asList("tool"));
		parentChildren.put("itemremove", Arrays.asList("item"));
		parentChildren.put("itemkeep", Arrays.asList("item"));
		parentChildren.put("disabledamage", Arrays.asList("damage"));
		parentChildren.put("modifybowprojectile", Arrays.asList("projectile", "velocityMod"));
		parentChildren.put("tnt", Arrays.asList("instantignite", "blockdamage", "yield"));
		parentChildren.put("mobs", Arrays.asList("filter"));
		parentChildren.put("killreward", Arrays.asList("item"));
		parentChildren.put("hunger", Arrays.asList("depletion"));

		
		//Filters
		parentChildren.put("filter", Arrays.asList("allow", "deny", "all", "any", "none"));
		parentChildren.put("allow", Arrays.asList("team", "block", "spawn", "mob", "void"));
		parentChildren.put("deny", Arrays.asList("team", "block", "spawn", "mob", "void"));

		//Spawns
		parentChildren.put("spawns", Arrays.asList("spawn", "default", "spawns"));
		parentChildren.put("spawn", Arrays.asList("block", "union", "negative", "complement", "intersect", "point", "region", "rectangle", "cuboid", "cylinder", "sphere", "circle"));
		parentChildren.put("playable", Arrays.asList("block", "union", "negative", "complement", "intersect", "point", "region", "rectangle", "cuboid", "cylinder", "sphere", "circle"));
		parentChildren.put("lanes", Arrays.asList("lane"));
		parentChildren.put("lane", Arrays.asList("block", "union", "negative", "complement", "intersect", "point", "region", "rectangle", "cuboid", "cylinder", "sphere", "circle"));
		
		//Portals
		parentChildren.put("portals", Arrays.asList("portal"));
		parentChildren.put("portal", Arrays.asList("block", "union", "negative", "complement", "intersect", "point", "region", "rectangle", "cuboid", "cylinder", "sphere", "circle"));

		//Scoreboxes
		parentChildren.put("box", Arrays.asList("block", "union", "negative", "complement", "intersect", "point", "region", "rectangle", "cuboid", "cylinder", "sphere", "circle"));

		
		//Sample "contain any region" code
		//		parentChildren.put("", Arrays.asList("block", "rectangle", "cuboid", "cylinder", "sphere", "circle"));
	}
	
	public static void validate(Element e) throws Exception {
		if (!parentChildren.containsKey(e.getParentNode().getNodeName()))
			return;
		List<String> allowedChildren = parentChildren.get(e.getParentNode().getNodeName());
		if (!allowedChildren.contains(e.getTagName())) 
			throw new Exception("Parent "+e.getParentNode().getNodeName()+" does not allow child "+e.getTagName());
	}
}
