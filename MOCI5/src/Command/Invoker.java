package Command;


public class Invoker {
	
	private Command cmd;

	public Invoker(Command cmd) {
		super();
		this.cmd = cmd;
	}
	
	public void invoke() {
		cmd.execute();
	}
}
