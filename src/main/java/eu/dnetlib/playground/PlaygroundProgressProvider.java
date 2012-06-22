package eu.dnetlib.playground;

import com.googlecode.sarasvati.Node;
import com.googlecode.sarasvati.NodeToken;

import eu.dnetlib.enabling.inspector.msro.progress.ProgressProvider;

public class PlaygroundProgressProvider implements ProgressProvider {

	private int currentValue;
	private int totalValue;

	PlaygroundProgressProvider(int totalValue) {
		this.totalValue = totalValue;
		this.currentValue = 0;
	}

	@Override
	public int getCurrentValue(Node arg0, NodeToken arg1) {
		return currentValue;
	}

	@Override
	public int getTotalValue(Node arg0, NodeToken arg1) {
		return totalValue;
	}

	@Override
	public boolean isInaccurate() {
		return false;
	}

	public void setCurrentValue(int currentValue) {
		this.currentValue = currentValue;
	}

}
