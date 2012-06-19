package eu.dnetlib.playground;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.googlecode.sarasvati.Graph;

import eu.dnetlib.enabling.tools.AbstractSchedulable;

public class PlaygroundJob extends AbstractSchedulable {
	private static final Log log = LogFactory.getLog(PlaygroundJob.class);

	private Graph graph;

	@Override
	protected void doExecute() {
		log.info("Started playing around");
	}

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}
}
