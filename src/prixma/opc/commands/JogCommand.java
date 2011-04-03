package prixma.opc.commands;


public class JogCommand extends CompositeCommand {

	public JogCommand(String item){
		super(new WriteCommand(item, HIGH), new WriteCommand(item, LOW));
	}
	
	public JogCommand(String item, int delay){
		super(delay, new WriteCommand(item, HIGH), new WriteCommand(item, LOW));
	}
	
}
