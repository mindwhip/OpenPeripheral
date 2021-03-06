package openperipheral.integration.thaumcraft;

import openperipheral.api.IPeripheralAdapter;
import openperipheral.api.LuaMethod;
import openperipheral.api.LuaType;
import thaumcraft.api.nodes.INode;
import thaumcraft.api.nodes.NodeModifier;
import thaumcraft.api.nodes.NodeType;
import dan200.computer.api.IComputerAccess;

public class AdapterNode implements IPeripheralAdapter {
	private static final String NONE = "NONE";

	@Override
	public Class<?> getTargetClass() {
		return INode.class;
	}

	@LuaMethod(returnType = LuaType.STRING, description = "Get the type of the node")
	public String getNodeType(IComputerAccess computer, INode node) {
		NodeType nodeType = node.getNodeType();
		return (nodeType != null? nodeType.name() : NONE);
	}

	@LuaMethod(returnType = LuaType.STRING, description = "Get the modifier of the node")
	public String getNodeModifier(IComputerAccess computer, INode node) {
		NodeModifier nodeModifier = node.getNodeModifier();
		return (nodeModifier != null? nodeModifier.name() : NONE);
	}
}
