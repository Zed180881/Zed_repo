package lesson2;

public class Zemlekop extends Human {

	private String tool;

	public void work(String tool) {
		System.out.println("work with " + tool);
	}

	public String getTool() {
		return this.tool;
	}

	public void setTool(String tool) {
		this.tool = tool;
	}
}
