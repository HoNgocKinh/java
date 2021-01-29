package tensormenu.item;

import java.awt.Point;
import java.util.List;

public class Item {
	
	private Point position;
	private List<Item> children;
	private String name;
	
	public Item(String name, Point p, List<Item> children) {
		this.position = p;
		this.children = children;
		this.name = name;
	}
	
	public Item() {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Point getPosition() {
		return position;
	}
	public void setPosition(Point position) {
		this.position = position;
	}
	public List<Item> getChildren() {
		return children;
	}
	public void setChildren(List<Item> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Item [position=" + position + ", children=" + children + ", name=" + name + "]";
	}
}
